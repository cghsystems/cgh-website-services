package net.cghsystems.model

import groovy.transform.ToString


/**
 *  The object representing generic Company. This can be either a client or contract company. 
 */
@ToString
class Company {
    String name
    Address address
    Contact contact
}
