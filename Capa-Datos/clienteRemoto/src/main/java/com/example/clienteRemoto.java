package com.example;

import com.example.entidades.Rol;
import com.example.entidades.Usuario;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

public class clienteRemoto {
    public static void main(String[] args) {
        IServiceLocator serviceLocator = new ServiceLocator();
        try {
            serviceLocator.getRemoteBodegaService().obtenerTodasBodegas().forEach(bodega -> {
                System.out.println(bodega.getNombre());
            });
/*            serviceLocator.getRemoteIngredientePlatoService().obtenerIngredientesPlato(29L).forEach(ingredientePlato -> {
                System.out.println(ingredientePlato.getPlato().getNombre());
                System.out.println(ingredientePlato.getIngrediente().getNombre());
                System.out.println(ingredientePlato.getIngrediente().getTipoIngrediente().getNombre());
                System.out.println(ingredientePlato.getCantidad());
            });
            List<Rol> roles = serviceLocator.getRemoteRoleService().obtenerTodosRoles();
            roles.forEach(rol -> {
                System.out.println(rol.getId());
                System.out.println(rol.getNombre());
            });
*//*            Set<Rol> rolesUsuario = new HashSet<>();
            rolesUsuario.add(serviceLocator.getRemoteRoleService().obtenerRolPorNombre("ADMIN"));
            Usuario usuario = Usuario.builder()
                    .correo("danielf.barreto@outlook.com")
                    .telefono(3118046921.0)
                    .usuario("danib")
                    .password("123456")
                    .nombre("Daniel Felipe")
                    .roles(rolesUsuario)
                    .build();
            serviceLocator.getRemoteUsuarioService().agregarUsuario(usuario);*//*
            System.out.println(serviceLocator.getRemoteUsuarioService().obtenerUsuarioPorNombreUsuario("danib").getUsuario());
            serviceLocator.getRemoteUsuarioService().obtenerRolUsuarioPorNombreUsuario("danib").forEach(rolUsuario -> {
                System.out.println(rolUsuario.getRol().getNombre());
            });

            Usuario us = Usuario.builder()
                    .correo("natamesa@hola.com")
                    .telefono(3214585691.0)
                    .usuario("natamesa")
                    .password("123456")
                    .nombre("Natalia Mesa")
                    .build();

            List<Rol> rolesUs = new ArrayList<>();
            rolesUs.add(serviceLocator.getRemoteRoleService().obtenerRolPorNombre("WORKER"));
            serviceLocator.getRemoteUsuarioService().agregarUsuario(us, rolesUs);*/


        } catch (NamingException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
