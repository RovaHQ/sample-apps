package com.rovahq.delivery.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessCodeResponse {

    private String accessToken;
    private String tokenType;
    private long expiresIn;
    private String refreshToken;
    private String[] scope;

    public AccessCodeResponse() {
    }

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("token_type")
    public String getTokenType() {
        return tokenType;
    }

    @JsonProperty("expires_in")
    public long getExpiresIn() {
        return expiresIn;
    }

    @JsonProperty("refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    public String[] getScope() {
        return scope;
    }
}
