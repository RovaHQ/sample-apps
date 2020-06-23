package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class FailureResult   {
  
  @Schema(description = "")
  private String error = null;
  
  @Schema(description = "")
  private String errBit = null;
  
  @Schema(description = "")
  private String errorDescription = null;
  
  @Schema(description = "")
  private List<String> validationError = null;
  
  @Schema(required = true, description = "")
  private String requestId = null;
 /**
   * Get error
   * @return error
  **/
  @JsonProperty("error")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public FailureResult error(String error) {
    this.error = error;
    return this;
  }

 /**
   * Get errBit
   * @return errBit
  **/
  @JsonProperty("errBit")
  public String getErrBit() {
    return errBit;
  }

  public void setErrBit(String errBit) {
    this.errBit = errBit;
  }

  public FailureResult errBit(String errBit) {
    this.errBit = errBit;
    return this;
  }

 /**
   * Get errorDescription
   * @return errorDescription
  **/
  @JsonProperty("errorDescription")
  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  public FailureResult errorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
    return this;
  }

 /**
   * Get validationError
   * @return validationError
  **/
  @JsonProperty("validationError")
  public List<String> getValidationError() {
    return validationError;
  }

  public void setValidationError(List<String> validationError) {
    this.validationError = validationError;
  }

  public FailureResult validationError(List<String> validationError) {
    this.validationError = validationError;
    return this;
  }

  public FailureResult addValidationErrorItem(String validationErrorItem) {
    this.validationError.add(validationErrorItem);
    return this;
  }

 /**
   * Get requestId
   * @return requestId
  **/
  @JsonProperty("requestId")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public FailureResult requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailureResult {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    errBit: ").append(toIndentedString(errBit)).append("\n");
    sb.append("    errorDescription: ").append(toIndentedString(errorDescription)).append("\n");
    sb.append("    validationError: ").append(toIndentedString(validationError)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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
