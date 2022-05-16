package com.ibm.academia.apirest;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Comandos implements CommandLineRunner {
    @Autowired
    private CarreraDAO carreraDAO;

    @Override
    public void run(String... args) throws Exception {
        /*
        Carrera finanzas = new Carrera(null, "Ingenieria en finanzas", 20, 3);
        Carrera carreraGuardada = carreraDAO.guardar(finanzas);
        System.out.println(carreraGuardada.toString());
         */


        Integer id = 11;

        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(id);
        if(oCarrera.isPresent()) {
             Carrera carrera = oCarrera.get();
            System.out.println(carrera.toString());
        }
        else {
            System.out.println("Carrera no encontrada");
        }



    }
}
