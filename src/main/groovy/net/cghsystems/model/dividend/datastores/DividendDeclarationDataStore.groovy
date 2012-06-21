package net.cghsystems.model.dividend.datastores

import java.text.DateFormat
import java.text.SimpleDateFormat

import net.cghsystems.model.Company
import net.cghsystems.model.dividend.DividendDeclaration
import net.cghsystems.model.invoice.datastores.InvoiceCompanyDataStore

@Mixin(InvoiceCompanyDataStore)
public class DividendDeclarationDataStore {

    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy")

    def createDividend(dateHeld, dividend, companyId) {
        Company company = getInvoiceCompany(companyId)
        new DividendDeclaration(dateHeld:df.format(dateHeld), dividend: dividend, company: company, director: company.contact)
    }
}
