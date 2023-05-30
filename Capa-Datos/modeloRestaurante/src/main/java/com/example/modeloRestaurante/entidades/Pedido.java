package com.example.modeloRestaurante.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Pedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tiempoestado",nullable = false)
    private Date tiempoestado;
    @ManyToOne
    @JoinColumn(name = "Mesaid",nullable = false,unique = true)
    private Mesa Mesaid;
    @ManyToOne
    @JoinColumn(name = "Clienteid",nullable = false,unique = true)
    private Cliente Clienteid;
    @ManyToOne
    @JoinColumn(name = "EstadoPedidoid",nullable = false)
    private EstadoPedido EstadoPedidoid;

}
