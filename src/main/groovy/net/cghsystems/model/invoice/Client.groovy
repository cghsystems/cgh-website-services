package net.cghsystems.model.invoice;

import net.cghsystems.model.Address
import net.cghsystems.model.Contact


class Client {
	String name
	Address address
	Contact contact = new Contact()
}
