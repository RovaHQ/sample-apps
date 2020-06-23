package com.rovahq.sample.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

public class DeliveryExceptionInformation   {
  public enum ExceptionTypeEnum {
    CUSTOMER_REFUSE_DELIVERY("CUSTOMER_REFUSE_DELIVERY"),
    CUSTOMER_BAD_NUMBER("CUSTOMER_BAD_NUMBER"),
    CUSTOMER_BAD_ADDRESS("CUSTOMER_BAD_ADDRESS"),
    CUSTOMER_NOT_AT_HOME("CUSTOMER_NOT_AT_HOME"),
    OTHER("OTHER");

    private String value;

    ExceptionTypeEnum(String value) {
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
    public static ExceptionTypeEnum fromValue(String text) {
      for (ExceptionTypeEnum b : ExceptionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(description = "")
  private ExceptionTypeEnum exceptionType = null;
  
  @Schema(description = "")
  private String notes = null;
 /**
   * Get exceptionType
   * @return exceptionType
  **/
  @JsonProperty("exceptionType")
  public String getExceptionType() {
    if (exceptionType == null) {
      return null;
    }
    return exceptionType.getValue();
  }

  public void setExceptionType(ExceptionTypeEnum exceptionType) {
    this.exceptionType = exceptionType;
  }

  public DeliveryExceptionInformation exceptionType(ExceptionTypeEnum exceptionType) {
    this.exceptionType = exceptionType;
    return this;
  }

 /**
   * Get notes
   * @return notes
  **/
  @JsonProperty("notes")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public DeliveryExceptionInformation notes(String notes) {
    this.notes = notes;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliveryExceptionInformation {\n");
    
    sb.append("    exceptionType: ").append(toIndentedString(exceptionType)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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
