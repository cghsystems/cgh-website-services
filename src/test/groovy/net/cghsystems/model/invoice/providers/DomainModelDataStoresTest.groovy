package net.cghsystems.model.invoice.providers

import net.cghsystems.model.InvoiceCompany
import net.cghsystems.model.TestData

import org.junit.Test

@Mixin(BankDetailsDataStore)
@Mixin(AddressDataStore)
@Mixin(InvoiceCompanyDataStore)
class DomainModelDataStoresTest  {

    @Test
    void givenAValidCompanyForCGHIdShouldBuildCGHCompanyObject() {
        InvoiceCompany actual = getInvoiceCompany(InvoiceDataStore.CGH)
        assert actual.registeredOffice == TestData.address()
        assert actual.bankDetails == TestData.hsbcBankDetails()
    }

    @Test
    void givenValidCGHCompanyIDThenGetCompanyAddressShouldReturnCGHAddress() {
        def actual = getAddress(InvoiceDataStore.CGH)
        assert actual == TestData.address()
    }

    @Test(expected = DataStoreException)
    void givenAnInvalidIDTheGetCompanyAddressShouldThrowInvoiceModelException() {
        getAddress(-1L)
    }

    @Test
    void givenValidCGHCompanyIDThenGetBankDetailsShouldreturnCGHBankDetails() {
        def actual = getBankDetails(InvoiceDataStore.CGH)
        assert actual == TestData.hsbcBankDetails()
    }

    @Test(expected = DataStoreException)
    void givenAnInvalidIDTheGetBankDetailShouldThrowInvoiceModelException() {
        getBankDetails(-1L)
    }
}
