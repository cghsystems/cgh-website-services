package net.cghsystems.web.rs

import groovy.util.logging.Log4j
import net.cghsystems.model.invoice.builders.InvoiceBuilder
import net.cghsystems.model.invoice.builders.InvoiceParameters

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.HttpMediaTypeNotAcceptableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

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
@Mixin(InvoiceBuilder)
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
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/create/{companyId}/{clientId}/{days}", method = RequestMethod.GET)
    def generateInvoice(@PathVariable("clientId") clientId,
    @PathVariable("companyId") companyId, @PathVariable("days") days) {

        log.info("Received request to create new Invoice for company: ${companyId}")

        def  i = new InvoiceParameters(clientId: clientId,
                companyId: companyId, days: days, toDate: "12/12/2012",
                fromDate: "12/12/2012", taxPointDate: "12/12/2012")

        if(i.isValid() == true) {
            def invoice = createInvoice(i)
            log.info("Created invoice ${invoice}")
            return invoice
        }else {
            log.error("Could not create valid Invoice: ${i.isValid().message}")
            throw new InvoiceBadRequestException(i.isValid().message)
        }
    }

    /**
     * Will return a notification of the email's sent state.
     * 
     * @param the unique id of the invoice to send.  
     * @return TODO
     */
    @ResponseBody
    @RequestMapping(value = "/email/{invoiceId}", method = RequestMethod.GET)
    def sendInvoiceToReceipients( @PathVariable("invoiceId") invoiceId  ) {
        log.info("Recieved request to send email for invoice ${invoiceId}")
        "test"
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException)
    void handle(e) {
        e.printStackTrace()
    }
}
