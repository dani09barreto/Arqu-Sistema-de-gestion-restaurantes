package com.example.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "RegistroPago")
public class RegistroPago implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "fecha",nullable = false,unique = true)
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "Pagoid",nullable = false,unique = true)
    private Pago Pagoid;

}
