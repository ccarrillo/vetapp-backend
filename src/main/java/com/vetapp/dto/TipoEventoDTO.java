package com.vetapp.dto;

import java.util.List;



public class TipoEventoDTO extends BaseModelDTO {

    private Long id;

    private String nombreEvento;

    private double precio;

    private String abreviacion;

    private Long grupoEventoId;
    
    private Long idGrupoMover;
    
    private Long idEventoRecordatorio;
    
    private List<DetalleTipoEventoDTO> listaDetallleTipoEventoDTO;
    
    private List<RecordatorioEventoDTO> listaRecordatorioEventoDTO;
    
    private boolean checkgrupoanimal;
    
    private boolean checktipoevento;
    
    private String nombreGrupo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

	public Long getGrupoEventoId() {
		return grupoEventoId;
	}

	public void setGrupoEventoId(Long grupoEventoId) {
		this.grupoEventoId = grupoEventoId;
	}

	public Long getIdGrupoMover() {
		return idGrupoMover;
	}

	public void setIdGrupoMover(Long idGrupoMover) {
		this.idGrupoMover = idGrupoMover;
	}

	public Long getIdEventoRecordatorio() {
		return idEventoRecordatorio;
	}

	public void setIdEventoRecordatorio(Long idEventoRecordatorio) {
		this.idEventoRecordatorio = idEventoRecordatorio;
	}

	public List<DetalleTipoEventoDTO> getListaDetallleTipoEventoDTO() {
		return listaDetallleTipoEventoDTO;
	}

	public void setListaDetallleTipoEventoDTO(List<DetalleTipoEventoDTO> listaDetallleTipoEventoDTO) {
		this.listaDetallleTipoEventoDTO = listaDetallleTipoEventoDTO;
	}

	public List<RecordatorioEventoDTO> getListaRecordatorioEventoDTO() {
		return listaRecordatorioEventoDTO;
	}

	public void setListaRecordatorioEventoDTO(List<RecordatorioEventoDTO> listaRecordatorioEventoDTO) {
		this.listaRecordatorioEventoDTO = listaRecordatorioEventoDTO;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public boolean isCheckgrupoanimal() {
		return checkgrupoanimal;
	}

	public void setCheckgrupoanimal(boolean checkgrupoanimal) {
		this.checkgrupoanimal = checkgrupoanimal;
	}

	public boolean isChecktipoevento() {
		return checktipoevento;
	}

	public void setChecktipoevento(boolean checktipoevento) {
		this.checktipoevento = checktipoevento;
	}
	
	

    

}
