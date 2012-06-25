package net.cghsystems.model.invoice.builders

import org.codehaus.jackson.map.ObjectMapper


/**
 * A Test helper builder that will build up {@link Invoice} objects and convert to JSON.
 * 
 * @author chris
 *
 */
@Mixin(InvoiceBuilder)
@Mixin(ObjectMapper)
class InvoiceTestModelBuilder {

    private def invoiceParameters, invoice

    /**
     * Creates a wrapped instance of Invoice with a clientId of 1, company id of 1 and days of 12. 
     * Creates a wrapped instance of Invoice with the above parameters. 
     * 
     * @return an instance of this for fluent interface
     */
    final createInvoiceWithDefaultInvoiceParameters() {
        invoiceParameters = new InvoiceParameters(clientId: 1,
                companyId: 1, days: 12, toDate: "12/12/2012",
                fromDate: "12/12/2012", taxPointDate: "12/12/2012")
        invoice = createInvoice(invoiceParameters)
        this
    }

    final createInvoiceWithParameters(clientId, companyId, days) {
        invoiceParameters = new InvoiceParameters(clientId: clientId,
                companyId: companyId, days: days, toDate: "12/12/2012",
                fromDate: "12/12/2012", taxPointDate: "12/12/2012")
        invoice = createInvoice(invoiceParameters)
        this
    }

    final toJson () {
        assert "Invoice has not been build", invoice != null
        writeValueAsString(invoice)
    }
}
