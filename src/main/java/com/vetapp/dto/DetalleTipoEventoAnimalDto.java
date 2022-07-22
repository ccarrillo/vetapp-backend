package com.vetapp.dto;

import java.util.Date;

public class DetalleTipoEventoAnimalDto extends BaseModelDto {

    private Long id;

    private Long idDetalleTipoEvento;

    private String detallesTipoEvento;

    private Date fechaDetalle;

    private Long idEmpleado;

    private Long estadoRecordatorio;

    private Date fechaRecordatorio;

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
