package net.cghsystems.model.builders;

import static org.junit.Assert.*

import javax.annotation.Resource

import net.cghsystems.model.InvoiceCompany
import net.cghsystems.model.TestData
import net.cghsystems.model.invoice.builders.InvoiceGenerator;
import net.cghsystems.test.util.AnnotationConfigContextLoader

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(loader = AnnotationConfigContextLoader, value = "net.cghsystems" )
class CompanyBuilderTest {

	@Resource(name = "companyBuilder")
	InvoiceGenerator unit

	@Test
	void givenAValidCompanyForCGHIdShouldBuildCGHCompanyObject() {
		InvoiceCompany actual = unit.buildCompany(1);
		assert actual.registeredOffice == TestData.address()
		assert actual.bankDetails == TestData.bankDetails()
	}
}
