package net.cghsystems.model.invoice

import groovy.transform.ToString
import net.cghsystems.groovy.transform.Validateable
import net.cghsystems.groovy.transform.Validateable.ValidatableReturnTypes

/**
 * The domain object representing the totals that are displayed on the invoice 
 */
@Validateable(ValidatableReturnTypes.NOT_VALID_FOR_INVALID)
@ToString
class InvoiceCalculation {
    Integer days
    Double rate
    Double vat

    String toString() {
        "${days} Days @ ${rate}"
    }

    BigDecimal total() {
        totalNoVat().add(vatOfTotal())
    }

    BigDecimal vatOfTotal() {
        BigDecimal totalNoVat = totalNoVat()
        totalNoVat.divide(100).multiply(vat)
    }

    BigDecimal totalNoVat() {
        rate = rate ? rate : 0
        BigDecimal res = new BigDecimal(rate)
        res.multiply(days)
    }
}
