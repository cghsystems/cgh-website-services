package net.cghsystems.model

import groovy.transform.EqualsAndHashCode


/**
 * Represents a generic Address and provides the methods to enable the address instance 
 * to be render each member field  in anyway the calling class needsIe. It can be represented in
 * a certain string format or in the case of a view built using a set of widgets..
 * 
 * @author chris
 *
 */
@EqualsAndHashCode
class Address {

    String line1, line2, town, county, postcode

    def buildAddress(Closure closure, Address address) {

        if (line1 != null && line1 != "") {
            closure(line1)
        }

        if (line2 != null && line2 != "") {
            closure(line2)
        }

        if (town != null && town != "") {
            closure(town)
        }

        if (county != null && county != "") {
            closure(county)
        }

        if (postcode != null && postcode != "") {
            closure(postcode)
        }
    }

    String toString() {
        def sb = new StringBuilder()
        def clos = { it ->
            sb.append(it).append(", ")
        }
        buildAddress(clos, this)
        def ret = sb.toString().trim()
        ret.substring(0, ret.lastIndexOf(","))
    }
}
