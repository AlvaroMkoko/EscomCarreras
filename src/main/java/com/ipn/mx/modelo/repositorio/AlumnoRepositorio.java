package com.ipn.mx.modelo.repositorio;

import com.ipn.mx.modelo.entidades.Alumno;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepositorio extends CrudRepository<Alumno, Long> {

    Object findAll(Sort idAlumno);
}
