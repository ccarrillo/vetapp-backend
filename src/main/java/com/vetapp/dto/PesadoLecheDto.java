package com.vetapp.dto;

import java.util.Calendar;

public class PesadoLecheDto extends BaseModelDto {

    private Long id;

    private double pesado;

    private Long animalid;

    private Long turnoid;

    private Long corralid;

    private Calendar fechapesado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPesado() {
        return pesado;
    }

    public void setPesado(double pesado) {
        this.pesado = pesado;
    }

    public Long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(Long animalid) {
        this.animalid = animalid;
    }

    public Long getTurnoid() {
        return turnoid;
    }

    public void setTurnoid(Long turnoid) {
        this.turnoid = turnoid;
    }

    public Long getCorralid() {
        return corralid;
    }

    public void setCorralid(Long corralid) {
        this.corralid = corralid;
    }

    public Calendar getFechapesado() {
        return fechapesado;
    }

    public void setFechapesado(Calendar fechapesado) {
        this.fechapesado = fechapesado;
    }


}
