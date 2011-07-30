package net.cghsystems.model.invoice;

import net.cghsystems.model.InvoiceCompany

/**
 * Object representing an invoice. 
 */
class Invoice {
	int number
	String description
	String taxPointDate, fromDate, toDate
	Date taxPointDate2
	InvoiceCompany invoiceCompany
	InvoiceClient invoiceClient
}
