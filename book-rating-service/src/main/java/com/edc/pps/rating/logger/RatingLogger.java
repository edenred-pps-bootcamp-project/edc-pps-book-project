package com.edc.pps.rating.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RatingLogger {
private static final Logger log = LoggerFactory.getLogger(RatingLogger.class);

public static void info(String message){
    log.info(message);
}

}
