package com.edc.pps.catalog.interceptors;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

// TODO: this class is not needed, you don't need additional headers on response/request
public class HeaderModifierInterceptor implements ClientHttpRequestInterceptor {

    // add custom header
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse response = execution.execute(request, body);
        response.getHeaders().add("sda", "upskill");
        return response;
    }
}