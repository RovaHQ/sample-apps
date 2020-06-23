package com.rovahq.sample.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * OneOfRouteAddressProofOfDelivery
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "podType"
)
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = PictureProofOfDelivery.class, name = "picture"),
                @JsonSubTypes.Type(value = SignatureProofOfDelivery.class, name = "signature")
        }
)
public interface OneOfRouteAddressProofOfDelivery {

}
