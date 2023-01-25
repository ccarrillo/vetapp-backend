package com.vetapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Table(name = "medicion", schema = "vet")
@Entity
public class Medicion extends BaseModel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @SequenceGenerator(name="vet.medicion_id_seq",sequenceName="vet.medicion_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.medicion_id_seq")
    @Column(name = "id")
    private Long id;


    @Column(name = "fecha")
    private Date fechamedicion;

    @Column(name = "peso")
    private double peso;
    
    @Column(name = "estatura")
    private double estatura;
    
    @Column(name = "concorporal")
    private int concorporal;
    
    @Column(name = "id_animal")
    private Long idanimal;

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

	public Long getIdanimal() {
		return idanimal;
	}

	public void setIdanimal(Long idanimal) {
		this.idanimal = idanimal;
	}

	 

    
   
}
