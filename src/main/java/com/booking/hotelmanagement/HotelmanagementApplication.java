package com.booking.hotelmanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(
		prePostEnabled = true,
		securedEnabled = true,
		jsr250Enabled = true)
@EnableJpaRepositories(basePackages = "com.booking.hotelmanagement")
@EntityScan(basePackages = "com.booking.hotelmanagement")
@ConfigurationPropertiesScan(basePackages = "com.booking.hotelmanagement")
// @ComponentScan(basePackages = "com.booking.hotelmanagement")
@EnableCaching
@SpringBootApplication
@Slf4j
public class HotelmanagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HotelmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("this will be executed after application is bootstraped");
	}
}
