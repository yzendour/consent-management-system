package com.consent.consentmanagementsystem;

import io.getunleash.UnleashContext;
import io.getunleash.strategy.Strategy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ConsentStrategy implements Strategy {

    @Override
    public String getName() {
        return "ConsentStrategy";
    }

    @Override
    public boolean isEnabled(Map<String, String> parameters, UnleashContext context) {
        String hasConsented = context.getProperties().get("hasConsented");
        return "true".equalsIgnoreCase(hasConsented);
    }
}
