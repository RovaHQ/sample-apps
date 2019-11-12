package com.rovahq.delivery;

import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.io.IOException;
import java.net.HttpURLConnection;

public class NoRedirectClientHttpRequestFactory extends SimpleClientHttpRequestFactory {

    @Override
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
        // TODO Auto-generated method stub
        super.prepareConnection(connection, httpMethod);
        connection.setInstanceFollowRedirects(false);
    }
}