package com.booking.hotelmanagement.cache.config;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// @Configuration("cacheConfigSpringCacheConfiguration")
@Configuration()
@ConfigurationProperties(prefix = "spring.cache")
@Data
public class SpringCacheConfigurationProperties {
    //extract spring.cache properties
    private String type = "none";

}
