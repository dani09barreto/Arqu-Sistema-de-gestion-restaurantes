package com.example.negociogeneral.ServiceLocator;

import com.example.IRemoteServiciosDatos.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final IResponseLB restClient;

    private final Map<String, IRemoteUsuarioService> cacheRemoteUsuarioService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteRoleService> cacheRemoteRoleService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteBodegaService> cacheRemoteBodegaService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteCantidadIngredienteService> cacheRemoteCantidadIngredienteService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteComentarioRestauranteService> cacheRemoteComentarioRestauranteService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteEstadoEnvioService> cacheRemoteEstadoEnvioService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteIngredientePlatoService> cacheRemoteIngredientePlatoService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteMenuService> cacheRemoteMenuService = new ConcurrentHashMap<>();
    private final Map<String, IRemotePlatoService> cacheRemotePlatoService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteIngredienteService> cacheRemoteIngredienteService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteInventarioService> cacheRemoteInventarioService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteRestauranteService> cacheRemoteRestauranteService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteEnvioInventarioService> cacheRemoteEnvioInventarioService = new ConcurrentHashMap<>();

    public ServiceLocator(@Qualifier("responseLB") IResponseLB restClient) {
        this.restClient = restClient;
    }

    @Override
    public IRemoteBodegaService getRemoteBodegaService() throws Exception {
        String uri = restClient.getResponse();
        if (cacheRemoteBodegaService.containsKey(uri)) {
            return cacheRemoteBodegaService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteBodegaService!com.example.IRemoteServiciosDatos.IRemoteBodegaService";
        IRemoteBodegaService remoteBodegaService = (IRemoteBodegaService) context.lookup(name);
        cacheRemoteBodegaService.put(uri, remoteBodegaService);
        return remoteBodegaService;
    }

    @Override
    public IRemoteCantidadIngredienteService getRemoteCantidadIngredienteService() throws IOException, NamingException {
        String uri = restClient.getResponse();
        if (cacheRemoteCantidadIngredienteService.containsKey(uri)) {
            return cacheRemoteCantidadIngredienteService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteCantidadIngredienteService!com.example.IRemoteServiciosDatos.IRemoteCantidadIngredienteService";
        IRemoteCantidadIngredienteService remoteCantidadIngredienteService = (IRemoteCantidadIngredienteService) context.lookup(name);
        cacheRemoteCantidadIngredienteService.put(uri, remoteCantidadIngredienteService);
        return remoteCantidadIngredienteService;
    }

    @Override
    public IRemoteComentarioRestauranteService getRemoteComentarioRestauranteService() throws IOException, NamingException {
        String uri = restClient.getResponse();
        if (cacheRemoteComentarioRestauranteService.containsKey(uri)) {
            return cacheRemoteComentarioRestauranteService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteComentarioRestauranteService!com.example.IRemoteServiciosDatos.IRemoteComentarioRestauranteService";
        IRemoteComentarioRestauranteService remoteComentarioRestauranteService = (IRemoteComentarioRestauranteService) context.lookup(name);
        cacheRemoteComentarioRestauranteService.put(uri, remoteComentarioRestauranteService);
        return remoteComentarioRestauranteService;
    }

    @Override
    public IRemoteEstadoEnvioService getRemoteEstadoEnvioService() throws IOException, NamingException {
        String uri = restClient.getResponse();
        if (cacheRemoteEstadoEnvioService.containsKey(uri)) {
            return cacheRemoteEstadoEnvioService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteEstadoEnvioService!com.example.IRemoteServiciosDatos.IRemoteEstadoEnvioService";
        IRemoteEstadoEnvioService remoteEstadoEnvioService = (IRemoteEstadoEnvioService) context.lookup(name);
        cacheRemoteEstadoEnvioService.put(uri, remoteEstadoEnvioService);
        return remoteEstadoEnvioService;
    }

    @Override
    public IRemoteIngredientePlatoService getRemoteIngredientePlatoService() throws NamingException, IOException {
        String uri = restClient.getResponse();
        if (cacheRemoteIngredientePlatoService.containsKey(uri)) {
            return cacheRemoteIngredientePlatoService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteIngredientePlatoService!com.example.IRemoteServiciosDatos.IRemoteIngredientePlatoService";
        IRemoteIngredientePlatoService remoteIngredientePlatoService = (IRemoteIngredientePlatoService) context.lookup(name);
        cacheRemoteIngredientePlatoService.put(uri, remoteIngredientePlatoService);
        return remoteIngredientePlatoService;
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

    @Override
    public IRemoteMenuService getRemoteMenuService() throws NamingException, IOException {
        String uri = restClient.getResponse();
        if (cacheRemoteMenuService.containsKey(uri)) {
            return cacheRemoteMenuService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteMenuService!com.example.IRemoteServiciosDatos.IRemoteMenuService";
        IRemoteMenuService remoteMenuService = (IRemoteMenuService) context.lookup(name);
        cacheRemoteMenuService.put(uri, remoteMenuService);
        return remoteMenuService;
    }

    @Override
    public IRemotePlatoService getRemotePlatoService() throws NamingException, IOException {
        String uri = restClient.getResponse();
        if (cacheRemotePlatoService.containsKey(uri)) {
            return cacheRemotePlatoService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemotePlatoService!com.example.IRemoteServiciosDatos.IRemotePlatoService";
        IRemotePlatoService remotePlatoService = (IRemotePlatoService) context.lookup(name);
        cacheRemotePlatoService.put(uri, remotePlatoService);
        return remotePlatoService;
    }

    @Override
    public IRemoteIngredienteService getRemoteIngredienteService() throws NamingException, IOException {
        String uri = restClient.getResponse();
        if (cacheRemoteIngredienteService.containsKey(uri)) {
            return cacheRemoteIngredienteService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteIngredienteService!com.example.IRemoteServiciosDatos.IRemoteIngredienteService";
        IRemoteIngredienteService remoteIngredienteService = (IRemoteIngredienteService) context.lookup(name);
        cacheRemoteIngredienteService.put(uri, remoteIngredienteService);
        return remoteIngredienteService;
    }

    @Override
    public IRemoteInventarioService getRemoteInventarioService() throws NamingException, IOException {
        String uri = restClient.getResponse();
        if (cacheRemoteInventarioService.containsKey(uri)) {
            return cacheRemoteInventarioService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteInventarioService!com.example.IRemoteServiciosDatos.IRemoteInventarioService";
        IRemoteInventarioService remoteInventarioService = (IRemoteInventarioService) context.lookup(name);
        cacheRemoteInventarioService.put(uri, remoteInventarioService);
        return remoteInventarioService;
    }

    @Override
    public IRemoteRestauranteService getRemoteRestauranteService() throws NamingException, IOException {
        String uri = restClient.getResponse();
        if (cacheRemoteRestauranteService.containsKey(uri)) {
            return cacheRemoteRestauranteService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteRestauranteService!com.example.IRemoteServiciosDatos.IRemoteRestauranteService";
        IRemoteRestauranteService remoteRestauranteService = (IRemoteRestauranteService) context.lookup(name);
        cacheRemoteRestauranteService.put(uri, remoteRestauranteService);
        return remoteRestauranteService;
    }

    @Override
    public IRemoteEnvioInventarioService getRemoteEnvioInventarioService() throws NamingException, IOException {
        String uri = restClient.getResponse();
        if (cacheRemoteEnvioInventarioService.containsKey(uri)) {
            return cacheRemoteEnvioInventarioService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteEnvioInventarioService!com.example.IRemoteServiciosDatos.IRemoteEnvioInventarioService";
        IRemoteEnvioInventarioService remoteEnvioInventarioService = (IRemoteEnvioInventarioService) context.lookup(name);
        cacheRemoteEnvioInventarioService.put(uri, remoteEnvioInventarioService);
        return remoteEnvioInventarioService;
    }
}
