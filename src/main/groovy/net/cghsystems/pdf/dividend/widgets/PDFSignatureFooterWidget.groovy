package net.cghsystems.pdf.dividend.widgets


import net.cghsystems.pdf.shared.PDFDocumentConstants

import com.itextpdf.text.pdf.PdfPTable

class PDFSignatureFooterWidget {

    def buildFooter() {

        PdfPTable table = new PdfPTable(false, 2)
        table.setWidthPercentage(PDFDocumentConstants.TABLE_WIDTH)

        table.addCell("______________________________________")
        table.addCell("______________________________________")

        table.addCell("Director")
        table.addCell("Date")

        table
    }
}
