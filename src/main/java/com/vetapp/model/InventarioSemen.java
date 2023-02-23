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
    @Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)

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

    @Column(name = "udc")
    private double udc;
    
    @Column(name = "milk_lbs")
    private double milkLbs;
    
    @Column(name = "grasa")
    private double grasa;
  
    @Column(name = "proteina")
    private double proteina;
    
    @Column(name = "merito_neto")
    private double meritoNeto;
    
    @Column(name = "idraza")
    private Long idraza;

    @Column(name = "numpajuelasdisponibles")
    private Integer numPajuelasDisponibles;

    @Column(name = "precio")
    private double precio;

    @Column(name = "idpadre")
    private Long idPadre;
    
    @Column(name = "otra_identificacion_padre")
    private String otraIdentificacionPadre;

    @Column(name = "idmadre")
    private Long idMadre;
    
    @Column(name = "otra_identificacion_madre")
    private String otraIdentificacionMadre;

    @Column(name = "observacion", length = 150)
    private String observacion;
    
    @Column(name = "id_grupo_inventario")
    private Long idGrupoInventario;
    
    @Column(name = "radio_madre")
    private String radioMadre;
    
    @Column(name = "radio_padre")
    private String radioPadre;

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

   

    public double getUdc() {
		return udc;
	}

	public void setUdc(double udc) {
		this.udc = udc;
	}

	public double getMilkLbs() {
		return milkLbs;
	}

	public void setMilkLbs(double milkLbs) {
		this.milkLbs = milkLbs;
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

	public double getMeritoNeto() {
		return meritoNeto;
	}

	public void setMeritoNeto(double meritoNeto) {
		this.meritoNeto = meritoNeto;
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

	public String getOtraIdentificacionPadre() {
		return otraIdentificacionPadre;
	}

	public void setOtraIdentificacionPadre(String otraIdentificacionPadre) {
		this.otraIdentificacionPadre = otraIdentificacionPadre;
	}

	public String getOtraIdentificacionMadre() {
		return otraIdentificacionMadre;
	}

	public void setOtraIdentificacionMadre(String otraIdentificacionMadre) {
		this.otraIdentificacionMadre = otraIdentificacionMadre;
	}

	public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

     

	public Long getIdGrupoInventario() {
		return idGrupoInventario;
	}

	public void setIdGrupoInventario(Long idGrupoInventario) {
		this.idGrupoInventario = idGrupoInventario;
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
