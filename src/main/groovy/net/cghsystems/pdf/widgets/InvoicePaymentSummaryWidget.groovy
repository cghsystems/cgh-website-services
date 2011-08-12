package net.cghsystems.pdf.widgets;

import net.cghsystems.model.invoice.Invoice
import net.cghsystems.pdf.invoice.InvoicePDFConstants

import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfPTable




class InvoicePaymentSummaryWidget {

    def build(Invoice invoice) {
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
        rightColumn.addCell(invoice.company.name)
        rightColumn.addCell(invoice.company.registeredOffice.toString())
        rightColumn.addCell(invoice.company.bankDetails.name)
        rightColumn.addCell(invoice.company.bankDetails.address)
        rightColumn.addCell(invoice.company.bankDetails.sortCode)
        rightColumn.addCell(invoice.company.bankDetails.accountNumber)
        rightColumn.addCell(invoice.company.bankDetails.reference)
        rightColumn.addCell(invoice.company.bankDetails.remittanceAdvice)

        PdfPTable main = new PdfPTable(false, 2)
        main.setWidthPercentage(InvoicePDFConstants.TABLE_WIDTH)
        main.addCell(leftColumn)
        main.addCell(rightColumn)
        paragraph.add(main)
    }
}
