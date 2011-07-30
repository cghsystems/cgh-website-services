package net.cghsystems.services

import net.cghsystems.model.Address
import net.cghsystems.model.invoice.BankDetails
import net.cghsystems.model.invoice.Invoice;
import net.cghsystems.model.InvoiceCompany
import net.cghsystems.model.invoice.InvoiceClient

/** TODO Will add support for DAO layer eventually */
class InvoiceModelService {

	private final static CGH = 1
	private final static DATA_INC = 1

	def getInvoiceDescription(Long companyId, Long clientId) {
		if(companyId == CGH && companyId == DATA_INC) {
			"For professional services of consultant, working for Data Inc UK Ltd at your client UBS."
		}
	}

	InvoiceCompany  getInvoiceCompany(Long companyId) {
		if(companyId == CGH) {

			String name = "CGH Systems Ltd"
			String companyNumber = "7173828"
			String vatNumber = "988 0979 40"

			def registeredOffice = getCompanyAddress(CGH)
			def bankDetails = getBankDetails(CGH)

			return new InvoiceCompany(bankDetails: bankDetails,
			companyNumber: companyNumber,
			created: new Date(),
			name: name,
			registeredOffice: registeredOffice,
			vatNumber: vatNumber)
		}
	}

	InvoiceClient getInvoiceClient(Long clientId) {
		if(clientId == DATA_INC) {
			def add = new Address(line1: "4 Winnersh Fields",
			town: "Winnersh",
			county: "Berkshire",
			postcode: "RG41 5QS")

			def contact = new Contact(emailAddress: "sian@dataincuk.com",
			ccEmailAddress: "sian@dataincuk.com",
			name: "Siân")

			return new InvoiceClient(address: add, name: "Data Inc UK Ltd", contact: contact)
		}
	}

	private def getCompanyAddress(Long companyId) {
		if(companyId == CGH) {
			return new Address(line1: "51 Brantwood",
			line2: "Chester-le-Street",
			county: "Co. Durham",
			postcode: "DH2 2UJ")
		}
		throw new InvoiceModelException("Address not found for compnay with id ${companyId}")
	}

	private def getBankDetails(Long companyId) {
		if(companyId == CGH) {
			return new BankDetails(accountNumber: "71432559",
			name: "HSBC",
			reference: "cgh-systems",
			sortCode: "40-17-31",
			address: bankAddress(),
			remittanceAdvice: "chris@cghsystems.net")
		}
		throw new InvoiceModelException("BankDetails not found for compnay with id ${companyId}")
	}

	private def bankAddress() {
		return new Address(line1: "The Helicon",
		line2: "1 South Place",
		town: "The City",
		county: "London",
		postcode: "EC2M 2UP")
	}
}
