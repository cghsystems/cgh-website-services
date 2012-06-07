package net.cghsystems.controllers.ioc

import net.cghsystems.controllers.InvoiceController

import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.EnableWebMvc


/**
 * Application context to to provide the Spring configuration required to create 
 * all Invoice web-mvc related Spring managed Beans.
 * <p>
 * Uses {@link EnableWebMvc} to ensure that the {@link MappingJacksonHttpMessageConverter} {@link MessageConverter} 
 * is registered. (An alternative to this annotation is to extend {@link WebMvcConfigurerAdapter} and register the 
 * {@link MessageConverter} explicitly). 
 * 
 * @author chris
 *
 */
@Configurable
@EnableWebMvc
public class InvoiceControllersApplicationContext  {

    @Bean
    InvoiceController invoiceController() {
        return new InvoiceController()
    }
}
