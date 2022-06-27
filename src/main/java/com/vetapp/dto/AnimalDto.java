package com.vetapp.dto;

import java.util.Date;

public class AnimalDto extends BaseModelDto {

    private Long id;

    private Long categoriaId;

    private String arete;

    private String nombre;

    private Long razaId;

    private Long origenId;

    private Date fechanacimiento;

    private Date  fechaultimoparto;

    private Long estadoreproductivoId;

    private Long estadoprodutivoId;

    private Long corralId;

    private String sexo;

    private Integer numeroparto;

    private Long padreId;

    private Long madreId;

    private double precio;

    private Integer muerto;

    private Integer venta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getArete() {
        return arete;
    }

    public void setArete(String arete) {
        this.arete = arete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getRazaId() {
        return razaId;
    }

    public void setRazaId(Long razaId) {
        this.razaId = razaId;
    }

    public Long getOrigenId() {
        return origenId;
    }

    public void setOrigenId(Long origenId) {
        this.origenId = origenId;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Date getFechaultimoparto() {
        return fechaultimoparto;
    }

    public void setFechaultimoparto(Date fechaultimoparto) {
        this.fechaultimoparto = fechaultimoparto;
    }

    public Long getEstadoreproductivoId() {
        return estadoreproductivoId;
    }

    public void setEstadoreproductivoId(Long estadoreproductivoId) {
        this.estadoreproductivoId = estadoreproductivoId;
    }

    public Long getEstadoprodutivoId() {
        return estadoprodutivoId;
    }

    public void setEstadoprodutivoId(Long estadoprodutivoId) {
        this.estadoprodutivoId = estadoprodutivoId;
    }

    public Long getCorralId() {
        return corralId;
    }

    public void setCorralId(Long corralId) {
        this.corralId = corralId;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getNumeroparto() {
        return numeroparto;
    }

    public void setNumeroparto(Integer numeroparto) {
        this.numeroparto = numeroparto;
    }

    public Long getPadreId() {
        return padreId;
    }

    public void setPadreId(Long padreId) {
        this.padreId = padreId;
    }

    public Long getMadreId() {
        return madreId;
    }

    public void setMadreId(Long madreId) {
        this.madreId = madreId;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getMuerto() {
        return muerto;
    }

    public void setMuerto(Integer muerto) {
        this.muerto = muerto;
    }

    public Integer getVenta() {
        return venta;
    }

    public void setVenta(Integer venta) {
        this.venta = venta;
    }

}
