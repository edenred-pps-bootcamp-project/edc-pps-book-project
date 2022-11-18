package com.edc.pps.rating.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvironmentConfig {

    @Autowired
    public Environment environment;

@Bean
    public  CustomProperties customProperties(){
    CustomProperties customProperties = new CustomProperties();
    customProperties.setAppOwner(environment.getProperty("appOwner"));
    customProperties.setReleaseVersion(environment.getProperty("releaseVersion"));
    System.out.println(environment.getProperty("appOwner"));
    return customProperties;
}
}
