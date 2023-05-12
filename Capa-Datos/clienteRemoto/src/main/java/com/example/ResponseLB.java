package com.example;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ResponseLB implements IResponseLB{

    private final static String URL = "http://localhost/";
    private final static String HEADER_NAME = "X-Upstream";
    @Override
    public String getResponse() throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(URL);
        HttpResponse response = httpClient.execute(request);

        // Obtener el valor del encabezado X-Upstream
        Header header = response.getFirstHeader(HEADER_NAME);
        return header.getValue();
    }
}
