package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "grupoprotocolo", schema = "vet")
@Entity
public class GrupoProtocolo extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @SequenceGenerator(name="vet.grupoprotocolo_id_seq",sequenceName="vet.grupoprotocolo_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.grupoprotocolo_id_seq")
    @Column(name = "id")
    private Long id;
 
     
	 @Column(name = "nombre",length = 50)
	 private String nombre;
	
    @Column(name = "padre")
    private Long padre ;
    
    @Column(name = "level")
    private Long level ;

    public GrupoProtocolo() {
    	
    }
    
	public GrupoProtocolo(Long id, String nombre, Long padre, Long level) {
		super();
		this.id = id;
		this.nombre = nombre;
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
