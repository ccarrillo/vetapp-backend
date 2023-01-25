package com.vetapp.dto;

public class RecordatorioEventoDTO extends BaseModelDTO {

    private Long id;

    private Long idtipoevento;

    private Integer numerodias;
    
    private Long idtipoeventopadre;
    
    private boolean editado;
    
    private boolean eliminado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

	public Long getIdtipoeventopadre() {
		return idtipoeventopadre;
	}

	public void setIdtipoeventopadre(Long idtipoeventopadre) {
		this.idtipoeventopadre = idtipoeventopadre;
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
