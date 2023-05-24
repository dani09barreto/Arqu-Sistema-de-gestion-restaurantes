package com.example.negociogeneral.Controller;

import com.example.entidades.Bodega;
import com.example.negociogeneral.Services.intf.IServicioBodega;
import com.example.negociogeneral.WebSocket.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/general/bodegas")
public class ControllerBodega {

    @Qualifier("servicioBodega")
    @Autowired
    IServicioBodega servicioBodega;

    @PostMapping("/mensaje")
    public ResponseEntity<?> mensaje(){
        WebSocketHandler.enviarActualizacion("hola");
        return ResponseEntity.ok().body("mensaje enviado");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public ResponseEntity<List<Bodega>> listarBodegas(){
        List <Bodega> bodegas = null;
        try {
            bodegas = servicioBodega.obtenerTodasBodegas();
            return ResponseEntity.ok().body(bodegas);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/bodega={id}")
    public ResponseEntity <?> obtenerBodega(@PathVariable Long id){
        try {
            Bodega bodega = servicioBodega.obtenerBodega(id);
            return ResponseEntity.ok().body(bodega);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener bodega");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> crearBodega(@RequestBody Bodega bodega){
        try {
            servicioBodega.agregarBodega(bodega);
            return ResponseEntity.ok().body("Bodega creada exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar")
    public ResponseEntity<?> acualizarBodega(@RequestBody Bodega bodega){
        Bodega bodegaActualizar = null;
        try {
            bodegaActualizar = servicioBodega.obtenerBodega(bodega.getId());
            bodegaActualizar.setDireccion(bodega.getDireccion());
            bodegaActualizar.setNombre(bodega.getNombre());
            bodegaActualizar.setLat(bodega.getLat());
            bodegaActualizar.setLng(bodega.getLng());

            return ResponseEntity.ok().body("Bodega actualizada exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/bodega={id}")
    public ResponseEntity<?> eliminarBodega(@PathVariable("id") Long id){
        try {
            servicioBodega.eliminarBodega(id);
            return ResponseEntity.ok().body("Bodega eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al elimnar la bodega");
        }
    }
}
