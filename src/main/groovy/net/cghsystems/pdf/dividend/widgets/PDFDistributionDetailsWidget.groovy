package net.cghsystems.pdf.dividend.widgets

import java.text.DecimalFormat
import java.text.NumberFormat

import net.cghsystems.model.dividend.DividendDeclaration

import com.itextpdf.text.pdf.PdfPTable


class PDFDistributionDetailsWidget {

    def buildDistributionDetails(DividendDeclaration dividend) {

        PdfPTable summaryTable = new PdfPTable(false, 2)

        PdfPTable t = new PdfPTable(false, 1)
        t.addCell("Net Dividend:")
        t.addCell("Tax Credit:")
        t.addCell("Gross Dividend:")

        NumberFormat fmt = new DecimalFormat("####.##")

        PdfPTable d = new PdfPTable(false, 1)
        d.addCell("£ ${fmt.format(dividend.dividend)}")
        d.addCell("£ ${fmt.format(dividend.taxCredit())}")
        d.addCell("£ ${fmt.format(dividend.grossDividend())}")

        summaryTable.addCell(t)
        summaryTable.addCell(d)

        return summaryTable
    }
}
