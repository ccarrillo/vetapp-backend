package com.vetapp.dto;

public class RecordatorioEventoDTO extends BaseModelDTO {

    private Long id;

    private Long idtipoevento;

    private Integer numerodias;

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


}
