package net.cghsystems.pdf.widgets;

import net.cghsystems.model.invoice.InvoiceClient
import net.cghsystems.model.invoice.Invoice
import net.cghsystems.pdf.invoice.InvoicePDFConstants

import com.itextpdf.text.pdf.PdfPTable


class InvoiceSummaryWidget {

	def build(Invoice invoice) {

		PdfPTable col1 = buildLeftHandSummaryColumn(invoice)
		PdfPTable col2 = buildRightHandSummaryColumn(invoice)

		PdfPTable mainTable = new PdfPTable(false, 2)
		mainTable.setWidthPercentage(InvoicePDFConstants.TABLE_WIDTH)

		mainTable.addCell(col1)
		mainTable.addCell(col2)

		return mainTable
	}

	def buildLeftHandSummaryColumn(Invoice invoice) {

		PdfPTable a = new PdfPTable(false, 1)
		a.addCell("Invoice to:")

		PdfPTable t = new PdfPTable(false, 1)
		addCounterpartAddressToColumn(invoice.client, t)

		PdfPTable col = new PdfPTable(false, 2)
		col.addCell(a)
		col.addCell(t)
		return col
	}

	void addCounterpartAddressToColumn(InvoiceClient cpty, PdfPTable column) {
		column.addCell(cpty.name)
		column.addCell(cpty.address.line1)
		column.addCell(cpty.address.line2)
		column.addCell(cpty.address.town)
		column.addCell(cpty.address.postcode)
	}

	def buildRightHandSummaryColumn(Invoice invoice) {

		PdfPTable col2 = new PdfPTable(false, 2)

		PdfPTable t = new PdfPTable(false, 1)
		t.addCell("Invoice Number:")
		t.addCell("Company Number:")
		t.addCell("VAT Number:")
		t.addCell("Tax Point Date:")

		PdfPTable d = new PdfPTable(false, 1)
		d.addCell("${invoice.number}")
		d.addCell("${invoice.company.companyNumber}")
		d.addCell("${invoice.company.vatNumber}")
		d.addCell("${invoice.taxPointDate}")

		col2.addCell(t)
		col2.addCell(d)

		return col2;
	}
}
