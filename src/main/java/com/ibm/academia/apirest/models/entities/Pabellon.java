package com.ibm.academia.apirest.models.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pabellones", schema = "universidad")
public class Pabellon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "metros_cuadrados")
    private Double metrosCuadrados;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
            @AttributeOverride(name = "departamento", column = @Column(name = "departamento"))
    })
    private Direccion direccion;

    @OneToMany(mappedBy = "pabellon", fetch = FetchType.LAZY)
    private Set<Aula> aulas;

    public Pabellon(Integer id, Double metrosCuadrados, String nombre, Direccion direccion) {
        this.id = id;
        this.metrosCuadrados = metrosCuadrados;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pabellon pabellon = (Pabellon) o;
        return Objects.equals(id, pabellon.id) && Objects.equals(nombre, pabellon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @PrePersist
    private void antesPersistir() {
        this.fechaAlta = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.fechaModificacion = new Date();
    }
}
