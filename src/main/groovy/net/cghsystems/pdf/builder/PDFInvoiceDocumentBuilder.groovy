package net.cghsystems.pdf.builder



import net.cghsystems.model.invoice.Invoice
import net.cghsystems.pdf.invoice.widgets.InvoiceHeaderWidget
import net.cghsystems.pdf.invoice.widgets.InvoicePaymentSummaryWidgetProvider
import net.cghsystems.pdf.invoice.widgets.InvoicePeriodWidgetProvider
import net.cghsystems.pdf.invoice.widgets.InvoiceSummaryWidget

import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter


/**
 * Should allow a PDF Invoice to be written to a outputStream. The generated PDF should contain:
 * <ul>
 *  <li>Invoice Header. Company logo, address etc</li>
 *  <li>Invoice Summary. I.e the Company the invoice represents, the client etc.</li>
 *  <li>Invoice Period. I.e the Period of time and the amount of days being invoice for</li>
 * </ul>
 * 
 * Uses lots of Mixins so basically multiple inheritance. Is this bad? I've yet to decide...
 */
@Mixin(InvoicePaymentSummaryWidgetProvider)
@Mixin(InvoicePeriodWidgetProvider)
@Mixin(InvoiceHeaderWidget)
class PDFInvoiceDocumentBuilder {

    private final Document doc = new Document()

    /**
     * Should generate an PDF representation of an Invoice and write it to the provided outputStream
     * 
     * @param invoice. The Invoice object to generate the PDF representation for.
     * @param outputStream to write the PDF to.
     */
    void generate(Invoice invoice, outputStream) {

        if(invoice == null || outputStream == null) {
            throw new IllegalStateException("Cannot accept a null parameter")
        }

        def output = PdfWriter.getInstance(doc, outputStream)
        doc.open()

        addMetaData()

        doc.add(buildHeaderWidget(invoice.invoiceCompany))
        doc.addLineBreak()
        doc.add(buildInvoiceSummary(invoice))
        doc.addLineBreak()
        doc.add(buildInvoicePeriodWidget(invoice))
        doc.addLineBreak()
        doc.add(buildInvoicePaymentSummaryWidget(invoice))
        doc.close()
    }

    /** Could add into its own mixin provider */
    private void addMetaData() {
        doc.addTitle("Invoice")
        doc.addSubject("Invoice")
        doc.addKeywords("Invoice for Christopher Hedley")
        doc.addAuthor("cgh-systems")
        doc.addCreator("cgh-systems")
    }

    /** Could add into its own mixin provider */
    private buildInvoiceSummary(invoice) {
        PdfPTable summaryTable = new InvoiceSummaryWidget().build(invoice)
        Paragraph section = new Paragraph()
        section.add(summaryTable)
        section
    }
}
