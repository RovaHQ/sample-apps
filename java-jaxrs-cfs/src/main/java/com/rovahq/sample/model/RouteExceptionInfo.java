package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

/**
  * describes how delivery exceptions should be handled. If `RETURN_TO_ADDRESS` is selected, `address` field cannot be null
 **/
@Schema(description="describes how delivery exceptions should be handled. If `RETURN_TO_ADDRESS` is selected, `address` field cannot be null")
public class RouteExceptionInfo   {
  public enum TypeEnum {
    DISCARD("DISCARD"),
    RETURN_TO_ADDRESS("RETURN_TO_ADDRESS");

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
  private RouteExceptionAddress address = null;
  
  @Schema(description = "")
  private Boolean hasTriggered = null;
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

  public RouteExceptionInfo type(TypeEnum type) {
    this.type = type;
    return this;
  }

 /**
   * Get address
   * @return address
  **/
  @JsonProperty("address")
  public RouteExceptionAddress getAddress() {
    return address;
  }

  public void setAddress(RouteExceptionAddress address) {
    this.address = address;
  }

  public RouteExceptionInfo address(RouteExceptionAddress address) {
    this.address = address;
    return this;
  }

 /**
   * Get hasTriggered
   * @return hasTriggered
  **/
  @JsonProperty("hasTriggered")
  public Boolean isHasTriggered() {
    return hasTriggered;
  }



  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RouteExceptionInfo {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    hasTriggered: ").append(toIndentedString(hasTriggered)).append("\n");
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
