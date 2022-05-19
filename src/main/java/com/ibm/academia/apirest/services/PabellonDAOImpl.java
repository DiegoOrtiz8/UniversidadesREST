package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Pabellon;
import com.ibm.academia.apirest.repositories.PabellonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PabellonDAOImpl extends GenericoDAOImpl<Pabellon, PabellonRepository> implements PabellonDAO {

    @Autowired
    public PabellonDAOImpl(PabellonRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Pabellon> findPabellonbyLocalidadAfter(String localidad) {
        return repository.findPabellonbyLocalidadAfter(localidad);
    }

    @Override
    public Iterable<Pabellon> findPabellonbyNombreAfter(String nombre) {
        return repository.findPabellonbyNombreAfter(nombre);
    }
}
