package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalletipoevento", schema = "vet")
public class DetalleTipoEvento extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombreDetalleTipoEvento;

    @Column(name = "abreviacion", length = 7)
    private String abreviacion;

    @Column(name = "datotexto", length = 300)
    private String datotexto;

    @Column(name = "datonumeroentero", length = 100)
    private String datonumeroentero;

    @Column(name = "datonumerodecimal", length = 100)
    private String datonumerodecimal;

    @Column(name = "combosseleccionables", length = 300)
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
