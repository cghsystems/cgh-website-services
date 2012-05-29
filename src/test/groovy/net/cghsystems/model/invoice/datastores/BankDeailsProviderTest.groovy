package net.cghsystems.model.invoice.datastores

import net.cghsystems.model.TestData
import net.cghsystems.model.invoice.BankDetails
import net.cghsystems.model.invoice.datastores.BankDetailsDataStore;
import net.cghsystems.model.invoice.datastores.InvoiceDataStoreCompanyIds;

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
        BankDetails actual = getBankDetails(InvoiceDataStoreCompanyIds.CGH)
        assert actual == TestData.hsbcBankDetails()
    }
}
