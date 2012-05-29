package net.cghsystems.pdf.generator

import static org.junit.Assert.*
import net.cghsystems.model.invoice.Invoice
import net.cghsystems.model.invoice.builders.InvoiceBuilderNew

import org.junit.Before
import org.junit.Test


class PDFInvoiceGeneratorTest {

    Invoice invoice

    PDFInvoiceGenerator unit

    @Before
    void before() {
        unit = new PDFInvoiceGenerator()
        invoice = new InvoiceBuilder_old()
    }

    @Test(expected = IllegalStateException)
    void expectExceptionForNullInvoice() {
        final outputStream = new ByteArrayOutputStream()
        unit.generate(invoice, outputStream)
    }

    @Test(expected = IllegalStateException)
    void expectExceptionForNullOutputStream() {
        unit.generate(new Invoice(), null)
    }
}
