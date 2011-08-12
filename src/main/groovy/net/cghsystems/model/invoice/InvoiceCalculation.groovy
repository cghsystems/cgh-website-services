package net.cghsystems.model.invoice

/**
 * The object representing the totals that are displayed on the invoice 
 */
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
        BigDecimal res = new BigDecimal(rate)
        res.multiply(days)
    }
}
