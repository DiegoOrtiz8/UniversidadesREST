package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.enums.Pizarron;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AulaRepository extends CrudRepository<Aula, Integer> {

    @Query("select a from Aula a where a.pizarron = ?1")
    public Iterable<Aula> findAulabyTipoPizarronAfter(Pizarron pizarron);

    @Query("select a from Aula a join fetch a.pabellon p  where p.nombre = ?1")
    public Iterable<Aula> findAulabyNombrePabellonAfter(String nombre);

    @Query("select a from Aula a where a.numeroAula = ?1")
    public Iterable<Aula> findAulabyNumeroAulaAfter(Integer numeroAula);
}
