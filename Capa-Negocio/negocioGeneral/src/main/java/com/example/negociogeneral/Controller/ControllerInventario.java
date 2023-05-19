package com.example.negociogeneral.Controller;

import com.example.entidades.*;
import com.example.negociogeneral.Payload.Request.InventarioRequest;
import com.example.negociogeneral.Payload.Response.InventarioIngredienteResponse;
import com.example.negociogeneral.Payload.Response.InventarioResponse;
import com.example.negociogeneral.Services.intf.*;
import com.example.negociogeneral.Utils.DistanciaHeap;
import com.example.negociogeneral.Utils.TokenUtils;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listarInventario/bodega={id}/inicio={inicio}/fin={fin}")
    public ResponseEntity <?> inventarioBodega(@PathVariable Long id, @PathVariable int fin, @PathVariable int inicio){
        try {
            Bodega bodega = servicioBodega.obtenerBodega(id);
            List<Inventario> inventarioBodega = servicioInventario.obtenerTodosInventarioPorBodega(bodega, inicio, fin);
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
    public ResponseEntity <?> solicitarInventario (@PathVariable Long id, @RequestBody List<InventarioRequest> inventarioRequest, HttpServletRequest request){
        try {
            EstadoEnvio estadoEnvio = servicioEstadoEnvio.obtenerEstadoEnvioPorNombre("Recibido");
            Usuario usuarioRequest = servicioUsuario.obtenerUsuario(tokenUtils.getUsernameToToken(request));
            Restaurante restaurante = servicioRestaurante.obtenerRestaurante(id);
            PriorityQueue<DistanciaHeap> heapBodegas = servicioBodega.obtenerBodegasPorUbicacion(restaurante.getLat(), restaurante.getLng());

            while(!heapBodegas.isEmpty()){
                DistanciaHeap distanciaHeap = heapBodegas.poll();
                Bodega bodega = servicioBodega.obtenerBodega(distanciaHeap.getBodegaId());
                EnvioInventario envioInventario = EnvioInventario.builder()
                        .usuario(usuarioRequest)
                        .estadoEnvio(estadoEnvio)
                        .restaurante(restaurante)
                        .bodega(bodega)
                        .fecha(new Date())
                        .build();

                List <CantidadIngrediente> ingredientesEnvio = new ArrayList<>();

                for (InventarioRequest inventario : inventarioRequest){
                    Ingrediente ingrediente = servicioIngrediente.obtenerIngrediente(inventario.getIngredienteId());
                    Inventario inventarioBodega = servicioInventario.obtenerTodosInventarioPorBodegaPorIngrediente(bodega, ingrediente);
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
                if (ingredientesEnvio.size() != inventarioRequest.size()){
                    return ResponseEntity.badRequest().body("No hay suficiente inventario en la bodega " + bodega.getNombre());
                }
                servicioInventario.agregarEnvioInventario(envioInventario, ingredientesEnvio);
            }
            return ResponseEntity.ok().body("Inventario solicitado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error al solicitar inventario");
        }
    }
}
