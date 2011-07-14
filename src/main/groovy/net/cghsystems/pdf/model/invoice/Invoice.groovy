package net.cghsystems.pdf.model.invoice;

import net.cghsystems.pdf.model.Company



class Invoice {
	int number
	String description
	String taxPointDate, fromDate, toDate
	Client client = new Client()
	Company company
	Date taxPointDate2
}
