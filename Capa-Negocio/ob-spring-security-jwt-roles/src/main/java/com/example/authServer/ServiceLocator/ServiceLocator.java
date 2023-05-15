package com.example.obspringsecurityjwtroles.ServiceLocator;

import com.example.IRemoteServiciosDatos.IRemoteRoleService;
import com.example.IRemoteServiciosDatos.IRemoteUsuarioService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

@Service
public class ServiceLocator implements IServiceLocator {
    private final IResponseLB restClient;

    public ServiceLocator(@Qualifier("responseLB") IResponseLB restClient) {
        this.restClient = restClient;
    }

    @Override
    public IRemoteUsuarioService getRemoteUsuarioService() throws NamingException, IOException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        String uri = restClient.getResponse();
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteUsuarioService!com.example.IRemoteServiciosDatos.IRemoteUsuarioService";
        return (IRemoteUsuarioService) context.lookup(name);
    }

    @Override
    public IRemoteRoleService getRemoteRoleService() throws NamingException, IOException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        String uri = restClient.getResponse();
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteRoleService!com.example.IRemoteServiciosDatos.IRemoteRoleService";
        return (IRemoteRoleService) context.lookup(name);
    }
}
