package net.cghsystems.model.invoice;

import net.cghsystems.model.Company



class Invoice {
    int number
    String description
    String taxPointDate, fromDate, toDate
    Client client = new Client()
    Company company
    Date taxPointDate2
}
