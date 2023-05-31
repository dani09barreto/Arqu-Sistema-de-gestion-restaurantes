package com.example.negociogeneral.Controller;

import com.example.entidades.*;
import com.example.negociogeneral.Payload.Request.EnvioSolicitudInventario;
import com.example.negociogeneral.Payload.Request.InventarioRequest;
import com.example.negociogeneral.Payload.Request.SolicitudInventario;
import com.example.negociogeneral.Payload.Response.InventarioIngredienteResponse;
import com.example.negociogeneral.Payload.Response.InventarioResponse;
import com.example.negociogeneral.Payload.Response.Mensaje;
import com.example.negociogeneral.ServiceLocator.IResponseLB;
import com.example.negociogeneral.Services.intf.*;
import com.example.negociogeneral.Utils.DistanciaHeap;
import com.example.negociogeneral.Utils.TokenUtils;
import com.example.negociogeneral.WebSocket.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/api/general/inventario")
public class ControllerInventario {

    @Qualifier("servicioBodega")
    @Autowired
    IServicioBodega servicioBodega;

    @Autowired
    @Qualifier("servicioInventario")
    IServicioInventario servicioInventario;

    @Autowired
    @Qualifier("servicioRestaurante")
    IServicioRestaurante servicioRestaurante;

    @Autowired
    @Qualifier("servicioIngrediente")
    IServicioIngrediente servicioIngrediente;

    @Autowired
    @Qualifier("servicioUsuario")
    IServicioUsuario servicioUsuario;

    @Autowired
    @Qualifier("servicioEstadoEnvio")
    IServicioEstadoEnvio servicioEstadoEnvio;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    @Qualifier("responseLB")
    IResponseLB restClient;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listarInventario/bodega={id}/inicio={inicio}/fin={fin}")
    public ResponseEntity <?> inventarioBodega(@PathVariable Long id, @PathVariable int fin, @PathVariable int inicio){
        try {
            String uri = restClient.getResponse();
            Bodega bodega = servicioBodega.obtenerBodega(id, uri);
            List<Inventario> inventarioBodega = servicioInventario.obtenerTodosInventarioPorBodega(bodega, inicio, fin, uri);
            List <InventarioIngredienteResponse> inventarioIngredienteResponseBodega = new ArrayList<>();
            for (Inventario inventario : inventarioBodega) {
                InventarioIngredienteResponse inventarioIngredienteResponse = InventarioIngredienteResponse.builder()
                        .ingrediente(inventario.getIngrediente())
                        .cantidad(inventario.getCantidad())
                        .build();
                inventarioIngredienteResponseBodega.add(inventarioIngredienteResponse);
            }
            InventarioResponse inventarioResponseBodega = InventarioResponse.builder()
                    .bodega(bodega)
                    .ingredientes(inventarioIngredienteResponseBodega)
                    .build();

            return ResponseEntity.ok().body(inventarioResponseBodega);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener bodega");
        }
    }

    @PreAuthorize("hasRole('ADMINRESTAURANTE')")
    @PostMapping("/solicitarInventario/restaurante={id}")
    public ResponseEntity <?> solicitarInventario (@PathVariable Long id, @RequestBody SolicitudInventario solicitudInventario, HttpServletRequest request){
        try {
            String uri = restClient.getResponse();
            EnvioInventario miEnvio = null;
            EstadoEnvio estadoEnvio = servicioEstadoEnvio.obtenerEstadoEnvioPorNombre("Recibido", uri);
            Usuario usuarioRequest = servicioUsuario.obtenerUsuario(tokenUtils.getUsernameToToken(request), uri);
            Restaurante restaurante = servicioRestaurante.obtenerRestaurante(id, uri);
            PriorityQueue<DistanciaHeap> heapBodegas = servicioBodega.obtenerBodegasPorUbicacion(restaurante.getLat(), restaurante.getLng(), uri);

            if (heapBodegas.size() == 0){
                return ResponseEntity.badRequest().body("No hay bodegas disponibles");
            }

            while(!heapBodegas.isEmpty()){
                DistanciaHeap distanciaHeap = heapBodegas.poll();
                Bodega bodega = servicioBodega.obtenerBodega(distanciaHeap.getBodegaId(), uri);
                EnvioInventario envioInventario = EnvioInventario.builder()
                        .usuario(usuarioRequest)
                        .estadoEnvio(estadoEnvio)
                        .restaurante(restaurante)
                        .bodega(bodega)
                        .fecha(new Date())
                        .build();

                List <CantidadIngrediente> ingredientesEnvio = new ArrayList<>();

                for (InventarioRequest inventario : solicitudInventario.getInventarioRequests()){
                    Ingrediente ingrediente = servicioIngrediente.obtenerIngrediente(inventario.getIngredienteId(), uri);
                    Inventario inventarioBodega = servicioInventario.obtenerTodosInventarioPorBodegaPorIngrediente(bodega, ingrediente, uri);
                    if (inventarioBodega.getCantidad() < inventario.getCantidad()){
                        System.out.println("No hay suficiente inventario en la bodega " + bodega.getNombre());
                        break;
                    }
                    CantidadIngrediente cantidadIngrediente = CantidadIngrediente.builder()
                            .ingrediente(ingrediente)
                            .cantidad(inventario.getCantidad())
                            .build();
                    ingredientesEnvio.add(cantidadIngrediente);

                }
                if (ingredientesEnvio.size() != solicitudInventario.getInventarioRequests().size()){
                    return ResponseEntity.badRequest().body("No hay suficiente inventario en la bodega " + bodega.getNombre());
                }
                miEnvio = servicioInventario.agregarEnvioInventario(envioInventario, ingredientesEnvio, uri);
                break;
            }
            EnvioSolicitudInventario en = EnvioSolicitudInventario.builder()
                            .envioInventario(miEnvio).uriSocket(solicitudInventario.getUri()).build();

            WebSocketHandler.enviarActualizacion(en);
            return ResponseEntity.ok().body("Inventario solicitado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error al solicitar inventario");
        }
    }

    @PreAuthorize("hasRole('REPARTIDOR')")
    @PutMapping("/cambiarEstado/solicitud={idEnvio}&estado={nameEstado}")
    public ResponseEntity <?> cambiarInventario(@PathVariable Long idEnvio, @PathVariable String nameEstado){

        try {
            String uri = restClient.getResponse();
            servicioInventario.actualizarEnvioInventario(idEnvio, nameEstado, uri);
            EnvioInventario en = servicioInventario.obtenerEnvioInventario(idEnvio, uri);
            WebSocketHandler.enviarActualizacion(en);
            return ResponseEntity.ok().body(new Mensaje("Estado cambiado"));
        } catch (NamingException | IOException e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al cambiar estado"));
        }
    }
}
