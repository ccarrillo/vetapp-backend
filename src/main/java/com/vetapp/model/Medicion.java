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



@Table(name = "medicion", schema = "vet")
@Entity
public class Medicion extends BaseModel{

	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


    @Column(name = "fecha")
    private Date fechamedicion;

    @Column(name = "peso")
    private double peso;
    
    @Column(name = "estatura")
    private double estatura;
    
    @Column(name = "concorporal")
    private int concorporal;
    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idanimal", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Animal idanimal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Date getFechamedicion() {
		return fechamedicion;
	}

	public void setFechamedicion(Date fechamedicion) {
		this.fechamedicion = fechamedicion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public int getConcorporal() {
		return concorporal;
	}

	public void setConcorporal(int concorporal) {
		this.concorporal = concorporal;
	}

	public Animal getIdanimal() {
		return idanimal;
	}

	public void setIdanimal(Animal idanimal) {
		this.idanimal = idanimal;
	}

	

	 

    
   
}
