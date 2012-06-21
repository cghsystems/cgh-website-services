package net.cghsystems.pdf.dividend

import net.cghsystems.model.dividend.DividendDeclaration
import net.cghsystems.model.dividend.datastores.DividendDeclarationDataStore
import net.cghsystems.pdf.shared.widgets.HeaderWidget

import com.itextpdf.text.Document
import com.itextpdf.text.Element
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter

class PDFDividendGenerator {

    private final Document doc = new Document()

    def build(date, dividend, outputStream) {

        DividendDeclaration declaration = new DividendDeclarationDataStore().build(date, dividend)

        def output = PdfWriter.getInstance(doc, outputStream)
        doc.open()

        addHeader(declaration.company)
        addTitle()
        doc.newLine()
        addDividendSummary(declaration)
        addMeetingDescription(declaration)
        addDistributionDetails(declaration)
        doc.newLine()
        addPaymentDetails(declaration)
        10.times { doc.newLine() }
        addSignatureFooter()

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

    void addDividendSummary(declaration) {
        doc.add(new PDFDividendSummaryBuilder().build(declaration))
    }

    void addMeetingDescription(declaration) {
        doc.add(new PDFDividendMeetingDescriptionBuilder().build())
    }

    void addDistributionDetails(declaration) {
        doc.add(new PDFDistributionDetailsBuilder().build(declaration))
    }

    void addPaymentDetails(declaration) {
        new PDFPaymentDetailsBuilder().build(doc, declaration)
    }

    void addSignatureFooter() {
        doc.add(new PDFSignatureFooterBuilder().build())
    }
}
