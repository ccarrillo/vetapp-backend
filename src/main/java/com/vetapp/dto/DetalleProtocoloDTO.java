package com.vetapp.dto;

import javax.persistence.Column;

import com.vetapp.model.BaseModel;

public class DetalleProtocoloDTO extends BaseModel {
   
	 private Long id;
		
	 @Column(name = "idprotocolo")
	 private Long idprotocolo;

    @Column(name = "idtipoevento")
    private Long idtipoevento;

    @Column(name = "numerodias")
    private Integer numerodias;

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
    
    
    
    
    
}
