package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteClienteService;
import com.example.entidades.Cliente;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IClienteService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;
@Stateless
public class RemoteClienteService  implements IRemoteClienteService {
    @EJB
    IClienteService clienteService;
    @Override
    public void agregarCliente(Cliente cliente) {
        clienteService.agregarCliente(cliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
clienteService.actualizarCliente(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
clienteService.eliminarCliente(id);
    }

    @Override
    public Cliente obtenerCliente(Long id) {
        return clienteService.obtenerCliente(id);
    }

    @Override
    public List<Cliente> obtenerTodosClientes() {
        return  clienteService.obtenerTodosClientes();
    }
}
