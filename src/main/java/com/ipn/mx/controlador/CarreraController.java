package com.ipn.mx.controlador;

import com.ipn.mx.modelo.entidades.Carrera;
import com.ipn.mx.servicios.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiCarreras")
public class CarreraController {

    //http://localhost:8080/apiCarreras/carrera
    @Autowired
    CarreraService servicio;

    @GetMapping("/carrera")
    public List<Carrera> readAll(){
        return servicio.findAll();
    }

    //http://localhost:8000/apiCarreras/carrera/{id}
    @GetMapping("/carrera/{id}")
    public Carrera readById(@PathVariable Long id){
        return servicio.findById(id);
    }

    /*
        {
            nombreCarrera : 'Derecho',
            descripcionCarrera : 'Carrera de leyes',
            duracionCarrera : 10
        }
    */

    @PostMapping("/carrera")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrera add(@RequestBody Carrera carrera){
        return servicio.save(carrera);
    }

    @DeleteMapping("/carrera/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        servicio.delete(id);
    }

    /*
        {
            idCarrera : 4
            nombreCarrera : 'Derecho',
            descripcionCarrera : 'Carrera de leyes',
            duracionCarrera : 10
        }

        update Carrera set nombreCarrera = 'valor nuevo' where idCarrera = 1;

        http://localhost:8080/apiCarrera/carrera/1
    */

    @PutMapping("/carrera/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrera update(@PathVariable Long id, @RequestBody Carrera carrera){
        Carrera c = servicio.findById(id);
        c.setNombreCarrera(carrera.getNombreCarrera());
        c.setDescripcionCarrera(carrera.getDescripcionCarrera());
        c.setDuracionCarrera(carrera.getDuracionCarrera());
        return servicio.save(c);
    }
}
