package net.cghsystems.model

import net.cghsystems.model.invoice.BankDetails

/**
 * The Object that represents the Company that the invoice is generated for.
 */
class InvoiceCompany {
    String name, companyNumber, vatNumber
    Address registeredOffice
    BankDetails bankDetails
    Date created
}
