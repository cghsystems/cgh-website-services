package net.cghsystems.model.dividend.datastores

import java.text.DateFormat
import java.text.SimpleDateFormat

import net.cghsystems.model.Contact
import net.cghsystems.model.dividend.DividendDeclaration
import net.cghsystems.model.invoice.InvoiceCompany
import net.cghsystems.model.invoice.datastores.InvoiceCompanyDataStore
import net.cghsystems.model.invoice.datastores.InvoiceDataStoreCompanyIds

/**
 * Currently will return a single {@link DividendDeclaration} for CGH Systems.
 * 
 * @author chris
 *
 */
@Mixin(InvoiceCompanyDataStore)
class DividendDeclarationDataStore {

    DividendDeclaration build(date, dividend) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy")

        InvoiceCompany cgh = getInvoiceCompany(InvoiceDataStoreCompanyIds.CGH)
        Contact me = new Contact(name:"Christopher Hedley")

        DividendDeclaration(dateHeld:df.format(date),
                company:cgh,
                director:me,
                dividend:dividend)
    }
}
