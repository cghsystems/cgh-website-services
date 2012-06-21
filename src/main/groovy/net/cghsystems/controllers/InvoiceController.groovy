package net.cghsystems.controllers

import groovy.util.logging.Log4j

import org.springframework.stereotype.Controller
import org.springframework.web.HttpMediaTypeNotAcceptableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Uses Springs REST support to serve up the data required to do all things invoice related. Such as creating invoices, returning 
 * invoice documents, sending emails related to invoices and recording invoices.
 * <p>
 * I prefer this to JAX-RS for serving up restful services as it feel more like a fist class citzen of Spring. 
 * (Jackson <http://jackson.codehaus.org/> the thing that provides JSON support for JAX is a plugin) although Spring used JAX-RS 
 * and Jackson behind the scenes this is hidden from us. SpringMVC allows optional parameters too which although break the JAX-RS 
 * spec are useful. 
 * <br><br>
 * {@link http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/mvc.html}
 * <p>
 * In order to serve up the JSON required by the client this needs to be mapped to 
 * {@code MappingJacksonJsonView} via the application context. See {@link InvoiceControllersApplicationContext} 
 *
 */
@Controller
@RequestMapping("/invoice")
@Log4j
class InvoiceController {

    /**
     * Will return the invoice document (typically a pdf) to the client.
     * <p>
     * This will map to the URL app-context/invoice/document/${id}
     * 
     * @param uniques id of the document to find.
     * @return the object representing the document. As the Method is 
     * annotated with {@link ResponseBody} and Jackson-Json is on the 
     * classpath Spring-WS with automatically convert the return type
     * to JSON on our behalf.
     */
    @ResponseBody
    @RequestMapping(value = "/document/{id}", method = RequestMethod.GET)
    def getInvoiceDocument(@PathVariable("id") documentId) {
        log.info("Received request for Invoice Document with Id: ${documentId}")
        "test".bytes
    }

    /**
     * @param invoiceParameters to generate the invoice with.
     * @return TODO
     */
    @ResponseBody
    @RequestMapping(value = "/create/{invoiceParameters}", method = RequestMethod.POST)
    def generateInvoice(@PathVariable('invoiceParameters') invoiceParameters) {
        log.info("Received request to create new Invoice with parameters: ${invoiceParameters }")
        "test"
    }

    /**
     * Will return a notification of the email's sent state.
     * 
     * @param the unique id of the invoice to send.  
     * @return TODO
     */
    @ResponseBody
    @RequestMapping(value = "/email/{invoiceId}", method = RequestMethod.POST)
    def sendInvoiceToReceipients(@PathVariable("invoiceId") invoiceId) {
        log.info("Recieved request to send email for invoice ${invoiceId}")
        "test"
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException)
    void handle(e) {
        e.printStackTrace
    }
}
