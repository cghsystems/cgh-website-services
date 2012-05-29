package net.cghsystems.pdf.invoice.widgets


import net.cghsystems.model.Address
import net.cghsystems.model.invoice.InvoiceCompany;
import net.cghsystems.pdf.invoice.InvoicePDFConstants

import com.itextpdf.text.Font
import com.itextpdf.text.pdf.PdfPTable

@Category(Object)
class HeaderWidgetProvider {

    def buildHeaderWidget(InvoiceCompany company) {

        PdfPTable nameCol = new PdfPTable(false, 1)
        nameCol.addCell(company.name.toUpperCase(), Font.NORMAL, 14)

        PdfPTable addressCol = new PdfPTable(false, 1)
        addressCol.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT)
        addAddressToColumn(company.registeredOffice, addressCol)

        PdfPTable header = new PdfPTable(false, 2)
        header.setWidthPercentage(InvoicePDFConstants.TABLE_WIDTH)

        header.addCell(nameCol)
        header.addCell(addressCol)
        return header
    }

    private void addAddressToColumn(Address address, PdfPTable column) {
        def closure = { column.addCell(it) }
        address.buildAddress(closure, address)
    }
}
