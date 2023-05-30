package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.Cliente;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface IClienteService {
    Cliente agregarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(Long id);
    Cliente obtenerCliente(Long id);
    Cliente obtenerClientePorEmail(String email);
    List<Cliente> obtenerTodosClientes();
}
