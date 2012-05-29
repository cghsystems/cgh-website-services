package net.cghsystems.model.invoice.datastores

import net.cghsystems.model.invoice.InvoiceCalculation


@Category(Object)
class InvoiceCalculatorDataStore {

    private final static VAT_RATE = 20

    def getInvoiceCalculation(Long companyId, Long clientId, days) {
        if (companyId == InvoiceDataStoreCompanyIds.CGH && clientId == InvoiceDataStoreCompanyIds.DATA_INC) {
            return new InvoiceCalculation(days: days, rate: 400, vat: VAT_RATE)
        }
        throw new DataStoreException("Cannot find InvoiceCalculation with companyId: ${companyId} and ClientId: ${clientId}")
    }
}
