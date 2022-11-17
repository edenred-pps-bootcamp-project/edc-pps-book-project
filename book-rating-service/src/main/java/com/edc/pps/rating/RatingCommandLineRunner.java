package com.edc.pps.rating;

import com.edc.pps.rating.logger.RatingLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RatingCommandLineRunner implements CommandLineRunner {
    @Autowired
    private RatingLogger logger;

    @Override
    public void run(String... args) throws Exception {
    logger.info("did operation1");
    }
}
