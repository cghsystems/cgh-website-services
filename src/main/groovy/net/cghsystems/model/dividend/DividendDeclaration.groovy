package net.cghsystems.model.dividend


import java.math.RoundingMode

import net.cghsystems.model.Company
import net.cghsystems.model.Contact


/**
 * Domain object that represents a Dividend declaration. This object required to produce the dividend declaration 
 * forms required by the HRMC every time a dividend is paid to a a director of a company. The information required 
 * includes dates of shareholder meetings, company the dividend represents and the Dividend figure to be paid. 
 * Currently only supports sterling
 * 
 * @author chris
 *
 */
class DividendDeclaration {

    String dateHeld
    Company company
    Contact director
    BigDecimal dividend

    BigDecimal taxCredit() {
        dividend.divide(9, RoundingMode.HALF_EVEN)
    }

    BigDecimal grossDividend() {
        dividend.add(taxCredit())
    }
}
