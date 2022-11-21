package com.edc.pps.catalog;

import com.edc.pps.catalog.logger.CatalogLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.catalog.Catalog;

@Component
public class CatalogCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CatalogLogger logger;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Ran info logger");
    }
}
