package net.cghsystems.services;

import net.cghsystems.model.invoice.InvoiceCalculation;

class InvoiceCalculator {

	private final static CGH = 1
	private final static DATA_INC = 1
	private final static VAT_RATE = 20
	
	def createInvoiceCalculation(Long companyId, Long clientId, days) {
		if (companyId == CGH && clientId == DATA_INC) {
			return new InvoiceCalculation(days: days, rate: 400, vat: VAT_RATE)
		}
	}
}
