package com.rovahq.sample;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.rovahq.sample.api.AuthorizationApi;
import com.rovahq.sample.api.DispatchApi;
import com.rovahq.sample.model.AuthResponse;
import com.rovahq.sample.model.BillingMetaData;
import com.rovahq.sample.model.CreateQuoteRequest;
import com.rovahq.sample.model.CreateQuoteResult;
import com.rovahq.sample.model.Leg;
import com.rovahq.sample.model.Route;
import com.rovahq.sample.model.RouteAddress;
import com.rovahq.sample.model.RouteList;
import com.rovahq.sample.model.SubmittedRoute;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;

public class CreateOrderSample {
    private static final String ROVA_API_ENDPOINT = "https://api.rovahq.com";
    // API credentials can be found under https://portal.rovahq.com/workspace
    private static final String ROVA_CLIENT_ID = System.getenv("ROVA_CLIENT_ID");
    private static final String ROVA_CLIENT_SECRET = System.getenv("ROVA_CLIENT_SECRET");
    private static final String ROVA_DEBUG = System.getenv("ROVA_DEBUG");

    private final DispatchApi dispatchApiClient;

    public static void main(String[] args) {

        // Login with oauth2 client_credentials
        CreateOrderSample sampleApp = new CreateOrderSample();
        int routeId = sampleApp.createSampleRoute();
        Route route = sampleApp.getRouteById(routeId);
        System.out.println(route);
        sampleApp.listRoutes();
    }

    public CreateOrderSample() {
        // setup the client and authenticate
        JAXRSClientFactoryBean oauthClientFactoryBean = new JAXRSClientFactoryBean();
        oauthClientFactoryBean.setAddress(ROVA_API_ENDPOINT);
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        oauthClientFactoryBean.setProvider(new JacksonJsonProvider(objectMapper));
        if ("true".equalsIgnoreCase(ROVA_DEBUG)) {
            oauthClientFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
            oauthClientFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
        }
        String clientIdWithSecret = ROVA_CLIENT_ID + ":" + ROVA_CLIENT_SECRET;
        String encodedIdWithSecret = Base64.getEncoder().encodeToString(clientIdWithSecret.getBytes());
        WebClient authorizationClient = oauthClientFactoryBean.createWebClient().authorization("Basic " + encodedIdWithSecret);
        AuthorizationApi authorizationApi = JAXRSClientFactory.fromClient(authorizationClient, AuthorizationApi.class, true);
        AuthResponse authResp = authorizationApi.v2OauthTokenPost(null, null, null, "client_credentials", null);
        String accessToken = authResp.getAccessToken();
        JAXRSClientFactoryBean clientFactoryBean = new JAXRSClientFactoryBean();
        clientFactoryBean.setAddress(ROVA_API_ENDPOINT);
        clientFactoryBean.setProvider(new JacksonJsonProvider(objectMapper));

        if ("true".equalsIgnoreCase(ROVA_DEBUG)) {
            clientFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
            clientFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
        }
        WebClient client = clientFactoryBean.createWebClient().authorization("Bearer " + accessToken);
        dispatchApiClient = JAXRSClientFactory.fromClient(client, DispatchApi.class, true);
    }

    public int createSampleRoute() {
        Route route = new Route();
        Leg pickUpLeg = new Leg()
                .type(Leg.TypeEnum.PICK_UP);
        pickUpLeg.setAddresses(new ArrayList<>());
        pickUpLeg.addAddressesItem(
                new RouteAddress()
                        .address("1601 5th Ave")
                        .address2("")
                        .locality("WA")
                        .city("Seattle")
                        .instructions("Ask for \"Jimmy\" at the front door")
                        .phone("415-222-1111")
                        .name("Jimmy Cricket")
                        .postalCode("98101"));
        Leg dropOffLeg = new Leg()
                .type(Leg.TypeEnum.DROP_OFF);
        dropOffLeg.setAddresses(new ArrayList<>());
        dropOffLeg.addAddressesItem(
                new RouteAddress()
                        .company("")
                        .name("Kristina")
                        .address("325 5th Ave N")
                        .address2("")
                        .locality("WA")
                        .city("Seattle")
                        .instructions("Please call Kristina at arrival")
                        .phone("2062221234")
                        .postalCode("98109"));
        route.setLegs(new ArrayList<>());
        route.addLegsItem(pickUpLeg).addLegsItem(dropOffLeg)
                .deliveryCategory(Route.DeliveryCategoryEnum.BOXES)
                .localPickUpDateTime(LocalDateTime.now().plusDays(2).toString())
                .vehicleType(Route.VehicleTypeEnum.CAR);
        CreateQuoteRequest payload = new CreateQuoteRequest()
                .route(route);
        CreateQuoteResult quoteResp = dispatchApiClient.createQuote(payload);
        System.out.println("Received a quote of $" + quoteResp.getQuote().getFinalPrice() + " for quote id " + quoteResp.getQuote().getTransaction().getId());

        SubmittedRoute createRouteRequest = new SubmittedRoute()
                .route(route)
                .billing(new BillingMetaData()
                        .tips(new BigDecimal(10))
                        .quoteId(quoteResp.getQuote().getTransaction().getId()));
        Route createdRoute = dispatchApiClient.submitRoute(createRouteRequest);
        System.out.println("Created route with route id " + createdRoute.getId());
        return createdRoute.getId();
    }

    private Route getRouteById(int routeId) {
        return dispatchApiClient.getSingleRoute(routeId);
    }

    private void listRoutes() {
        RouteList routeList = dispatchApiClient.getRoutes(null, null, null, null, 5);
        routeList.getRoutes().forEach(route -> System.out.printf("Route #%d - status %s - cost %4.2f%n", route.getId(), route.getStatus(), route.getTransaction().getFinalPrice())
        );
    }


}
