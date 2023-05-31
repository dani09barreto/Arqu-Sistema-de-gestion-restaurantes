package com.example.rest_admin_app.model;

public class ServicesRoutes {

    private static final String URL_LB_DESPACHADOR = "http://192.168.211.101:1000/";
    private static final String DESTINO_AUTH = "auth";
    private static final String DESTINO_GENERAL = "general";

    public static String getUrlLbDespachador(){
        return URL_LB_DESPACHADOR;
    }
    public static String getDestinoAuth(){
        return DESTINO_AUTH;
    }
    public static String getDestinoGeneral(){
        return DESTINO_GENERAL;
    }

    public static String getServerAuth(String serverIp){
        return String.format("http://%s/api/auth/", serverIp);
    }
    public static String getServerRestaurante(String serverIp){
        return String.format("http://%s/api/restaurante/", serverIp);
    }
    public static String getServerDespachador(String serverIp){
        return String.format("http://%s/api/dispatcher/", serverIp);
    }
    public static String getServerGeneral(String serverIp){
        return String.format("http://%s/api/general/", serverIp);
    }
    public static String getServerGeneralWebSocketEnvios(String serverIp){
        return String.format("ws://%s/websocket-path", serverIp);
    }
    public static String getServerGeneralWebSocketPos(String serverIp){
        return String.format("ws://%s/mobile-websocket-path", serverIp);
    }
}
