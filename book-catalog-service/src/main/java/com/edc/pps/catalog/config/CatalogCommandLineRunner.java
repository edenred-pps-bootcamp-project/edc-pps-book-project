package com.edc.pps.catalog.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CatalogCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		log.info("app started");
	}
}
