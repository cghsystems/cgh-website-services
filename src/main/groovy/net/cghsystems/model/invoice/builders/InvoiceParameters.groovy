package net.cghsystems.model.invoice.builders


import java.text.SimpleDateFormat

import net.cghsystems.groovy.transform.Validateable
import net.cghsystems.groovy.transform.Validateable.ValidatableReturnTypes



/**
 * Class encapsulating parameters required to generate an {@code Invoice} via {@link InvoiceBuilder}
 * <pre>
 *    toDate, fromDate and taxPointDate Must be provided as String in the format dd/MM/yyyy
 * </pre>
 * 
 */
@Validateable(ValidatableReturnTypes.NOT_VALID_FOR_INVALID)
class InvoiceParameters {

    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy")

    def companyId, clientId, days, toDate, number, taxPointDate
    String fromDate

    def getFromDate() {
        bounceNulls(fromDate, "fromDate")
        df.parse(fromDate)
    }

    def getTaxPointDate() {
        bounceNulls(taxPointDate, "taxPointDate")
        df.parse(taxPointDate)
    }

    def getToDate() {
        bounceNulls(toDate, "toDate")
        df.parse(toDate)
    }

    private bounceNulls(var, varName) {
        if(var == "" || var == null) {
            throw new IllegalArgumentException("Cannot form ${varName} as it is null. Hint: Try calling isValid to validate instance")
        }
    }
}
