package net.cghsystems.model.dividend

import static org.junit.Assert.*

import org.junit.Test

class DividendDeclarationTest {

    @Test
    void givenaDividendOf6000ThenGrossDivdendAndTaxCreditShouldBeCalculated() {
        DividendDeclaration unit = new DividendDeclaration(dividend:6000.00)
        assert 666.67 == unit.taxCredit()
        assert 6666.67 == unit.grossDividend()
    }
}
