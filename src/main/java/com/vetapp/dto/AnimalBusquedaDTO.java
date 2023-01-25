package com.vetapp.dto;

import java.util.Date;
import java.util.List;

public class AnimalBusquedaDTO extends BaseModelDTO {

    private Long id;

    private Long categoriaReproduccionId;

    private Long categoriaProduccionId;

    private String arete;

    private Long razaId;

    private Long origenId;

    private Date fechanacimiento;

    private Date  fechaultimoparto;

    private Long estadoreproductivoId;

    private Long estadoproductivoId;

    private Long corralId;

    private String sexo;

    private Integer numeroparto;

    private Long padreId;

    private Long madreId;

    private double precio;

    private boolean muerto;

    private boolean venta;
    
    private List<MedicionDTO> medicion;
    
    
    
    

    public List<MedicionDTO> getMedicion() {
		return medicion;
	}

	public void setMedicion(List<MedicionDTO> medicion) {
		this.medicion = medicion;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoriaReproduccionId() {
		return categoriaReproduccionId;
	}

	public void setCategoriaReproduccionId(Long categoriaReproduccionId) {
		this.categoriaReproduccionId = categoriaReproduccionId;
	}

	public Long getCategoriaProduccionId() {
		return categoriaProduccionId;
	}

	public void setCategoriaProduccionId(Long categoriaProduccionId) {
		this.categoriaProduccionId = categoriaProduccionId;
	}

	public String getArete() {
        return arete;
    }

    public void setArete(String arete) {
        this.arete = arete;
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

    public Long getEstadoproductivoId() {
        return estadoproductivoId;
    }

    public void setEstadoproductivoId(Long estadoproductivoId) {
        this.estadoproductivoId = estadoproductivoId;
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

    public boolean getMuerto() {
        return muerto;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }

    public boolean getVenta() {
        return venta;
    }

    public void setVenta(boolean venta) {
        this.venta = venta;
    }

}
