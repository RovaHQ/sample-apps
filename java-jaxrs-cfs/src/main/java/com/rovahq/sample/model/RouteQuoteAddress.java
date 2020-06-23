package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class RouteQuoteAddress   {
  
  @Schema(description = "")
  private String address = null;
  
  @Schema(description = "")
  private String address2 = null;
  
  @Schema(description = "")
  private String city = null;
  
  @Schema(description = "")
  private String postalCode = null;
  
  @Schema(description = "")
  private String locality = null;
  
  @Schema(description = "")
  private Coordinates coordinates = null;
 /**
   * Get address
   * @return address
  **/
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public RouteQuoteAddress address(String address) {
    this.address = address;
    return this;
  }

 /**
   * Get address2
   * @return address2
  **/
  @JsonProperty("address2")
  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public RouteQuoteAddress address2(String address2) {
    this.address2 = address2;
    return this;
  }

 /**
   * Get city
   * @return city
  **/
  @JsonProperty("city")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public RouteQuoteAddress city(String city) {
    this.city = city;
    return this;
  }

 /**
   * Get postalCode
   * @return postalCode
  **/
  @JsonProperty("postalCode")
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public RouteQuoteAddress postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

 /**
   * Get locality
   * @return locality
  **/
  @JsonProperty("locality")
  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public RouteQuoteAddress locality(String locality) {
    this.locality = locality;
    return this;
  }

 /**
   * Get coordinates
   * @return coordinates
  **/
  @JsonProperty("coordinates")
  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public RouteQuoteAddress coordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RouteQuoteAddress {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    address2: ").append(toIndentedString(address2)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
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
