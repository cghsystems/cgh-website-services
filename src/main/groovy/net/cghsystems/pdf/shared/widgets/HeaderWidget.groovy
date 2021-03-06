package net.cghsystems.pdf.shared.widgets


import net.cghsystems.model.Address
import net.cghsystems.model.invoice.InvoiceCompany
import net.cghsystems.pdf.shared.PDFDocumentConstants

import com.itextpdf.text.Font
import com.itextpdf.text.pdf.PdfPTable

class HeaderWidget {

    def build(InvoiceCompany company) {

        PdfPTable nameCol = new PdfPTable(false, 1)
        nameCol.addCell(company.name.toUpperCase(), Font.NORMAL, 14)

        PdfPTable addressCol = new PdfPTable(false, 1)
        addressCol.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT)
        addAddressToColumn(company.address, addressCol)

        PdfPTable header = new PdfPTable(false, 2)
        header.setWidthPercentage(PDFDocumentConstants.TABLE_WIDTH)

        header.addCell(nameCol)
        header.addCell(addressCol)
        return header
    }

    void addAddressToColumn(Address address, PdfPTable column) {
        def closure = { column.addCell(it) }
        address.buildAddress(closure, address)
    }
}
