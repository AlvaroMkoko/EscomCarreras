package com.ipn.mx.servicios;

import com.ipn.mx.modelo.entidades.Carrera;

import java.util.List;

public interface CarreraService {
    public List<Carrera> findAll();
    public Carrera findById(Long id);
    public Carrera save(Carrera carrera);
    public void delete(Long id);
}
