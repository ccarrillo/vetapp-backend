package com.vetapp.dto;

import java.util.Date;

import javax.persistence.Column;



public class AnimalDTO extends BaseModelDTO {

    private Long id;

    private Long categoriaReproduccionId;

    private Long categoriaProduccionId;

    private String arete;
    
    private String otraIdentificacion;

    private Long razaId;

    private Long origenId;

    private Date fechanacimiento;

    private Date  fechaultimoparto;

    private Date fechadestete;
    
    private Date fechacastracion;

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
    
    private String marcaizquierda;

    private String marcaderecha;

    private String color;
   
    private String marcadistintiva;
    
    private String anotaciones;
    
    private Long propositoId;

    private Integer pureza;
    
    private Long idGrupoAnimal;
    
    private boolean noservir;
    
    private String otraIdentificacionMadre;

    private String otraIdentificacionPadre;

    private String radioMadre;
    
    private String radioPadre;
    

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
    
    

    public String getOtraIdentificacion() {
		return otraIdentificacion;
	}

	public void setOtraIdentificacion(String otraIdentificacion) {
		this.otraIdentificacion = otraIdentificacion;
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
    
    

    public Date getFechadestete() {
		return fechadestete;
	}

	public void setFechadestete(Date fechadestete) {
		this.fechadestete = fechadestete;
	}

	public Date getFechacastracion() {
		return fechacastracion;
	}

	public void setFechacastracion(Date fechacastracion) {
		this.fechacastracion = fechacastracion;
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

	public String getMarcaizquierda() {
		return marcaizquierda;
	}

	public void setMarcaizquierda(String marcaizquierda) {
		this.marcaizquierda = marcaizquierda;
	}

	public String getMarcaderecha() {
		return marcaderecha;
	}

	public void setMarcaderecha(String marcaderecha) {
		this.marcaderecha = marcaderecha;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarcadistintiva() {
		return marcadistintiva;
	}

	public void setMarcadistintiva(String marcadistintiva) {
		this.marcadistintiva = marcadistintiva;
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	public Long getPropositoId() {
		return propositoId;
	}

	public void setPropositoId(Long propositoId) {
		this.propositoId = propositoId;
	}

	public Integer getPureza() {
		return pureza;
	}

	public void setPureza(Integer pureza) {
		this.pureza = pureza;
	}

	public Long getIdGrupoAnimal() {
		return idGrupoAnimal;
	}

	public void setIdGrupoAnimal(Long idGrupoAnimal) {
		this.idGrupoAnimal = idGrupoAnimal;
	}

	public boolean isNoservir() {
		return noservir;
	}

	public void setNoservir(boolean noservir) {
		this.noservir = noservir;
	}

	public String getOtraIdentificacionMadre() {
		return otraIdentificacionMadre;
	}

	public void setOtraIdentificacionMadre(String otraIdentificacionMadre) {
		this.otraIdentificacionMadre = otraIdentificacionMadre;
	}

	public String getOtraIdentificacionPadre() {
		return otraIdentificacionPadre;
	}

	public void setOtraIdentificacionPadre(String otraIdentificacionPadre) {
		this.otraIdentificacionPadre = otraIdentificacionPadre;
	}

	public String getRadioMadre() {
		return radioMadre;
	}

	public void setRadioMadre(String radioMadre) {
		this.radioMadre = radioMadre;
	}

	public String getRadioPadre() {
		return radioPadre;
	}

	public void setRadioPadre(String radioPadre) {
		this.radioPadre = radioPadre;
	}
   
    
    
}
