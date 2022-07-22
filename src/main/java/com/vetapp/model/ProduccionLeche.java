package com.vetapp.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "produccionleche", schema = "vet")
public class ProduccionLeche extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fechaproduccion")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar fechaproduccion;

    @Column(name = "racionternero")
    private double racionternero;

    @Column(name = "ventacontado")
    private double ventacontado;

    @Column(name = "ventainterna")
    private double ventainterna;

    @Column(name = "ventaexterna")
    private double ventaexterna;

    @Column(name = "precio")
    private double precio;


    @Column(name = "grasa")
    private double grasa;

    @Column(name = "proteina")
    private double proteina;

    @Column(name = "ufc")
    private double ufc;

    @Column(name = "ccss")
    private double ccss;

    @Column(name = "totalvacas")    //Grasa, proteína, ufc, ccss
    private Integer totalvacas;

    @Column(name = "totalvacassecas")
    private Integer totalvacassecas;

    @Column(name = "promproduccion")
    private double promproduccion;

    @Column(name = "promhato")
    private double promhato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaproduccion() {
        return fechaproduccion;
    }

    public void setFechaproduccion(Calendar fechaproduccion) {
        this.fechaproduccion = fechaproduccion;
    }

    public double getRacionternero() {
        return racionternero;
    }

    public void setRacionternero(double racionternero) {
        this.racionternero = racionternero;
    }

    public double getVentacontado() {
        return ventacontado;
    }

    public void setVentacontado(double ventacontado) {
        this.ventacontado = ventacontado;
    }

    public double getVentainterna() {
        return ventainterna;
    }

    public void setVentainterna(double ventainterna) {
        this.ventainterna = ventainterna;
    }

    public double getVentaexterna() {
        return ventaexterna;
    }

    public void setVentaexterna(double ventaexterna) {
        this.ventaexterna = ventaexterna;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public double getGrasa() {
        return grasa;
    }

    public void setGrasa(double grasa) {
        this.grasa = grasa;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public double getUfc() {
        return ufc;
    }

    public void setUfc(double ufc) {
        this.ufc = ufc;
    }

    public double getCcss() {
        return ccss;
    }

    public void setCcss(double ccss) {
        this.ccss = ccss;
    }

    public Integer getTotalvacas() {
        return totalvacas;
    }

    public void setTotalvacas(Integer totalvacas) {
        this.totalvacas = totalvacas;
    }

    public int getTotalvacassecas() {
        return totalvacassecas;
    }

    public void setTotalvacassecas(Integer totalvacassecas) {
        this.totalvacassecas = totalvacassecas;
    }

    public double getPromproduccion() {
        return promproduccion;
    }

    public void setPromproduccion(double promproduccion) {
        this.promproduccion = promproduccion;
    }

    public double getPromhato() {
        return promhato;
    }

    public void setPromhato(double promhato) {
        this.promhato = promhato;
    }


}
