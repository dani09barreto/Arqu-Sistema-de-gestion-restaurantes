package com.example.negociogeneral.Services.intf;

import com.example.entidades.Ingrediente;
import com.example.entidades.TipoIngrediente;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public interface IServicioIngrediente {
    void agregarIngrediente(Ingrediente ingrediente, String uri);
    Ingrediente obtenerIngrediente(Long id, String uri) throws NamingException, IOException;
    void actualizarIngrediente(Ingrediente ingrediente, String uri);
    void eliminarIngrediente(Long id, String uri);
    List <Ingrediente> obtenerIngredientesPorTipo(TipoIngrediente tipoIngrediente, String uri);
}
