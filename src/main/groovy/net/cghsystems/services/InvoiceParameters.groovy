package net.cghsystems.services

import java.text.SimpleDateFormat

/**
 * Class encapsulating parameters required to generate an {@code Invoice}  
 */
class InvoiceParameters {

    private static final DF = new SimpleDateFormat("dd/MM/yyyy")

    final Long companyId, clientId
    def days, fromDate, toDate, number, taxPointDate

    def getFromDate() {
        if(fromDate == "" || fromDate == null) {
            throw new IllegalArgumentException("Cannot form fromDate as it is null")
        }
        DF.format(fromDate)
    }

    def getTaxPointDate() {
        if(taxPointDate == "" || taxPointDate == null) {
            throw new IllegalArgumentException("Cannot form fromDate as it is null")
        }
        DF.format(taxPointDate)
    }
}
