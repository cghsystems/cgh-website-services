package net.cghsystems.services

import org.junit.Test

class InvoiceParametersTest {

    InvoiceParameters unit

    @Test
    void giveATaxPointDateWhenGetTaxPointDateThenReturnDateFormattedString() {
        unit = new InvoiceParameters(taxPointDate: new Date(0))
        assert "01/01/1970" == unit.getTaxPointDate()
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
        unit = new InvoiceParameters(taxPointDate: new Date(0))
        assert "01/01/1970" == unit.getTaxPointDate()
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
}
