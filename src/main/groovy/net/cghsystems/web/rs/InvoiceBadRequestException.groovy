package net.cghsystems.web.rs

import groovy.transform.InheritConstructors

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * {@link RuntimeException} thrown if there is an issue in the {@link InvoiceController}. Notifies of a 
 * Bad Request  or Http 500 error.
 * 
 * @author chris
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
@InheritConstructors
class InvoiceBadRequestException extends RuntimeException {
}
