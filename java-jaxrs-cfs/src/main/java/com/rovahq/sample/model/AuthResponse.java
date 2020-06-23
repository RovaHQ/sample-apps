package com.rovahq.sample.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class AuthResponse {

    @Schema(description = "")
    private String accessToken = null;

    @Schema(description = "")
    private Integer expiresIn = null;

    @Schema(description = "")
    private String refreshToken = null;

    @Schema(description = "")
    private List<String> scope = null;

    @Schema(description = "")
    private String tokenType = null;
    /**
     * Get accessToken
     * @return accessToken
     **/
    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public AuthResponse accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    /**
     * Get expiresIn
     * minimum: 1
     * @return expiresIn
     **/
    @JsonProperty("expires_in")
    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public AuthResponse expiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    /**
     * Get refreshToken
     * @return refreshToken
     **/
    @JsonProperty("refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public AuthResponse refreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    /**
     * Get scope
     * @return scope
     **/
    @JsonProperty("scope")
    public List<String> getScope() {
        return scope;
    }

    public void setScope(List<String> scope) {
        this.scope = scope;
    }

    public AuthResponse scope(List<String> scope) {
        this.scope = scope;
        return this;
    }

    public AuthResponse addScopeItem(String scopeItem) {
        this.scope.add(scopeItem);
        return this;
    }

    /**
     * Get tokenType
     * @return tokenType
     **/
    @JsonProperty("token_type")
    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public AuthResponse tokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuthResponse {\n");

        sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
        sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
        sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
        sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
        sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private static String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
