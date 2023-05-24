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
    private final Map<String, IRemoteRoleService> cacheRemoteRoleService = new ConcurrentHashMap<>();

    public ServiceLocator(@Qualifier("responseLB") IResponseLB restClient) {
        this.restClient = restClient;
    }

    @Override
    public IRemoteUsuarioService getRemoteUsuarioService() throws NamingException, IOException {
        String uri = restClient.getResponse();
        if (cacheRemoteUsuarioService.containsKey(uri)) {
            return cacheRemoteUsuarioService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteUsuarioService!com.example.IRemoteServiciosDatos.IRemoteUsuarioService";
        IRemoteUsuarioService remoteUsuarioService = (IRemoteUsuarioService) context.lookup(name);
        cacheRemoteUsuarioService.put(uri, remoteUsuarioService);
        return remoteUsuarioService;
    }

    @Override
    public IRemoteRoleService getRemoteRoleService() throws NamingException, IOException {
        String uri = restClient.getResponse();
        if (cacheRemoteRoleService.containsKey(uri)) {
            return cacheRemoteRoleService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteRoleService!com.example.IRemoteServiciosDatos.IRemoteRoleService";
        IRemoteRoleService remoteRoleService = (IRemoteRoleService) context.lookup(name);
        cacheRemoteRoleService.put(uri, remoteRoleService);
        return remoteRoleService;
    }
}
