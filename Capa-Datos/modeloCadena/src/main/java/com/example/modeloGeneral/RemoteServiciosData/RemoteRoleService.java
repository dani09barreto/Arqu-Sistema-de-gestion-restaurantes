package com.example.modeloGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteRoleService;
import com.example.modeloGeneral.GestionDatos.intf.IRolService;
import com.example.entidades.Rol;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteRoleService implements IRemoteRoleService {

    @EJB
    IRolService rolService;

    @Override
    public void agregarRol(Rol rol) {
        rolService.agregarRol(rol);
    }

    @Override
    public void actualizarRol(Rol rol) {
        rolService.actualizarRol(rol);
    }

    @Override
    public void eliminarRol(Long id) {
        rolService.eliminarRol(id);
    }

    @Override
    public Rol obtenerRol(Long id) {
        return rolService.obtenerRol(id);
    }

    @Override
    public Rol obtenerRolPorNombre(String nombre) {
        return rolService.obtenerRolPorNombre(nombre);
    }

    @Override
    public List<Rol> obtenerTodosRoles() {
        return rolService.obtenerTodosRoles();
    }
}
