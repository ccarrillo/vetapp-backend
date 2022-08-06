package com.vetapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "alimento", schema = "vet")
@Entity
public class Alimento extends BaseModel {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="vet.alimento_id_seq",sequenceName="vet.alimento_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.alimento_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;
    
    @Column(name = "abreviatura", length = 50)
    private String abreviatura;
    
    
    @Column(name = "precio_insumo", length = 20)
    private String precio_insumo;
    
    @Column(name = "porc_ms", length = 20)
    private String porc_ms;
    
    @Column(name = "altar1",precision= 12, scale= 2)
    private double altar1;
    
    @Column(name = "altar2",precision= 12, scale= 2)
    private double altar2;
    
    @Column(name = "ruta_unica",precision= 12, scale= 2)
    private double ruta_unica;
    
    @Column(name = "preparto",precision= 12, scale= 2)
    private double preparto;
   
    @Column(name = "secas",precision= 12, scale= 2)
    private double secas;
    
    @Column(name = "machos",precision= 12, scale= 2)
    private double machos;
    
    @Column(name = "cuna_destetado",precision= 12, scale= 2)
    private double cuna_destetado;
    
    @Column(name = "de3a6m",precision= 12, scale= 2)
    private double de3a6m;
    
    @Column(name = "de6a12m",precision= 12, scale= 2)
    private double de6a12m;
    
    @Column(name = "de12amas",precision= 12, scale= 2)
    private double de12amas;
    
    @Column(name = "consumo_dia",precision= 12, scale= 2)
    private double consumo_dia;
    
    @Column(name = "paltar1",precision= 12, scale= 2)
    private double paltar1;
    
    @Column(name = "paltar2",precision= 12, scale= 2)
    private double paltar2;
    
    @Column(name = "pruta_unica",precision= 12, scale= 2)
    private double pruta_unica;
    
    @Column(name = "ppreparto",precision= 12, scale= 2)
    private double ppreparto;
   
    @Column(name = "psecas",precision= 12, scale= 2)
    private double psecas;
    
    @Column(name = "pmachos",precision= 12, scale= 2)
    private double pmachos;
    
    @Column(name = "pcuna_destetado",precision= 12, scale= 2)
    private double pcuna_destetado;
    
    @Column(name = "pde3a6m",precision= 12, scale= 2)
    private double pde3a6m;
    
    @Column(name = "pde6a12m",precision= 12, scale= 2)
    private double pde6a12m;
    
    @Column(name = "pde12amas",precision= 12, scale= 2)
    private double pde12amas;
    
    @Column(name = "pconsumo_dia",precision= 12, scale= 2)
    private double pconsumo_dia;
    
    @Column(name = "fecha")
    private Date fecha;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getPrecio_insumo() {
		return precio_insumo;
	}

	public void setPrecio_insumo(String precio_insumo) {
		this.precio_insumo = precio_insumo;
	}

	public String getPorc_ms() {
		return porc_ms;
	}

	public void setPorc_ms(String porc_ms) {
		this.porc_ms = porc_ms;
	}

	public double getAltar1() {
		return altar1;
	}

	public void setAltar1(double altar1) {
		this.altar1 = altar1;
	}

	public double getAltar2() {
		return altar2;
	}

	public void setAltar2(double altar2) {
		this.altar2 = altar2;
	}

	public double getRuta_unica() {
		return ruta_unica;
	}

	public void setRuta_unica(double ruta_unica) {
		this.ruta_unica = ruta_unica;
	}

	public double getPreparto() {
		return preparto;
	}

	public void setPreparto(double preparto) {
		this.preparto = preparto;
	}

	public double getSecas() {
		return secas;
	}

	public void setSecas(double secas) {
		this.secas = secas;
	}

	public double getMachos() {
		return machos;
	}

	public void setMachos(double machos) {
		this.machos = machos;
	}

	public double getCuna_destetado() {
		return cuna_destetado;
	}

	public void setCuna_destetado(double cuna_destetado) {
		this.cuna_destetado = cuna_destetado;
	}

	public double getDe3a6m() {
		return de3a6m;
	}

	public void setDe3a6m(double de3a6m) {
		this.de3a6m = de3a6m;
	}

	public double getDe6a12m() {
		return de6a12m;
	}

	public void setDe6a12m(double de6a12m) {
		this.de6a12m = de6a12m;
	}

	public double getDe12amas() {
		return de12amas;
	}

	public void setDe12amas(double de12amas) {
		this.de12amas = de12amas;
	}

	public double getConsumo_dia() {
		return consumo_dia;
	}

	public void setConsumo_dia(double consumo_dia) {
		this.consumo_dia = consumo_dia;
	}

	public double getPaltar1() {
		return paltar1;
	}

	public void setPaltar1(double paltar1) {
		this.paltar1 = paltar1;
	}

	public double getPaltar2() {
		return paltar2;
	}

	public void setPaltar2(double paltar2) {
		this.paltar2 = paltar2;
	}

	public double getPruta_unica() {
		return pruta_unica;
	}

	public void setPruta_unica(double pruta_unica) {
		this.pruta_unica = pruta_unica;
	}

	public double getPpreparto() {
		return ppreparto;
	}

	public void setPpreparto(double ppreparto) {
		this.ppreparto = ppreparto;
	}

	public double getPsecas() {
		return psecas;
	}

	public void setPsecas(double psecas) {
		this.psecas = psecas;
	}

	public double getPmachos() {
		return pmachos;
	}

	public void setPmachos(double pmachos) {
		this.pmachos = pmachos;
	}

	public double getPcuna_destetado() {
		return pcuna_destetado;
	}

	public void setPcuna_destetado(double pcuna_destetado) {
		this.pcuna_destetado = pcuna_destetado;
	}

	public double getPde3a6m() {
		return pde3a6m;
	}

	public void setPde3a6m(double pde3a6m) {
		this.pde3a6m = pde3a6m;
	}

	public double getPde6a12m() {
		return pde6a12m;
	}

	public void setPde6a12m(double pde6a12m) {
		this.pde6a12m = pde6a12m;
	}

	public double getPde12amas() {
		return pde12amas;
	}

	public void setPde12amas(double pde12amas) {
		this.pde12amas = pde12amas;
	}

	public double getPconsumo_dia() {
		return pconsumo_dia;
	}

	public void setPconsumo_dia(double pconsumo_dia) {
		this.pconsumo_dia = pconsumo_dia;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
    
    
    


}
