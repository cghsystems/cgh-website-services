package net.cghsystems.model.dividend

import net.cghsystems.model.Company
import net.cghsystems.model.invoice.datastores.InvoiceCompanyDataStore

@Mixin(InvoiceCompanyDataStore)
public class DividendDeclarationBuilder {

    def createDividend(dateHeld, dividend, companyId) {
        Company company = getInvoiceCompany(companyId)
        new DividendDeclaration(dateHeld: dateHeld, dividend: dividend, company: company, director: company.contact)
    }
}
