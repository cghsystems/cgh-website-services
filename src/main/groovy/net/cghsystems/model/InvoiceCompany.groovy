package net.cghsystems.model

import net.cghsystems.model.invoice.BankDetails
import net.cghsystems.model.invoice.InvoiceCalculation


/**
 * The Object that represents the Company tht the invoice is generated for.
 */
class InvoiceCompany {
	String name, companyNumber, vatNumber
	Address registeredOffice
	BankDetails bankDetails
	Date created
}
