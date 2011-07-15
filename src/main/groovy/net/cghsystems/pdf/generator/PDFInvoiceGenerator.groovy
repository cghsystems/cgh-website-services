package net.cghsystems.pdf.generator



import net.cghsystems.model.invoice.Invoice
import net.cghsystems.model.invoice.builders.CghsystemsInvoiceBuilder;
import net.cghsystems.pdf.widgets.HeaderWidget
import net.cghsystems.pdf.widgets.InvoicePaymentSummaryWidget
import net.cghsystems.pdf.widgets.InvoicePeriodWidget
import net.cghsystems.pdf.widgets.InvoiceSummaryWidget

import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter



class PDFInvoiceGenerator {

	private final Document doc = new Document();

	def build(fromDate, toDate, days, number, outputStream) {

		Invoice invoice = new CghsystemsInvoiceBuilder().build(days, fromDate, toDate, number, toDate)

		def output = PdfWriter.getInstance(doc, outputStream)
		doc.open();

		addMetaData();

		addHeader(invoice)
		doc.addLineBreak()
		addInvoiceSummary(invoice);
		doc.addLineBreak()
		addPeriodSummary(invoice)
		doc.addLineBreak()
		addPaymentSummary(invoice)
		doc.close();
	}

	void addPaymentSummary(Invoice invoice) {
		doc.add(new InvoicePaymentSummaryWidget().build(invoice))
	}

	void addPeriodSummary(Invoice invoice) {
		doc.add(new InvoicePeriodWidget().build(invoice))
	}

	void addHeader(invoice) {
		doc.add(new HeaderWidget().build(invoice.company))
	}

	void addMetaData() {
		doc.addTitle("Invoice")
		doc.addSubject("Invoice")
		doc.addKeywords("Invoice for Christopher Hedley")
		doc.addAuthor("cgh-systems")
		doc.addCreator("cgh-systems")
	}

	void addInvoiceSummary(invoice) {

		PdfPTable summaryTable = new InvoiceSummaryWidget().build(invoice)

		Paragraph section = new Paragraph();
		section.add(summaryTable)

		doc.add(section)
	}
}
