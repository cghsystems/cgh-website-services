package net.cghsystems.model.invoice

import net.cghsystems.model.Address
import net.cghsystems.model.Contact

/**
 *  The object representing the CLient the invoice is for. I.e DataInc
 */
class InvoiceClient {
    String name
    Address address
    Contact contact
}
