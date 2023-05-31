package com.example.modeloRestaurante.IRemoteServiciosDatos;

import com.example.modeloRestaurante.entidades.Cliente;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemoteClienteService {
    Cliente agregarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(Long id);
    Cliente obtenerCliente(Long id);
    Cliente obtenerClientePorEmail(String email);
    List<Cliente> obtenerTodosClientes();
}
