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
    private String precioInsumo;
    
    @Column(name = "porc_ms", length = 20)
    private String porcMs;
    
    @Column(name = "alta_r1",precision= 12, scale= 2)
    private double altaR1;
    
    @Column(name = "alta_r2",precision= 12, scale= 2)
    private double altaR2;

	@Column(name = "alta_r3",precision= 12, scale= 2)
	private double altaR3;
    
    @Column(name = "ruta_unica",precision= 12, scale= 2)
    private double rutaUnica;
    
    @Column(name = "pre_parto",precision= 12, scale= 2)
    private double preParto;
   
    @Column(name = "secas",precision= 12, scale= 2)
    private double secas;
    
    @Column(name = "machos",precision= 12, scale= 2)
    private double machos;
    
    @Column(name = "cuna_destetado",precision= 12, scale= 2)
    private double cunaDestetado;
    
    @Column(name = "de3a6m",precision= 12, scale= 2)
    private double de3a6m;
    
    @Column(name = "de6a12m",precision= 12, scale= 2)
    private double de6a12m;
    
    @Column(name = "de12amas",precision= 12, scale= 2)
    private double de12amas;
    
    @Column(name = "consumo_dia",precision= 12, scale= 2)
    private double consumoDia;
    
    @Column(name = "palta_r1",precision= 12, scale= 2)
    private double paltaR1;
    
    @Column(name = "palta_r2",precision= 12, scale= 2)
    private double paltaR2;

	@Column(name = "palta_r3",precision= 12, scale= 2)
	private double paltaR3;

    @Column(name = "pruta_unica",precision= 12, scale= 2)
    private double prutaUnica;
    
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

    public String getPrecioInsumo() {
        return precioInsumo;
    }

    public void setPrecioInsumo(String precioInsumo) {
        this.precioInsumo = precioInsumo;
    }

    public String getPorcMs() {
        return porcMs;
    }

    public void setPorcMs(String porcMs) {
        this.porcMs = porcMs;
    }

    public double getAltaR1() {
        return altaR1;
    }

    public void setAltaR1(double altaR1) {
        this.altaR1 = altaR1;
    }

    public double getAltaR2() {
        return altaR2;
    }

    public void setAltaR2(double altaR2) {
        this.altaR2 = altaR2;
    }

    public double getAltaR3() {
        return altaR3;
    }

    public void setAltaR3(double altaR3) {
        this.altaR3 = altaR3;
    }

    public double getRutaUnica() {
        return rutaUnica;
    }

    public void setRutaUnica(double rutaUnica) {
        this.rutaUnica = rutaUnica;
    }

    public double getPreParto() {
        return preParto;
    }

    public void setPreParto(double preParto) {
        this.preParto = preParto;
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

    public double getCunaDestetado() {
        return cunaDestetado;
    }

    public void setCunaDestetado(double cunaDestetado) {
        this.cunaDestetado = cunaDestetado;
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

    public double getConsumoDia() {
        return consumoDia;
    }

    public void setConsumoDia(double consumoDia) {
        this.consumoDia = consumoDia;
    }

    public double getPaltaR1() {
        return paltaR1;
    }

    public void setPaltaR1(double paltaR1) {
        this.paltaR1 = paltaR1;
    }

    public double getPaltaR2() {
        return paltaR2;
    }

    public void setPaltaR2(double paltaR2) {
        this.paltaR2 = paltaR2;
    }

    public double getPaltaR3() {
        return paltaR3;
    }

    public void setPaltaR3(double paltaR3) {
        this.paltaR3 = paltaR3;
    }

    public double getPrutaUnica() {
        return prutaUnica;
    }

    public void setPrutaUnica(double prutaUnica) {
        this.prutaUnica = prutaUnica;
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
