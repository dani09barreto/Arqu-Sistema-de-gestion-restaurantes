package com.example.negociogeneral.Services.intf;

import com.example.entidades.Ingrediente;
import com.example.entidades.TipoIngrediente;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public interface IServicioIngrediente {
    void agregarIngrediente(Ingrediente ingrediente);
    Ingrediente obtenerIngrediente(Long id) throws NamingException, IOException;
    void actualizarIngrediente(Ingrediente ingrediente);
    void eliminarIngrediente(Long id);
    List <Ingrediente> obtenerIngredientesPorTipo(TipoIngrediente tipoIngrediente);
}
