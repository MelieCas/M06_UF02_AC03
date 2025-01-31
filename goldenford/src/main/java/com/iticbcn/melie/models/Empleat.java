package com.iticbcn.melie.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

public class Empleat implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="nom")
    private String nom;
    @Column(name="primer_cognom")
    private String cognom1;
    @Column(name="segon_cognom")
    private String cognom2;
    @Column(name="dni")
    private String dni;
    @Column(name="telefon")
    private String telefon;
    @Column(name="sou")
    private double sou;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name="Equips",
    joinColumns = {@JoinColumn(name="idEmpleat", foreignKey=@ForeignKey(name="FK_EQUIP_EMPLEAT"))},
    inverseJoinColumns = {@JoinColumn(name="idTasca", foreignKey=@ForeignKey(name="FK_EQUIP_TASCA"))})
    private Set<Tasca> tasques = new HashSet<>();
        public void addTasca(Tasca t) {
            if(!this.tasques.contains(t)) {
                tasques.add(t);
            }
            t.addEmpleat(this);
        }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCognom1() {
        return cognom1;
    }
    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }
    public String getCognom2() {
        return cognom2;
    }
    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public double getSou() {
        return sou;
    }
    public void setSou(double sou) {
        this.sou = sou;
    }

    public Empleat(int id, String nom, String cognom1, String cognom2, String dni, String telefon, double sou) {
        this.id = id;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.dni = dni;
        this.telefon = telefon;
        this.sou = sou;
    }
         

}
