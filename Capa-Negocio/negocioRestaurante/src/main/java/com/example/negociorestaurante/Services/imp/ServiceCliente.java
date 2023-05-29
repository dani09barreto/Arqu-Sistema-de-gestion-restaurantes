package com.example.negociorestaurante.Services.imp;

import com.example.entidades.Cliente;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceCliente implements IServiceCliente {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;
    @Override
    public void agregarCliente(Cliente cliente) throws Exception {
        serviceLocator.getRemoteClienteService().agregarCliente(cliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {

    }

    @Override
    public void eliminarCliente(Long id) {

    }

    @Override
    public Cliente obtenerCliente(Long id) throws Exception {
        return serviceLocator.getRemoteClienteService().obtenerCliente(id);
    }

    @Override
    public List<Cliente> obtenerTodosClientes() {
        return null;
    }
}
