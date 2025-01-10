package com.ipn.mx.servicios;

import com.ipn.mx.modelo.entidades.Alumno;

import java.util.List;

public interface AlumnoService {
    public List<Alumno> findAll();
    public Alumno findById(Long id);
    public Alumno save(Alumno alumno);
    public void delete(Long id);
}