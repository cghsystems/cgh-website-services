package net.cghsystems.providers

import net.cghsystems.model.InvoiceCompany


@Category(Object)
@Mixin(AddressProvider)
@Mixin(BankDetailsProvider)
class InvoiceCompanyProvider {

    InvoiceCompany  getInvoiceCompany(Long companyId) {
        if(companyId == InvoiceConstants.CGH) {

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

