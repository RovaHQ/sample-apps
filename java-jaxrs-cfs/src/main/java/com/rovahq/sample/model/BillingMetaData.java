package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public class BillingMetaData   {
  
  @Schema(required = true, description = "")
  private BigDecimal tips = null;
  
  @Schema(description = "")
  private String quoteId = null;
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

  public BillingMetaData tips(BigDecimal tips) {
    this.tips = tips;
    return this;
  }

 /**
   * Get quoteId
   * @return quoteId
  **/
  @JsonProperty("quoteId")
  public String getQuoteId() {
    return quoteId;
  }

  public void setQuoteId(String quoteId) {
    this.quoteId = quoteId;
  }

  public BillingMetaData quoteId(String quoteId) {
    this.quoteId = quoteId;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillingMetaData {\n");
    
    sb.append("    tips: ").append(toIndentedString(tips)).append("\n");
    sb.append("    quoteId: ").append(toIndentedString(quoteId)).append("\n");
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
