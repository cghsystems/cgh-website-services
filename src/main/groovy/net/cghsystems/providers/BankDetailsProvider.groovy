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

    BankDetails getBankDetails(companyId) {
        if(companyId == InvoiceConstants.CGH) {
            log.info("Returning company bank details for company with id ${companyId}")
            return new BankDetails(accountNumber: "71432559",
            name: "HSBC",
            reference: "cgh-systems",
            sortCode: "40-17-31",
            address: getAddress(InvoiceConstants.HSBC),
            remittanceAdvice: "chris@cghsystems.net")
        }
        throw new ProviderException("BankDetails not found for compnay with id ${companyId}")
    }
}
