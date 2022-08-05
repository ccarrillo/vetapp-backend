package com.vetapp.dto;

import java.util.Calendar;

public class ProduccionLecheDTO extends BaseModelDTO {

    private Long id;

    private Calendar fechaproduccion;

    private double racionternero;

    private double ventacontado;

    private double ventainterna;

    private double ventaexterna;

    private double precio;

    private double grasa;

    private double proteina;

    private double ufc;

    private double ccss;

    private Integer totalvacas;

    private Integer totalvacassecas;

    private double promproduccion;

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
