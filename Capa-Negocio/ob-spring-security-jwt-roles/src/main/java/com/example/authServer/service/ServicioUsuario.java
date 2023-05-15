package com.example.obspringsecurityjwtroles.service;

import com.example.entidades.Rol;
import com.example.entidades.RolUsuario;
import com.example.entidades.Usuario;
import com.example.obspringsecurityjwtroles.ServiceLocator.IServiceLocator;
import com.example.obspringsecurityjwtroles.exception.EmailAlreadyExistsException;
import com.example.obspringsecurityjwtroles.payload.request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class ServicioUsuario implements UserDetailsService, IServicioUsuario {

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public void agregarUsuario(UsuarioRequest usuario) throws NamingException, IOException {
        if (serviceLocator.getRemoteUsuarioService().obtenerUsuarioPorNombreUsuario(usuario.getUsuario()) != null) {
            throw new EmailAlreadyExistsException("Email ocupado");
        }
        Usuario us = Usuario.builder()
                .nombre(usuario.getNombre())
                .correo(usuario.getCorreo())
                .telefono(usuario.getTelefono())
                .password(bcryptEncoder.encode(usuario.getPassword()))
                .usuario(usuario.getUsuario()).build();
        List<Rol> roles = new ArrayList<>();
        Rol rolUser = serviceLocator.getRemoteRoleService().obtenerRolPorNombre(usuario.getRol());
        roles.add(rolUser);
        serviceLocator.getRemoteUsuarioService().agregarUsuario(us, roles);
    }

    private Set<SimpleGrantedAuthority> getAuthority(List<RolUsuario> rolesUsuario){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        rolesUsuario.forEach(rolUsuario -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rolUsuario.getRol().getNombre()));
        });
        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            List <RolUsuario> rolesUsuario = serviceLocator.getRemoteUsuarioService().obtenerRolUsuarioPorNombreUsuario(s);
            if (rolesUsuario == null) {
                throw new UsernameNotFoundException("Invalid username or password.");
            }
            return new org.springframework.security.core.userdetails.User(rolesUsuario.get(0).getUsuario().getUsuario(), rolesUsuario.get(0).getUsuario().getPassword(), getAuthority(rolesUsuario));

        } catch (NamingException | IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
