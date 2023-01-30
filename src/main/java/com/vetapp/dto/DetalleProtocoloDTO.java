package com.vetapp.dto;

import com.vetapp.model.BaseModel;

public class DetalleProtocoloDTO extends BaseModel {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
		
	 private Long idprotocolo;

    private Long idtipoevento;

    private Integer numerodias;
    
    private boolean editado;
    
    private boolean eliminado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdprotocolo() {
		return idprotocolo;
	}

	public void setIdprotocolo(Long idprotocolo) {
		this.idprotocolo = idprotocolo;
	}

	public Long getIdtipoevento() {
		return idtipoevento;
	}

	public void setIdtipoevento(Long idtipoevento) {
		this.idtipoevento = idtipoevento;
	}

	public Integer getNumerodias() {
		return numerodias;
	}

	public void setNumerodias(Integer numerodias) {
		this.numerodias = numerodias;
	}

	public boolean isEditado() {
		return editado;
	}

	public void setEditado(boolean editado) {
		this.editado = editado;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
    
    
    
    
    
}
