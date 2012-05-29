package net.cghsystems.controllers

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

/**
 * Uses Springs REST support to serve up the data required to do all things invoice related. Such as creating invoices, returning 
 * invoice documents, sending emails related to invoices and recording invoices.
 * <p>
 * I prefer this to JAX-RS for serving up restful services as it feel more like a fist class citzen of Spring. 
 * (Jackson <http://jackson.codehaus.org/> the thing that provides JSON support for JAX is a plugin) although Spring used JAX-RS 
 * and Jackson behind the scenes this is hidden from us. SpringMVC allows optional parameters too. 
 * <br><br>
 * {@link http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/mvc.html}
 * <p>
 * TODO In order to serve up the JSON required by the client this needs to be mapped to 
 * {@code MappingJacksonJsonView} via the application context. 
 *
 */
@Controller
@RequestMapping("/invoice")
class InvoiceController {

    /**
     * Will return the invoice document (typically a pdf) to the client.
     * <p>
     * This will map to app-context/invoice/pdf/${id}
     * 
     * @param uniques id of the document to find.
     * @return the object representing the document
     */
    @RequestMapping(value = "/document/{id}", method = GET)
    def getInvoiceDocument(@RequestParam('id') documentId) {
        println documentId
    }

    /**
     * @param invoiceParameters to generate the invoice with.
     * @return TODO
     */
    @RequestMapping(value = "/{invoiceParameters}", method = POST)
    def generateInvoice(@RequestParam('invoiceParameters') invoiceParameters) {
        println invoiceParameters
    }

    /**
     * Will return a notification of the email's sent state.
     * 
     * @param the unique id of the invoice to send.  
     * @return TODO
     */
    @RequestMapping(value = "/email", method = GET)
    def sendInvoiceToReceipients(@RequestParam("invoiceId") invoiceId) {
    }
}
