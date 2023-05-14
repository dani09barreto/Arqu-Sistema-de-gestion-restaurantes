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
@Table(name = "IngredientePlato")
public class IngredientePlato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cantidad",nullable = false)
    private long cantidad;
    @ManyToOne
    @Column(name = "Ingredienteid",nullable = false,unique = true)
    private Ingrediente Ingredienteid;
    @ManyToOne
    @Column(name = "Platoid",nullable = false,unique = true)
    private Plato Platoid;
}
