package com.example.negociogeneral.Controller;

import com.example.entidades.Usuario;
import com.example.negociogeneral.Payload.Request.UsuarioUpdate;
import com.example.negociogeneral.ServiceLocator.IResponseLB;
import com.example.negociogeneral.Services.intf.IServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/general/usuarios")
public class ControllerUsuario {

    @Autowired
    @Qualifier("servicioUsuario")
    IServicioUsuario servicioUsuario;

    @Autowired
    @Qualifier("responseLB")
    IResponseLB restClient;

    @GetMapping("/usuario={username}")
    public ResponseEntity <?> obtenerUsuario(@PathVariable String username){
        try {
            String uri = restClient.getResponse();
            return ResponseEntity.ok().body(servicioUsuario.obtenerUsuario(username, uri));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener usuario");
        }
    }

    @GetMapping("/usuario={username}/roles")
    public ResponseEntity <?> obtenerUsuarioRoles(@PathVariable String username){
        try {
            String uri = restClient.getResponse();
            return ResponseEntity.ok().body(servicioUsuario.obtenerUsuarioRoles(username, uri));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener usuario");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioUpdate usuario){
        try {
            String uri = restClient.getResponse();
            Usuario us = servicioUsuario.obtenerUsuario(usuario.getUsuario(), uri);
            us.setNombre(usuario.getNombre());
            us.setCorreo(usuario.getCorreo());
            us.setTelefono(usuario.getTelefono());
            return ResponseEntity.ok().body(servicioUsuario.actualizarUsuario(us, uri));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar usuario");
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'WORKER')")
    @DeleteMapping("/eliminar={username}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable String username){
        try {
            String uri = restClient.getResponse();
            servicioUsuario.EliminarUsuario(username, uri);
            return ResponseEntity.ok().body("Usuario eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar usuario");
        }
    }
}
