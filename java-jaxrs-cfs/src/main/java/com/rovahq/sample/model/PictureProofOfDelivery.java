package com.rovahq.sample.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class PictureProofOfDelivery  implements OneOfRouteAddressProofOfDelivery  {
  
  @Schema(description = "")
  private String description = null;
  
  @Schema(description = "")
  private String imageUri = null;
  
  @Schema(required = true, description = "")
  private String podType = null;
 /**
   * Get description
   * @return description
  **/
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PictureProofOfDelivery description(String description) {
    this.description = description;
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

  public PictureProofOfDelivery imageUri(String imageUri) {
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

  public PictureProofOfDelivery podType(String podType) {
    this.podType = podType;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PictureProofOfDelivery {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
