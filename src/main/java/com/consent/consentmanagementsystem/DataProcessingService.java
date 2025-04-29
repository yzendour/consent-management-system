package com.consent.consentmanagementsystem;

import io.getunleash.Unleash;
import io.getunleash.UnleashContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataProcessingService {

    private final Unleash unleash;

    @Autowired
    public DataProcessingService(Unleash unleash) {
        this.unleash = unleash;
    }

    public void processUserData(String userId, boolean hasConsented) {
        UnleashContext context = UnleashContext.builder()
                .userId(userId)
                .addProperty("hasConsented", String.valueOf(hasConsented))
                .build();

        boolean isAllowed = unleash.isEnabled("usePrivateData", context);

        if (isAllowed) {
            // proceed with processing private data
            System.out.println("✅ Processing private data for user: " + userId);
        } else {
            // skip or anonymize
            System.out.println("❌ Consent not given. Skipping user: " + userId);
        }
    }
}
