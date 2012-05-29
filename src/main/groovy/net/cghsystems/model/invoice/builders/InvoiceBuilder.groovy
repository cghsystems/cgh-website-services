package net.cghsystems.model.invoice.builders

import groovy.lang.Mixin
import net.cghsystems.model.invoice.Invoice
import net.cghsystems.model.invoice.providers.InvoiceCalculatorDataStore
import net.cghsystems.model.invoice.providers.InvoiceClientDataStore
import net.cghsystems.model.invoice.providers.InvoiceCompanyDataStore

/**
 * @author chris
 * 
 *         Given a valid {@link InvoiceParameters} will build up the
 *         {@link Invoice} domain object for the provided company. The invoice
 *         should contain the all details related the client, the period
 *         represented, VAT figures and the invoice totals.
 * 
 */
@Mixin(InvoiceCompanyDataStore)
@Mixin(InvoiceClientDataStore)
@Mixin(InvoiceCalculatorDataStore)
class InvoiceBuilder {

    def createInvoice(InvoiceParameters params) {
        if(params.isValid()==true) {

            def invoiceCompany = getInvoiceCompany(params.companyId)
            def invoiceClient =  getInvoiceClient(params.clientId)
            def invoiceDescription = getInvoiceDescription(params.companyId, params.clientId)
            def invoiceCalculation = getInvoiceCalculation(params.companyId, params.clientId, params.days)

            new Invoice(invoiceCompany: invoiceCompany,
                    invoiceClient: invoiceClient,
                    invoiceCalculation: invoiceCalculation,
                    fromDate: params.fromDate,
                    taxPointDate: params.taxPointDate,
                    toDate: params.toDate,
                    description: invoiceDescription)
        } else {
            return params.isValid()
        }
    }
}
