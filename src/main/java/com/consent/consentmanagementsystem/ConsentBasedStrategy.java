package com.consent.consentmanagementsystem;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.getunleash.UnleashContext;
import io.getunleash.strategy.Strategy;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Map;

public class ConsentBasedStrategy implements Strategy {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String getName() {
        return "consent-based"; // match this in your Unleash feature toggle strategy config
    }

    @Override
    public boolean isEnabled(Map<String, String> parameters, UnleashContext context) {
        String userId = context.getProperties().get("userId");
        String processingId = parameters.get("processingId");
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://priam/api/contract/list/consents/" + userId + "/" + processingId))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonNode jsonNode = objectMapper.readTree(response.body());
                return jsonNode.isContainerNode() && jsonNode.size() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
