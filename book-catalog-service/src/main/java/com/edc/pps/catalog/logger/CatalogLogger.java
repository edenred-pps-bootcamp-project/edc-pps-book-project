package com.edc.pps.catalog.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CatalogLogger {
    private static final Logger log = LoggerFactory.getLogger(CatalogLogger.class);

    public static void info(String message){
        log.info(message);
    }
}
