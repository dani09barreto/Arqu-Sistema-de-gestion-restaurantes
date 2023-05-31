package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.modeloRestaurante.GestionDatos.Interfaces.IAdicionalesPagoService;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IAdicionalesService;
import com.example.modeloRestaurante.entidades.Adicionales;
import com.example.modeloRestaurante.entidades.AdicionalesPago;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class AdicionalesPagoService implements IAdicionalesPagoService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;


    @Override
    public Adicionales obtenerAdicionalesPorPlatoid(long id) {
        return entityManager.createQuery("SELECT a FROM AdicionalesPago a WHERE a.Pagoid=:id",Adicionales.class).setParameter("id",id).getSingleResult();
    }

    @Override
    public void AgregarAdicionalesPago(AdicionalesPago adicionalesPago) {
        entityManager.persist(adicionalesPago);
    }
}
