package com.ibm.academia.apirest;

import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Direccion;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.services.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UniversidadesRestApplication {

    @Autowired
    private AlumnoDAO alumnoDAO;

    public static void main(String[] args) {
        SpringApplication.run(UniversidadesRestApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            /*Direccion direccion = new Direccion("calle 77", "11", "5555", "1305", "13", "tijuana");
            Persona alumno = new Alumno(null, "Maria", "De las nieves", "987654328", direccion);

            Persona personaGuardada = alumnoDAO.guardar(alumno);
            System.out.println(personaGuardada.toString());
             */
            //List<Persona> alumnos = (List<Persona>)  alumnoDAO.buscarTodos();
            //alumnos.forEach(System.out::println);
        };
    }

}
