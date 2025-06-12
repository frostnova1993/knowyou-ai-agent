package com.knowyou.knowyouaiagent.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(modelConfig.CONFIG_PREFIX)
public class modelConfig {
    public static final String CONFIG_PREFIX = "model.config";
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
