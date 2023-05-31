package com.example.negociorestaurante.Services.imp;

import com.example.modeloRestaurante.entidades.Adicionales;
import com.example.modeloRestaurante.entidades.AdicionalesPago;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServiceAdicionalesPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceAdicionalesPago implements IServiceAdicionalesPago {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;
    @Override
    public Adicionales obtenerAdicionalesPorPlatoid(long id) throws Exception {
        return serviceLocator.getRemoteAdicionalesPago().obtenerAdicionalesPorPlatoid(id);
    }

    @Override
    public void AgregarAdicionalesPago(AdicionalesPago adicionalesPago) throws Exception {
        serviceLocator.getRemoteAdicionalesPago().AgregarAdicionalesPago(adicionalesPago);
    }
}
