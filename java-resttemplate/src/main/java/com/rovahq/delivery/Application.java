package com.rovahq.delivery;

import com.rovahq.delivery.models.AccessCodeResponse;
import com.rovahq.delivery.models.Address;
import com.rovahq.delivery.models.CreateOrder;
import com.rovahq.delivery.models.Item;
import com.rovahq.delivery.models.Order;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Application {

    private static final String CLIENT_ID = "<CLIENT_ID>";
    private static final String CLIENT_SECRET = "<CLIENT_SECRET>";
    private static final String BASE_URL = "https://api.rovahq.com/v2/";

    private final RestTemplate template;
    private final String authCode;
    private final String accessToken;

    public static void main(String... args) throws IOException {
        RestTemplate template = new RestTemplate(new SimpleClientHttpRequestFactory() {
            @Override
            protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
                super.prepareConnection(connection, httpMethod);
                connection.setInstanceFollowRedirects(false);
            }
        });
        Application application = new Application(template);
        application.createOrder();
        Order[] orders = application.getAllOrders();
        for (Order order : orders) {
            System.out.printf("Order %d - status %s - cost %4.2f\n", order.getId(), order.getStatus(), order.getQuote().getCost());
        }
    }

    public Application(RestTemplate template) {
        this.template = template;
        this.authCode = authorize();
        this.accessToken = getAccessToken();
    }

    private String authorize() {
        String transactionUrl = BASE_URL + "oauth/authorize";
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(transactionUrl)
                .queryParam("client_id", CLIENT_ID)
                .queryParam("response_type", "code");
        ResponseEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        String authCode = response.getHeaders().getLocation().toString().split("=")[1];
        System.out.println("Authorization code : " + authCode);
        return authCode;
    }

    private String getAccessToken() {
        String url = BASE_URL + "oauth/token";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        MultiValueMap<String, String> accessCodeRequest = new LinkedMultiValueMap<>();
        accessCodeRequest.add("client_id", CLIENT_ID);
        accessCodeRequest.add("client_secret", CLIENT_SECRET);
        accessCodeRequest.add("code", authCode);
        accessCodeRequest.add("grant_type", "authorization_code");
        accessCodeRequest.add("redirect_uri", "https://localhost/");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(accessCodeRequest, headers);
        ResponseEntity<AccessCodeResponse> resp = template.postForEntity(builder.toUriString(), request, AccessCodeResponse.class, Map.of());
        System.out.println(resp.getHeaders());
        System.out.println(resp.getBody().getAccessToken());
        return resp.getBody().getAccessToken();
    }

    private Order[] getAllOrders() {
        String url = BASE_URL + "entity/orders";
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", "Bearer " + accessToken);
        headers.set("x-rova-testmode", "true");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<Order[]> orders = template.exchange(url, HttpMethod.GET, entity, Order[].class, Map.of());
        return orders.getBody();

    }

    private void createOrder() {
        String orderUrl = BASE_URL + "entity/orders";
        String quoteUrl = BASE_URL + "entity/orders/quote";
        Address pickupAddress = new Address()
                .address("1601 5th Ave")
                .address2("")
                .locality("WA")
                .city("Seattle")
                .instructions("Ask for \"Jimmy\" at the front door")
                .phone("415-222-1111")
                .name("Jimmy Cricket")
                .name2("")
                .postalCode("98101");
        Address dropoffAddress = new Address()
                .company("")
                .name("Kristina")
                .address("325 5th Ave N")
                .address2("")
                .locality("WA")
                .city("Seattle")
                .instructions("Please call Kristina at arrival")
                .phone("2062221234")
                .postalCode("98109");
        String pickUpTime = DateTimeFormatter.ISO_DATE_TIME.format(OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
        String dropOffTime = DateTimeFormatter.ISO_DATE_TIME.format(OffsetDateTime.ofInstant(
                Instant.now().plus(25, ChronoUnit.MINUTES)
                , ZoneId.systemDefault()));
        CreateOrder sampleOrder = new CreateOrder()
                .deliveryCategory("boxes")
                .orderReferenceId("test 123")
                .pickUpDateTime(pickUpTime)
                .pickUpAddress(pickupAddress)
                .shipToAddress(dropoffAddress)
                .customerSignatureType(CreateOrder.CustomerSignatureTypeEnum.NONE)
                .tips(new BigDecimal(10))
                .webhookUrl("https://example.com/v2/logistic/event")
                .vehicleType("car")
                .items(List.of(new Item()
                        .name("Plywood")
                        .quantity(2)
                ));

        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", "Bearer " + accessToken);
        headers.set("x-rova-testmode", "true");
        HttpEntity<CreateOrder> request = new HttpEntity<>(sampleOrder, headers);
        ResponseEntity<Order> order = template.postForEntity(orderUrl, request, Order.class, Map.of());
        System.out.println("Order estimated at $" + order.getBody().getQuote().getCost());
    }
}
