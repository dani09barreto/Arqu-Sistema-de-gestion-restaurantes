package com.example.entidades;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="ingredienteplato")
public class IngredientePlato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Platoid")
    private Plato plato;

    @ManyToOne
    @JoinColumn(name = "Ingredienteid")
    private Ingrediente ingrediente;

    @Column(name = "cantidad")
    private double cantidad;
}
