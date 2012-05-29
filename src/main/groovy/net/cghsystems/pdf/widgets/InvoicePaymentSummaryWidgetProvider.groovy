package net.cghsystems.pdf.widgets

import net.cghsystems.model.invoice.Invoice
import net.cghsystems.pdf.invoice.InvoicePDFConstants

import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfPTable



@Category(Object)
class InvoicePaymentSummaryWidgetProvider {

    def buildInvoicePaymentSummaryWidget(Invoice invoice) {
        Paragraph paragraph = new Paragraph()

        paragraph.add("Please make payment to:")
        addPaymentSummaryToParagraph(paragraph, invoice)
        return paragraph
    }

    void addPaymentSummaryToParagraph(Paragraph paragraph, Invoice invoice) {

        PdfPTable leftColumn = new PdfPTable(false, 1)
        leftColumn.addCell("Company:")
        leftColumn.addCell("Registered Office:")
        leftColumn.addCell("Bank:")
        leftColumn.addCell("Address:")
        leftColumn.addCell("Sort Code:")
        leftColumn.addCell("Account Number:")
        leftColumn.addCell("Reference:")
        leftColumn.addCell("Remittance Advice:")

        PdfPTable rightColumn = new PdfPTable(false, 1)
        rightColumn.addCell(invoice.invoiceCompany.name)
        rightColumn.addCell(invoice.invoiceCompany.registeredOffice.toString())
        rightColumn.addCell(invoice.invoiceCompany.bankDetails.name)
        rightColumn.addCell(invoice.invoiceCompany.bankDetails.address.toString())
        rightColumn.addCell(invoice.invoiceCompany.bankDetails.sortCode)
        rightColumn.addCell(invoice.invoiceCompany.bankDetails.accountNumber)
        rightColumn.addCell(invoice.invoiceCompany.bankDetails.reference)
        rightColumn.addCell(invoice.invoiceCompany.bankDetails.remittanceAdvice)

        PdfPTable main = new PdfPTable(false, 2)
        main.setWidthPercentage(InvoicePDFConstants.TABLE_WIDTH)
        main.addCell(leftColumn)
        main.addCell(rightColumn)
        paragraph.add(main)
    }
}
