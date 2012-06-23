package net.cghsystems.model.invoice.builders

import java.text.SimpleDateFormat

import org.junit.Ignore
import org.junit.Test

class InvoiceParametersTest {

    InvoiceParameters unit

    @Test
    void giveATaxPointDateWhenGetTaxPointDateThenReturnDateFormattedString() {
        unit = new InvoiceParameters(taxPointDate: "01/01/1970")
        assert new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1970") == unit.getTaxPointDate()
    }

    @Test(expected = IllegalArgumentException)
    void givenANullTaxPointDateThenGetTaxPointDateShouldReturnZeroLengthString() {
        unit = new InvoiceParameters(taxPointDate: null)
        unit.getTaxPointDate()
    }

    @Test(expected = IllegalArgumentException)
    void givenZeroLengthTaxPointDateThenGetTaxPointDateShouldReturnZeroLengthString() {
        unit = new InvoiceParameters(taxPointDate: "")
        unit.getTaxPointDate()
    }

    @Test
    void giveAFromDateDateWhenGetFromDateThenReturnDateFormattedString() {
        unit = new InvoiceParameters(fromDate: "01/01/1970")
        assert new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1970") == unit.getFromDate()
    }

    @Test(expected = IllegalArgumentException)
    void givenANullFromDateThenGetFromDateShouldReturnZeroLengthString() {
        unit = new InvoiceParameters(taxPointDate: null)
        unit.getTaxPointDate()
    }

    @Test(expected = IllegalArgumentException)
    void givenZeroLengthFromDateDateThenGetFromDateShouldReturnZeroLengthString() {
        unit = new InvoiceParameters(taxPointDate: "")
        unit.getTaxPointDate()
    }

    @Test
    void isNotValid() {
        unit = new InvoiceParameters()
        assert unit.isValid().getMessage() == "The following fields have not been set correctly:  days, companyId, clientId"
    }

    @Test
    @Ignore
    void isValidNoDateFieldsDefined() {
        unit = new InvoiceParameters(companyId: 1, clientId: 2, days: 12)
        assert unit.isValid() == false
    }
    @Test
    void isValid() {
        unit = new InvoiceParameters(companyId: 1, clientId: 2, days: 12, fromDate: "12/12/2012", toDate: "12/12/2012", taxPointDate: "12/12/2012")
        assert unit.isValid() == true
    }
}
