package com.example.negociogeneral.ServiceLocator;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class ResponseLB implements IResponseLB{
    private final static String URL = "http://localhost/";
    private final static String HEADER_NAME = "X-Upstream";
    @Override
    public String getResponse() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <String> responseEntity = restTemplate.getForEntity(URL, String.class);
        HttpHeaders headers = responseEntity.getHeaders();
        return headers.getFirst(HEADER_NAME);
    }
}
