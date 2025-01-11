package com.ipn.mx.servicios.impl;

import com.ipn.mx.modelo.entidades.Carrera;
import com.ipn.mx.modelo.repositorio.CarreraRepositorio;
import com.ipn.mx.servicios.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CarreraServiceImpl implements CarreraService {
    @Autowired
    CarreraRepositorio carreraRepositorio;

    @Override
    @Transactional(readOnly = true)
    public List<Carrera> findAll(){
        return (List<Carrera>) carreraRepositorio.findAll(Sort.by(Sort.Direction.ASC, "idCarrera"));
    }

    @Override
    @Transactional(readOnly = true)
    public Carrera findById(Long id){
        return carreraRepositorio.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Carrera save(Carrera carrera) {
        return carreraRepositorio.save(carrera);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        carreraRepositorio.deleteById(id);
    }
}
