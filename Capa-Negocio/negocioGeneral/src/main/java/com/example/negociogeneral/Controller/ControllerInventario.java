package com.example.negociogeneral.Controller;

import com.example.entidades.Bodega;
import com.example.entidades.Inventario;
import com.example.entidades.Restaurante;
import com.example.negociogeneral.Payload.Response.InventarioIngredienteResponse;
import com.example.negociogeneral.Payload.Response.InventarioResponse;
import com.example.negociogeneral.Services.intf.IServicioInventario;
import com.example.negociogeneral.Services.intf.IServicioBodega;
import com.example.negociogeneral.Services.intf.IServicioRestaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listarInventario/bodegas")
    public ResponseEntity <?> listarInventarioBodegas(){
        List <InventarioResponse> inventarioBodegas = new ArrayList<>();
        try {
            List <Bodega> bodegas = servicioBodega.obtenerTodasBodegas();

            for (Bodega bodega : bodegas) {
                List<Inventario> inventarioBodega = servicioInventario.obtenerTodosInventarioPorBodega(bodega);
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
                inventarioBodegas.add(inventarioResponseBodega);
            }
            return ResponseEntity.ok().body(inventarioBodegas);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener bodegas");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listarInventario/bodega={id}")
    public ResponseEntity <?> inventarioBodega(@PathVariable Long id){
        try {
            Bodega bodega = servicioBodega.obtenerBodega(id);
            List<Inventario> inventarioBodega = servicioInventario.obtenerTodosInventarioPorBodega(bodega);
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
    
}
