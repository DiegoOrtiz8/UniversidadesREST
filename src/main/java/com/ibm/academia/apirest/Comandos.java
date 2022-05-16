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

        /*
        Carrera carrera = null;

        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(1);
        if(oCarrera.isPresent()) {
             carrera = oCarrera.get();
            System.out.println(carrera.toString());
        }
        else {
            System.out.println("Carrera no encontrada");
        }
        carrera.setCantidadAnios(7);
        carrera.setCantidadMaterias(66);
        carreraDAO.guardar(carrera);

        System.out.println(carreraDAO.buscarPorId(7).orElse(new Carrera()).toString());

         */

        //carreraDAO.eliminarPorId(3);
        //System.out.println(carreraDAO.buscarPorId(3).orElse(new Carrera()).toString());
    }
}
