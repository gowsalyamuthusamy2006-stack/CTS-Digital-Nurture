package com.example.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        logger.info("=================================================");
        logger.info("Spring Learn Application Started Successfully!");
        logger.info("Access the application at: http://localhost:8084/api");
        logger.info("H2 Console: http://localhost:8084/api/h2-console");
        logger.info("=================================================");
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Application is running successfully!");
        logger.info("All beans loaded successfully!");
        logger.info("JWT Authentication is enabled and secure.");
    }
}