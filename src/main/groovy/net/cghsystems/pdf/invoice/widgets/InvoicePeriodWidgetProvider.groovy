package net.cghsystems.pdf.invoice.widgets

import java.text.DecimalFormat
import java.text.NumberFormat

import net.cghsystems.model.invoice.Invoice
import net.cghsystems.pdf.shared.PDFDocumentConstants

import com.itextpdf.text.Font
import com.itextpdf.text.Rectangle
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable

class InvoicePeriodWidgetProvider {

    def buildInvoicePeriodWidget(Invoice invoice) {

        bounceInvoiceIfInValid(invoice)

        PdfPTable main = new PdfPTable(false, 4)
        main.setWidthPercentage(PDFDocumentConstants.TABLE_WIDTH)
        main.addCell("Description:")

        PdfPTable desc = new PdfPTable(false, 1)
        desc.addCell(invoice.description)
        PdfPCell cell = new PdfPCell(desc)
        cell.setBorder(Rectangle.NO_BORDER)
        cell.setColspan(3)
        main.addCell(cell)
        main.setHeaderRows(1)

        main.addCell("Period:")
        main.addCell("${invoice.fromDate} - ${invoice.toDate}")

        main.addEmptyCells(2)

        main.addCell("Client:")
        main.addCell(invoice.invoiceClient.name)

        main.addEmptyCells(2)

        main.addCell("Detail:")
        main.addCell("${invoice.invoiceCalculation.toString()}")

        main.addEmptyCells(5)

        NumberFormat fmt = new DecimalFormat("##.##")
        main.addCell("£ ${fmt.format(invoice.invoiceCalculation.totalNoVat())}")

        main.addEmptyCells(2)
        main.addCell("Vat @ ${invoice.invoiceCalculation.vat}%")
        main.addCell("£ ${fmt.format(invoice.invoiceCalculation.vatOfTotal())}")

        main.addEmptyCells(2)
        main.addCell("Total:")
        main.addCell("£ ${fmt.format(invoice.invoiceCalculation.total())}", Font.BOLD)

        return main
    }

    private bounceInvoiceIfInValid(Invoice invoice) {
        if(!invoice.isValid()) {
            throw new IllegalStateException("Invoice Object is NotValid: ${invoice.isValid().message}")
        }

        if(!invoice.invoiceCalculation.isValid()) {
            throw new IllegalStateException("Invoice Object is NotValid: ${invoice.invoiceCalculation.isValid().message}")
        }
    }
}
