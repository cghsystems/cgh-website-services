


package net.cghsystems.web.rs

import static org.junit.Assert.*
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*
import net.cghsystems.model.invoice.builders.InvoiceBuilder
import net.cghsystems.model.invoice.builders.InvoiceParameters
import net.cghsystems.pdf.itext.ItextMetaClassesRegistrar
import net.cghsystems.web.rs.ioc.InvoiceControllersApplicationContext

import org.codehaus.jackson.map.ObjectMapper
import org.hamcrest.MatcherAssert
import org.junit.BeforeClass
import org.junit.Test
import org.springframework.http.MediaType
import org.springframework.test.web.server.MvcResult
import org.springframework.test.web.server.ResultMatcher
import org.springframework.test.web.server.setup.MockMvcBuilders

@Mixin(ObjectMapper)
@Mixin(InvoiceBuilder)
class InvoiceControllerTest {

    @BeforeClass
    static void beforeClass() {
        ItextMetaClassesRegistrar.register()
    }

    @Test
    void shouldGetInvoiceDocument() {

        final  invoiceParameters = new InvoiceParameters(clientId: 1,
                companyId: 1, days: 12, toDate: "12/12/2012",
                fromDate: "12/12/2012", taxPointDate: "12/12/2012")
        final invoice = createInvoice(invoiceParameters)
        final invoiceJson = writeValueAsString(invoice)

        def matcher = new ResultMatcher() {
                    public void match(MvcResult result) throws Exception {
                        MatcherAssert.assertThat("Response content", result.getResponse().getContentLength() == 100 )
                    }
                }

        MockMvcBuilders.annotationConfigSetup(InvoiceControllersApplicationContext).build()
                .perform(post("/invoice/document/", invoiceJson).contentType(MediaType.APPLICATION_JSON).body(invoiceJson.bytes))
                .andExpect(status().isOk())
    }

    @Test
    void shouldGenerateInvoiceWithValidParameters() {

        def (clientId, companyId, days) = [1, 1, 34]

        final  invoiceParameters = new InvoiceParameters(clientId: clientId,
                companyId: companyId, days: days, toDate: "12/12/2012",
                fromDate: "12/12/2012", taxPointDate: "12/12/2012")
        final invoice = createInvoice(invoiceParameters)

        final expected = writeValueAsString(invoice)

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
