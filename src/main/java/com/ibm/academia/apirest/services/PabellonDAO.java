package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Pabellon;

public interface PabellonDAO extends GenericoDAO<Pabellon> {

    public Iterable<Pabellon> findPabellonbyLocalidadAfter(String localidad);

    public Iterable<Pabellon> findPabellonbyNombreAfter(String nombre);
}
