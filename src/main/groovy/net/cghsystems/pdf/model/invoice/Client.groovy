package net.cghsystems.pdf.model.invoice;

import net.cghsystems.pdf.model.Address
import net.cghsystems.pdf.model.Contact


class Client {
	String name
	Address address
	Contact contact = new Contact()
}
