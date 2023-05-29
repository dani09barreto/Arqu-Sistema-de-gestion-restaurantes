package com.example.negociorestaurante.Services.intf;

import com.example.entidades.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IServiceCliente {
    void agregarCliente(Cliente cliente) throws Exception;
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(Long id);
    Cliente obtenerCliente(Long id) throws Exception;
    List<Cliente> obtenerTodosClientes();
}
