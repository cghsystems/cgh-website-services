package net.cghsystems.services

import net.cghsystems.pdf.model.Address


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
}
