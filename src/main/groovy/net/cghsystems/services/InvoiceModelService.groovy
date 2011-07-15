package net.cghsystems.services

import net.cghsystems.model.Address
import net.cghsystems.model.invoice.BankDetails

/** TODO Will add support for DAO layer eventually */
class InvoiceModelService {

	private final static CGH = 1

	Address getCompanyAddress(Long companyId) {
		if(companyId == CGH) {
			return new Address(line1: "51 Brantwood",
			line2: "Chester-le-Street",
			county: "Co. Durham",
			postcode: "DH2 2UJ")
		}
		throw new InvoiceModelException("Address not found for compnay with id ${companyId}")
	}

	BankDetails getBankDetails(Long companyId) {
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
