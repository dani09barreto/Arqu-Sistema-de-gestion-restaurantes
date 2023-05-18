package com.example.negociogeneral.ServiceLocator;

import com.example.IRemoteServiciosDatos.*;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;

@Service
public interface IServiceLocator {
    IRemoteBodegaService getRemoteBodegaService() throws Exception;
    IRemoteCantidadIngredienteService getRemoteCantidadIngredienteService();
    IRemoteComentarioRestauranteService getRemoteComentarioRestauranteService();
    IRemoteEstadoEnvioService getRemoteEstadoEnvioService();
    IRemoteIngredientePlatoService getRemoteIngredientePlatoService() throws NamingException, IOException;
    IRemoteUsuarioService getRemoteUsuarioService() throws NamingException, IOException;
    IRemoteRoleService getRemoteRoleService() throws NamingException, IOException;
    IRemoteMenuService getRemoteMenuService() throws NamingException, IOException;
    IRemotePlatoService getRemotePlatoService() throws NamingException, IOException;

}
