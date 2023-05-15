package com.example.obspringsecurityjwtroles.ServiceLocator;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface IResponseLB {
    String getResponse() throws IOException;
}
