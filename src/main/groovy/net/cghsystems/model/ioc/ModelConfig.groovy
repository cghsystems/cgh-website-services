package net.cghsystems.model.ioc

import net.cghsystems.services.InvoiceService;

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ModelConfig {

    @Bean(name = "invoiceGenerator")
    InvoiceService invoiceGenerator() {
        new InvoiceService()
    }
}
