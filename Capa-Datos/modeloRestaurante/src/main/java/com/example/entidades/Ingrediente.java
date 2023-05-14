package com.example.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Ingrediente")
public class Ingrediente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre",nullable = false,unique = true)
    private String nombre;

    @ManyToOne
    @Column(name = "TipoIngredienteid",nullable = false,unique = true)
    private TipoIngrediente tipoIngredienteid;


}
