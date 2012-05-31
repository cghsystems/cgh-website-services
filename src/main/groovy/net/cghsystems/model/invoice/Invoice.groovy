package net.cghsystems.model.invoice

import net.cghsystems.groovy.transform.Validateable
import net.cghsystems.model.Company


/**
 * Object representing an invoice. 
 */
@Validateable
class Invoice {
    int number
    String description, taxPointDate, fromDate, toDate
    InvoiceCompany invoiceCompany
    Company invoiceClient
    InvoiceCalculation invoiceCalculation
}