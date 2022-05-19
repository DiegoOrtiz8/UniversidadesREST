package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO {

    @Autowired
    public AulaDAOImpl(AulaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Aula> findAulabyTipoPizarronAfter(Pizarron pizarron) {
        return repository.findAulabyTipoPizarronAfter(pizarron);
    }

    @Override
    public Iterable<Aula> findAulabyNombrePabellonAfter(String nombre) {
        return repository.findAulabyNombrePabellonAfter(nombre);
    }

    @Override
    public Iterable<Aula> findAulabyNumeroAulaAfter(Integer numeroAula) {
        return repository.findAulabyNumeroAulaAfter(numeroAula);
    }
}
