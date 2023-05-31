package com.example.negociorestaurante.ServiceLocator;

import com.example.entidades.Restaurante;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class ResponseLBGeneral implements IResponseLB{
    private final static String URL = "http://192.168.195.152/";
    private final static String HEADER_NAME = "X-Upstream";
    @Override
    public String getResponse() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        HttpHeaders headers = responseEntity.getHeaders();
        return headers.getFirst(HEADER_NAME);
    }
}
