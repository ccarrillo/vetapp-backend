package com.vetapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "animal")
@Entity
public class Animal extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoriaid")
    private Long categoriaId;

    @Column(name = "arete", length = 50)
    private String arete;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "razaid")
    private Long razaId;

    @Column(name = "origenid")
    private Long origenId;

    @Column(name="fechanacimiento")
    private Date fechanacimiento;

    @Column(name="fechaultimoparto")
    private Date  fechaultimoparto;

    @Column(name = "estadoreproductivoid")
    private Long estadoreproductivoId;

    @Column(name = "estadoprodutivoid")
    private Long estadoprodutivoId;

    @Column(name = "corralid")
    private Long corralId;

    @Column(name = "sexo", length = 1)
    private String sexo;

    @Column(name = "numeroparto")
    private Integer numeroparto;

    @Column(name = "padreid")
    private Long padreId;

    @Column(name = "madreid")
    private Long madreId;

    @Column(name = "precio")
    private double precio;

    @Column(name = "muerto")
    private Integer muerto;

    @Column(name = "venta")
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
