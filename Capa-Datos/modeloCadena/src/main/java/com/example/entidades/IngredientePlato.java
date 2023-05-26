package com.example.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="ingredienteplato")
public class IngredientePlato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Platoid")
    private Plato plato;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Ingredienteid")
    private Ingrediente ingrediente;

    @Column(name = "cantidad")
    private Integer cantidad;
}
