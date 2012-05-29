package net.cghsystems.model.invoice.providers

import net.cghsystems.model.TestData
import net.cghsystems.model.invoice.InvoiceCompany;
import net.cghsystems.model.invoice.datastores.AddressDataStore;
import net.cghsystems.model.invoice.datastores.BankDetailsDataStore;
import net.cghsystems.model.invoice.datastores.DataStoreException;
import net.cghsystems.model.invoice.datastores.InvoiceCompanyDataStore;
import net.cghsystems.model.invoice.datastores.InvoiceDataStoreCompanyIds;

import org.junit.Test

@Mixin(BankDetailsDataStore)
@Mixin(AddressDataStore)
@Mixin(InvoiceCompanyDataStore)
class DomainModelDataStoresTest  {

    @Test
    void givenAValidCompanyForCGHIdShouldBuildCGHCompanyObject() {
        InvoiceCompany actual = getInvoiceCompany(InvoiceDataStoreCompanyIds.CGH)
        assert actual.registeredOffice == TestData.address()
        assert actual.bankDetails == TestData.hsbcBankDetails()
    }

    @Test
    void givenValidCGHCompanyIDThenGetCompanyAddressShouldReturnCGHAddress() {
        def actual = getAddress(InvoiceDataStoreCompanyIds.CGH)
        assert actual == TestData.address()
    }

    @Test(expected = DataStoreException)
    void givenAnInvalidIDTheGetCompanyAddressShouldThrowInvoiceModelException() {
        getAddress(-1L)
    }

    @Test
    void givenValidCGHCompanyIDThenGetBankDetailsShouldreturnCGHBankDetails() {
        def actual = getBankDetails(InvoiceDataStoreCompanyIds.CGH)
        assert actual == TestData.hsbcBankDetails()
    }

    @Test(expected = DataStoreException)
    void givenAnInvalidIDTheGetBankDetailShouldThrowInvoiceModelException() {
        getBankDetails(-1L)
    }
}
