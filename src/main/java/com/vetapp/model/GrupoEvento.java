package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "grupoevento", schema = "vet")
@Entity
public class GrupoEvento extends BaseModel {

	private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

     
	 @Column(name = "nombre",length = 50)
	 private String nombre;
	 
	 @Column(name = "nombredetallado")
	 private String nombredetallado;
	
    @Column(name = "padre")
    private Long padre ;
    
    @Column(name = "level")
    private Long level ;
    
    
    
    public GrupoEvento() {
    	
    }

    public GrupoEvento(Long id, String nombre, String nombredetallado, Long padre, Long level) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombredetallado = nombredetallado;
		this.padre = padre;
		this.level = level;
	}

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
	
	

	public String getNombredetallado() {
		return nombredetallado;
	}

	public void setNombredetallado(String nombredetallado) {
		this.nombredetallado = nombredetallado;
	}

	public Long getPadre() {
		return padre;
	}

	public void setPadre(Long padre) {
		this.padre = padre;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}
    
    
    
    

}
