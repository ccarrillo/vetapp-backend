package com.vetapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produccionleche", schema = "vet")
public class ProduccionLeche extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="vet.produccionleche_id_seq",sequenceName="vet.produccionleche_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.produccionleche_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "racionternero",precision= 12, scale= 2)
    private double racionternero;

    @Column(name = "ventacontado",precision= 12, scale= 2)
    private double ventacontado;

    @Column(name = "ventainterna",precision= 12, scale= 2)
    private double ventainterna;
    
    @Column(name = "antibmastitis",precision= 12, scale= 2)
    private double antibmastitis;

    @Column(name = "ventaexterna",precision= 12, scale= 2)
    private double ventaexterna;

    @Column(name = "precio",precision= 12, scale= 2)
    private double precio;
    
    @Column(name = "diferencia",precision= 12, scale= 2)
    private double diferencia;
    
    @Column(name = "totallitros",precision= 12, scale= 2)
    private double totallitros;
    
    @Column(name = "ordeno")
    private Integer ordeno;
    
    @Column(name = "establo")
    private Integer establo;

    @Column(name = "secas")
    private Integer secas;
    
    @Column(name = "promordeno",precision= 12, scale= 2)
    private double promordeno;
    
    @Column(name = "promestablo",precision= 12, scale= 2)
    private double promestablo;

    @Column(name = "grasa",precision= 12, scale= 2)
    private double grasa;

    @Column(name = "proteina",precision= 12, scale= 2)
    private double proteina;

    @Column(name = "ufc",precision= 12, scale= 2)
    private double ufc;

    @Column(name = "ccss",precision= 12, scale= 2)
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
