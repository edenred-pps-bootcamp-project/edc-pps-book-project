package com.edc.pps.catalog.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvironmentConfig {

    @Autowired
    public Environment environment;
}
