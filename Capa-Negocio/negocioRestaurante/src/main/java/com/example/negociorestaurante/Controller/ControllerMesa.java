package com.example.negociorestaurante.Controller;

import com.example.negociorestaurante.Services.intf.IServiceMesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/restaurante/mesa")
public class ControllerMesa {
    @Autowired
    @Qualifier("serviceMesa")
    IServiceMesa serviceMesa;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listAll")
    public ResponseEntity<?> listarMesas() {
        try {
            return ResponseEntity.ok().body(serviceMesa.obtenerTodasMesas());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
