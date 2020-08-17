package com.xpeppers.salestaxes;

import com.xpeppers.salestaxes.property.Property;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties({
	Property.class
})

@SpringBootApplication
public class SalestaxesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalestaxesApplication.class, args);
	}

}
