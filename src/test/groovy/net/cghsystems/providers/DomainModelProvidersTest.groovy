package net.cghsystems.providers;

import net.cghsystems.model.TestData

import org.junit.Test

@Mixin(BankDetailsProvider)
@Mixin(AddressProvider)
class DomainModelProvidersTest  {

    @Test
    void givenValidCGHCompanyIDThenGetCompanyAddressShouldReturnCGHAddress() {
        def actual = getAddress(1L)
        assert actual == TestData.address()
    }

    @Test(expected = ProviderException)
    void givenAnInvalidIDTheGetCompanyAddressShouldThrowInvoiceModelException() {
        getAddress(-1L);
    }

    @Test
    void givenValidCGHCompanyIDThenGetBankDetailsShouldreturnCGHBankDetails() {
        def actual = getBankDetails(1L)
        assert actual == TestData.bankDetails();
    }

    @Test(expected = ProviderException)
    void givenAnInvalidIDTheGetBankDetailShouldThrowInvoiceModelException() {
        getBankDetails(-1L);
    }
}
