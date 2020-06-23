package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class Leg   {
  public enum TypeEnum {
    PICK_UP("PICK_UP"),
    DROP_OFF("DROP_OFF"),
    RETURN("RETURN");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(required = true, description = "")
  private TypeEnum type = null;
  
  @Schema(description = "")
  private String uid = null;
  
  @Schema(description = "")
  private List<RouteAddress> addresses = null;
 /**
   * Get type
   * @return type
  **/
  @JsonProperty("type")
  public String getType() {
    if (type == null) {
      return null;
    }
    return type.getValue();
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Leg type(TypeEnum type) {
    this.type = type;
    return this;
  }

 /**
   * Get uid
   * @return uid
  **/
  @JsonProperty("uid")
  public String getUid() {
    return uid;
  }


 /**
   * Get addresses
   * @return addresses
  **/
  @JsonProperty("addresses")
  public List<RouteAddress> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<RouteAddress> addresses) {
    this.addresses = addresses;
  }

  public Leg addresses(List<RouteAddress> addresses) {
    this.addresses = addresses;
    return this;
  }

  public Leg addAddressesItem(RouteAddress addressesItem) {
    this.addresses.add(addressesItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Leg {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
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
