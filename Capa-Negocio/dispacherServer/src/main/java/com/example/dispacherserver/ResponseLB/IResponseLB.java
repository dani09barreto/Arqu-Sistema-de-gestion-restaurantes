package com.example.dispacherserver.ResponseLB;

import org.springframework.stereotype.Service;

@Service
public interface IResponseLB {
    String getResponse(String uri);
}
