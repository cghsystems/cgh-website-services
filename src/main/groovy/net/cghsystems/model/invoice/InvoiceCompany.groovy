package net.cghsystems.model.invoice

import groovy.transform.ToString
import net.cghsystems.model.Address
import net.cghsystems.model.BankDetails
import net.cghsystems.model.Company

/**
 * The Object that represents the Company that the invoice is generated for. E.g cgh systems ltd.
 */
@ToString
class InvoiceCompany extends Company {
    String companyNumber, vatNumber
    BankDetails bankDetails
    Date created
}
