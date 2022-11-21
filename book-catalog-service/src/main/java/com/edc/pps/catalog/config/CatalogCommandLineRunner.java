package com.edc.pps.catalog.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.catalog.Catalog;
@Slf4j
@Component
public class CatalogCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("Ran info logger");
    }
}
