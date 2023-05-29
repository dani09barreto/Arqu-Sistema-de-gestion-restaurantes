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
@Table(name = "PlatoPedido")
public class PlatoPedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cantidad",nullable = false)
    private long cantidad;
    @ManyToOne
    @JoinColumn(name = "Pedidoid",nullable = false,unique = true)
    private Pedido Pedidoid;

    @Column(name = "Platoid",nullable = false,unique = true)
    private long Platoid;


}
