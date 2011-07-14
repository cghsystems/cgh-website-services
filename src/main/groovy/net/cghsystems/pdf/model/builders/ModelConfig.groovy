package net.cghsystems.pdf.model.builders

import net.cghsystems.services.InvoiceModelService

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ModelConfig {

	@Bean(name = "invoiceModelService")
	InvoiceModelService invoiceModelService() {
		new InvoiceModelService()
	}

	@Bean(name = "companyBuilder")
	CompanyBuilder Builder() {
		new CompanyBuilder()
	}
}
