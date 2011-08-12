package net.cghsystems.model

import net.cghsystems.model.invoice.BankDetails

class TestData {

    static def address() {
        new Address(line1: "51 Brantwood",
                line2: "Chester-le-Street",
                county: "Co. Durham",
                postcode: "DH2 2UJ")
    }

    static def bankDetails() {
        def address = bankAddress();
        return new BankDetails(accountNumber: "71432559",
        name: "HSBC",
        reference: "cgh-systems",
        sortCode: "40-17-31",
        address: address,
        remittanceAdvice: "chris@cghsystems.net")
    }

    static def bankAddress() {
        return new Address(line1: "The Helicon",
        line2: "1 South Place",
        town: "The City",
        county: "London",
        postcode: "EC2M 2UP")
    }
}
