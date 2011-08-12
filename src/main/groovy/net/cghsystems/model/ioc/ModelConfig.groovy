package net.cghsystems.model.ioc

import net.cghsystems.model.builders.CompanyBuilder

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ModelConfig {

    @Bean(name = "companyBuilder")
    CompanyBuilder builder() {
        new CompanyBuilder()
    }
}
