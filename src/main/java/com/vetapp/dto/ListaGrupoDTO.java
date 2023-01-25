package com.vetapp.dto;

import java.util.List;

public class ListaGrupoDTO {
    
	private Long id;
	private List<GrupoDTO> grupos;
	private boolean is_active;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<GrupoDTO> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<GrupoDTO> grupos) {
		this.grupos = grupos;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	

	
}
