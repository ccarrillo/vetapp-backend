package com.vetapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "alimento", schema = "vet")
@Entity
public class Racion extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idalimento")
    private Long idAlimento;

    @Column(name = "fecharacion")
    private Date fechaRacion;

    @Column(name = "precioalimento")
    private double precioAlimento;

    @Column(name = "cantidadvacaseca")
    private Integer cantidadVacaSeca;

    @Column(name = "kgvacaseca")
    private double kgVacaSeca;

    @Column(name = "precioseca")
    private double precioSeca;

    @Column(name = "cantidadvacapparto")
    private Integer cantidadVacaPParto;

    @Column(name = "kgvacapparto")
    private double kgVacaPParto;

    @Column(name = "preciopparto")
    private double precioPParto;


    @Column(name = "cantidadvacadestete")
    private Integer cantidadVacaDestete;

    @Column(name = "kgvacadestete")
    private double kgVacaDestete;

    @Column(name = "preciodestete")
    private double precioDestete;


    @Column(name = "cantidadvaca3a6meses")
    private Integer cantidadVaca3a6Meses;

    @Column(name = "kgvaca3a6meses")
    private double kgVaca3a6Meses;

    @Column(name = "precio3a6meses")
    private double precio3a6Meses;


    @Column(name = "cantidadvaca6a12meses")
    private Integer cantidadVaca6a12Meses;

    @Column(name = "kgvaca6a12meses")
    private double kgVaca6a12Meses;

    @Column(name = "precio6a12meses")
    private double precio6a12Meses;


    @Column(name = "cantidadvaca12mesesamas")
    private Integer cantidadVaca12MesesaMas;

    @Column(name = "kgvaca12mesesamas")
    private double kgVaca12MesesaMas;

    @Column(name = "precio12mesesamas")
    private double precio12MesesaMas;


    @Column(name = "cantidadvacaproduccion1")
    private Integer cantidadVacaProduccion1;

    @Column(name = "kgvacaproduccion1")
    private double kgVacaProduccion1;

    @Column(name = "precioproduccion1")
    private double precioProduccion1;


    @Column(name = "cantidadvacaproduccion2")
    private Integer cantidadVacaProduccion2;

    @Column(name = "kgvacaproduccion2")
    private double kgVacaProduccion2;

    @Column(name = "precioproduccion2")
    private double precioProduccion2;


    @Column(name = "cantidadvacatoro")
    private Integer cantidadVacaToro;

    @Column(name = "kgvacatoro")
    private double kgVacaToro;

    @Column(name = "preciotoro")
    private double precioToro;


    @Column(name = "cantidadvacatotal")
    private Integer cantidadVacaTotal;

    @Column(name = "kgvacaconsumototal")
    private double kgVacaConsumoTotal;

    @Column(name = "precioTotal")
    private double precioTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Long idAlimento) {
        this.idAlimento = idAlimento;
    }


    public Date getFechaRacion() {
        return fechaRacion;
    }

    public void setFechaRacion(Date fechaRacion) {
        this.fechaRacion = fechaRacion;
    }

    public double getPrecioAlimento() {
        return precioAlimento;
    }

    public void setPrecioAlimento(double precioAlimento) {
        this.precioAlimento = precioAlimento;
    }

    public Integer getCantidadVacaSeca() {
        return cantidadVacaSeca;
    }

    public void setCantidadVacaSeca(Integer cantidadVacaSeca) {
        this.cantidadVacaSeca = cantidadVacaSeca;
    }

    public double getKgVacaSeca() {
        return kgVacaSeca;
    }

    public void setKgVacaSeca(double kgVacaSeca) {
        this.kgVacaSeca = kgVacaSeca;
    }

    public double getPrecioSeca() {
        return precioSeca;
    }

    public void setPrecioSeca(double precioSeca) {
        this.precioSeca = precioSeca;
    }

    public Integer getCantidadVacaPParto() {
        return cantidadVacaPParto;
    }

    public void setCantidadVacaPParto(Integer cantidadVacaPParto) {
        this.cantidadVacaPParto = cantidadVacaPParto;
    }

    public double getKgVacaPParto() {
        return kgVacaPParto;
    }

    public void setKgVacaPParto(double kgVacaPParto) {
        this.kgVacaPParto = kgVacaPParto;
    }

    public double getPrecioPParto() {
        return precioPParto;
    }

    public void setPrecioPParto(double precioPParto) {
        this.precioPParto = precioPParto;
    }

    public Integer getCantidadVacaDestete() {
        return cantidadVacaDestete;
    }

    public void setCantidadVacaDestete(Integer cantidadVacaDestete) {
        this.cantidadVacaDestete = cantidadVacaDestete;
    }

    public double getKgVacaDestete() {
        return kgVacaDestete;
    }

    public void setKgVacaDestete(double kgVacaDestete) {
        this.kgVacaDestete = kgVacaDestete;
    }

    public double getPrecioDestete() {
        return precioDestete;
    }

    public void setPrecioDestete(double precioDestete) {
        this.precioDestete = precioDestete;
    }

    public Integer getCantidadVaca3a6Meses() {
        return cantidadVaca3a6Meses;
    }

    public void setCantidadVaca3a6Meses(Integer cantidadVaca3a6Meses) {
        this.cantidadVaca3a6Meses = cantidadVaca3a6Meses;
    }

    public double getKgVaca3a6Meses() {
        return kgVaca3a6Meses;
    }

    public void setKgVaca3a6Meses(double kgVaca3a6Meses) {
        this.kgVaca3a6Meses = kgVaca3a6Meses;
    }

    public double getPrecio3a6Meses() {
        return precio3a6Meses;
    }

    public void setPrecio3a6Meses(double precio3a6Meses) {
        this.precio3a6Meses = precio3a6Meses;
    }

    public Integer getCantidadVaca6a12Meses() {
        return cantidadVaca6a12Meses;
    }

    public void setCantidadVaca6a12Meses(Integer cantidadVaca6a12Meses) {
        this.cantidadVaca6a12Meses = cantidadVaca6a12Meses;
    }

    public double getKgVaca6a12Meses() {
        return kgVaca6a12Meses;
    }

    public void setKgVaca6a12Meses(double kgVaca6a12Meses) {
        this.kgVaca6a12Meses = kgVaca6a12Meses;
    }

    public double getPrecio6a12Meses() {
        return precio6a12Meses;
    }

    public void setPrecio6a12Meses(double precio6a12Meses) {
        this.precio6a12Meses = precio6a12Meses;
    }

    public Integer getCantidadVaca12MesesaMas() {
        return cantidadVaca12MesesaMas;
    }

    public void setCantidadVaca12MesesaMas(Integer cantidadVaca12MesesaMas) {
        this.cantidadVaca12MesesaMas = cantidadVaca12MesesaMas;
    }

    public double getKgVaca12MesesaMas() {
        return kgVaca12MesesaMas;
    }

    public void setKgVaca12MesesaMas(double kgVaca12MesesaMas) {
        this.kgVaca12MesesaMas = kgVaca12MesesaMas;
    }

    public double getPrecio12MesesaMas() {
        return precio12MesesaMas;
    }

    public void setPrecio12MesesaMas(double precio12MesesaMas) {
        this.precio12MesesaMas = precio12MesesaMas;
    }

    public Integer getCantidadVacaProduccion1() {
        return cantidadVacaProduccion1;
    }

    public void setCantidadVacaProduccion1(Integer cantidadVacaProduccion1) {
        this.cantidadVacaProduccion1 = cantidadVacaProduccion1;
    }

    public double getKgVacaProduccion1() {
        return kgVacaProduccion1;
    }

    public void setKgVacaProduccion1(double kgVacaProduccion1) {
        this.kgVacaProduccion1 = kgVacaProduccion1;
    }

    public double getPrecioProduccion1() {
        return precioProduccion1;
    }

    public void setPrecioProduccion1(double precioProduccion1) {
        this.precioProduccion1 = precioProduccion1;
    }

    public Integer getCantidadVacaProduccion2() {
        return cantidadVacaProduccion2;
    }

    public void setCantidadVacaProduccion2(Integer cantidadVacaProduccion2) {
        this.cantidadVacaProduccion2 = cantidadVacaProduccion2;
    }

    public double getKgVacaProduccion2() {
        return kgVacaProduccion2;
    }

    public void setKgVacaProduccion2(double kgVacaProduccion2) {
        this.kgVacaProduccion2 = kgVacaProduccion2;
    }

    public double getPrecioProduccion2() {
        return precioProduccion2;
    }

    public void setPrecioProduccion2(double precioProduccion2) {
        this.precioProduccion2 = precioProduccion2;
    }

    public Integer getCantidadVacaToro() {
        return cantidadVacaToro;
    }

    public void setCantidadVacaToro(Integer cantidadVacaToro) {
        this.cantidadVacaToro = cantidadVacaToro;
    }

    public double getKgVacaToro() {
        return kgVacaToro;
    }

    public void setKgVacaToro(double kgVacaToro) {
        this.kgVacaToro = kgVacaToro;
    }

    public double getPrecioToro() {
        return precioToro;
    }

    public void setPrecioToro(double precioToro) {
        this.precioToro = precioToro;
    }

    public Integer getCantidadVacaTotal() {
        return cantidadVacaTotal;
    }

    public void setCantidadVacaTotal(Integer cantidadVacaTotal) {
        this.cantidadVacaTotal = cantidadVacaTotal;
    }

    public double getKgVacaConsumoTotal() {
        return kgVacaConsumoTotal;
    }

    public void setKgVacaConsumoTotal(double kgVacaConsumoTotal) {
        this.kgVacaConsumoTotal = kgVacaConsumoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }


}
