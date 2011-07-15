package net.cghsystems.services;

import javax.annotation.Resource

import net.cghsystems.model.TestData
import net.cghsystems.test.util.AnnotationConfigContextLoader

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(loader = AnnotationConfigContextLoader, value = "net.cghsystems" )
class InvoiceModelServiceTest  {

	@Resource(name = "invoiceModelService")
	private InvoiceModelService unit;

	@Test
	void givenValidCGHCompanyIDThenGetCompanyAddressShouldreturnCGHAddress() {
		def actual = unit.getCompanyAddress(1L)
		assert actual == TestData.address()
	}

	@Test(expected = InvoiceModelException)
	void givenAnInvalidIDTheGetCompanyAddressShouldThrowInvoiceModelException() {
		unit.getCompanyAddress(-1L);
	}

	@Test
	void givenValidCGHCompanyIDThenGetBankDetailsShouldreturnCGHBankDetails() {
		def actual = unit.getBankDetails(1L)
		assert actual == TestData.bankDetails();
	}

	@Test(expected = InvoiceModelException)
	void givenAnInvalidIDTheGetBankDetailShouldThrowInvoiceModelException() {
		unit.getBankDetails(-1L);
	}
}
