package net.cghsystems.pdf.model.builders;

import static org.junit.Assert.*

import org.junit.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ModelConfigTest {

	@Test
	void test() {
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext("net.cghsystems.pdf")
		def companyBuilder = c.getBean("companyBuilder")
		assert companyBuilder != null
	}
}
