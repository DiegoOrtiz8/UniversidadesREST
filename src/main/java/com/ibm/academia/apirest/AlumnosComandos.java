package com.ibm.academia.apirest;

import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.services.AlumnoDAO;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AlumnosComandos implements CommandLineRunner {

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;

    @Autowired
    private CarreraDAO carreraDAO;

    @Autowired
    private AlumnoDAO alumnoDAO;

    @Override
    public void run(String... args) throws Exception {

        /*
        Optional<Carrera> sistemas = carreraDAO.buscarPorId(1);

        Optional<Carrera> ingSistemas = carreraDAO.buscarPorId(2);

        Iterable<Persona> alumnos = personaDAO.buscarTodos();
        alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(ingSistemas.get()));
        alumnos.forEach(alumno -> personaDAO.guardar(alumno));
         */

        Optional<Persona> alumno = alumnoDAO.buscarPorId(1);

        /*Optional<Persona> personaDni = personaDAO.buscarPorDni(alumno.get().getDni());
        System.out.println("DNI: = " + personaDni.toString());*/

        /*Optional<Persona> persona = personaDAO.buscarPorId(11);
        System.out.println(persona.orElse(null));
        System.out.println(persona.orElseThrow());
        List<Persona> personas = (List<Persona>) personaDAO.buscarTodos();*/

        Iterable<Persona> personasApellido = personaDAO.buscarPersonaPorApellido(alumno.get().getApellido());
        personasApellido.forEach(System.out::println);
    }
}
