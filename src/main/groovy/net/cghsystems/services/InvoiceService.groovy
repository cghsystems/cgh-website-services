package net.cghsystems.services

import net.cghsystems.model.invoice.Invoice
import net.cghsystems.providers.InvoiceCalculatorProvider
import net.cghsystems.providers.InvoiceClientProvider
import net.cghsystems.providers.InvoiceCompanyProvider

//TODO WRite unit test

@Mixin(InvoiceCompanyProvider)
@Mixin(InvoiceClientProvider)
@Mixin(InvoiceCalculatorProvider)
class InvoiceService {

    def createInvoice(InvoiceParameters params) {

        def invoiceCompany = getInvoiceCompany(params.companyId)
        def invoiceClient =  getInvoiceClient(params.clientId)
        def invoiceDescription = getInvoiceDescription(params.companyId, params.clientId)
        def invoiceCalculation = getInvoiceCalculation(params.companyId, params.clientId, params.days)

        Invoice invoice = new Invoice(invoiceCompany: invoiceCompany,
                invoiceClient: invoiceClient,
                invoiceCalculation: invoiceCalculation,
                fromDate: params.fromDate,
                taxPointDate: params.toDate,
                toDate: params.toDate,
                description: invoiceDescription)

        return invoice
    }
}
