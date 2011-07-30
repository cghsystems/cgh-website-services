package net.cghsystems.model.ioc

import net.cghsystems.model.invoice.builders.InvoiceGenerator;
import net.cghsystems.services.InvoiceModelService

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ModelConfig {

	@Bean(name = "invoiceModelService")
	InvoiceModelService invoiceModelService() {
		new InvoiceModelService()
	}

	@Bean(name = "invoiceGenerator")
	InvoiceGenerator builder() {
		new InvoiceGenerator()
	}
}
