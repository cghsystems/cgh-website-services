package net.cghsystems.controllers.ioc

import net.cghsystems.controllers.InvoiceController

import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configurable
@EnableWebMvc
public class InvoiceControllersApplicationContext extends
WebMvcConfigurerAdapter {

    @Bean
    InvoiceController invoiceController() {
        return new InvoiceController()
    }

    //    @Override
    //    public void configureMessageConverters(
    //    List<HttpMessageConverter<?>> converters) {
    //        converters.add(new MappingJacksonHttpMessageConverter())
    //    }
}
