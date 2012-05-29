package net.cghsystems.model.invoice.builders


import java.text.SimpleDateFormat

import net.cghsystems.groovy.transform.NotValid

/**
 * Class encapsulating parameters required to generate an {@code Invoice}  
 * <pre>
 *    toDate, fromDate and taxPointDate Must be provided as String in the format dd/MM/yyyy
 * </pre>
 * 
 */
class InvoiceParameters {

    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy")

    def companyId, clientId, days, toDate, number, taxPointDate
    String fromDate

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

    def isValid() {
        def invalidFields = []
        if(companyId == null) {
            invalidFields << "companyId"
        }
        if(clientId == null) {
            invalidFields << "clientId"
        }
        if(days == null) {
            invalidFields << "days"
        }
        if(fromDate == null) {
            invalidFields << "fromDate"
        }
        if(toDate == null) {
            invalidFields << "toDate"
        }
        if(number == null) {
            invalidFields << "number"
        }
        if(taxPointDate == null) {
            invalidFields << "taxPointDate"
        }
        invalidFields.size() == 0 ? true : newNotValid(invalidFields)
    }

    private newNotValid(invalidFields) {
        new NotValid(preMessage: "The following fields have not been set:", invalidFields: invalidFields)
    }
}
