package com.learning.linnyk.ps.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.learning.linnyk.ps.java.repository.CustomRepository;
import com.learning.linnyk.ps.java.repository.HibernateCustomRepository;
import com.learning.linnyk.ps.java.service.CustomerService;
import com.learning.linnyk.ps.java.service.CustomerServiceImpl;

/**
 * @author LinnykOleh
 */
@Configuration
@ComponentScan("com.learning.linnyk.ps.java") /* autowiring */
@PropertySource("classpath:ps/java/app.properties")
public class AppConfig {

	@Bean(name = "customerServiceSetterInjection")
	public CustomerService customerServiceSetterInjection(){
		final CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.setCustomRepository(customRepository());

		return customerService;
	}

	@Bean(name = "customerServiceConstructorInjection")
	public CustomerService customerServiceConstructorInjection(){
		return new CustomerServiceImpl(customRepository());
	}

	@Bean
	public CustomRepository customRepository(){
		return new HibernateCustomRepository();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
