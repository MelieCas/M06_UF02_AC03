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
            
        }
         

}
