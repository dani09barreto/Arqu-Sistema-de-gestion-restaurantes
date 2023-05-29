package com.example.negociorestaurante.ServiceLocator;

import com.example.IRemoteServiciosDatos.*;
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
    private final IResponseLB restClientRest;
    private final IResponseLB restClientGeneral;
    private final Map<String, IRemoteUsuarioService> cacheRemoteUsuarioService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteAdicionalesService> cacheRemoteAdicionalesService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteClienteService> cacheRemoteClienteService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteDescuentoFidelidadService> cacheRemoteDescuentoFidelidadService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteEstadoPedidoService> cacheRemoteEstadoPedidoService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteIngredienteService> cacheRemoteIngredienteService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteInventarioRService> cacheRemoteInventarioService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteMesaService> cacheRemoteMesaService = new ConcurrentHashMap<>();
    private final Map<String, IRemotePagoService> cacheRemotePagoService = new ConcurrentHashMap<>();
    private final Map<String, IRemotePedidoService> cacheRemotePedidoService = new ConcurrentHashMap<>();
    private final Map<String, IRemotePlatoPedidoService> cacheRemotePlatoPedidoService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteRegistroPagoService> cacheRemoteRegistroPagoService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteTipoIngredienteService> cacheRemoteTipoIngredienteService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteTipoPagoService> cacheRemoteTipoPagoService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteIngredientePlatoService> cacheRemoteIngredientePlatoService = new ConcurrentHashMap<>();
    private final Map<String, IRemoteRoleService> cacheRemoteRoleService = new ConcurrentHashMap<>();

    public ServiceLocator(@Qualifier("responseLBRest") IResponseLB restClientRest, @Qualifier("responseLBGeneral") IResponseLB restClientGeneral) {
        this.restClientRest = restClientRest;
        this.restClientGeneral = restClientGeneral;
    }



    @Override
    public IRemoteAdicionalesService getRemoteAdicionalesService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemoteAdicionalesService.containsKey(uri)){
            return cacheRemoteAdicionalesService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemoteAdicionalesService!com.example.IRemoteServiciosDatos.IRemoteAdicionalesService";
         IRemoteAdicionalesService iRemoteAdicionalesService = (IRemoteAdicionalesService) context.lookup(name);
         cacheRemoteAdicionalesService.put(uri,iRemoteAdicionalesService);
         return iRemoteAdicionalesService;
    }

    @Override
    public IRemoteClienteService getRemoteClienteService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemoteClienteService.containsKey(uri)){
            return cacheRemoteClienteService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemoteClienteService!com.example.IRemoteServiciosDatos.IRemoteClienteService";
        IRemoteClienteService remoteClienteService =  (IRemoteClienteService) context.lookup(name);
        cacheRemoteClienteService.put(uri,remoteClienteService);
        return remoteClienteService;
    }

    @Override
    public IRemoteDescuentoFidelidadService getRemoteDescuentoFidelidadService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemoteDescuentoFidelidadService.containsKey(uri)){
            return cacheRemoteDescuentoFidelidadService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemoteDescuentoFidelidadService!com.example.IRemoteServiciosDatos.IRemoteDescuentoFidelidadService";
        IRemoteDescuentoFidelidadService remoteDescuentoFidelidadService = (IRemoteDescuentoFidelidadService) context.lookup(name);
        cacheRemoteDescuentoFidelidadService.put(uri,remoteDescuentoFidelidadService);
        return remoteDescuentoFidelidadService;
    }

    @Override
    public IRemoteEstadoPedidoService getRemoteEstadoPedidoService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemoteEstadoPedidoService.containsKey(uri)){
            return cacheRemoteEstadoPedidoService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemoteEstadoPedidoService!com.example.IRemoteServiciosDatos.IRemoteEstadoPedidoService";
        IRemoteEstadoPedidoService remoteEstadoPedidoService = (IRemoteEstadoPedidoService) context.lookup(name);
        cacheRemoteEstadoPedidoService.put(uri,remoteEstadoPedidoService);
        return remoteEstadoPedidoService;
    }

    @Override
    public IRemoteIngredienteService getRemoteIngredienteService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemoteIngredienteService.containsKey(uri)){
            return cacheRemoteIngredienteService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemoteIngredienteService!com.example.IRemoteServiciosDatos.IRemoteIngredienteService";
        IRemoteIngredienteService remoteIngredienteService = (IRemoteIngredienteService) context.lookup(name);
        cacheRemoteIngredienteService.put(uri,remoteIngredienteService);
        return remoteIngredienteService;
    }

    @Override
    public IRemoteInventarioRService getRemoteInventarioService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemoteInventarioService.containsKey(uri)){
            return cacheRemoteInventarioService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemoteInventarioService!com.example.IRemoteServiciosDatos.IRemoteInventarioRService";
        IRemoteInventarioRService remoteInventarioService = (IRemoteInventarioRService) context.lookup(name);
        cacheRemoteInventarioService.put(uri,remoteInventarioService);
        return remoteInventarioService;
    }

    @Override
    public IRemoteMesaService getRemoteMesaService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemoteMesaService.containsKey(uri)){
            return cacheRemoteMesaService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemoteMesaService!com.example.IRemoteServiciosDatos.IRemoteMesaService";
        IRemoteMesaService remoteMesaService=  (IRemoteMesaService) context.lookup(name);
        cacheRemoteMesaService.put(uri,remoteMesaService);
        return remoteMesaService;
    }

    @Override
    public IRemotePagoService getRemotePagoService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemotePagoService.containsKey(uri)){
            return cacheRemotePagoService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemotePagoService!com.example.IRemoteServiciosDatos.IRemotePagoService";
        IRemotePagoService remotePagoService =  (IRemotePagoService) context.lookup(name);
        cacheRemotePagoService.put(uri,remotePagoService);
        return remotePagoService;
    }

    @Override
    public IRemotePedidoService getRemotePedidoService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemotePedidoService.containsKey(uri)){
            return cacheRemotePedidoService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemotePedidoService!com.example.IRemoteServiciosDatos.IRemotePedidoService";
        IRemotePedidoService remotePedidoService = (IRemotePedidoService) context.lookup(name);
        cacheRemotePedidoService.put(uri,remotePedidoService);
        return remotePedidoService;
    }

    @Override
    public IRemotePlatoPedidoService getRemotePlatoPedidoService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemotePlatoPedidoService.containsKey(uri)){
            return cacheRemotePlatoPedidoService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemotePlatoPedidoService!com.example.IRemoteServiciosDatos.IRemotePlatoPedidoService";
        IRemotePlatoPedidoService remotePlatoPedidoService =  (IRemotePlatoPedidoService) context.lookup(name);
        cacheRemotePlatoPedidoService.put(uri,remotePlatoPedidoService);
        return remotePlatoPedidoService;
    }

    @Override
    public IRemoteRegistroPagoService getRemoteRegistroPagoService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemoteRegistroPagoService.containsKey(uri)){
            return cacheRemoteRegistroPagoService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemoteRegistroPagoService!com.example.IRemoteServiciosDatos.IRemoteRegistroPagoService";
        IRemoteRegistroPagoService registroPagoService = (IRemoteRegistroPagoService) context.lookup(name);
        cacheRemoteRegistroPagoService.put(uri,registroPagoService);
        return registroPagoService;

    }

    @Override
    public IRemoteTipoIngredienteService getRemoteTipoIngredienteService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemoteTipoIngredienteService.containsKey(uri)){
            return cacheRemoteTipoIngredienteService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemoteTipoIngredienteService!com.example.IRemoteServiciosDatos.IRemoteTipoIngredienteService";
        IRemoteTipoIngredienteService remoteTipoIngredienteService= (IRemoteTipoIngredienteService) context.lookup(name);
        cacheRemoteTipoIngredienteService.put(uri,remoteTipoIngredienteService);
        return remoteTipoIngredienteService;
    }

    @Override
    public IRemoteTipoPagoService getRemoteTipoPagoService() throws Exception {
        String uri = restClientRest.getResponse();
        if(cacheRemoteTipoPagoService.containsKey(uri)){
            return cacheRemoteTipoPagoService.get(uri);
        }
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, String.format("http-remoting://%s", uri));
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(jndiProperties);
        String name = "ejb:/modeloRestaurante/RemoteTipoPagoService!com.example.IRemoteServiciosDatos.IRemoteTipoPagoService";
        IRemoteTipoPagoService remoteTipoPagoService = (IRemoteTipoPagoService) context.lookup(name);
        cacheRemoteTipoPagoService.put(uri,remoteTipoPagoService);
        return remoteTipoPagoService;
    }
 //Servicio remoto de usuario
    @Override
    public IRemoteUsuarioService getRemoteUsuarioService() throws NamingException, IOException {
        String uri = restClientGeneral.getResponse();
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
        String uri = restClientGeneral.getResponse();
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
    public IRemoteIngredientePlatoService getRemoteIngredientePlatoService() throws NamingException, IOException {
        String uri = restClientGeneral.getResponse();
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


}
