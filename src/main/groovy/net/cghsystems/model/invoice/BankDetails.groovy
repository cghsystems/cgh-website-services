package net.cghsystems.model.invoice

import net.cghsystems.model.Address
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class BankDetails {
    String name, accountNumber, sortCode, reference, remittanceAdvice
    Address address
}
