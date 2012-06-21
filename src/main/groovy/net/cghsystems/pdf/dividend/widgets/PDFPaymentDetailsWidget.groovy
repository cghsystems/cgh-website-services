package net.cghsystems.pdf.dividend.widgets

import net.cghsystems.model.dividend.DividendDeclaration
import net.cghsystems.pdf.shared.PDFDocumentConstants

import com.itextpdf.text.Document
import com.itextpdf.text.Element
import com.itextpdf.text.Font
import com.itextpdf.text.FontFactory
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfPTable


class PDFPaymentDetailsWidget {

    def buildPaymentDetails(Document doc, DividendDeclaration dividend) {

        addTitle(doc)
        doc.newLine()
        addPaymentTable(doc, dividend)
        doc.newLine()
        addFooter(doc)
    }

    private void addFooter(doc) {
        def text =
                """
			The shareholders were advised of these amounts and cheques paid/drawn accordingly.

			There being no further business, the meeting was adjourned.
			"""
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 8)
        Paragraph footer = new Paragraph(text, font)
        doc.add(footer)
    }

    private  void addPaymentTable(doc, dividend) {

        PdfPTable table = new PdfPTable(false, 4)
        table.setWidthPercentage(PDFDocumentConstants.TABLE_WIDTH)

        table.addCell("Cheque Payee:")
        table.addCell("Cheque Value:")
        table.addCell("Date:")
        table.addCell("Cheque number:")

        table.addCell("${dividend.director.name}")
        table.addCell("${dividend.dividend}")
        table.addCell("${dividend.dateHeld}")
        table.addCell("Bank Transfer")

        doc.add(table)
    }

    private void addTitle(doc) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 10)
        Paragraph title = new Paragraph("Payment Details", font)
        title.setAlignment(Element.ALIGN_CENTER)
        doc.add(title)
    }
}
