package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.Cliente;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IClienteService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class ClienteService implements IClienteService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarCliente(Cliente cliente) {
        entityManager.persist(cliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        entityManager.merge(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        Cliente cliente = obtenerCliente(id);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }

    @Override
    public Cliente obtenerCliente(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> obtenerTodosClientes() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

}
