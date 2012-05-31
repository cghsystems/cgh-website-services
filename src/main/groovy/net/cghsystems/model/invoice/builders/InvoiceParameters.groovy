package net.cghsystems.model.invoice.builders


import java.text.SimpleDateFormat

import net.cghsystems.groovy.transform.Validateable



/**
 * Class encapsulating parameters required to generate an {@code Invoice}  
 * <pre>
 *    toDate, fromDate and taxPointDate Must be provided as String in the format dd/MM/yyyy
 * </pre>
 * 
 */
@Validateable
class InvoiceParameters {

    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy")

    def companyId, clientId, days, toDate, number, taxPointDate
    String fromDate

    //TODO Look into using the elvis operator here to make the null check more groovy
    def getFromDate() {
        if(fromDate == "" || fromDate == null) {
            throw new IllegalArgumentException("Cannot form fromDate as it is null. Hint: Try calling isValid to validate instance")
        }
        df.parse(fromDate)
    }

    def getTaxPointDate() {
        if(taxPointDate == "" || taxPointDate == null) {
            throw new IllegalArgumentException("Cannot form fromDate as it is null. Hint Try calling isValid to validate instnace")
        }
        df.parse(taxPointDate)
    }

    def getToDate() {
        if(taxPointDate == "" || taxPointDate == null) {
            throw new IllegalArgumentException("Cannot form toDate as it is null. Hint Try calling isValid to validate instnace")
        }
        df.parse(toDate)
    }
}
