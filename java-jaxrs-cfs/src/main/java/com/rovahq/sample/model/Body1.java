package com.rovahq.sample.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class Body1   {
  
  @Schema(description = "the Account ID found in settings page")
 /**
   * the Account ID found in settings page  
  **/
  private String clientId = null;
  
  @Schema(description = "the primary or secondary Auth Token found in settings page")
 /**
   * the primary or secondary Auth Token found in settings page  
  **/
  private String clientSecret = null;
  
  @Schema(description = "the authorization code")
 /**
   * the authorization code  
  **/
  private String code = null;
  
  @Schema(description = "the support grant types are `password`, `client_credentials`, `refresh_token` and `authorization_code`")
 /**
   * the support grant types are `password`, `client_credentials`, `refresh_token` and `authorization_code`  
  **/
  private String grantType = null;
  
  @Schema(description = "expects the `redirect_uri` to match the `redirect_uri` from `/oauth/authorize`")
 /**
   * expects the `redirect_uri` to match the `redirect_uri` from `/oauth/authorize`  
  **/
  private String redirectUri = null;
 /**
   * the Account ID found in settings page
   * @return clientId
  **/
  @JsonProperty("client_id")
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public Body1 clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

 /**
   * the primary or secondary Auth Token found in settings page
   * @return clientSecret
  **/
  @JsonProperty("client_secret")
  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public Body1 clientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
    return this;
  }

 /**
   * the authorization code
   * @return code
  **/
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Body1 code(String code) {
    this.code = code;
    return this;
  }

 /**
   * the support grant types are &#x60;password&#x60;, &#x60;client_credentials&#x60;, &#x60;refresh_token&#x60; and &#x60;authorization_code&#x60;
   * @return grantType
  **/
  @JsonProperty("grant_type")
  public String getGrantType() {
    return grantType;
  }

  public void setGrantType(String grantType) {
    this.grantType = grantType;
  }

  public Body1 grantType(String grantType) {
    this.grantType = grantType;
    return this;
  }

 /**
   * expects the &#x60;redirect_uri&#x60; to match the &#x60;redirect_uri&#x60; from &#x60;/oauth/authorize&#x60;
   * @return redirectUri
  **/
  @JsonProperty("redirect_uri")
  public String getRedirectUri() {
    return redirectUri;
  }

  public void setRedirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
  }

  public Body1 redirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body1 {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientSecret: ").append(toIndentedString(clientSecret)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    grantType: ").append(toIndentedString(grantType)).append("\n");
    sb.append("    redirectUri: ").append(toIndentedString(redirectUri)).append("\n");
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
