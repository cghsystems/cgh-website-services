package net.cghsystems.model.invoice.providers

import net.cghsystems.model.TestData
import net.cghsystems.model.invoice.BankDetails

import org.junit.Before
import org.junit.Test

@Mixin(BankDetailsDataStore)
class BankDeailsProviderTest {

    BankDetailsDataStore unit

    @Before
    public void before() {
        unit = new BankDetailsDataStore()
    }

    @Test
    public void shouldProvideExectedBankDetailsForCGHSystems() {
        BankDetails actual = getBankDetails(InvoiceDataStore.CGH)
        assert actual == TestData.hsbcBankDetails()
    }
}
