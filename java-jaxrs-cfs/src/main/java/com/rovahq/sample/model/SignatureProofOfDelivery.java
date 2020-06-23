package com.rovahq.sample.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class SignatureProofOfDelivery  implements OneOfRouteAddressProofOfDelivery  {
  
  @Schema(description = "")
  private String signatureName = null;
  
  @Schema(description = "")
  private String imageUri = null;
  
  @Schema(required = true, description = "")
  private String podType = null;
 /**
   * Get signatureName
   * @return signatureName
  **/
  @JsonProperty("signatureName")
  public String getSignatureName() {
    return signatureName;
  }

  public void setSignatureName(String signatureName) {
    this.signatureName = signatureName;
  }

  public SignatureProofOfDelivery signatureName(String signatureName) {
    this.signatureName = signatureName;
    return this;
  }

 /**
   * Get imageUri
   * @return imageUri
  **/
  @JsonProperty("imageUri")
  public String getImageUri() {
    return imageUri;
  }

  public void setImageUri(String imageUri) {
    this.imageUri = imageUri;
  }

  public SignatureProofOfDelivery imageUri(String imageUri) {
    this.imageUri = imageUri;
    return this;
  }

 /**
   * Get podType
   * @return podType
  **/
  @JsonProperty("podType")
  public String getPodType() {
    return podType;
  }

  public void setPodType(String podType) {
    this.podType = podType;
  }

  public SignatureProofOfDelivery podType(String podType) {
    this.podType = podType;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignatureProofOfDelivery {\n");
    
    sb.append("    signatureName: ").append(toIndentedString(signatureName)).append("\n");
    sb.append("    imageUri: ").append(toIndentedString(imageUri)).append("\n");
    sb.append("    podType: ").append(toIndentedString(podType)).append("\n");
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
