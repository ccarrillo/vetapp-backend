package com.vetapp.model;

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

@Entity
@Table(name = "detalletipoeventoanimal", schema = "vet")
public class DetalleTipoEventoAnimal extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombre;
    
    @Column(name = "nombrevalor", length = 100)
    private String nombrevalor;

    @Column(name = "tdesde")
    private   String tdesde;

    @Column(name = "thasta")
    private String thasta;
 
    @Column(name = "combosseleccionables",length = 1200)
    private String combosseleccionables;
    
    
    @Column(name = "radioinformacion")
    private String radioInformacion;
    
    @Column(name = "requerido")
    private boolean requerido;

    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ideventoanimal", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private EventoAnimal ideventoanimal;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	


	public String getNombrevalor() {
		return nombrevalor;
	}


	public void setNombrevalor(String nombrevalor) {
		this.nombrevalor = nombrevalor;
	}


	public String getTdesde() {
		return tdesde;
	}


	public void setTdesde(String tdesde) {
		this.tdesde = tdesde;
	}


	public String getThasta() {
		return thasta;
	}


	public void setThasta(String thasta) {
		this.thasta = thasta;
	}


	public String getCombosseleccionables() {
		return combosseleccionables;
	}
	

	public void setCombosseleccionables(String combosseleccionables) {
		this.combosseleccionables = combosseleccionables;
	}


	public String getRadioInformacion() {
		return radioInformacion;
	}


	public void setRadioInformacion(String radioInformacion) {
		this.radioInformacion = radioInformacion;
	}


	public boolean isRequerido() {
		return requerido;
	}


	public void setRequerido(boolean requerido) {
		this.requerido = requerido;
	}


	public EventoAnimal getIdeventoanimal() {
		return ideventoanimal;
	}


	public void setIdeventoanimal(EventoAnimal ideventoanimal) {
		this.ideventoanimal = ideventoanimal;
	}

    
    


}
