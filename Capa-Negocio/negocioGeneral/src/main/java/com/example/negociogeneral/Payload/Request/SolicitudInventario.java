package com.example.negociogeneral.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SolicitudInventario {
    private String uri;
    private List<InventarioRequest> inventarioRequests;
}
