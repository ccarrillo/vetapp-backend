package com.vetapp.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "pesadoleche", schema = "vet")
@Entity
public class PesadoLeche extends BaseModel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long idpesado;
	
	@Column(name="pesado")
	private double pesado;
	
	@Column(name="animalid")
	private Long animalid;
	
	@Column(name="fechapesado")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar  fechapesado;
	
	
	/*@Column(name="eliminado")
	private byte eliminado;*///
	
	@Column(name="turnoid")
	private Long turnoid;
	
	@Column(name="idgrupoanimal")
	private Long idgrupoanimal;
	
	@Transient
	private String arete;
	

	
	@Transient
	private String contador;
	

	public Long getIdpesado() {
		return idpesado;
	}

	public void setIdpesado(Long idpesado) {
		this.idpesado = idpesado;
	}

	public double getPesado() {
		return pesado;
	}

	public void setPesado(double pesado) {
		this.pesado = pesado;
	}

	public Long getAnimalid() {
		return animalid;
	}

	public void setAnimalid(Long animalid) {
		this.animalid = animalid;
	}

	public Calendar getFechapesado() {
		return fechapesado;
	}

	public void setFechapesado(Calendar fechapesado) {
		this.fechapesado = fechapesado;
	}
    
	
	
	/*public Long getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(Long usuarioid) {
		this.usuarioid = usuarioid;
	}

	public byte getEliminado() {
		return eliminado;
	}

	public void setEliminado(byte eliminado) {
		this.eliminado = eliminado;
	}*/

     
	

	public String getArete() {
		return arete;
	}

	public Long getIdgrupoanimal() {
		return idgrupoanimal;
	}

	public void setIdgrupoanimal(Long idgrupoanimal) {
		this.idgrupoanimal = idgrupoanimal;
	}

	public Long getTurnoid() {
		return turnoid;
	}

	public void setTurnoid(Long turnoid) {
		this.turnoid = turnoid;
	}

	public void setArete(String arete) {
		this.arete = arete;
	}

	public String getContador() {
		return contador;
	}

	public void setContador(String contador) {
		this.contador = contador;
	}
	
	

}
