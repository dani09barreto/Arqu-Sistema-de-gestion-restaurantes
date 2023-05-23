package com.example.negociogeneral.ServiceLocator;

import com.example.IRemoteServiciosDatos.*;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;

@Service
public interface IServiceLocator {
    IRemoteBodegaService getRemoteBodegaService() throws Exception;
    IRemoteCantidadIngredienteService getRemoteCantidadIngredienteService() throws IOException, NamingException;
    IRemoteComentarioRestauranteService getRemoteComentarioRestauranteService() throws IOException, NamingException;
    IRemoteEstadoEnvioService getRemoteEstadoEnvioService() throws IOException, NamingException;
    IRemoteIngredientePlatoService getRemoteIngredientePlatoService() throws NamingException, IOException;
    IRemoteUsuarioService getRemoteUsuarioService() throws NamingException, IOException;
    IRemoteRoleService getRemoteRoleService() throws NamingException, IOException;
    IRemoteMenuService getRemoteMenuService() throws NamingException, IOException;
    IRemotePlatoService getRemotePlatoService() throws NamingException, IOException;
    IRemoteIngredienteService getRemoteIngredienteService() throws NamingException, IOException;
    IRemoteInventarioService getRemoteInventarioService() throws NamingException, IOException;
    IRemoteRestauranteService getRemoteRestauranteService() throws NamingException, IOException;
    IRemoteEnvioInventarioService getRemoteEnvioInventarioService() throws NamingException, IOException;
}
