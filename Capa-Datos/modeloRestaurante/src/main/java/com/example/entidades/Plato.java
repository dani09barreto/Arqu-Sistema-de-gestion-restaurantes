package com.example.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Plato")
public class Plato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre",nullable = false,unique = true)
    private String nombre;
    @Column(name = "descripcion",nullable = false,unique = true)
    private String descripcion;
    @Column(name = "precio",nullable = false)
    private BigInteger precio;
    @Column(name = "img",nullable = false,unique = true)
    private String img;


}
