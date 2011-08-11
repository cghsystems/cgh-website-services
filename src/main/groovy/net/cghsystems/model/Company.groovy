package net.cghsystems.model

import net.cghsystems.model.invoice.BankDetails
import net.cghsystems.model.invoice.ContractDetail


//TODO REname
class Company {
    String name, companyNumber, vatNumber
    Address registeredOffice
    ContractDetail contractDetail;
    BankDetails bankDetails
    Date created
}
