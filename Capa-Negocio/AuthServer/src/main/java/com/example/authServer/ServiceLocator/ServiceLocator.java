package com.example.authServer.ServiceLocator;

import com.example.IRemoteServiciosDatos.IRemoteRoleService;
import com.example.IRemoteServiciosDatos.IRemoteUsuarioService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ServiceLocator implements IServiceLocator {
    private static IResponseLB restClient;
    private final Map<String, IRemoteUsuarioService> cacheRemoteUsuarioService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteRoleService> cacheRemoteRolService = new ConcurrentHashMap<>();

    public ServiceLocator(@Qualifier("responseLB") IResponseLB restClient) {
        this.restClient = restClient;
    }

    @Override
    public IRemoteUsuarioService getRemoteUsuarioService() throws NamingException, IOException {
        String uri = restClient.getResponse();
        IRemoteUsuarioService rm = cacheRemoteUsuarioService.get(uri);
        if (rm != null){
            return rm;
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteUsuarioService!com.example.IRemoteServiciosDatos.IRemoteUsuarioService";
        rm = (IRemoteUsuarioService) context.lookup(name);
        cacheRemoteUsuarioService.put(uri, rm);
        return rm;
    }

    @Override
    public IRemoteRoleService getRemoteRoleService() throws NamingException, IOException {
        String uri = restClient.getResponse();
        IRemoteRoleService rm = cacheRemoteRolService.get(uri);
        if (rm != null){
            return rm;
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteRoleService!com.example.IRemoteServiciosDatos.IRemoteRoleService";
        rm = (IRemoteRoleService) context.lookup(name);
        cacheRemoteRolService.put(uri, rm);
        return rm;
    }
}
