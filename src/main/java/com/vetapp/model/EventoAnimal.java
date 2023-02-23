package com.vetapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "eventoanimal", schema = "vet")
@Entity
public class EventoAnimal extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "idempleado")
    private Long idempleado;

    @Column(name = "idtipoevento")
    private Long idtipoevento;
    
    @Column(name = "anotacion")
    private String anotacion;
    
    @Column(name = "costo")
    private Double costo;
    
    @Column(name = "checkprotocolo",length = 1)
    private String checkprotocolo;
     
    @Column(name = "idprotocolo")
    private Long idprotocolo;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idanimal", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Animal idAnimal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(Long idempleado) {
		this.idempleado = idempleado;
	}

	public Long getIdtipoevento() {
		return idtipoevento;
	}

	public void setIdtipoevento(Long idtipoevento) {
		this.idtipoevento = idtipoevento;
	}

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

     
	public String getCheckprotocolo() {
		return checkprotocolo;
	}

	public void setCheckprotocolo(String checkprotocolo) {
		this.checkprotocolo = checkprotocolo;
	}

	public Long getIdprotocolo() {
		return idprotocolo;
	}

	public void setIdprotocolo(Long idprotocolo) {
		this.idprotocolo = idprotocolo;
	}

	public Animal getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Animal idAnimal) {
		this.idAnimal = idAnimal;
	}
   
    
	
    


}
