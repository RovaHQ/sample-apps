package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class RouteExceptionAddress   {
  
  @Schema(required = true, description = "")
  private String name = null;
  
  @Schema(description = "")
  private String company = null;
  
  @Schema(required = true, description = "")
  private String address = null;
  
  @Schema(description = "")
  private String address2 = null;
  
  @Schema(required = true, description = "")
  private String city = null;
  
  @Schema(required = true, description = "")
  private String postalCode = null;
  
  @Schema(required = true, description = "")
  private String locality = null;
  
  @Schema(required = true, description = "")
  private String phone = null;
  
  @Schema(description = "")
  private String instructions = null;
  
  @Schema(description = "")
  private AllOfRouteExceptionAddressCoordinates coordinates = null;
  
  @Schema(description = "")
  private String timezone = null;
  
  @Schema(description = "")
  private Date created = null;
  
  @Schema(description = "")
  private Date modified = null;
  
  @Schema(description = "")
  private Date deleted = null;
 /**
   * Get name
   * @return name
  **/
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RouteExceptionAddress name(String name) {
    this.name = name;
    return this;
  }

 /**
   * Get company
   * @return company
  **/
  @JsonProperty("company")
  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public RouteExceptionAddress company(String company) {
    this.company = company;
    return this;
  }

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

  public RouteExceptionAddress address(String address) {
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

  public RouteExceptionAddress address2(String address2) {
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

  public RouteExceptionAddress city(String city) {
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

  public RouteExceptionAddress postalCode(String postalCode) {
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

  public RouteExceptionAddress locality(String locality) {
    this.locality = locality;
    return this;
  }

 /**
   * Get phone
   * @return phone
  **/
  @JsonProperty("phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public RouteExceptionAddress phone(String phone) {
    this.phone = phone;
    return this;
  }

 /**
   * Get instructions
   * @return instructions
  **/
  @JsonProperty("instructions")
  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public RouteExceptionAddress instructions(String instructions) {
    this.instructions = instructions;
    return this;
  }

 /**
   * Get coordinates
   * @return coordinates
  **/
  @JsonProperty("coordinates")
  public AllOfRouteExceptionAddressCoordinates getCoordinates() {
    return coordinates;
  }


 /**
   * Get timezone
   * @return timezone
  **/
  @JsonProperty("timezone")
  public String getTimezone() {
    return timezone;
  }


 /**
   * Get created
   * @return created
  **/
  @JsonProperty("created")
  public Date getCreated() {
    return created;
  }


 /**
   * Get modified
   * @return modified
  **/
  @JsonProperty("modified")
  public Date getModified() {
    return modified;
  }


 /**
   * Get deleted
   * @return deleted
  **/
  @JsonProperty("deleted")
  public Date getDeleted() {
    return deleted;
  }



  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RouteExceptionAddress {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    address2: ").append(toIndentedString(address2)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    instructions: ").append(toIndentedString(instructions)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
    sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
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
