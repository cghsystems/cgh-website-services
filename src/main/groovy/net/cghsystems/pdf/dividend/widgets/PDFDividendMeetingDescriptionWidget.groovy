package net.cghsystems.pdf.dividend.widgets

import com.itextpdf.text.Font
import com.itextpdf.text.FontFactory
import com.itextpdf.text.Paragraph

class PDFDividendMeetingDescriptionWidget {

    private final String description =
    """
	At a meeting of the Directors of the Company held on the above date, it was proposed and resolved to confirm the payments to the shareholders of the Company Dividends in the proportion of their respective shareholdings in the amounts shown below.
	"""

    def buildMeetingDescription() {
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 8)
        new Paragraph(description, font)
    }
}
