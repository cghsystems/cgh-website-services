package net.cghsystems.model.invoice;

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class BankDetails {
	String name, accountNumber, sortCode, address, reference, remittanceAdvice;
}
