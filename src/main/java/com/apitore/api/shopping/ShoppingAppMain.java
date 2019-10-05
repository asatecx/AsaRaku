package com.apitore.api.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author ASATECX
 */
@ComponentScan
@EnableDiscoveryClient
@SpringBootApplication
public class ShoppingAppMain extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ShoppingAppMain.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingAppMain.class, args);
	}

}
