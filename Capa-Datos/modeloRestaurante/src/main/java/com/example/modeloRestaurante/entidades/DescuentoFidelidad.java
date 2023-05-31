package com.example.modeloRestaurante.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="DescuentoFidelidad")
public class DescuentoFidelidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(name = "minimo",nullable = false)
    private long minimo;
    @Column(name = "max",nullable = false)
    private long max;
    @Column(name = "descuento",nullable = false)
    private  float descuento;



}
