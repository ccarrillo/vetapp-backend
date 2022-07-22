package com.vetapp.dto;

public class InventarioSemenDto extends BaseModelDto {

    private Long id;

    private String nombre;

    private String reproductorNumero;

    private String numeroRegistro;

    private String nombreNum;

    private String otro;

    private String codigo;

    private Long idraza;

    private Integer numPajuelasDisponibles;

    private double precio;

    private Long idPadre;

    private Long idMadre;

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
