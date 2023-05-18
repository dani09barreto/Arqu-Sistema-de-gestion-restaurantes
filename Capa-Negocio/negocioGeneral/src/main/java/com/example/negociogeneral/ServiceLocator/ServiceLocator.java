package com.example.negociogeneral.ServiceLocator;

import com.example.IRemoteServiciosDatos.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public IRemoteBodegaService getRemoteBodegaService() throws Exception {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        String uri = restClient.getResponse();
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteBodegaService!com.example.IRemoteServiciosDatos.IRemoteBodegaService";
        return (IRemoteBodegaService) context.lookup(name);
    }

    @Override
    public IRemoteCantidadIngredienteService getRemoteCantidadIngredienteService() {
        return null;
    }

    @Override
    public IRemoteComentarioRestauranteService getRemoteComentarioRestauranteService() {
        return null;
    }

    @Override
    public IRemoteEstadoEnvioService getRemoteEstadoEnvioService() {
        return null;
    }

    @Override
    public IRemoteIngredientePlatoService getRemoteIngredientePlatoService() throws NamingException, IOException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        String uri = restClient.getResponse();
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteIngredientePlatoService!com.example.IRemoteServiciosDatos.IRemoteIngredientePlatoService";
        return (IRemoteIngredientePlatoService) context.lookup(name);
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

    @Override
    public IRemoteMenuService getRemoteMenuService() throws NamingException, IOException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        String uri = restClient.getResponse();
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteMenuService!com.example.IRemoteServiciosDatos.IRemoteMenuService";
        return (IRemoteMenuService) context.lookup(name);
    }

    @Override
    public IRemotePlatoService getRemotePlatoService() throws NamingException, IOException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        String uri = restClient.getResponse();
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemotePlatoService!com.example.IRemoteServiciosDatos.IRemotePlatoService";
        return (IRemotePlatoService) context.lookup(name);
    }

    @Override
    public IRemoteIngredienteService getRemoteIngredienteService() throws NamingException, IOException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        String uri = restClient.getResponse();
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteIngredienteService!com.example.IRemoteServiciosDatos.IRemoteIngredienteService";
        return (IRemoteIngredienteService) context.lookup(name);
    }

    @Override
    public IRemoteInventarioService getRemoteInventarioService() throws NamingException, IOException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        String uri = restClient.getResponse();
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteInventarioService!com.example.IRemoteServiciosDatos.IRemoteInventarioService";
        return (IRemoteInventarioService) context.lookup(name);
    }

    @Override
    public IRemoteRestauranteService getRemoteRestauranteService() throws NamingException, IOException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        String uri = restClient.getResponse();
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteRestauranteService!com.example.IRemoteServiciosDatos.IRemoteRestauranteService";
        return (IRemoteRestauranteService) context.lookup(name);
    }
}
