package com.example.negociorestaurante.ServiceLocator;

import com.example.IRemoteServiciosDatos.*;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.rmi.server.ExportException;

@Service
public interface IServiceLocator {
    IRemoteAdicionalesService getRemoteAdicionalesService() throws Exception;
    IRemoteClienteService getRemoteClienteService() throws Exception;
    IRemoteDescuentoFidelidadService getRemoteDescuentoFidelidadService() throws Exception;
    IRemoteEstadoPedidoService getRemoteEstadoPedidoService() throws Exception;
    IRemoteIngredienteService getRemoteIngredienteService() throws Exception;
    IRemoteInventarioRService getRemoteInventarioService() throws Exception;
    IRemoteMesaService getRemoteMesaService() throws Exception;
    IRemotePagoService getRemotePagoService() throws Exception;
    IRemotePedidoService getRemotePedidoService() throws Exception;
    IRemotePlatoPedidoService getRemotePlatoPedidoService() throws Exception;
    IRemoteRegistroPagoService getRemoteRegistroPagoService() throws Exception;
    IRemoteTipoIngredienteService getRemoteTipoIngredienteService() throws Exception;
    IRemoteTipoPagoService getRemoteTipoPagoService()throws Exception;
    IRemoteUsuarioService getRemoteUsuarioService() throws NamingException, IOException;
    IRemotePlatoService getRemotePlatoService() throws Exception;

}
