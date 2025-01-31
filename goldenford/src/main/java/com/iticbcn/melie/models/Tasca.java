package com.iticbcn.melie.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Tasca implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="nom")
    private String nom;
    @Column(name="descripcio")
    private String descripcio;
    @Column(name="fecha_limit")
    private Date fecha_limit;
    @Column(name="prioritat")
    private int prioritat;
    

}
