
package net.cghsystems.web.rs

import static org.junit.Assert.*
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*
import net.cghsystems.web.rs.ioc.InvoiceControllersApplicationContext

import org.junit.Test
import org.springframework.test.web.server.setup.MockMvcBuilders


class InvoiceControllerTest {

    @Test
    void shouldGetInvoiceDocument() {
        def pdfByteArray = "test"
        MockMvcBuilders.annotationConfigSetup(InvoiceControllersApplicationContext).build()
                .perform(get("/invoice/document/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string(pdfByteArray))
    }

    @Test
    void shouldGenerateInvoiceWithValidParameters() {
        MockMvcBuilders.annotationConfigSetup(InvoiceControllersApplicationContext).build()
                .perform(get("/invoice/create/{companyId}/{clientId}/{days}", 1,1,34))
                .andExpect(status().isCreated())
        throw null //TEst the Invoice return type
    }

    @Test
    void shouldSendEmailWithValidInvoiceId() {
        MockMvcBuilders.annotationConfigSetup(InvoiceControllersApplicationContext).build()
                .perform(get("/invoice/email/{invoiceId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string("test"))
    }
}
