package net.cghsystems.providers

import groovy.util.logging.Log4j
import net.cghsystems.model.Address

/**
 * A Provider for {@code Address}'s. 
 * <p>
 * For now the addresses are hardcoded in the object but it is my intention to 
 * add a suitable way of abstracting these. Probably to a datastore.
 */
@Category(Object)
@Log4j
class AddressProvider {

    Address getAddress(Long companyId) {
        log.info("Returning company address for company with id ${companyId}")
        if(companyId == InvoiceConstants.CGH) {
            return new Address(line1: "51 Brantwood",
            line2: "Chester-le-Street",
            county: "Co. Durham",
            postcode: "DH2 2UJ")
        }else if(companyId == InvoiceConstants.HSBC) {
            return new Address(line1: "The Helicon",
            line2: "1 South Place",
            town: "The City",
            county: "London",
            postcode: "EC2M 2UP")
        }
        throw new ProviderException("Address not found for compnay with id ${companyId}")
    }
}
