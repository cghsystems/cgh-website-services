package net.cghsystems.pdf.itext


import groovy.util.logging.Log4j

import com.itextpdf.text.Document
import com.itextpdf.text.Font
import com.itextpdf.text.FontFactory
import com.itextpdf.text.Paragraph
import com.itextpdf.text.Phrase
import com.itextpdf.text.Rectangle
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.draw.LineSeparator

/**
 * Decorates the {@link PdfPTable} and {@link Document} with metaClass methods and constructors to makes its use more. 
 * Methods include those to add new cells, empty cells and line breaks. A call to register will register 
 * these methods on any instance created during a JVM's lifecycle. 
 * 
 * @author chris
 *
 */
@Log4j
class ItextMetaClassesRegistrar {

    /**
     * Addds the methods we want on to the {@link PdfPTable} and {@link Document} metaClass's so we can use 
     * on any instance.
     */
    static void register() {
        println "Adding metaMethods to PdfPTable"

        PdfPTable.metaClass.constructor= { boolean showBorder, int numberOfColumns ->
            PdfPTable p = new PdfPTable(numberOfColumns)
            if(!showBorder) {
                p.getDefaultCell().setBorder(Rectangle.NO_BORDER)
            }
            return p
        }

        PdfPTable.metaClass.addEmptyCells = { number ->
            number.times { addCell("") }
        }

        PdfPTable.metaClass.addCell = { String text ->
            addCell(text, Font.NORMAL, 8)
        }

        PdfPTable.metaClass.addCell = { String text, int fontStyle ->
            addCell(text, fontStyle, 8)
        }

        PdfPTable.metaClass.addCell = {String text, int fontStyle, int fontSize ->
            PdfPCell pCell = new PdfPCell()
            pCell.setBorder(Rectangle.NO_BORDER)
            Font font = FontFactory.getFont(FontFactory.HELVETICA, fontSize)
            font.setStyle(fontStyle)
            Phrase phrase = new Phrase(text, font)
            addCell(phrase)
        }

        Document.metaClass.addLineBreak = {
            add(new Paragraph(" "))
            add(new LineSeparator())
        }

        Document.metaClass.newLine = {
            add(new Paragraph(" "))
        }
    }
}