package net.cghsystems.test.util

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.test.context.ContextLoader

class AnnotationConfigContextLoader implements ContextLoader {

	ApplicationContext loadContext(String... basePackages) throws Exception {
		new AnnotationConfigApplicationContext(basePackages);
	}

	String[] processLocations(Class<?> clazz, String... locations) {
		return locations;
	}
}
