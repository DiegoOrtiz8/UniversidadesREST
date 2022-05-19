package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.services.AlumnoDAO;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO alumnoDAO;

    @Autowired
    private CarreraDAO carreraDAO;

    /**
     * Endpoint para crear un objeto Persona de tipo Alumno
     * @param alumno Objeto con la informacion a crear
     * @return Retorna un objeto Persona de tipo Alumno con codigo httpstatus 201
     * @author DECO 18/05/2022
     */
    @PostMapping
    public ResponseEntity<?> crearAlumno(@RequestBody Persona alumno) {

        Persona alumnoGuardado = alumnoDAO.guardar(alumno);

        return new ResponseEntity<Persona>(alumnoGuardado, HttpStatus.CREATED);
    }

    /**
     * Endpoint para listar los alumnos
     * @return
     * @author DECO 18/05/2022
     */
    @GetMapping("/lista/alumnos")
    public ResponseEntity<?> obtenerTodos() {
        List<Persona> alumnos = (List<Persona>) alumnoDAO.buscarTodos();

        if(alumnos.isEmpty())
            throw new NotFoundException("No existen alumnos");

        return new ResponseEntity<List<Persona>>(alumnos, HttpStatus.OK);
    }

    /**
     * Endpoint para obtener Alumno mediante Id
     * @param alumnoId Id de alumno
     * @return Retorna el alumno encontrado
     * @author DECO 18/05/2022
     */
    @GetMapping("/alumnoId/{alumnoId}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer alumnoId) {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("Alumno con ID %d no existe", alumnoId));

        return new ResponseEntity<Persona>(oAlumno.get(), HttpStatus.OK);
    }

    /**
     * Endpoint para actualizar alumno mediante el id
     * @param alumnoId Id de alumno
     * @param alumno Alumno a actualizar
     * @return Retorna el alumno actualizado
     * @author DECO 18/05/2022
     */
    @PutMapping("/upd/alumnoId/{alumnoId}")
    public ResponseEntity<?> actualizarAlumno(@PathVariable Integer alumnoId, @RequestBody Persona alumno) {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("Alumno con ID %d no existe", alumnoId));

        Persona alumnoActualizado = ((AlumnoDAO)alumnoDAO).actualizar(oAlumno.get(), alumno);

        return new ResponseEntity<Persona>(alumnoActualizado, HttpStatus.OK);
    }

    /**
     * Endpoint para eliminar alumno por Id
     * @param alumnoId
     * @return
     */
    @DeleteMapping("/alumnoId/{alumnoId}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable Integer alumnoId) {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("Alumno con ID %d no existe", alumnoId));

        alumnoDAO.eliminarPorId(oAlumno.get().getId());

        return new ResponseEntity<String>("Alumno ID: " + alumnoId + " se elimino satisfactoriamente", HttpStatus.NO_CONTENT);
    }

    /**
     * Endpoint para asignar una carrera a un alumno
     * @param carreraId
     * @param alumnoId
     * @return
     */
    @PutMapping("/alumnoId/{alumnoId}/carrera/{carreraId}")
    public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer carreraId, @PathVariable Integer alumnoId) {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("Alumno con ID %d no existe", alumnoId));

        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);

        if(!oCarrera.isPresent())
            throw new NotFoundException(String.format("Carrera con ID %d no existe", carreraId));

        Persona alumno = ((AlumnoDAO)alumnoDAO).asociarCarreraAlumno(oAlumno.get(), oCarrera.get());

        return new ResponseEntity<Persona>(alumno, HttpStatus.OK);
    }
}
