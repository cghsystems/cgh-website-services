package net.cghsystems.model.invoice

import net.cghsystems.groovy.transform.NotValid
import net.cghsystems.model.Company;


/**
 * Object representing an invoice. 
 */
class Invoice {
    int number
    String description
    String taxPointDate, fromDate, toDate
    //Date taxPointDate2
    InvoiceCompany invoiceCompany
    Company invoiceClient
    InvoiceCalculation invoiceCalculation

    def isValid() {

        def errorFields = []
        def ignore = ["class", "metaClass"]
        properties.keySet().collect{ it }.findAll{
            !ignore.contains(it)
        }.each {
            if(properties.get(it) == null) {
                errorFields << it
            }
        }

        if(errorFields.size() == 0) {
            return true
        }else {
            return new NotValid(preMessage: "The following fields have not been build correctly: ", invalidFields: errorFields)
        }
    }
}