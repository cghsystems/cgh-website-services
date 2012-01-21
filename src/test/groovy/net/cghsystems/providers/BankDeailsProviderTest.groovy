package net.cghsystems.providers

import net.cghsystems.model.TestData
import net.cghsystems.model.invoice.BankDetails

import org.junit.Before
import org.junit.Test

@Mixin(BankDetailsProvider)
class BankDeailsProviderTest {

    BankDetailsProvider unit

    @Before
    public void before() {
        unit = new BankDetailsProvider()
    }

    @Test
    public void shouldProvideExectedBankDetailsForCGHSystems() {
        BankDetails actual = getBankDetails(InvoiceConstants.CGH)
        assert actual == TestData.hsbcBankDetails()
    }
}
