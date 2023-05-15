package com.example.negociogeneral.Controller;

import com.example.entidades.Bodega;
import com.example.negociogeneral.ServiceLocator.IServiceLocator;
import com.example.negociogeneral.Services.intf.IServicioBodega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/general/bodegas")
public class ControllerBodega {

    @Qualifier("servicioBodega")
    @Autowired
    IServicioBodega servicioBodega;

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

    @PostMapping
    public ResponseEntity<?> crearBodega(Bodega bodega){
        try {
            servicioBodega.agregarBodega(bodega);
            return ResponseEntity.ok().body("Bodega creada exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
