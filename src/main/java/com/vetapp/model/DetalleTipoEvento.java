package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalletipoevento", schema = "vet")
public class DetalleTipoEvento extends BaseModel {

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

    @Column(name = "abreviacion", length = 7)
    private String abreviacion;

    @Column(name = "tdesde")
    private   String tdesde;

    @Column(name = "thasta")
    private String thasta;
 
    @Column(name = "combosseleccionables",length = 1200)
    private String combosseleccionables;
    
    /*@Column(name = "padremadre", length = 1)
    private String padremadre;*/
    
    @Column(name = "radioinformacion")
    private String radioInformacion;
    
    @Column(name = "requerido")
    private boolean requerido;

    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idtipoevento", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TipoEvento idTipoEvento;
    
 

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

	public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
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

	public TipoEvento getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(TipoEvento idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	
     
     
    
    

}
