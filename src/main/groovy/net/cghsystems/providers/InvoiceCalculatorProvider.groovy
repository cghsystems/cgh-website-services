package net.cghsystems.providers

import net.cghsystems.model.invoice.InvoiceCalculation


@Category(Object)
class InvoiceCalculatorProvider {

    private final static VAT_RATE = 20

    def getInvoiceCalculation(Long companyId, Long clientId, days) {
        if (companyId == InvoiceConstants.CGH && clientId == InvoiceConstants.DATA_INC) {
            return new InvoiceCalculation(days: days, rate: 400, vat: VAT_RATE)
        }
        throw new ProviderException("Cannot find InvoiceCalculation with companyId: ${companyId}} and ClientId: ${clientId}}")
    }
}
