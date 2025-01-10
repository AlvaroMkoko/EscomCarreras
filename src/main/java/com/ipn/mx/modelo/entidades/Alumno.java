package com.ipn.mx.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Alumno")
public class Alumno implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;
    @Column(name = "nombreAlumno", length = 50, nullable =  false)
    private String nombreAlumno;
    @Column(name = "paternoAlumno", length = 50, nullable =  false)
    private String paternoAlumno;
    @Column(name = "maternoAlumno", length = 50, nullable =  false)
    private String maternoAlumno;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimiento", nullable =  false)
    private Date fechaNacimiento;
    @Column(name = "emailAlumno", length = 100, nullable =  false)
    private String emailAlumno;

    //Para hacer cosas
    //@Column("name = " nullable = false)
    //private int ;

    @ManyToOne
    @JoinColumn(name = "idCarrera", nullable = false)
    @JsonBackReference
    private Carrera idCarrera; //Atributo del mismo nombre de tipo objeto. Traerá el id y lo demás.
}

