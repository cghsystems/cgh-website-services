package net.cghsystems.services;

import javax.annotation.Resource

import net.cghsystems.pdf.model.Address

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.ContextLoader
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(loader = InvoiceModelServiceTest, value = "net.cghsystems" )
class InvoiceModelServiceTest implements ContextLoader {

	@Resource(name = "invoiceModelService")
	private InvoiceModelService unit;

	@Test
	void givenValidCGHCompanyIDThenGetCompanyAddressShouldreturnCGHAddress() {
		Address address = unit.getCompanyAddress(1L)

		assert address.line1 == "51 Brantwood"
		assert address.line2 == "Chester-le-Street"
		assert address.town == null
		assert address.county == "Co. Durham"
		assert address.postcode == "DH2 2UJ"
	}

	@Test(expected = InvoiceModelException)
	void givenAnInvalidIDTheGetCompanyAddressShouldThrowInvoiceModelException() {
		unit.getCompanyAddress(-1L);
	}


	ApplicationContext loadContext(String... basePackages) throws Exception {
		new AnnotationConfigApplicationContext(basePackages);
	}

	String[] processLocations(Class<?> clazz, String... locations) {
		return locations;
	}
}
