package com.rovahq.sample.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Route   {
  
  @Schema(description = "")
  private Integer id = null;
  
  @Schema(description = "")
  private UUID uuid = null;
  
  @Schema(description = "")
  private String status = null;
  
  @Schema(description = "")
  private AllOfRouteCourier courier = null;
  public enum DeliveryCategoryEnum {
    PRINT("PRINT"),
    HARDWARE("HARDWARE"),
    FOOD("FOOD"),
    RETAIL("RETAIL"),
    BOXES("BOXES"),
    OTHER("OTHER");

    private String value;

    DeliveryCategoryEnum(String value) {
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
    public static DeliveryCategoryEnum fromValue(String text) {
      for (DeliveryCategoryEnum b : DeliveryCategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(required = true, description = "")
  private DeliveryCategoryEnum deliveryCategory = null;
  
  @Schema(description = "")
  private String deliveryType = null;
  public enum VehicleTypeEnum {
    CAR("CAR"),
    VAN("VAN"),
    TRUCK("TRUCK"),
    SUV("SUV"),
    BICYCLE("BICYCLE");

    private String value;

    VehicleTypeEnum(String value) {
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
    public static VehicleTypeEnum fromValue(String text) {
      for (VehicleTypeEnum b : VehicleTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(required = true, description = "")
  private VehicleTypeEnum vehicleType = null;
  public enum PickUpProofOfDeliveryEnum {
    ANY("ANY"),
    SIGNATURE("SIGNATURE"),
    PICTURE("PICTURE"),
    NONE("NONE");

    private String value;

    PickUpProofOfDeliveryEnum(String value) {
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
    public static PickUpProofOfDeliveryEnum fromValue(String text) {
      for (PickUpProofOfDeliveryEnum b : PickUpProofOfDeliveryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(description = "Indicates theproof of delivery required for each pick up address")
 /**
   * Indicates theproof of delivery required for each pick up address  
  **/
  private PickUpProofOfDeliveryEnum pickUpProofOfDelivery = PickUpProofOfDeliveryEnum.NONE;
  public enum DropOffProofOfDeliveryEnum {
    ANY("ANY"),
    SIGNATURE("SIGNATURE"),
    PICTURE("PICTURE"),
    NONE("NONE");

    private String value;

    DropOffProofOfDeliveryEnum(String value) {
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
    public static DropOffProofOfDeliveryEnum fromValue(String text) {
      for (DropOffProofOfDeliveryEnum b : DropOffProofOfDeliveryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(description = "Indicates the proof of delivery required for each drop off address")
 /**
   * Indicates the proof of delivery required for each drop off address  
  **/
  private DropOffProofOfDeliveryEnum dropOffProofOfDelivery = DropOffProofOfDeliveryEnum.NONE;
  
  @Schema(description = "")
  private String referenceId = null;
  
  @Schema(description = "")
  private Date pickUpDateTime = null;
  
  @Schema(description = "")
  private AllOfRouteCourierCoordinates courierCoordinates = null;
  
  @Schema(example = "2020-06-17T09:15:00", required = true, description = "ISO 8601 extedned date time string without the timezone designator")
 /**
   * ISO 8601 extedned date time string without the timezone designator  
  **/
  private String localPickUpDateTime = null;
  
  @Schema(description = "")
  private Date accepted = null;
  
  @Schema(description = "")
  private Date completed = null;
  
  @Schema(description = "")
  private Date created = null;
  
  @Schema(description = "")
  private Date modified = null;
  
  @Schema(description = "")
  private Date deleted = null;
  
  @Schema(description = "")
  private Integer entityId = null;
  
  @Schema(description = "")
  private AllOfRouteTransaction transaction = null;
  
  @Schema(description = "")
  private AllOfRouteRouteExceptionInformation routeExceptionInformation = null;
  
  @Schema(description = "")
  private String uid = null;
  
  @Schema(description = "Each route must consist of 2 legs, 1 `PICK_UP` and 1 `DROP_OFF`. A RETURN leg can be added by the system if the route has a exception handling type of `RETURN_TO_ADDRESS`")
 /**
   * Each route must consist of 2 legs, 1 `PICK_UP` and 1 `DROP_OFF`. A RETURN leg can be added by the system if the route has a exception handling type of `RETURN_TO_ADDRESS`  
  **/
  private List<Leg> legs = null;
 /**
   * Get id
   * @return id
  **/
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }


 /**
   * Get uuid
   * @return uuid
  **/
  @JsonProperty("uuid")
  public UUID getUuid() {
    return uuid;
  }


 /**
   * Get status
   * @return status
  **/
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }


 /**
   * Get courier
   * @return courier
  **/
  @JsonProperty("courier")
  public AllOfRouteCourier getCourier() {
    return courier;
  }


 /**
   * Get deliveryCategory
   * @return deliveryCategory
  **/
  @JsonProperty("deliveryCategory")
  public String getDeliveryCategory() {
    if (deliveryCategory == null) {
      return null;
    }
    return deliveryCategory.getValue();
  }

  public void setDeliveryCategory(DeliveryCategoryEnum deliveryCategory) {
    this.deliveryCategory = deliveryCategory;
  }

  public Route deliveryCategory(DeliveryCategoryEnum deliveryCategory) {
    this.deliveryCategory = deliveryCategory;
    return this;
  }

 /**
   * Get deliveryType
   * @return deliveryType
  **/
  @JsonProperty("deliveryType")
  public String getDeliveryType() {
    return deliveryType;
  }


 /**
   * Get vehicleType
   * @return vehicleType
  **/
  @JsonProperty("vehicleType")
  public String getVehicleType() {
    if (vehicleType == null) {
      return null;
    }
    return vehicleType.getValue();
  }

  public void setVehicleType(VehicleTypeEnum vehicleType) {
    this.vehicleType = vehicleType;
  }

  public Route vehicleType(VehicleTypeEnum vehicleType) {
    this.vehicleType = vehicleType;
    return this;
  }

 /**
   * Indicates theproof of delivery required for each pick up address
   * @return pickUpProofOfDelivery
  **/
  @JsonProperty("pickUpProofOfDelivery")
  public String getPickUpProofOfDelivery() {
    if (pickUpProofOfDelivery == null) {
      return null;
    }
    return pickUpProofOfDelivery.getValue();
  }

  public void setPickUpProofOfDelivery(PickUpProofOfDeliveryEnum pickUpProofOfDelivery) {
    this.pickUpProofOfDelivery = pickUpProofOfDelivery;
  }

  public Route pickUpProofOfDelivery(PickUpProofOfDeliveryEnum pickUpProofOfDelivery) {
    this.pickUpProofOfDelivery = pickUpProofOfDelivery;
    return this;
  }

 /**
   * Indicates the proof of delivery required for each drop off address
   * @return dropOffProofOfDelivery
  **/
  @JsonProperty("dropOffProofOfDelivery")
  public String getDropOffProofOfDelivery() {
    if (dropOffProofOfDelivery == null) {
      return null;
    }
    return dropOffProofOfDelivery.getValue();
  }

  public void setDropOffProofOfDelivery(DropOffProofOfDeliveryEnum dropOffProofOfDelivery) {
    this.dropOffProofOfDelivery = dropOffProofOfDelivery;
  }

  public Route dropOffProofOfDelivery(DropOffProofOfDeliveryEnum dropOffProofOfDelivery) {
    this.dropOffProofOfDelivery = dropOffProofOfDelivery;
    return this;
  }

 /**
   * Get referenceId
   * @return referenceId
  **/
  @JsonProperty("referenceId")
  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public Route referenceId(String referenceId) {
    this.referenceId = referenceId;
    return this;
  }

 /**
   * Get pickUpDateTime
   * @return pickUpDateTime
  **/
  @JsonProperty("pickUpDateTime")
  public Date getPickUpDateTime() {
    return pickUpDateTime;
  }


 /**
   * Get courierCoordinates
   * @return courierCoordinates
  **/
  @JsonProperty("courierCoordinates")
  public AllOfRouteCourierCoordinates getCourierCoordinates() {
    return courierCoordinates;
  }


 /**
   * ISO 8601 extedned date time string without the timezone designator
   * @return localPickUpDateTime
  **/
  @JsonProperty("localPickUpDateTime")
  public String getLocalPickUpDateTime() {
    return localPickUpDateTime;
  }

  public void setLocalPickUpDateTime(String localPickUpDateTime) {
    this.localPickUpDateTime = localPickUpDateTime;
  }

  public Route localPickUpDateTime(String localPickUpDateTime) {
    this.localPickUpDateTime = localPickUpDateTime;
    return this;
  }

 /**
   * Get accepted
   * @return accepted
  **/
  @JsonProperty("accepted")
  public Date getAccepted() {
    return accepted;
  }


 /**
   * Get completed
   * @return completed
  **/
  @JsonProperty("completed")
  public Date getCompleted() {
    return completed;
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
   * Get entityId
   * @return entityId
  **/
  @JsonProperty("entityId")
  public Integer getEntityId() {
    return entityId;
  }


 /**
   * Get transaction
   * @return transaction
  **/
  @JsonProperty("transaction")
  public AllOfRouteTransaction getTransaction() {
    return transaction;
  }


 /**
   * Get routeExceptionInformation
   * @return routeExceptionInformation
  **/
  @JsonProperty("routeExceptionInformation")
  public AllOfRouteRouteExceptionInformation getRouteExceptionInformation() {
    return routeExceptionInformation;
  }

  public void setRouteExceptionInformation(AllOfRouteRouteExceptionInformation routeExceptionInformation) {
    this.routeExceptionInformation = routeExceptionInformation;
  }

  public Route routeExceptionInformation(AllOfRouteRouteExceptionInformation routeExceptionInformation) {
    this.routeExceptionInformation = routeExceptionInformation;
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
   * Each route must consist of 2 legs, 1 &#x60;PICK_UP&#x60; and 1 &#x60;DROP_OFF&#x60;. A RETURN leg can be added by the system if the route has a exception handling type of &#x60;RETURN_TO_ADDRESS&#x60;
   * @return legs
  **/
  @JsonProperty("legs")
  public List<Leg> getLegs() {
    return legs;
  }

  public void setLegs(List<Leg> legs) {
    this.legs = legs;
  }

  public Route legs(List<Leg> legs) {
    this.legs = legs;
    return this;
  }

  public Route addLegsItem(Leg legsItem) {
    this.legs.add(legsItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Route {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    courier: ").append(toIndentedString(courier)).append("\n");
    sb.append("    deliveryCategory: ").append(toIndentedString(deliveryCategory)).append("\n");
    sb.append("    deliveryType: ").append(toIndentedString(deliveryType)).append("\n");
    sb.append("    vehicleType: ").append(toIndentedString(vehicleType)).append("\n");
    sb.append("    pickUpProofOfDelivery: ").append(toIndentedString(pickUpProofOfDelivery)).append("\n");
    sb.append("    dropOffProofOfDelivery: ").append(toIndentedString(dropOffProofOfDelivery)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    pickUpDateTime: ").append(toIndentedString(pickUpDateTime)).append("\n");
    sb.append("    courierCoordinates: ").append(toIndentedString(courierCoordinates)).append("\n");
    sb.append("    localPickUpDateTime: ").append(toIndentedString(localPickUpDateTime)).append("\n");
    sb.append("    accepted: ").append(toIndentedString(accepted)).append("\n");
    sb.append("    completed: ").append(toIndentedString(completed)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("    entityId: ").append(toIndentedString(entityId)).append("\n");
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
    sb.append("    routeExceptionInformation: ").append(toIndentedString(routeExceptionInformation)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    legs: ").append(toIndentedString(legs)).append("\n");
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
