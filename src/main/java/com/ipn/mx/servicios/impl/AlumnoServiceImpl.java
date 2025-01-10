package com.ipn.mx.servicios.impl;

import com.ipn.mx.modelo.entidades.Alumno;
import com.ipn.mx.modelo.entidades.Carrera;
import com.ipn.mx.modelo.repositorio.AlumnoRepositorio;
import com.ipn.mx.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    AlumnoRepositorio alumnoRepositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findAll(){ return (List<Alumno>) alumnoRepositorio.findAll();}

    @Override
    @Transactional(readOnly = true)
    public Alumno findById(Long id) {
        return alumnoRepositorio.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public Alumno save(Alumno alumno) {
        return alumnoRepositorio.save(alumno);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        alumnoRepositorio.deleteById(id);
    }
}