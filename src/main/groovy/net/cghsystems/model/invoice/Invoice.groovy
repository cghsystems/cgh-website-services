package net.cghsystems.model.invoice

import net.cghsystems.groovy.transform.Validateable
import net.cghsystems.groovy.transform.Validateable.ValidatableReturnTypes
import net.cghsystems.model.Company


/**
 * Object representing a top level invoice domain object. A invoice contains all of the information required in 
 * order for it to be rendered to a view.
 */
@Validateable(ValidatableReturnTypes.NOT_VALID_FOR_INVALID)
class Invoice {
    int number
    String description, taxPointDate, fromDate, toDate
    InvoiceCompany invoiceCompany
    Company invoiceClient
    InvoiceCalculation invoiceCalculation
}