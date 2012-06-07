package net.cghsystems.controllers

import static org.junit.Assert.*
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*
import net.cghsystems.controllers.ioc.InvoiceControllersApplicationContext

import org.junit.Test
import org.springframework.test.web.server.setup.MockMvcBuilders


class InvoiceControllerTest {

    @Test
    void shouldGetInvoiceDocument() {
        def pdfByteArray = new String(1..1000 as byte[])
        MockMvcBuilders.annotationConfigSetup(InvoiceControllersApplicationContext).build()
                .perform(get("/invoice/document/{id}", 1)).andExpect(status().isOk()).andExpect(content().string(pdfByteArray))
    }

    @Test
    void shouldGenerateInvoiceWithValidParameters() {
        MockMvcBuilders.annotationConfigSetup(InvoiceControllersApplicationContext).build()
                .perform(post("/invoice/create/{invoiceParameters}", 1)).andExpect(status().isOk()).andExpect(content().string("test"))
    }

    @Test
    void shouldSendEmailWithValidInvoiceId() {
        MockMvcBuilders.annotationConfigSetup(InvoiceControllersApplicationContext).build()
                .perform(post("/invoice/email/{invoiceId}", 1)).andExpect(status().isOk()).andExpect(content().string("test"))
    }
}
