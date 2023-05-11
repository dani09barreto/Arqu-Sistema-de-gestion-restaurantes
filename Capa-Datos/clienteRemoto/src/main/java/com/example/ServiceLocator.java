package com.example;

import com.example.IRemoteServiciosDatos.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class ServiceLocator implements IServiceLocator{
    @Override
    public IRemoteBodegaService getRemoteBodegaService() throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8180");
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
    public IRemoteIngredientePlatoService getRemoteIngredientePlatoService() throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8180");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloCadena/RemoteIngredientePlatoService!com.example.IRemoteServiciosDatos.IRemoteIngredientePlatoService";
        return (IRemoteIngredientePlatoService) context.lookup(name);
    }
}
