package net.cghsystems.model.invoice.datastores

import net.cghsystems.model.Contact
import net.cghsystems.model.datastores.AddressDataStore
import net.cghsystems.model.datastores.BankDetailsDataStore
import net.cghsystems.model.invoice.InvoiceCompany


@Category(Object)
@Mixin(AddressDataStore)
@Mixin(BankDetailsDataStore)
class InvoiceCompanyDataStore {

    InvoiceCompany  getInvoiceCompany(companyId) {
        if(companyId == InvoiceDataStoreCompanyIds.CGH) {

            String name = "CGH Systems Ltd"
            String companyNumber = "7173828"
            String vatNumber = "988 0979 40"

            def registeredOffice = getAddress(companyId)
            def bankDetails = getBankDetails(companyId)
            def contact = new Contact(name: "Christopher Hedley")

            new InvoiceCompany(bankDetails: bankDetails,
                    companyNumber: companyNumber,
                    created: null,
                    name: name,
                    address: registeredOffice,
                    vatNumber: vatNumber,
                    contact: contact)
        }
    }
}

