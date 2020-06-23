package com.rovahq.sample.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

public class OrderStatus   {
  public enum DeliveryStatusEnum {
    CANCELLED("cancelled");

    private String value;

    DeliveryStatusEnum(String value) {
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
    public static DeliveryStatusEnum fromValue(String text) {
      for (DeliveryStatusEnum b : DeliveryStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(required = true, description = "")
  private DeliveryStatusEnum deliveryStatus = null;
 /**
   * Get deliveryStatus
   * @return deliveryStatus
  **/
  @JsonProperty("deliveryStatus")
  public String getDeliveryStatus() {
    if (deliveryStatus == null) {
      return null;
    }
    return deliveryStatus.getValue();
  }

  public void setDeliveryStatus(DeliveryStatusEnum deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

  public OrderStatus deliveryStatus(DeliveryStatusEnum deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderStatus {\n");
    
    sb.append("    deliveryStatus: ").append(toIndentedString(deliveryStatus)).append("\n");
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
