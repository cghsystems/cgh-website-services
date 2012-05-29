package net.cghsystems.pdf.widgets

import net.cghsystems.model.Address
import net.cghsystems.model.InvoiceCompany
import net.cghsystems.pdf.invoice.InvoicePDFConstants

import com.itextpdf.text.Font
import com.itextpdf.text.pdf.PdfPTable



class InvoiceHeaderWidget {

    def buildHeaderWidget(InvoiceCompany invoice) {

        PdfPTable nameCol = new PdfPTable(false, 1)
        nameCol.addCell(invoice.name.toUpperCase(), Font.NORMAL, 14)

        PdfPTable addressCol = new PdfPTable(false, 1)
        addressCol.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT)
        addAddressToColumn(invoice.registeredOffice, addressCol)

        PdfPTable header = new PdfPTable(false, 2)
        header.setWidthPercentage(InvoicePDFConstants.TABLE_WIDTH)

        header.addCell(nameCol)
        header.addCell(addressCol)
        return header
    }

    void addAddressToColumn(Address address, PdfPTable column) {
        def closure = { column.addCell(it) }
        address.buildAddress(closure, address)
    }
}
