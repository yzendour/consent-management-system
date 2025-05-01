package com.consent.consentmanagementsystem;

import io.getunleash.DefaultUnleash;
import io.getunleash.Unleash;
import io.getunleash.UnleashContext;
import io.getunleash.util.UnleashConfig;

public class FeatureToggleExample {

    public static void main(String[] args) {
        UnleashConfig config = UnleashConfig.builder()
                .appName("unleash-onboarding-java")
                .instanceId("unleash-onboarding-instance")
                .unleashAPI("http://localhost:4242/api/")
                .apiKey("default:development.unleash-insecure-api-token")
                .build();

        Unleash unleash = new DefaultUnleash(config);

        // Create a context with necessary attributes
        UnleashContext context = UnleashContext.builder()
                .userId("508")
                .build();
        ConsentBasedStrategy consentBasedStrategy=new ConsentBasedStrategy();


        boolean isFeatureEnabled = consentBasedStrategy.isEnabled("recommendation",context);

        if (isFeatureEnabled) {
            System.out.println("The feature is enabled based on user consent.");
        } else {
            System.out.println("The feature is disabled due to lack of user consent.");
            // Disable the feature functionality
        }
    }
}
