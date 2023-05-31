package com.example.negociorestaurante.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerReserva {
/*
    @Autowired
    @Qualifier("serviceReserva")
    IServiceReserva serviceReserva;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listAll")
    public ResponseEntity<?> listarReservas() {
        try {
            return ResponseEntity.ok().body(serviceReserva.obtenerTodasReservas());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

*/
}
