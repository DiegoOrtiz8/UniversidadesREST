package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> guardarCarrera(@Valid @RequestBody Carrera carrera, BindingResult result) {

        /*if(carrera.getCantidadAnios() < 0)
            throw new BadRequestException("El campo cantidad de años debe ser mayor a 0");

        if(carrera.getCantidadMaterias() < 0)
            throw new BadRequestException("El campo cantidad de materias debe ser mayor a 0");*/

        Map<String, Object> validaciones = new HashMap<String, Object>();
        if(result.hasErrors()) {
            List<String> listaErrores = result.getFieldErrors()
                    .stream()
                    .map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
                    .collect(Collectors.toList());
            validaciones.put("Lista Errores", listaErrores);

            return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
        }

        Carrera carreraGuardada = carreraDAO.guardar(carrera);

        return new ResponseEntity<Carrera>(carreraGuardada, HttpStatus.CREATED);
    }

    /**
     * Endpoint para actualizar un objeto de tipo carrera
     * @param carreraId Parametro para buscar la carrera
     * @param carrera Objeto con la informacion a modificar
     * @return Retorna un objeto de tipo Carrera con la informacion actualizada
     * @NotFoundException En caso de que falle actualizando el objeto carrera
     * @author DECO 18/05/2022
     */
    @PutMapping("/upd/carreraId/{carreraId}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable Integer carreraId, @RequestBody Carrera carrera) {

        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);

        if(!oCarrera.isPresent())
            throw new NotFoundException(String.format("La carrera con ID: %d no existe", carreraId));

        Carrera carreraActualizada = carreraDAO.actualizar(oCarrera.get(), carrera);

        return new ResponseEntity<Carrera>(carreraActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/carreraId/{carreraId}")
    public ResponseEntity<?> eliminarCarrera(@PathVariable Integer carreraId) {
        Map<String, Object> respuesta = new HashMap<String, Object>();

        Optional<Carrera> carrera = carreraDAO.buscarPorId(carreraId);

        if(!carrera.isPresent())
            throw new NotFoundException(String.format("La carrera con ID: %d no existe", carreraId));

        carreraDAO.eliminarPorId(carreraId);
        respuesta.put("OK", "Carrera ID: " + carreraId + " eliminada exitosamente");

        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }
}
