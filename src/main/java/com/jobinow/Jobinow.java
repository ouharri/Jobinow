package com.jobinow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the Jobinow application.
 * This class contains the main method to start the Spring Boot application.
 */
@SpringBootApplication
public class Jobinow {

    /**
     * The main method to start the File Uploader application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Jobinow.class, args);
    }

}