package com.example.rest_admin_app.model;

import java.util.ArrayList;
import java.util.List;

public class SolicitudInventario {
    private String uri;
    private List <InventarioRequests> inventarioRequests = new ArrayList<>();

    public SolicitudInventario(String uri, List<InventarioRequests> inventarioRequests) {
        this.uri = uri;
        this.inventarioRequests = inventarioRequests;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<InventarioRequests> getInventarioRequests() {
        return inventarioRequests;
    }

    public void setInventarioRequests(List<InventarioRequests> inventarioRequests) {
        this.inventarioRequests = inventarioRequests;
    }
}
