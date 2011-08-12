package net.cghsystems.providers

import groovy.util.logging.Log4j
import net.cghsystems.model.invoice.BankDetails

/**
 * A Provider for {@code BankDetails}'s. 
 * <p>
 * For now the addresses are hardcoded in the object  but it is my intention to 
 * add a suitable way of abstracting these. Probably to a datastore.
 */
@Log4j
@Mixin(AddressProvider)
@Category(Object)
class BankDetailsProvider  {

    private final static CGH = 1

    BankDetails getBankDetails(Long companyId) {
        if(companyId == CGH) {
            log.info("Returning company bank details for company with id ${companyId}")
            return new BankDetails(accountNumber: "71432559",
            name: "HSBC",
            reference: "cgh-systems",
            sortCode: "40-17-31",
            address: getAddress(2),
            remittanceAdvice: "chris@cghsystems.net")
        }
        throw new ProviderException("BankDetails not found for compnay with id ${companyId}")
    }
}
