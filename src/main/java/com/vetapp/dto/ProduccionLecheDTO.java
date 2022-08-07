package com.vetapp.dto;

import java.util.Date;

public class ProduccionLecheDTO extends BaseModelDTO {

    private Long id;

    private Date fecha;

    private double racionternero;

    private double ventacontado;

    private double ventainterna;

    private double antibmastitis;

    private double ventaexterna;

    private double precio;

    private double diferencia;

    private double totallitros;

    private Integer ordeno;

    private Integer establo;

    private Integer secas;

    private double promordeno;

    private double promestablo;

    private double grasa;

    private double proteina;

    private double ufc;

    private double ccss;

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

	public double getAntibmastitis() {
		return antibmastitis;
	}

	public void setAntibmastitis(double antibmastitis) {
		this.antibmastitis = antibmastitis;
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

	public double getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(double diferencia) {
		this.diferencia = diferencia;
	}

	public double getTotallitros() {
		return totallitros;
	}

	public void setTotallitros(double totallitros) {
		this.totallitros = totallitros;
	}

	public Integer getOrdeno() {
		return ordeno;
	}

	public void setOrdeno(Integer ordeno) {
		this.ordeno = ordeno;
	}

	public Integer getEstablo() {
		return establo;
	}

	public void setEstablo(Integer establo) {
		this.establo = establo;
	}

	public Integer getSecas() {
		return secas;
	}

	public void setSecas(Integer secas) {
		this.secas = secas;
	}

	public double getPromordeno() {
		return promordeno;
	}

	public void setPromordeno(double promordeno) {
		this.promordeno = promordeno;
	}

	public double getPromestablo() {
		return promestablo;
	}

	public void setPromestablo(double promestablo) {
		this.promestablo = promestablo;
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
     
    
    
}
