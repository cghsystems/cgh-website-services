package net.cghsystems.pdf.generator



import net.cghsystems.pdf.widgets.InvoiceHeaderWidget
import net.cghsystems.pdf.widgets.InvoicePaymentSummaryWidgetProvider
import net.cghsystems.pdf.widgets.InvoicePeriodWidgetProvider
import net.cghsystems.pdf.widgets.InvoiceSummaryWidget

import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter


/**
 * Uses lots of Mixins so basically multiple inheritance. Is this bad? I've yet to decide...
 */
@Mixin(InvoicePaymentSummaryWidgetProvider)
@Mixin(InvoicePeriodWidgetProvider)
@Mixin(InvoiceHeaderWidget)
class PDFInvoiceGenerator {

    private final Document doc = new Document()

    void build(invoice, outputStream) {

        def output = PdfWriter.getInstance(doc, outputStream)
        doc.open()

        addMetaData()

        doc.add(buildHeaderWidget(invoice.company))
        doc.addLineBreak()
        doc.add(buildInvoiceSummary(invoice))
        doc.addLineBreak()
        doc.add(buildInvoicePeriodWidget(invoice))
        doc.addLineBreak()
        doc.add(buildInvoicePaymentSummaryWidget(invoice))
        doc.close()
    }

    /** Could add into its own provider */
    private void addMetaData() {
        doc.addTitle("Invoice")
        doc.addSubject("Invoice")
        doc.addKeywords("Invoice for Christopher Hedley")
        doc.addAuthor("cgh-systems")
        doc.addCreator("cgh-systems")
    }

    /** Could add into its own provider */
    private buildInvoiceSummary(invoice) {
        PdfPTable summaryTable = new InvoiceSummaryWidget().build(invoice)
        Paragraph section = new Paragraph()
        section.add(summaryTable)
        doc.add(section)
    }
}
