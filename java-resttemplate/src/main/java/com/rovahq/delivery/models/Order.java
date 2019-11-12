package com.rovahq.delivery.models;
/*
 * Overview ROVA Dispatch API
 * Integrate with ROVA's robust API to power your business with more efficient on demand deliveries. A few lines of code will allow your deliveries to access ROVA’s courier network programmatically leaving you to focus on your unique business needs.</p><p>Here you will find information on how to setup the API integration.</p><p>Have questions? Reach out to us <a href=\"mailto:support@rovahq.com\">support@rovahq.com</a>
 *
 * OpenAPI spec version: 2.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Order
 */
public class Order {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("testMode")
    private Boolean testMode = null;

    @JsonProperty("price")
    private Float price = null;

    @JsonProperty("courier")
    private Object courier = null;

    @JsonProperty("tips")
    private BigDecimal tips = null;

    @JsonProperty("vehicleType")
    private String vehicleType = null;

    @JsonProperty("accepted")
    private String accepted = null;

    @JsonProperty("delivered")
    private String delivered = null;

    @JsonProperty("pickedUp")
    private String pickedUp = null;

    @JsonProperty("created")
    private String created = null;

    @JsonProperty("modified")
    private String modified = null;

    @JsonProperty("quote")
    private Quote quote = null;

    @JsonProperty("pickUpDateTime")
    private String pickUpDateTime = null;

    @JsonProperty("pickUpAddress")
    private Address pickUpAddress = null;

    @JsonProperty("shipToAddress")
    private Address shipToAddress = null;

    @JsonProperty("items")
    private List<Item> items = null;

    @JsonProperty("lastKnownCoordinates")
    private Object lastKnownCoordinates = null;

    @JsonProperty("readyBy")
    private String readyBy = null;

    @JsonProperty("deliveryWindowStart")
    private String deliveryWindowStart = null;

    @JsonProperty("deliveryWindowEnd")
    private String deliveryWindowEnd = null;

    @JsonProperty("ageRequired")
    private Integer ageRequired = null;

    /**
     * Gets or Sets customerSignatureType
     */
    public enum CustomerSignatureTypeEnum {
        ANY("any"),

        NONE("none");

        private String value;

        CustomerSignatureTypeEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static CustomerSignatureTypeEnum fromValue(String text) {
            for (CustomerSignatureTypeEnum b : CustomerSignatureTypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("customerSignatureType")
    private CustomerSignatureTypeEnum customerSignatureType = null;

    @JsonProperty("webhookUrl")
    private String webhookUrl = null;

    @JsonProperty("orderReferenceId")
    private String orderReferenceId = null;

    public Order id(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("testMode")
    public Boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(Boolean testMode) {
        this.testMode = testMode;
    }

    public Order price(Float price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     *
     * @return price
     **/
    @JsonProperty("price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Order courier(Object courier) {
        this.courier = courier;
        return this;
    }

    /**
     * Get courier
     *
     * @return courier
     **/
    @JsonProperty("courier")
    public Object getCourier() {
        return courier;
    }

    public void setCourier(Object courier) {
        this.courier = courier;
    }

    public Order tips(BigDecimal tips) {
        this.tips = tips;
        return this;
    }

    /**
     * Get tips
     *
     * @return tips
     **/
    @JsonProperty("tips")
    public BigDecimal getTips() {
        return tips;
    }

    public void setTips(BigDecimal tips) {
        this.tips = tips;
    }

    public Order vehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    /**
     * a type of CAR or VAN
     *
     * @return vehicleType
     **/
    @JsonProperty("vehicleType")
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Order accepted(String accepted) {
        this.accepted = accepted;
        return this;
    }

    public String getStatus() {
        return status;
    }

    /**
     * ISO8601 datetime string
     *
     * @return accepted
     **/
    @JsonProperty("accepted")
    public String getAccepted() {
        return accepted;
    }

    public void setAccepted(String accepted) {
        this.accepted = accepted;
    }

    public Order delivered(String delivered) {
        this.delivered = delivered;
        return this;
    }

    /**
     * ISO8601 datetime string
     *
     * @return delivered
     **/
    @JsonProperty("delivered")
    public String getDelivered() {
        return delivered;
    }

    public void setDelivered(String delivered) {
        this.delivered = delivered;
    }

    public Order pickedUp(String pickedUp) {
        this.pickedUp = pickedUp;
        return this;
    }

    /**
     * ISO8601 datetime string
     *
     * @return pickedUp
     **/
    @JsonProperty("pickedUp")
    public String getPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(String pickedUp) {
        this.pickedUp = pickedUp;
    }

    public Order created(String created) {
        this.created = created;
        return this;
    }

    /**
     * ISO8601 datetime string
     *
     * @return created
     **/
    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Order modified(String modified) {
        this.modified = modified;
        return this;
    }

    /**
     * ISO8601 datetime string
     *
     * @return modified
     **/
    @JsonProperty("modified")
    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Order quote(Quote quote) {
        this.quote = quote;
        return this;
    }

    /**
     * Get quote
     *
     * @return quote
     **/
    @JsonProperty("quote")
    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public Order pickUpDateTime(String pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
        return this;
    }

    /**
     * ISO8601 datetime string of when the order should be picked up
     *
     * @return pickUpDateTime
     **/
    @JsonProperty("pickUpDateTime")
    public String getPickUpDateTime() {
        return pickUpDateTime;
    }

    public void setPickUpDateTime(String pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
    }

    public Order pickUpAddress(Address pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
        return this;
    }

    /**
     * Get pickUpAddress
     *
     * @return pickUpAddress
     **/
    @JsonProperty("pickUpAddress")
    public Address getPickUpAddress() {
        return pickUpAddress;
    }

    public void setPickUpAddress(Address pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
    }

    public Order shipToAddress(Address shipToAddress) {
        this.shipToAddress = shipToAddress;
        return this;
    }

    /**
     * Get shipToAddress
     *
     * @return shipToAddress
     **/
    @JsonProperty("shipToAddress")
    public Address getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(Address shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    public Order items(List<Item> items) {
        this.items = items;
        return this;
    }

    public Order addItemsItem(Item itemsItem) {
        if (this.items == null) {
            this.items = new ArrayList<Item>();
        }
        this.items.add(itemsItem);
        return this;
    }

    /**
     * Get items
     *
     * @return items
     **/
    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Order lastKnownCoordinates(Object lastKnownCoordinates) {
        this.lastKnownCoordinates = lastKnownCoordinates;
        return this;
    }

    /**
     * Get lastKnownCoordinates
     *
     * @return lastKnownCoordinates
     **/
    @JsonProperty("lastKnownCoordinates")
    public Object getLastKnownCoordinates() {
        return lastKnownCoordinates;
    }

    public void setLastKnownCoordinates(Object lastKnownCoordinates) {
        this.lastKnownCoordinates = lastKnownCoordinates;
    }

    public Order readyBy(String readyBy) {
        this.readyBy = readyBy;
        return this;
    }

    /**
     * ISO8601 datetime string
     *
     * @return readyBy
     **/
    @JsonProperty("readyBy")
    public String getReadyBy() {
        return readyBy;
    }

    public void setReadyBy(String readyBy) {
        this.readyBy = readyBy;
    }

    public Order deliveryWindowStart(String deliveryWindowStart) {
        this.deliveryWindowStart = deliveryWindowStart;
        return this;
    }

    /**
     * ISO8601 datetime string
     *
     * @return deliveryWindowStart
     **/
    @JsonProperty("deliveryWindowStart")
    public String getDeliveryWindowStart() {
        return deliveryWindowStart;
    }

    public void setDeliveryWindowStart(String deliveryWindowStart) {
        this.deliveryWindowStart = deliveryWindowStart;
    }

    public Order deliveryWindowEnd(String deliveryWindowEnd) {
        this.deliveryWindowEnd = deliveryWindowEnd;
        return this;
    }

    /**
     * ISO8601 datetime string
     *
     * @return deliveryWindowEnd
     **/
    @JsonProperty("deliveryWindowEnd")
    public String getDeliveryWindowEnd() {
        return deliveryWindowEnd;
    }

    public void setDeliveryWindowEnd(String deliveryWindowEnd) {
        this.deliveryWindowEnd = deliveryWindowEnd;
    }

    public Order ageRequired(Integer ageRequired) {
        this.ageRequired = ageRequired;
        return this;
    }

    /**
     * Get ageRequired
     * minimum: 0
     *
     * @return ageRequired
     **/
    @JsonProperty("ageRequired")
    @Min(0)
    public Integer getAgeRequired() {
        return ageRequired;
    }

    public void setAgeRequired(Integer ageRequired) {
        this.ageRequired = ageRequired;
    }

    public Order customerSignatureType(CustomerSignatureTypeEnum customerSignatureType) {
        this.customerSignatureType = customerSignatureType;
        return this;
    }

    /**
     * Get customerSignatureType
     *
     * @return customerSignatureType
     **/
    @JsonProperty("customerSignatureType")
    public CustomerSignatureTypeEnum getCustomerSignatureType() {
        return customerSignatureType;
    }

    public void setCustomerSignatureType(CustomerSignatureTypeEnum customerSignatureType) {
        this.customerSignatureType = customerSignatureType;
    }

    public Order webhookUrl(String webhookUrl) {
        this.webhookUrl = webhookUrl;
        return this;
    }

    /**
     * Get webhookUrl
     *
     * @return webhookUrl
     **/
    @JsonProperty("webhookUrl")
    public String getWebhookUrl() {
        return webhookUrl;
    }

    public void setWebhookUrl(String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    public Order orderReferenceId(String orderReferenceId) {
        this.orderReferenceId = orderReferenceId;
        return this;
    }

    /**
     * Get orderReferenceId
     *
     * @return orderReferenceId
     **/
    @JsonProperty("orderReferenceId")
    public String getOrderReferenceId() {
        return orderReferenceId;
    }

    public void setOrderReferenceId(String orderReferenceId) {
        this.orderReferenceId = orderReferenceId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(this.id, order.id) &&
                Objects.equals(this.uuid, order.uuid) &&
                Objects.equals(this.status, order.status) &&
                Objects.equals(this.testMode, order.testMode) &&
                Objects.equals(this.price, order.price) &&
                Objects.equals(this.courier, order.courier) &&
                Objects.equals(this.tips, order.tips) &&
                Objects.equals(this.vehicleType, order.vehicleType) &&
                Objects.equals(this.accepted, order.accepted) &&
                Objects.equals(this.delivered, order.delivered) &&
                Objects.equals(this.pickedUp, order.pickedUp) &&
                Objects.equals(this.created, order.created) &&
                Objects.equals(this.modified, order.modified) &&
                Objects.equals(this.quote, order.quote) &&
                Objects.equals(this.pickUpDateTime, order.pickUpDateTime) &&
                Objects.equals(this.pickUpAddress, order.pickUpAddress) &&
                Objects.equals(this.shipToAddress, order.shipToAddress) &&
                Objects.equals(this.items, order.items) &&
                Objects.equals(this.lastKnownCoordinates, order.lastKnownCoordinates) &&
                Objects.equals(this.readyBy, order.readyBy) &&
                Objects.equals(this.deliveryWindowStart, order.deliveryWindowStart) &&
                Objects.equals(this.deliveryWindowEnd, order.deliveryWindowEnd) &&
                Objects.equals(this.ageRequired, order.ageRequired) &&
                Objects.equals(this.customerSignatureType, order.customerSignatureType) &&
                Objects.equals(this.webhookUrl, order.webhookUrl) &&
                Objects.equals(this.orderReferenceId, order.orderReferenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid, status, testMode, price, courier, tips, vehicleType, accepted, delivered, pickedUp, created, modified, quote, pickUpDateTime, pickUpAddress, shipToAddress, items, lastKnownCoordinates, readyBy, deliveryWindowStart, deliveryWindowEnd, ageRequired, customerSignatureType, webhookUrl, orderReferenceId);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Order {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    testMode: ").append(toIndentedString(testMode)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    courier: ").append(toIndentedString(courier)).append("\n");
        sb.append("    tips: ").append(toIndentedString(tips)).append("\n");
        sb.append("    vehicleType: ").append(toIndentedString(vehicleType)).append("\n");
        sb.append("    accepted: ").append(toIndentedString(accepted)).append("\n");
        sb.append("    delivered: ").append(toIndentedString(delivered)).append("\n");
        sb.append("    pickedUp: ").append(toIndentedString(pickedUp)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
        sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
        sb.append("    quote: ").append(toIndentedString(quote)).append("\n");
        sb.append("    pickUpDateTime: ").append(toIndentedString(pickUpDateTime)).append("\n");
        sb.append("    pickUpAddress: ").append(toIndentedString(pickUpAddress)).append("\n");
        sb.append("    shipToAddress: ").append(toIndentedString(shipToAddress)).append("\n");
        sb.append("    items: ").append(toIndentedString(items)).append("\n");
        sb.append("    lastKnownCoordinates: ").append(toIndentedString(lastKnownCoordinates)).append("\n");
        sb.append("    readyBy: ").append(toIndentedString(readyBy)).append("\n");
        sb.append("    deliveryWindowStart: ").append(toIndentedString(deliveryWindowStart)).append("\n");
        sb.append("    deliveryWindowEnd: ").append(toIndentedString(deliveryWindowEnd)).append("\n");
        sb.append("    ageRequired: ").append(toIndentedString(ageRequired)).append("\n");
        sb.append("    customerSignatureType: ").append(toIndentedString(customerSignatureType)).append("\n");
        sb.append("    webhookUrl: ").append(toIndentedString(webhookUrl)).append("\n");
        sb.append("    orderReferenceId: ").append(toIndentedString(orderReferenceId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
