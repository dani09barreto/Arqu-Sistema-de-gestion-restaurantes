package com.example.envios_app.model;

public class ServicesRoutes {

    private static final String URL_LB_DESPACHADOR = "http://172.20.10.4:100/";
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
    public static String getServerDespachador(String serverIp){
        return String.format("http://%s/api/dispatcher/", serverIp);
    }
    public static String getServerGeneral(String serverIp){
        return String.format("http://%s/api/general/", serverIp);
    }
    public static String getServerGeneralWebSocket(String serverIp){
        return String.format("ws://%s/websocket-path", serverIp);
    }
}
