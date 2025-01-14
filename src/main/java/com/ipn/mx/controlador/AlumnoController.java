package com.ipn.mx.controlador;


import com.ipn.mx.modelo.entidades.Alumno;
import com.ipn.mx.modelo.entidades.Carrera;
import com.ipn.mx.servicios.AlumnoService;
import com.ipn.mx.servicios.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiAlumnos")
public class AlumnoController {
    @Autowired
    AlumnoService serviceAlumno;

    @Autowired
    CarreraService serviceCarrera;

    // En algún punto dirá localhost:8080/apialumno/alumnos
    // Para llegar a los verbos es la última
    @GetMapping("/alumno")
    public List<Alumno> readAll() {
        return serviceAlumno.findAll();
    }

    @GetMapping("/alumno/{id}")
    // Para http @
    public Alumno read(@PathVariable Long id) {
        return serviceAlumno.findById(id);
    }

    @PostMapping("/alumno")
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

    @PutMapping("/alumno/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Alumno update(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
        Alumno a = serviceAlumno.findById(id);
        if (a == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El alumno no existe");
        }

        // Actualizar los campos del alumno
        a.setNombreAlumno((String) payload.get("nombreAlumno"));
        a.setPaternoAlumno((String) payload.get("paternoAlumno"));
        a.setMaternoAlumno((String) payload.get("maternoAlumno"));
        a.setFechaNacimiento(Date.valueOf((String) payload.get("fechaNacimiento")));
        a.setEmailAlumno((String) payload.get("emailAlumno"));

        // Cargar la carrera gestionada
        Long idCarrera = ((Number) payload.get("idCarrera")).longValue();
        Carrera carrera = serviceCarrera.findById(idCarrera);
        if (carrera == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La carrera no existe");
        }
        a.setIdCarrera(carrera);

        // Guardar los cambios
        return serviceAlumno.save(a);
    }

}