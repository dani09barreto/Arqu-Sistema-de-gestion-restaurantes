package com.example.negociogeneral.Security.service;


import com.example.entidades.RolUsuario;
import com.example.negociogeneral.ServiceLocator.IResponseLB;
import com.example.negociogeneral.ServiceLocator.IServiceLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class ServicioUsuario implements UserDetailsService{

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;
    @Autowired
    @Qualifier("responseLB")
    IResponseLB restClient;

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
            String uri = restClient.getResponse();
            List <RolUsuario> rolesUsuario = serviceLocator.getRemoteUsuarioService(uri).obtenerRolUsuarioPorNombreUsuario(s);
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
