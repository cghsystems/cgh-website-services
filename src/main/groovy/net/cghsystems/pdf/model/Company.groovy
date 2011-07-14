package net.cghsystems.pdf.model

import net.cghsystems.pdf.model.invoice.BankDetails;
import net.cghsystems.pdf.model.invoice.ContractDetail;



class Company {
	String name, companyNumber, vatNumber
	Address registeredOffice
	ContractDetail contractDetail;
	BankDetails bankDetails
	Date created
}
