package com.iticbcn.melie.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

public class Tasca implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;
    @Column(name="nom", nullable = false)
    private String nom;
    @Column(name="descripcio", nullable = false)
    private String descripcio;
    @Column(name="fecha_limit", nullable = false)
    private Date fecha_limit;
    @Column(name="prioritat", nullable = false)
    private int prioritat;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "tasques")
    private Set<Empleat> empleats = new HashSet<>();
        public void addEmpleat(Empleat e) {
            if(!this.empleats.contains(e)) {
                empleats.add(e);
            }
            e.addTasca(this);
        }

}
