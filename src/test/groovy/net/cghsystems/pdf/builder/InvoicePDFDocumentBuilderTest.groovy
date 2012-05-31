package net.cghsystems.pdf.builder

import static org.junit.Assert.*
import net.cghsystems.model.invoice.Invoice
import net.cghsystems.model.invoice.builders.InvoiceBuilder
import net.cghsystems.model.invoice.builders.InvoiceParameters
import net.cghsystems.model.invoice.datastores.InvoiceDataStoreCompanyIds
import net.cghsystems.pdf.itext.ItextMetaClassesRegistrar

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test



class InvoicePDFDocumentBuilderTest {

    Invoice invoice

    InvoicePDFDocumentBuilder unit


    @BeforeClass
    static void beforeClass() {
        ItextMetaClassesRegistrar.register()
    }

    @Before
    void before() {
        unit = new InvoicePDFDocumentBuilder()
        final params = new InvoiceParameters(companyId: InvoiceDataStoreCompanyIds.CGH, clientId: 1, days: 1,fromDate: "12/12/2012", number: 400,  taxPointDate: "12/12/2001", toDate: "12/12/2005")
        invoice = new InvoiceBuilder().createInvoice(params)
    }

    @Test(expected = IllegalStateException)
    void expectExceptionForNullInvoice() {
        final outputStream = new ByteArrayOutputStream()
        unit.generate(null, outputStream)
    }

    @Test(expected = IllegalStateException)
    void expectExceptionForNullOutputStream() {
        unit.generate(new Invoice(), null)
    }

    @Test
    void createInvoicePDF() {
        final outputFileName = "/tmp/invoice.pdf"
        final OutputStream os = new FileOutputStream(outputFileName)
        unit.generate(invoice, os)
        println "A Test Invoice PDF has been created at ${outputFileName}"
    }
}
