package com.ipn.mx.controlador;


import com.ipn.mx.modelo.entidades.Alumno;
import com.ipn.mx.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiAlumno")
public class AlumnoController {
    @Autowired
    AlumnoService serviceAlumno;

    // En algún punto dirá localhost:8080/apialumno/alumnos
    // Para llegar a los verbos es la última
    @GetMapping("/alumnos")
    public List<Alumno> readAll() {
        return serviceAlumno.findAll();
    }

    @GetMapping("/alumnos/{id}")
    // Para http @
    public Alumno read(@PathVariable Long id) {
        return serviceAlumno.findById(id);
    }

    @PostMapping("/alumnos")
    //Created 201 Http
    @ResponseStatus(HttpStatus.CREATED)
    // Lo pasaremos con un json
    public Alumno create(@RequestBody Alumno alumno) {
        return serviceAlumno.save(alumno);
    }

    @DeleteMapping("/alumno/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        serviceAlumno.delete(id);
    }

    @PutMapping("/alumnos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Alumno update(@PathVariable Long id, @RequestBody Alumno alumno) {
        Alumno a = serviceAlumno.findById(id);
        a.setNombreAlumno(alumno.getNombreAlumno());
        a.setPaternoAlumno(alumno.getPaternoAlumno());
        a.setMaternoAlumno(alumno.getMaternoAlumno());
        a.setFechaNacimiento(alumno.getFechaNacimiento());
        a.setEmailAlumno(alumno.getEmailAlumno());
        return serviceAlumno.save(a);
    }
}