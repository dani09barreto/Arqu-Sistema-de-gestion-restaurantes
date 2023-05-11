package com.example;

import com.example.IRemoteServiciosDatos.*;

import javax.naming.NamingException;

public interface IServiceLocator {
    IRemoteBodegaService getRemoteBodegaService() throws NamingException;
    IRemoteCantidadIngredienteService getRemoteCantidadIngredienteService();
    IRemoteComentarioRestauranteService getRemoteComentarioRestauranteService();
    IRemoteEstadoEnvioService getRemoteEstadoEnvioService();
    IRemoteIngredientePlatoService getRemoteIngredientePlatoService() throws NamingException;
    IRemoteUsuarioService getRemoteUsuarioService() throws NamingException;
    IRemoteRoleService getRemoteRoleService() throws NamingException;

}
