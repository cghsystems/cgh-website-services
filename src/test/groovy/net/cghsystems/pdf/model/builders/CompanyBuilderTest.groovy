package net.cghsystems.pdf.model.builders;

import javax.annotation.Resource

import net.cghsystems.services.InvoiceModelService

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.ContextLoader
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(loader = CompanyBuilderTest, value = "net.cghsystems" )
class CompanyBuilderTest implements ContextLoader {

	@Resource(name = "invoiceModelService")
	private InvoiceModelService unit;

	@Test
	void shouldFail() {
		assert unit != null
	}

	ApplicationContext loadContext(String... basePackages) throws Exception {
		new AnnotationConfigApplicationContext(basePackages);
	}

	String[] processLocations(Class<?> clazz, String... locations) {
		return locations;
	}
}
