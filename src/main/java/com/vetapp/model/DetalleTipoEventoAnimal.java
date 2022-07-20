package com.vetapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalletipoeventoanimal", schema="vet")
public class DetalleTipoEventoAnimal extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
	
	@Column(name="iddetalletipoevento")
    private Long idDetalleTipoEvento;
	
	@Column(name = "detallestipoevento", length = 300)
	private String detallesTipoEvento;
	
    @Column(name="fechadetalle")
    private Date fechaDetalle;
    
    @Column(name="idempleado")
    private Long idEmpleado;
    
    @Column(name="estadorecordatorio")
    private Long estadoRecordatorio;
    
    @Column(name="fecharecordatorio")
    private Date fechaRecordatorio;
    
	@Column(name = "observaciones", length = 200)
	private String observaciones;

	public String getDetallesTipoEvento() {
		return detallesTipoEvento;
	}

	public void setDetallesTipoEvento(String detallesTipoEvento) {
		this.detallesTipoEvento = detallesTipoEvento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDetalleTipoEvento() {
		return idDetalleTipoEvento;
	}

	public void setIdDetalleTipoEvento(Long idDetalleTipoEvento) {
		this.idDetalleTipoEvento = idDetalleTipoEvento;
	}

	public Date getFechaDetalle() {
		return fechaDetalle;
	}

	public void setFechaDetalle(Date fechaDetalle) {
		this.fechaDetalle = fechaDetalle;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Long getEstadoRecordatorio() {
		return estadoRecordatorio;
	}

	public void setEstadoRecordatorio(Long estadoRecordatorio) {
		this.estadoRecordatorio = estadoRecordatorio;
	}

	public Date getFechaRecordatorio() {
		return fechaRecordatorio;
	}

	public void setFechaRecordatorio(Date fechaRecordatorio) {
		this.fechaRecordatorio = fechaRecordatorio;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
    

}
