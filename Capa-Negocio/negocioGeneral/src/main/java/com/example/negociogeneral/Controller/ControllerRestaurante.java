package com.example.negociogeneral.Controller;

import com.example.entidades.Restaurante;
import com.example.negociogeneral.Services.intf.IServicioRestaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/general/restaurantes")
@Controller
public class ControllerRestaurante {

    @Autowired
    @Qualifier("servicioRestaurante")
    IServicioRestaurante servicioRestaurante;
    @GetMapping("/listar/nombres")
    public ResponseEntity <?> listarRestaurantes(){
        try {
            List < Restaurante> restaurantes = servicioRestaurante.obtenerTodosRestaurantes();
            List<String> nombresRestaurantes = new ArrayList<>();
            for (Restaurante restaurante: restaurantes) {
                nombresRestaurantes.add(restaurante.getNombre());
            }
            return ResponseEntity.ok(nombresRestaurantes);
        } catch (NamingException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al obtener restaurantes");
        }
    }
}
