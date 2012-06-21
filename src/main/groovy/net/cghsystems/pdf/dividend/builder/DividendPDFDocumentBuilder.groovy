package net.cghsystems.pdf.dividend.builder

import net.cghsystems.model.dividend.DividendDeclaration
import net.cghsystems.pdf.dividend.widgets.PDFDistributionDetailsWidget
import net.cghsystems.pdf.dividend.widgets.PDFDividendMeetingDescriptionWidget
import net.cghsystems.pdf.dividend.widgets.PDFDividendSummaryWidget
import net.cghsystems.pdf.dividend.widgets.PDFPaymentDetailsWidget
import net.cghsystems.pdf.dividend.widgets.PDFSignatureFooterWidget
import net.cghsystems.pdf.shared.builder.PDFDocumentBuilder
import net.cghsystems.pdf.shared.widgets.HeaderWidget

import com.itextpdf.text.Document
import com.itextpdf.text.Element
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter

/**
 * Top level {@link DividendDeclaration} PDF object that allows a  PDF Dividend document to be written to a outputStream. 
 * The generated PDF
 * 
 * should contain:
 * <ul>
 *  * A Dividend Summary
 *  * A meeting description
 *  * The distribution details of of who requires a copy of these documents.
 *  * The payment details of how the dividend should be paid.
 *  * A Footer to close the document.
 * </ul>
 *
 * Uses lots of Mixin's so basically multiple inheritance. Is this bad? I've yet to decide...
 */
@Mixin(PDFDividendSummaryWidget)
@Mixin(PDFDividendMeetingDescriptionWidget)
@Mixin(PDFDistributionDetailsWidget)
@Mixin(PDFPaymentDetailsWidget)
@Mixin(PDFSignatureFooterWidget)
class DividendPDFDocumentBuilder implements PDFDocumentBuilder<DividendDeclaration> {

    /** The itext 'canvas' to create the pdf within */
    private final Document doc = new Document()

    /* (non-Javadoc)
     * @see net.cghsystems.pdf.shared.builder.PDFDocumentBuilder#generate(java.lang.Object, java.io.OutputStream)
     */
    public void generate(DividendDeclaration declaration, OutputStream pdfOutputStream) {

        def output = PdfWriter.getInstance(doc, pdfOutputStream)
        doc.open()

        addHeader(declaration.company)
        addTitle()
        doc.addLineBreak()
        buildDividendSummary(declaration)
        buildMeetingDescription()
        buildDistributionDetails(declaration)
        doc.addLineBreak()
        buildPaymentDetails(declaration)
        10.times { doc.newLine() }
        buildFooter()

        doc.close()
    }

    void addHeader(company) {
        doc.add(new HeaderWidget().build(company))
        doc.addLineBreak()
    }

    void addTitle() {
        Paragraph title = new Paragraph("Dividend Declaration")
        title.setAlignment(Element.ALIGN_CENTER)
        doc.add(title)
    }
}
