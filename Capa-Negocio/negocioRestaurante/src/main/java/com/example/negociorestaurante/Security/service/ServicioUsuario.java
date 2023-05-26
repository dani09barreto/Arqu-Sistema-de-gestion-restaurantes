package com.example.negociorestaurante.Security.service;


import com.example.entidades.RolUsuario;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class ServicioUsuario implements UserDetailsService{

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

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
