package com.consent.consentmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class ConsentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsentManagementSystemApplication.class, args);
    }

}
