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
@Table(name = "Pago")
public class Pago implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "valor",nullable = false)
    private Double valor;
    @Column(name = "descuento",nullable = false)
    private Double descuento;
    @ManyToOne
    @JoinColumn(name = "Pedidoid",nullable = false,unique = true)
    private Pedido Pedidoid;
    @ManyToOne
    @JoinColumn(name = "TipoPagoid",nullable = false,unique = true)
    private TipoPago tipopagoid;
}
