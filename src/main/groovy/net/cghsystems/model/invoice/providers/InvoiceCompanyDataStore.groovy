package net.cghsystems.model.invoice.providers

import java.util.Date

import net.cghsystems.model.InvoiceCompany


@Category(Object)
@Mixin(AddressDataStore)
@Mixin(BankDetailsDataStore)
class InvoiceCompanyDataStore {

    InvoiceCompany  getInvoiceCompany(companyId) {
        if(companyId == InvoiceDataStore.CGH) {

            String name = "CGH Systems Ltd"
            String companyNumber = "7173828"
            String vatNumber = "988 0979 40"

            def registeredOffice = getAddress(companyId)
            def bankDetails = getBankDetails(companyId)

            return new InvoiceCompany(bankDetails: bankDetails,
            companyNumber: companyNumber,
            created: new Date(),
            name: name,
            registeredOffice: registeredOffice,
            vatNumber: vatNumber)
        }
    }
}

