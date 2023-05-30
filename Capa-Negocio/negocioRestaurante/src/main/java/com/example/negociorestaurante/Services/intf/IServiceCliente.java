package com.example.negociorestaurante.Services.intf;

<<<<<<< HEAD
import com.example.entidades.Cliente;
=======
import com.example.modeloRestaurante.entidades.Cliente;
>>>>>>> develop
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IServiceCliente {
    Cliente agregarCliente(Cliente cliente) throws Exception;
    void actualizarCliente(Cliente cliente) throws Exception;
    void eliminarCliente(Long id) throws Exception;
    Cliente obtenerCliente(Long id) throws Exception;
    Cliente obtenerClientePorEmail(String email) throws Exception;
    List<Cliente> obtenerTodosClientes();
}
