package com.consent.consentmanagementsystem;

import io.getunleash.DefaultUnleash;
import io.getunleash.util.UnleashConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class UnleashConfigBean {

    @Bean
    public DefaultUnleash unleash() {
        UnleashConfig config = UnleashConfig.builder()
                .appName("unleash-onboarding-java")
                .instanceId("unleash-onboarding-instance")
                .unleashAPI("http://localhost:4242/api/")
                .apiKey("default:development.unleash-insecure-api-token") // in production use environment variable
                .build();

        return new DefaultUnleash(config);
    }
}