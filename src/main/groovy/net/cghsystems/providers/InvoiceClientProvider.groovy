package net.cghsystems.providers

import net.cghsystems.model.Address
import net.cghsystems.model.Contact
import net.cghsystems.model.invoice.InvoiceClient


@Category(Object)
class InvoiceClientProvider {

    InvoiceClient getInvoiceClient(Long clientId) {
        if(clientId == InvoiceConstants.DATA_INC) {
            def add = new Address(line1: "4 Winnersh Fields",
                    town: "Winnersh",
                    county: "Berkshire",
                    postcode: "RG41 5QS")

            def contact = new Contact(emailAddress: "sian@dataincuk.com",
                    ccEmailAddress: "sian@dataincuk.com",
                    name: "Dave")

            return new InvoiceClient(address: add, name: "Data Inc UK Ltd", contact: contact)
        }
    }

    def getInvoiceDescription(Long companyId, Long clientId) {
        if(companyId == InvoiceConstants.CGH && companyId == InvoiceConstants.DATA_INC) {
            "For professional services of consultant, working for Data Inc UK Ltd at your client UBS."
        }
    }
}

