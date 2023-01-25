package com.vetapp.dto;

import java.util.List;

import com.vetapp.model.BaseModel;

public class GrupoEventoDTO extends BaseModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nombre;
	
    private Long padre ;
    
    private Long level ;
    
    private List<GrupoEventoDTO> children;
    
    public GrupoEventoDTO() {
    	
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

	public List<GrupoEventoDTO> getChildren() {
		return children;
	}

	public void setChildren(List<GrupoEventoDTO> children) {
		this.children = children;
	}
    
    

}
