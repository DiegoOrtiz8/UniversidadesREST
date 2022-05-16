package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Carrera;

import java.util.Optional;

public interface CarreraDAO extends GenericoDAO<Carrera>{
    public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}
