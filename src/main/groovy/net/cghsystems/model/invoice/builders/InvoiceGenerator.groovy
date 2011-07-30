package net.cghsystems.model.invoice.builders

import javax.annotation.Resource

import net.cghsystems.model.Address
import net.cghsystems.model.InvoiceCompany
import net.cghsystems.model.invoice.BankDetails
import net.cghsystems.model.invoice.Invoice;
import net.cghsystems.model.invoice.InvoiceCalculation
import net.cghsystems.model.invoice.InvoiceClient
import net.cghsystems.services.InvoiceModelService
import net.cghsystems.services.InvoiceCalculator

//TODO WRite unit test
class InvoiceGenerator {

	@Resource(name = "invoiceModelService")
	final InvoiceModelService invoiceModelService

	@Resource(name = "invoiceCalculator")
	final InvoiceCalculator invoiceCalculator

	def findInvoiceForCGHSystemsAndDataInc(days, fromDate, toDate) {
		final CGH = 1;
		final DATA_INC = 1;
		
		def invoiceCompany = invoiceModelService.getInvoiceCompany(CGH)
		def invoiceClient = invoiceModelService.getInvoiceClient(DATA_INC)
		def invoiceDescription = invoiceModelService.getInvoiceDescription(CGH, DATA_INC)
		def invoiceCalculation = invoiceCalculator.createInvoiceCalculation(CGH, DATA_INC, days)

		Invoice invoice = new Invoice(invoiceCompany: invoiceCompany,
				invoiceClient: invoiceClient,
				invoiceCalculation: invoiceCalculation,
				fromDate: fromDate,
				taxPointDate: toDate,
				toDate:toDate,
				description: invoiceDescription)
		
		return invoice
	}
}
