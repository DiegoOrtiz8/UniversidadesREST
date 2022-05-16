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

    public static void main(String[] args) {
        SpringApplication.run(UniversidadesRestApplication.class, args);
    }

}
