package com.vetapp.dto;

public class DetalleTipoEventoDTO extends BaseModelDTO {


    private Long id;

    private String nombreDetalleTipoEvento;

    private String abreviacion;

    private String datotexto;

    private String datonumeroentero;

    private String datonumerodecimal;

    private String combosseleccionables;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDetalleTipoEvento() {
        return nombreDetalleTipoEvento;
    }

    public void setNombreDetalleTipoEvento(String nombreDetalleTipoEvento) {
        this.nombreDetalleTipoEvento = nombreDetalleTipoEvento;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    public String getDatotexto() {
        return datotexto;
    }

    public void setDatotexto(String datotexto) {
        this.datotexto = datotexto;
    }

    public String getDatonumeroentero() {
        return datonumeroentero;
    }

    public void setDatonumeroentero(String datonumeroentero) {
        this.datonumeroentero = datonumeroentero;
    }

    public String getDatonumerodecimal() {
        return datonumerodecimal;
    }

    public void setDatonumerodecimal(String datonumerodecimal) {
        this.datonumerodecimal = datonumerodecimal;
    }

    public String getCombosseleccionables() {
        return combosseleccionables;
    }

    public void setCombosseleccionables(String combosseleccionables) {
        this.combosseleccionables = combosseleccionables;
    }


}
