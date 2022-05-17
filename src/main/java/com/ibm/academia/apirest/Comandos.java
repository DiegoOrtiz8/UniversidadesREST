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
public class Comandos implements CommandLineRunner {

    @Autowired
    private CarreraDAO carreraDAO;

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;

    @Override
    public void run(String... args) throws Exception {

        /*Carrera ingSistemas = new Carrera(null, "Ingenieria en Sistemas", 60, 5);
        Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5);
        Carrera ingAlimentos = new Carrera(null, "Ingenieria en Alimentos", 53, 5);
        Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 45, 5);
        Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas", 40, 4);
        Carrera licTurismo = new Carrera(null, "Licenciatura en Turismo", 42, 4);
        Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 25, 3);
        Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos Humanos - RRHH", 33, 3);

        carreraDAO.guardar(ingSistemas);
        carreraDAO.guardar(ingIndustrial);
        carreraDAO.guardar(ingAlimentos);
        carreraDAO.guardar(ingElectronica);
        carreraDAO.guardar(licSistemas);
        carreraDAO.guardar(licTurismo);
        carreraDAO.guardar(licYoga);
        carreraDAO.guardar(licRecursos);
         */

        /*
        Optional<Carrera> ingSistemas = carreraDAO.buscarPorId(2);

        Iterable<Persona> alumnos = personaDAO.buscarTodos();
        alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(ingSistemas.get()));
        alumnos.forEach(alumno -> personaDAO.guardar(alumno));
        */

        /*
        Optional<Carrera> ingSistemas = carreraDAO.buscarPorId(2);
        Iterable<Persona> alumnosCarrera = ((AlumnoDAO) personaDAO).buscarAlumnoPorNombreCarrera(ingSistemas.get().getNombre());
        alumnosCarrera.forEach(System.out::println);
        */

        /*List<Carrera> carreras = (List<Carrera>)carreraDAO.findCarrerasByNombreContains("Sistemas");
        carreras.forEach(System.out::println);
         */

        /*
        List<Carrera> carrerasIgnoreCase1 = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase("SISTEMAS");
        //List<Carrera> carrerasIgnoreCase2 = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase("sistemas");
        carrerasIgnoreCase1.forEach(System.out::println);
        //carrerasIgnoreCase2.forEach(System.out::println);

        List<Carrera> carrerasPorAnio = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(3);
        carrerasPorAnio.forEach(System.out::println);
         */

        /*
        Optional<Persona> persona = personaDAO.buscarPorId(1);
        System.out.println(persona.toString());
         */
    }
}
