package com.example.negociogeneral.ServiceLocator;

import com.example.IRemoteServiciosDatos.*;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;

@Service
public interface IServiceLocator {
    IRemoteBodegaService getRemoteBodegaService(String uri) throws Exception;
    IRemoteCantidadIngredienteService getRemoteCantidadIngredienteService(String uri) throws IOException, NamingException;
    IRemoteComentarioRestauranteService getRemoteComentarioRestauranteService(String uri) throws IOException, NamingException;
    IRemoteEstadoEnvioService getRemoteEstadoEnvioService(String uri) throws IOException, NamingException;
    IRemoteIngredientePlatoService getRemoteIngredientePlatoService(String uri) throws NamingException, IOException;
    IRemoteUsuarioService getRemoteUsuarioService(String uri) throws NamingException, IOException;
    IRemoteRoleService getRemoteRoleService(String uri) throws NamingException, IOException;
    IRemoteMenuService getRemoteMenuService(String uri) throws NamingException, IOException;
    IRemotePlatoService getRemotePlatoService(String uri) throws NamingException, IOException;
    IRemoteIngredienteService getRemoteIngredienteService(String uri) throws NamingException, IOException;
    IRemoteInventarioService getRemoteInventarioService(String uri) throws NamingException, IOException;
    IRemoteRestauranteService getRemoteRestauranteService(String uri) throws NamingException, IOException;
    IRemoteEnvioInventarioService getRemoteEnvioInventarioService(String uri) throws NamingException, IOException;
}
