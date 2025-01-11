package com.ipn.mx.modelo.repositorio;


import com.ipn.mx.modelo.entidades.Carrera;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface CarreraRepositorio extends CrudRepository<Carrera, Long> {

    Object findAll(Sort idCarrera);
}
