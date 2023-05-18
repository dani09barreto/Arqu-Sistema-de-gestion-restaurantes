package com.example.negociogeneral.Services.intf;

import com.example.entidades.Bodega;
import com.example.entidades.Inventario;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public interface IServicioInventario {
    void agregarInventario(Inventario inventario) throws NamingException, IOException;
    void actualizarInventario(Inventario inventario) throws NamingException, IOException;
    void eliminarInventario(Long id) throws NamingException, IOException;
    Inventario obtenerInventario(Long id) throws NamingException, IOException;
    List<Inventario> obtenerTodosInventarioPorBodega(Bodega bodega) throws NamingException, IOException;
}
