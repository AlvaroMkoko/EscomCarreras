package com.ipn.mx.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Carrera")
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCarrera", nullable = false)
    private long idCarrera;

    @Column(name = "nombreCarrera", length = 150, nullable = false)
    private String nombreCarrera;

    @Column(name = "descripcionCarrera", length = 150, nullable = false)
    private String descripcionCarrera;

    @Column(name = "duracionCarrera", nullable = false)
    private int duracionCarrera;
}
