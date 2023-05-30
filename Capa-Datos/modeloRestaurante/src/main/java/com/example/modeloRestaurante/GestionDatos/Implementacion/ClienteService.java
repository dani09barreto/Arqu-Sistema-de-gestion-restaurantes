package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.modeloRestaurante.entidades.Cliente;
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
    public Cliente agregarCliente(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
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
    public Cliente obtenerClientePorEmail(String email) {
        return entityManager.createQuery("SELECT c FROM Cliente c WHERE c.email = :email", Cliente.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<Cliente> obtenerTodosClientes() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

}
