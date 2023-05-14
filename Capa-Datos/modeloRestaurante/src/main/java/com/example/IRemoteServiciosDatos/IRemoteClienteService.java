package com.example.IRemoteServiciosDatos;

import com.example.entidades.Cliente;

import java.util.List;

public interface IRemoteClienteService {
    void agregarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(Long id);
    Cliente obtenerCliente(Long id);
    List<Cliente> obtenerTodosClientes();
}
