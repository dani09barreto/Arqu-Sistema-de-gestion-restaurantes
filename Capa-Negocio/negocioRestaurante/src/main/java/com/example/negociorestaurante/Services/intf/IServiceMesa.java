package com.example.negociorestaurante.Services.intf;

<<<<<<< HEAD
import com.example.entidades.Mesa;
=======
import com.example.modeloRestaurante.entidades.Mesa;
>>>>>>> develop
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceMesa {
    void agregarMesa(Mesa mesa) throws Exception;
    void actualizarMesa(Mesa mesa) throws Exception;
    void eliminarMesa(Long id) throws Exception;
    Mesa obtenerMesa(Long id) throws Exception;
    List<Mesa> obtenerTodasMesas() throws Exception;
}
