package net.cghsystems.model.invoice.builders

import static org.junit.Assert.*

import java.text.ParseException

import net.cghsystems.model.invoice.Invoice
import net.cghsystems.model.invoice.datastores.InvoiceDataStoreCompanyIds

import org.junit.Before
import org.junit.Test


class InvoiceBuilderTest {

    InvoiceBuilder unit

    @Before
    void before() {
        unit = new InvoiceBuilder()
    }

    @Test
    void shoudlReturnInValidAsInvoiceParametersIsPoorlyFormed() {
        final params = new InvoiceParameters(companyId: InvoiceDataStoreCompanyIds.CGH)
        println unit.createInvoice(params).getMessage()
        assert unit.createInvoice(params).getMessage() == "The following fields have not been set correctly:  days, clientId"
    }

    @Test
    void shouldReturnInvoiceAsInvoiceParametersIsCorrectlyFormed() {
        final params = new InvoiceParameters(companyId: InvoiceDataStoreCompanyIds.CGH, clientId: 1, days: 1,fromDate: "12/12/2012", taxPointDate: "12/12/2001", toDate: "12/12/2005"  )
        Invoice actual = unit.createInvoice(params)
        assert actual instanceof Invoice
        assert actual.isValid() == true
    }

    @Test(expected  = ParseException)
    void shouldThrowExcetpionIfFromDateIsInValidFormat() {
        final params = new InvoiceParameters(companyId: InvoiceDataStoreCompanyIds.CGH, clientId: 1, days: 1,fromDate: "12/dd/2012", taxPointDate: "12/12/2001", toDate: "12/12/2005"  )
        unit.createInvoice(params)
    }

    @Test(expected  = ParseException)
    void shouldThrowExcetpionIfToDateIsInValidFormat() {
        final params = new InvoiceParameters(companyId: InvoiceDataStoreCompanyIds.CGH, clientId: 1, days: 1,fromDate: "12/12/2012", taxPointDate: "12/12/2001", toDate: "12/mm/2005"  )
        unit.createInvoice(params)
    }

    @Test(expected  = ParseException)
    void shouldThrowExcetpionIfTaxPointDateIsInValidFormat() {
        final params = new InvoiceParameters(companyId: InvoiceDataStoreCompanyIds.CGH, clientId: 1, days: 1,fromDate: "12/12/2012", taxPointDate: "1223/1212/sss", toDate: "12/12/2005"  )
        unit.createInvoice(params)
    }
}
