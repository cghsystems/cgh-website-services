package net.cghsystems.model.invoice.builders

import static org.junit.Assert.*

import org.junit.Test

class InvoiceParametersTest {

    InvoiceParameters unit

    @Test
    void isNotValid() {
        unit = new InvoiceParameters()
        assert unit.isValid().getMessage() == "The following fields have not been set: companyId, clientId, days, fromDate, toDate, number, taxPointDate"
    }

    @Test
    void isValid() {
        unit = new InvoiceParameters(companyId: 1, clientId: 2, days: 12, fromDate: "12/12/2012", toDate: "12/12/2012", number: 455, taxPointDate: "12/12/2012")
        assert unit.isValid() == true
    }
}
