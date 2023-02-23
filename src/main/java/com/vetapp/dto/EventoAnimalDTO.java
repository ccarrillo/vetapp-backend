package com.vetapp.dto;

import java.util.Date;
import java.util.List;



public class EventoAnimalDTO extends BaseModelDTO {

	private Long id;

    
    private Date fecha;
    

    private Long idempleado;


    private Long idtipoevento;

    private String anotacion;
    
    private Double costo;

    private String checkprotocolo;
  
    private Long idprotocolo;
    
    private AnimalDTO idAnimal;
    
    private String  nombreEvento;
	    
	private List<DetalleTipoEventoAnimalDTO> listaDetallleTipoEventoAnimalDTO;
	    
	private List<RecordatorioEventoAnimalDTO> listaRecordatorioEventoAnimalDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(Long idempleado) {
		this.idempleado = idempleado;
	}

	public Long getIdtipoevento() {
		return idtipoevento;
	}

	public void setIdtipoevento(Long idtipoevento) {
		this.idtipoevento = idtipoevento;
	}

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
    

	public String getCheckprotocolo() {
		return checkprotocolo;
	}

	public void setCheckprotocolo(String checkprotocolo) {
		this.checkprotocolo = checkprotocolo;
	}

	public Long getIdprotocolo() {
		return idprotocolo;
	}

	public void setIdprotocolo(Long idprotocolo) {
		this.idprotocolo = idprotocolo;
	}
	
	


	public AnimalDTO getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(AnimalDTO idAnimal) {
		this.idAnimal = idAnimal;
	}
	
	
	

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public List<DetalleTipoEventoAnimalDTO> getListaDetallleTipoEventoAnimalDTO() {
		return listaDetallleTipoEventoAnimalDTO;
	}

	public void setListaDetallleTipoEventoAnimalDTO(List<DetalleTipoEventoAnimalDTO> listaDetallleTipoEventoAnimalDTO) {
		this.listaDetallleTipoEventoAnimalDTO = listaDetallleTipoEventoAnimalDTO;
	}

	public List<RecordatorioEventoAnimalDTO> getListaRecordatorioEventoAnimalDTO() {
		return listaRecordatorioEventoAnimalDTO;
	}

	public void setListaRecordatorioEventoAnimalDTO(List<RecordatorioEventoAnimalDTO> listaRecordatorioEventoAnimalDTO) {
		this.listaRecordatorioEventoAnimalDTO = listaRecordatorioEventoAnimalDTO;
	}
	    
   
	    
	    

}
