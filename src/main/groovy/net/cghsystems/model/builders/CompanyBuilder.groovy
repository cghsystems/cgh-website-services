package net.cghsystems.model.builders

import net.cghsystems.model.Address
import net.cghsystems.model.Company
import net.cghsystems.model.invoice.BankDetails
import net.cghsystems.model.invoice.ContractDetail
import net.cghsystems.providers.AddressProvider
import net.cghsystems.providers.BankDetailsProvider

/**
 * As this class uses lots of mixins it is essentially using multiple inheritance. 
 * I have yet to decide if this is a good or a bad thing.
 */
@Mixin(AddressProvider)
@Mixin(BankDetailsProvider)
class CompanyBuilder {

    def buildCompany(days) {

        final CGH = 1;

        String name = "CGH Systems Ltd"
        String companyNumber = "7173828"
        String vatNumber = "988 0979 40"

        Address registeredOffice = getAddress(CGH)
        BankDetails bankDetails = getBankDetails(CGH)
        ContractDetail invoiceDetail = new ContractDetail(days: days, rate: 400, vat: 20)

        return new Company(bankDetails: bankDetails,
        companyNumber: companyNumber,
        contractDetail: invoiceDetail,
        created: new Date(),
        name: name,
        registeredOffice: registeredOffice,
        vatNumber: vatNumber)
    }
}
