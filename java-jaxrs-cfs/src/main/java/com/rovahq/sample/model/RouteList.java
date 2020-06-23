package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class RouteList   {
  
  @Schema(description = "")
  private List<Route> routes = null;
  
  @Schema(description = "")
  private Integer totalRoutes = null;
 /**
   * Get routes
   * @return routes
  **/
  @JsonProperty("routes")
  public List<Route> getRoutes() {
    return routes;
  }

  public void setRoutes(List<Route> routes) {
    this.routes = routes;
  }

  public RouteList routes(List<Route> routes) {
    this.routes = routes;
    return this;
  }

  public RouteList addRoutesItem(Route routesItem) {
    this.routes.add(routesItem);
    return this;
  }

 /**
   * Get totalRoutes
   * @return totalRoutes
  **/
  @JsonProperty("totalRoutes")
  public Integer getTotalRoutes() {
    return totalRoutes;
  }

  public void setTotalRoutes(Integer totalRoutes) {
    this.totalRoutes = totalRoutes;
  }

  public RouteList totalRoutes(Integer totalRoutes) {
    this.totalRoutes = totalRoutes;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RouteList {\n");
    
    sb.append("    routes: ").append(toIndentedString(routes)).append("\n");
    sb.append("    totalRoutes: ").append(toIndentedString(totalRoutes)).append("\n");
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
