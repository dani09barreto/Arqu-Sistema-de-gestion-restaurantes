package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.modeloRestaurante.IRemoteServiciosDatos.IRemoteClienteService;
import com.example.modeloRestaurante.entidades.Cliente;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IClienteService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;
@Stateless
public class RemoteClienteService  implements IRemoteClienteService {
    @EJB
    IClienteService clienteService;
    @Override
    public Cliente agregarCliente(Cliente cliente) {
        return clienteService.agregarCliente(cliente);
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
    public Cliente obtenerClientePorEmail(String email) {
        return clienteService.obtenerClientePorEmail(email);
    }

    @Override
    public List<Cliente> obtenerTodosClientes() {
        return  clienteService.obtenerTodosClientes();
    }
}
