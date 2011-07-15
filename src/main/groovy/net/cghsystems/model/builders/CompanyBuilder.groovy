package net.cghsystems.model.builders

import javax.annotation.Resource

import net.cghsystems.model.Address
import net.cghsystems.model.Company
import net.cghsystems.model.invoice.BankDetails
import net.cghsystems.model.invoice.ContractDetail
import net.cghsystems.services.InvoiceModelService

class CompanyBuilder {

	@Resource(name = "invoiceModelService")
	final InvoiceModelService invoiceModelService;

	def buildCompany(days) {

		final CGH = 1;


		String name = "CGH Systems Ltd"
		String companyNumber = "7173828"
		String vatNumber = "988 0979 40"

		Address registeredOffice = invoiceModelService.getCompanyAddress(CGH)
		BankDetails bankDetails = invoiceModelService.getBankDetails(CGH)
		ContractDetail invoiceDetail = new ContractDetail(days: days, rate: 400, vat: 20)

		return new Company(bankDetails: bankDetails,
		companyNumber: companyNumber,
		contractDetail: invoiceDetail,
		created: new Date(),
		name: name,
		registeredOffice: registeredOffice,
		vatNumber: vatNumber)
	}
}
