package com.example.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="plato")
public class Plato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private BigInteger precio;

    @Column(name = "img")
    private String img;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Menuid")
    private Menu menu;
}
