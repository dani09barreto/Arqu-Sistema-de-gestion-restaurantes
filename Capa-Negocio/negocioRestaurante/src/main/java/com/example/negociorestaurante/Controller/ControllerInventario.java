package com.example.negociorestaurante.Controller;

<<<<<<< HEAD
import com.example.entidades.InventarioR;
=======

import com.example.modeloRestaurante.entidades.Inventario;
>>>>>>> develop
import com.example.negociorestaurante.Services.intf.IServiceInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
=======
import org.springframework.security.access.prepost.PreAuthorize;
>>>>>>> develop
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/restaurante/inventario")
public class ControllerInventario {
    @Autowired
    @Qualifier("serviceInventario")
    IServiceInventario serviceInventario;
<<<<<<< HEAD
    @GetMapping("/listAll")
    public ResponseEntity<List<InventarioR>> listarInventario() {
        List<InventarioR> inventarios = null;
=======

    @PreAuthorize("hasRole('ADMINRESTAURANTE')")
    @GetMapping("/listAll")
    public ResponseEntity<List<Inventario>> listarInventario() {
>>>>>>> develop
        try {
            return ResponseEntity.ok().body(serviceInventario.obtenerTodosInventarios());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/agregar")
<<<<<<< HEAD
    public ResponseEntity<?> agregarInventario(@RequestBody InventarioR inventario) throws Exception {
=======
    public ResponseEntity<?> agregarInventario(@RequestBody Inventario inventario) throws Exception {
>>>>>>> develop
        try {
            serviceInventario.agregarInventario(inventario);
            return ResponseEntity.ok().body("Inventario agregado");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al agregar el inventario");
        }
    }
    @PostMapping("/actualizar")
<<<<<<< HEAD
    public ResponseEntity<?> actualizarInventario(@RequestBody InventarioR inventario) throws Exception {
=======
    public ResponseEntity<?> actualizarInventario(@RequestBody Inventario inventario) throws Exception {
>>>>>>> develop
        try {
            serviceInventario.actualizarInventario(inventario);
            return ResponseEntity.ok().body("Inventario actualizado");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al actualizar el inventario");
        }
    }

}
