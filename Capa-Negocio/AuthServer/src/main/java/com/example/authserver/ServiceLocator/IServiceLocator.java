package com.example.authServer.ServiceLocator;

import com.example.IRemoteServiciosDatos.IRemoteRoleService;
import com.example.IRemoteServiciosDatos.IRemoteUsuarioService;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;

@Service
public interface IServiceLocator {
    IRemoteUsuarioService getRemoteUsuarioService() throws NamingException, IOException;
    IRemoteRoleService getRemoteRoleService() throws NamingException, IOException;
}
