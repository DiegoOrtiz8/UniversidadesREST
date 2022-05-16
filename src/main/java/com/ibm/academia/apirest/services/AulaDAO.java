package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.enums.Pizarron;
import org.springframework.data.jpa.repository.Query;

public interface AulaDAO extends GenericoDAO<Aula> {
    public Iterable<Aula> findAulabyTipoPizarronAfter(Pizarron pizarron);

    public Iterable<Aula> findAulabyNombrePabellonAfter(String nombre);

    public Iterable<Aula> findAulabyNumeroAulaAfter(Integer numeroAula);
}
