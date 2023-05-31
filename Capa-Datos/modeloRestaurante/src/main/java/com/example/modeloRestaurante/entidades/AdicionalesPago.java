package com.example.modeloRestaurante.entidades;

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
@Table(name = "AdicionalesPago")
public class AdicionalesPago implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "Pagoid",nullable = false,unique = true)
    private Pago Pagoid;

    @ManyToOne
    @JoinColumn(name = "Adicionalesid",nullable = false,unique = true)
    private Adicionales Adicionalesid;

}
