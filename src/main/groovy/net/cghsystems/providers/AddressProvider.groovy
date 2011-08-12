package net.cghsystems.providers

import groovy.util.logging.Log4j
import net.cghsystems.model.Address

@Category(Object)
@Log4j
class AddressProvider {

    private final static CGH = 1
    private final static HSBC = 2

    Address getAddress(Long companyId) {
        log.info("Returning company address for company with id ${companyId}")
        if(companyId == CGH) {
            return new Address(line1: "51 Brantwood",
            line2: "Chester-le-Street",
            county: "Co. Durham",
            postcode: "DH2 2UJ")
        }else if(companyId == HSBC) {
            return new Address(line1: "The Helicon",
            line2: "1 South Place",
            town: "The City",
            county: "London",
            postcode: "EC2M 2UP")
        }
        throw new ProviderException("Address not found for compnay with id ${companyId}")
    }
}
