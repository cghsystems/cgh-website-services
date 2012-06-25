


package net.cghsystems.web.rs

import static org.junit.Assert.*
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*
import net.cghsystems.model.invoice.builders.InvoiceTestModelBuilder
import net.cghsystems.pdf.itext.ItextMetaClassesRegistrar
import net.cghsystems.web.rs.ioc.InvoiceControllersApplicationContext

import org.hamcrest.MatcherAssert
import org.junit.BeforeClass
import org.junit.Test
import org.springframework.http.MediaType
import org.springframework.test.web.server.MvcResult
import org.springframework.test.web.server.ResultMatcher
import org.springframework.test.web.server.setup.MockMvcBuilders

@Mixin(InvoiceTestModelBuilder)
class InvoiceControllerTest {

    @BeforeClass
    static void beforeClass() {
        ItextMetaClassesRegistrar.register()
    }

    @Test
    void shouldGetInvoiceDocument() {

        //Ensures that the invoice/document rest interface return a  byte Array with content.
        final matcher = new ResultMatcher() {
                    public void match(MvcResult result) throws Exception {
                        final actual = result.getResponse().getContentLength()
                        final expected = 1776
                        MatcherAssert.assertThat("Response content length ${actual} was not expected length ${expected}", expected == actual)
                    }
                }

        final invoiceJson = createInvoiceWithDefaultInvoiceParameters().toJson()
        MockMvcBuilders.annotationConfigSetup(InvoiceControllersApplicationContext).build()
                .perform(post("/invoice/document/").contentType(MediaType.APPLICATION_JSON).body(invoiceJson.bytes))
                .andExpect(status().isOk())
                .andExpect(matcher)
    }

    @Test
    void shouldGenerateInvoiceWithValidParameters() {
        def (clientId, companyId, days) = [1, 1, 34]
        final expected = createInvoiceWithParameters(clientId, companyId, days).toJson()
        MockMvcBuilders.annotationConfigSetup(InvoiceControllersApplicationContext).build()
                .perform(get("/invoice/create/{companyId}/{clientId}/{days}", clientId,companyId,days))
                .andExpect(status().isCreated())
                .andExpect(content().string(expected))
    }

    @Test
    void shouldGetBadRequestWithInvalidParameters() {
        MockMvcBuilders.annotationConfigSetup(InvoiceControllersApplicationContext).build()
                .perform(get("/invoice/create/{companyId}/{clientId}/{days}", "dave",1,2))
                .andExpect(status().isBadRequest())
    }

    @Test
    void shouldSendEmailWithValidInvoiceId() {
        MockMvcBuilders.annotationConfigSetup(InvoiceControllersApplicationContext).build()
                .perform(get("/invoice/email/{invoiceId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string("test"))
    }
}
