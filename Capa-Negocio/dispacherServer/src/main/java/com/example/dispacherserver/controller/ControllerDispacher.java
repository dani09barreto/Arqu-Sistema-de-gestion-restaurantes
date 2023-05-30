package com.example.dispacherserver.controller;

import com.example.dispacherserver.ResponseLB.IResponseLB;
import com.example.dispacherserver.payload.DestServer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/api/dispatcher")
public class ControllerDispacher {

    @Autowired
    @Qualifier("responseLB")
    private IResponseLB responseLB;

    private ConcurrentHashMap<String, String> serverMap;
    @Value("${server.configurations}")
    private String serverConfigurations;

    public ControllerDispacher() {
        serverMap = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void init() {
        // Parsea la cadena de configuración y agrega las entradas iniciales al mapa
        parseAndAddConfigurations();

        // Programa la ejecución periódica del método refreshConfigurations cada 10 segundos
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::refreshConfigurations, 0, 10, TimeUnit.SECONDS);
    }

    private void refreshConfigurations() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Parsea la cadena de configuración en un objeto JSON
            JsonNode configurations = objectMapper.readTree(serverConfigurations);

            // Itera sobre las configuraciones y realiza una solicitud a cada cadena de conexión
            for (JsonNode config : configurations) {
                String lugar = config.get("lugar").asText();
                String conexion = config.get("conexion").asText();

                // Realiza una solicitud al servicio REST en la cadena de conexión
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.getForEntity(conexion, String.class);

                // Si la solicitud es exitosa (código de estado 2xx), agrega o actualiza la entrada en el mapa
                if (response.getStatusCode().is2xxSuccessful()) {
                    serverMap.put(lugar, conexion);
                } else {
                    serverMap.remove(lugar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseAndAddConfigurations() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Parsea la cadena de configuración en un objeto JSON
            JsonNode configurations = objectMapper.readTree(serverConfigurations);

            // Crea un nuevo mapa temporal para almacenar las configuraciones iniciales
            ConcurrentHashMap<String, String> tempMap = new ConcurrentHashMap<>();

            // Itera sobre las configuraciones y agrega las entradas al mapa temporal
            for (JsonNode config : configurations) {
                String lugar = config.get("lugar").asText();
                String conexion = config.get("conexion").asText();
                tempMap.put(lugar, conexion);
            }

            // Reemplaza el mapa actual con el mapa temporal
            serverMap = tempMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @GetMapping(value = "/dest={destination}")
    public ResponseEntity<?> dispatcher(@PathVariable String destination) {
        String server = serverMap.get(destination);
        if (server == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(new DestServer(server));
        }
    }
    @GetMapping("/dest={destination}/server")
    public ResponseEntity<?> dispatcherServer(@PathVariable String destination) {
        System.out.println("se recibe destino :"  + destination);
        String server = serverMap.get(destination);
        if (server == null){
            return ResponseEntity.notFound().build();
        } else {
            String uriDest = responseLB.getResponse(server);
            System.out.println("Se devuelve ruta de conexion: " + uriDest);
            return ResponseEntity.ok(new DestServer(uriDest));
        }
    }
}
