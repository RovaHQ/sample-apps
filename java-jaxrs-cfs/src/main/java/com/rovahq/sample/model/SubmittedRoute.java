package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class SubmittedRoute   {
  
  @Schema(required = true, description = "")
  private Route route = null;
  
  @Schema(required = true, description = "")
  private BillingMetaData billing = null;
 /**
   * Get route
   * @return route
  **/
  @JsonProperty("route")
  public Route getRoute() {
    return route;
  }

  public void setRoute(Route route) {
    this.route = route;
  }

  public SubmittedRoute route(Route route) {
    this.route = route;
    return this;
  }

 /**
   * Get billing
   * @return billing
  **/
  @JsonProperty("billing")
  public BillingMetaData getBilling() {
    return billing;
  }

  public void setBilling(BillingMetaData billing) {
    this.billing = billing;
  }

  public SubmittedRoute billing(BillingMetaData billing) {
    this.billing = billing;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmittedRoute {\n");
    
    sb.append("    route: ").append(toIndentedString(route)).append("\n");
    sb.append("    billing: ").append(toIndentedString(billing)).append("\n");
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
