package com.example.authServer.controller;

import com.example.authServer.config.TokenProvider;
import com.example.authServer.payload.request.LoginUser;
import com.example.authServer.payload.request.UsuarioRequest;
import com.example.authServer.payload.response.AuthToken;
import com.example.authServer.service.IServicioUsuario;
import com.example.authServer.utils.UserErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserController {

    private AuthenticationManager authenticationManager;
    private TokenProvider jwtTokenUtil;
    private IServicioUsuario userService;

    public UserController(AuthenticationManager authenticationManager, TokenProvider jwtTokenUtil, IServicioUsuario userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @PostMapping("/singUp")
    public ResponseEntity<?> saveUser(@RequestBody UsuarioRequest user){
        try {
            if (!userService.agregarUsuario(user)){
                throw new UserErrorException("Error al añadir usuario");
            }
            return ResponseEntity.ok("Usuario añadido correctamente");
        } catch (NamingException | IOException | UserErrorException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error al añadir usuario");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello-admin")
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/hello-user")
    public String userPing(){
        return "Any User Can Read This";
    }

}
