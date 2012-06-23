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

    @Test
    void taxCreditShouldHandleNullDividendGracefully() {
        DividendDeclaration unit = new DividendDeclaration()
        assert 0 == unit.taxCredit()
    }

    @Test
    void grossDividendShouldHandleNullDividendGracefully() {
        DividendDeclaration unit = new DividendDeclaration()
        assert 0 == unit.grossDividend()
    }

    @Test
    void isValid() {
        DividendDeclaration unit = new DividendDeclaration()
        assert "The following fields have not been set correctly:  director, dateHeld, company, dividend" ==  unit.isValid().message
    }
}
