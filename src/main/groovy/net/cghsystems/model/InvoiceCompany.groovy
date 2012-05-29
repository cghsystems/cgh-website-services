package net.cghsystems.model

import net.cghsystems.model.invoice.BankDetails

/**
 * The Object that represents the Company that the invoice is generated for. E.g cgh systems ltd.
 */
class InvoiceCompany {
    String name, companyNumber, vatNumber
    Address registeredOffice
    BankDetails bankDetails
    Date created
}
