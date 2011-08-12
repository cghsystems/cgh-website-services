package net.cghsystems.model.invoice.builders;

import java.text.DateFormat
import java.text.SimpleDateFormat

import net.cghsystems.model.Address
import net.cghsystems.model.Company
import net.cghsystems.model.builders.CompanyBuilder
import net.cghsystems.model.invoice.Client
import net.cghsystems.model.invoice.Invoice


class InvoiceBuilder {

    Invoice build(days, fromDate, toDate, number, taxPointDate) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy")
        Company comp = buildCompany(days);
        Client client = buildClient();

        String description = "For professional services of consultant, working for Data Inc UK Ltd at your client UBS."

        Invoice inv = new Invoice(company: comp,
                client: client,
                description: description,
                fromDate: df.format(fromDate),
                number: number,
                taxPointDate: df.format(taxPointDate),
                toDate: df.format(toDate))

        return inv;
    }

    def buildClient() {
        Address add = new Address(line1: "4 Winnersh Fields",
                town: "Winnersh",
                county: "Berkshire",
                postcode: "RG41 5QS")

        Client client = new Client(address: add, name: "Data Inc UK Ltd")
    }

    def buildCompany(days) {
        new CompanyBuilder().buildCompany(days)
    }
}
