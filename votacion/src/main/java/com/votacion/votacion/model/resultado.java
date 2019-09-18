package com.votacion.votacion.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.databind.ObjectReader;

import org.aspectj.apache.bcel.generic.ObjectType;

@Entity
@NamedQueries({
    @NamedQuery(name = "resultado.findAll", query = "SELECT t FROM resultado t")
})

public class resultado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Basic(optional = false)
    private Integer id;

    @Basic(optional = false)
    private String sexo;

    @Basic(optional = false)
    private Integer edad;

    @Basic(optional = false)
    private String nivelEducativo;

    @Basic(optional = false)
    private Integer departamento_id;

    @Basic(optional = false)
    private Integer municipio_id;


    public resultado() {
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNivelEducativo() {
        return this.nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public Integer getDepartamento_id() {
        return this.departamento_id;
    }

    public void setDepartamento_id(Integer departamento_id) {
        this.departamento_id = departamento_id;
    }

    public Integer getMunicipio_id() {
        return this.municipio_id;
    }

    public void setMunicipio_id(Integer municipio_id) {
        this.municipio_id = municipio_id;
    }
    




 


}