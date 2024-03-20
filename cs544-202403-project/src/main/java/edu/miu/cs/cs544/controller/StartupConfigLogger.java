package edu.miu.cs.cs544.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class StartupConfigLogger {

    private static final Logger log = LoggerFactory.getLogger(StartupConfigLogger.class);

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @PostConstruct
    public void logDatabaseUrl() {
        // Logging the URL without credentials for security
        String sanitizedUrl = databaseUrl.replaceAll("://[^@]*@", "://***:***@");
        log.info("Database URL: {}", sanitizedUrl);
    }
}
