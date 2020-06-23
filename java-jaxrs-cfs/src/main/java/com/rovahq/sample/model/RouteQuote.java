package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public class RouteQuote   {
  
  @Schema(description = "")
  private BigDecimal finalPrice = null;
  
  @Schema(description = "")
  private RouteQuoteTransaction transaction = null;
 /**
   * Get finalPrice
   * @return finalPrice
  **/
  @JsonProperty("finalPrice")
  public BigDecimal getFinalPrice() {
    return finalPrice;
  }

  public void setFinalPrice(BigDecimal finalPrice) {
    this.finalPrice = finalPrice;
  }

  public RouteQuote finalPrice(BigDecimal finalPrice) {
    this.finalPrice = finalPrice;
    return this;
  }

 /**
   * Get transaction
   * @return transaction
  **/
  @JsonProperty("transaction")
  public RouteQuoteTransaction getTransaction() {
    return transaction;
  }

  public void setTransaction(RouteQuoteTransaction transaction) {
    this.transaction = transaction;
  }

  public RouteQuote transaction(RouteQuoteTransaction transaction) {
    this.transaction = transaction;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RouteQuote {\n");
    
    sb.append("    finalPrice: ").append(toIndentedString(finalPrice)).append("\n");
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
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
