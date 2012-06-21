package net.cghsystems.pdf.dividend.builder

import static org.junit.Assert.*
import net.cghsystems.model.dividend.DividendDeclaration
import net.cghsystems.model.dividend.DividendDeclarationBuilder
import net.cghsystems.model.invoice.datastores.InvoiceDataStoreCompanyIds
import net.cghsystems.pdf.itext.ItextMetaClassesRegistrar

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class DividendPDFDocumentBuilderTest {

    private DividendPDFDocumentBuilder unit

    private dividend

    @BeforeClass
    static void beforeClass() {
        ItextMetaClassesRegistrar.register()
    }

    @Before
    void before() {
        unit = new DividendPDFDocumentBuilder()
        dividend = new DividendDeclarationBuilder().createDividend(new Date(), 100, InvoiceDataStoreCompanyIds.CGH)
    }

    @Test(expected = IllegalStateException)
    void expectExceptionForNullOutputStream() {
        unit.generate(new DividendDeclaration(), null)
    }

    @Test
    void createDividendPDF() {
        final outputFileName = "/tmp/dividend.pdf"
        final OutputStream os = new FileOutputStream(outputFileName)
        unit.generate(dividend, os)
        println "A Test Dividend Declaration PDF has been created at ${outputFileName}"
    }
}
