package com.example.negociorestaurante.Controller;

import com.example.entidades.InventarioR;
import com.example.negociorestaurante.Services.intf.IServiceInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/restaurante/inventario")
public class ControllerInventario {
    @Autowired
    @Qualifier("serviceInventario")
    IServiceInventario serviceInventario;
    @GetMapping("/listAll")
    public ResponseEntity<List<InventarioR>> listarInventario() {
        List<InventarioR> inventarios = null;
        try {
            return ResponseEntity.ok().body(serviceInventario.obtenerTodosInventarios());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
