package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public class RouteTransaction   {
  
  @Schema(description = "")
  private BigDecimal finalPrice = null;
  
  @Schema(description = "")
  private BigDecimal tips = null;
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

  public RouteTransaction finalPrice(BigDecimal finalPrice) {
    this.finalPrice = finalPrice;
    return this;
  }

 /**
   * Get tips
   * @return tips
  **/
  @JsonProperty("tips")
  public BigDecimal getTips() {
    return tips;
  }

  public void setTips(BigDecimal tips) {
    this.tips = tips;
  }

  public RouteTransaction tips(BigDecimal tips) {
    this.tips = tips;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RouteTransaction {\n");
    
    sb.append("    finalPrice: ").append(toIndentedString(finalPrice)).append("\n");
    sb.append("    tips: ").append(toIndentedString(tips)).append("\n");
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
