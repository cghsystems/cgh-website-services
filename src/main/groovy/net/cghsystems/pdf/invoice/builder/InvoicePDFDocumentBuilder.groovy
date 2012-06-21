package net.cghsystems.pdf.invoice.builder



import net.cghsystems.model.invoice.Invoice
import net.cghsystems.pdf.invoice.widgets.InvoiceHeaderWidget
import net.cghsystems.pdf.invoice.widgets.InvoicePaymentSummaryWidgetProvider
import net.cghsystems.pdf.invoice.widgets.InvoicePeriodWidgetProvider
import net.cghsystems.pdf.invoice.widgets.InvoiceSummaryWidget
import net.cghsystems.pdf.shared.builder.PDFDocumentBuilder

import com.itextpdf.text.Document
import com.itextpdf.text.pdf.PdfWriter


/**
 * Top level {@link Invoice}  PDF object that allows a PDF Invoice document to be written to a outputStream. The generated PDF 
 * should contain:
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
@Mixin(InvoiceSummaryWidget)
class InvoicePDFDocumentBuilder implements PDFDocumentBuilder<Invoice> {

    /** The itext 'canvas' to create the pdf within */
    private final Document doc = new Document()


    /* (non-Javadoc)
     * @see net.cghsystems.pdf.shared.builder.PDFDocumentBuilder#generate(java.lang.Object, java.io.OutputStream)
     */
    void generate(Invoice invoice, OutputStream outputStream) {

        if(invoice == null || outputStream == null) {
            throw new IllegalStateException("Cannot accept a null parameter")
        }

        invoice.isValid()

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
}
