package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class RouteAddress   {
  
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
  private AllOfRouteAddressCoordinates coordinates = null;
  
  @Schema(description = "")
  private String timezone = null;
  
  @Schema(description = "")
  private Date created = null;
  
  @Schema(description = "")
  private Date modified = null;
  
  @Schema(description = "")
  private Date deleted = null;
  
  @Schema(description = "the timestamp of where the address was serviced by a courier")
 /**
   * the timestamp of where the address was serviced by a courier  
  **/
  private Date actionedTime = null;
  
  @Schema(description = "a marker to indicate if the address cannot serviced")
 /**
   * a marker to indicate if the address cannot serviced  
  **/
  private Boolean hasDeliveryException = null;
  
  @Schema(description = "")
  private AllOfRouteAddressDeliveryExceptionInformation deliveryExceptionInformation = null;
  
  @Schema(example = "{\"signatureName\":\"Customer Name\",\"podType\":\"signature\",\"imageUri\":\"image-url\"}", description = "")
  private OneOfRouteAddressProofOfDelivery proofOfDelivery = null;
  
  @Schema(description = "")
  private Boolean exceptionAllowed = null;
  
  @Schema(description = "")
  private Boolean completed = null;
  
  @Schema(description = "")
  private String uid = null;
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

  public RouteAddress name(String name) {
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

  public RouteAddress company(String company) {
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

  public RouteAddress address(String address) {
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

  public RouteAddress address2(String address2) {
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

  public RouteAddress city(String city) {
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

  public RouteAddress postalCode(String postalCode) {
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

  public RouteAddress locality(String locality) {
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

  public RouteAddress phone(String phone) {
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

  public RouteAddress instructions(String instructions) {
    this.instructions = instructions;
    return this;
  }

 /**
   * Get coordinates
   * @return coordinates
  **/
  @JsonProperty("coordinates")
  public AllOfRouteAddressCoordinates getCoordinates() {
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


 /**
   * the timestamp of where the address was serviced by a courier
   * @return actionedTime
  **/
  @JsonProperty("actionedTime")
  public Date getActionedTime() {
    return actionedTime;
  }


 /**
   * a marker to indicate if the address cannot serviced
   * @return hasDeliveryException
  **/
  @JsonProperty("hasDeliveryException")
  public Boolean isHasDeliveryException() {
    return hasDeliveryException;
  }


 /**
   * Get deliveryExceptionInformation
   * @return deliveryExceptionInformation
  **/
  @JsonProperty("deliveryExceptionInformation")
  public AllOfRouteAddressDeliveryExceptionInformation getDeliveryExceptionInformation() {
    return deliveryExceptionInformation;
  }


 /**
   * Get proofOfDelivery
   * @return proofOfDelivery
  **/
  @JsonProperty("proofOfDelivery")
  public OneOfRouteAddressProofOfDelivery getProofOfDelivery() {
    return proofOfDelivery;
  }


 /**
   * Get exceptionAllowed
   * @return exceptionAllowed
  **/
  @JsonProperty("exceptionAllowed")
  public Boolean isExceptionAllowed() {
    return exceptionAllowed;
  }


 /**
   * Get completed
   * @return completed
  **/
  @JsonProperty("completed")
  public Boolean isCompleted() {
    return completed;
  }


 /**
   * Get uid
   * @return uid
  **/
  @JsonProperty("uid")
  public String getUid() {
    return uid;
  }



  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RouteAddress {\n");
    
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
    sb.append("    actionedTime: ").append(toIndentedString(actionedTime)).append("\n");
    sb.append("    hasDeliveryException: ").append(toIndentedString(hasDeliveryException)).append("\n");
    sb.append("    deliveryExceptionInformation: ").append(toIndentedString(deliveryExceptionInformation)).append("\n");
    sb.append("    proofOfDelivery: ").append(toIndentedString(proofOfDelivery)).append("\n");
    sb.append("    exceptionAllowed: ").append(toIndentedString(exceptionAllowed)).append("\n");
    sb.append("    completed: ").append(toIndentedString(completed)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
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
