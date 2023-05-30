package com.example.dispacherserver.ResponseLB;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ResponseLB implements IResponseLB{
    private static final String HEADER_NAME = "X-Upstream";
    @Override
    public String getResponse(String uri) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        HttpHeaders headers = response.getHeaders();
        return headers.getFirst(HEADER_NAME);
    }
}
