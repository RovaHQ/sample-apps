package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class CreateQuoteResult   {
  
  @Schema(description = "")
  private RouteQuote quote = null;
  
  @Schema(description = "")
  private RouteQuoteAddress addressess = null;
 /**
   * Get quote
   * @return quote
  **/
  @JsonProperty("quote")
  public RouteQuote getQuote() {
    return quote;
  }

  public void setQuote(RouteQuote quote) {
    this.quote = quote;
  }

  public CreateQuoteResult quote(RouteQuote quote) {
    this.quote = quote;
    return this;
  }

 /**
   * Get addressess
   * @return addressess
  **/
  @JsonProperty("addressess")
  public RouteQuoteAddress getAddressess() {
    return addressess;
  }

  public void setAddressess(RouteQuoteAddress addressess) {
    this.addressess = addressess;
  }

  public CreateQuoteResult addressess(RouteQuoteAddress addressess) {
    this.addressess = addressess;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateQuoteResult {\n");
    
    sb.append("    quote: ").append(toIndentedString(quote)).append("\n");
    sb.append("    addressess: ").append(toIndentedString(addressess)).append("\n");
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
