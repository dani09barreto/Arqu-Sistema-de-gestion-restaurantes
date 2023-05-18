package com.example.negociogeneral.Controller;

import com.example.entidades.Usuario;
import com.example.negociogeneral.Payload.Request.UsuarioUpdate;
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

    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'WORKER')")
    @GetMapping("/usuario={username}")
    public ResponseEntity <?> obtenerUsuario(@PathVariable String username){
        try {
            return ResponseEntity.ok().body(servicioUsuario.obtenerUsuario(username));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener usuario");
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'WORKER')")
    @GetMapping("/usuario={username}/roles")
    public ResponseEntity <?> obtenerUsuarioRoles(@PathVariable String username){
        try {
            return ResponseEntity.ok().body(servicioUsuario.obtenerUsuarioRoles(username));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener usuario");
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'WORKER')")
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioUpdate usuario){
        try {
            Usuario us = servicioUsuario.obtenerUsuario(usuario.getUsuario());
            us.setNombre(usuario.getNombre());
            us.setCorreo(usuario.getCorreo());
            us.setTelefono(usuario.getTelefono());
            return ResponseEntity.ok().body(servicioUsuario.actualizarUsuario(us));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar usuario");
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'WORKER')")
    @DeleteMapping("/eliminar={username}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable String username){
        try {
            servicioUsuario.EliminarUsuario(username);
            return ResponseEntity.ok().body("Usuario eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar usuario");
        }
    }
}
