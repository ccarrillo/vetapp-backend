package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "inventariosemen", schema = "vet")
public class InventarioSemen extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="vet.inventariosemen_id_seq",sequenceName="vet.inventariosemen_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.inventariosemen_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "reproductornumero", length = 50)
    private String reproductorNumero;

    @Column(name = "numeroregistro", length = 50)
    private String numeroRegistro;

    @Column(name = "nombrenum", length = 50)
    private String nombreNum;

    @Column(name = "otro", length = 50)
    private String otro;

    @Column(name = "codigo", length = 50)
    private String codigo;

    @Column(name = "idraza")
    private Long idraza;

    @Column(name = "numpajuelasdisponibles")
    private Integer numPajuelasDisponibles;

    @Column(name = "precio")
    private double precio;

    @Column(name = "idpadre")
    private Long idPadre;

    @Column(name = "idmadre")
    private Long idMadre;

    @Column(name = "observacion", length = 150)
    private String observacion;

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

    public String getReproductorNumero() {
        return reproductorNumero;
    }

    public void setReproductorNumero(String reproductorNumero) {
        this.reproductorNumero = reproductorNumero;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getNombreNum() {
        return nombreNum;
    }

    public void setNombreNum(String nombreNum) {
        this.nombreNum = nombreNum;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getIdraza() {
        return idraza;
    }

    public void setIdraza(Long idraza) {
        this.idraza = idraza;
    }

    public Integer getNumPajuelasDisponibles() {
        return numPajuelasDisponibles;
    }

    public void setNumPajuelasDisponibles(Integer numPajuelasDisponibles) {
        this.numPajuelasDisponibles = numPajuelasDisponibles;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Long idPadre) {
        this.idPadre = idPadre;
    }

    public Long getIdMadre() {
        return idMadre;
    }

    public void setIdMadre(Long idMadre) {
        this.idMadre = idMadre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


}
