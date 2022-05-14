package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Persona;

import java.util.Optional;

public interface AlumnoDAO {
    public Optional<Persona> buscarPorId(Integer id);
    public Persona guardar(Persona persona);
    public Iterable<Persona> buscarTodos();
    public void eliminarPorId(Integer id);
}
