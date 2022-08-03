package com.vetapp.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "pesadoleche", schema = "vet")
@Entity
public class PesadoLeche extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="vet.pesadoleche_id_seq",sequenceName="vet.pesadoleche_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.pesadoleche_id_seq")
    @Column(name = "id")
    private Long id;


    @Column(name = "pesado")
    private double pesado;

    @Column(name = "animalid")
    private Long animalid;

    @Column(name = "turnoid")
    private Long turnoid;

    @Column(name = "corralid")
    private Long corralid;

    @Column(name = "fechapesado")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
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
