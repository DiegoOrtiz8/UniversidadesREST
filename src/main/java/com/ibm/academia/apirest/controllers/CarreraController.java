package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    private CarreraDAO carreraDAO;

    @GetMapping("/lista/carreras")
    public List<Carrera> buscarTodas() {

        List<Carrera> carreras = (List<Carrera>) carreraDAO.buscarTodos();
        if(carreras.isEmpty())
            throw new BadRequestException("No existen carreras");

        return carreras;
    }

    @GetMapping("/id/{carreraId}")
    public Carrera buscarCarreraPorId(@PathVariable Integer carreraId) {

        /*Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);

        if(!oCarrera.isPresent())
            throw new BadRequestException(String.format("La carrera con ID: %d no exite", carreraId));

        return oCarrera.get();
         */

        Carrera carreras = carreraDAO.buscarPorId(carreraId).orElse(null);
        if(carreras == null)
            throw new BadRequestException(String.format("La carrera con ID: %d no exite", carreraId));
        return carreras;
    }

    @PostMapping
    public ResponseEntity<?> guardarCarrera(@RequestBody Carrera carrera) {

        if(carrera.getCantidadAnios() < 0)
            throw new BadRequestException("El campo cantidad de años debe ser mayor a 0");

        if(carrera.getCantidadMaterias() < 0)
            throw new BadRequestException("El campo cantidad de materias debe ser mayor a 0");

        Carrera carreraGuardada = carreraDAO.guardar(carrera);

        return new ResponseEntity<Carrera>(carreraGuardada, HttpStatus.CREATED);
    }
}
