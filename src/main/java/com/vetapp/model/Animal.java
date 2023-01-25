package com.vetapp.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "animal", schema = "vet")
@Entity
public class Animal extends BaseModel {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="vet.animal_id_seq",sequenceName="vet.animal_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.animal_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "categoriareproduccionid")
    private Long categoriaReproduccionId;
    
    @Column(name = "categoriaproduccionid")
    private Long categoriaProduccionId;
    
    @Column(name = "arete", length = 50)
    private String arete;
    
    @Column(name = "otra_identificacion", length = 50)
    private String otraIdentificacion;

    @Column(name = "razaid")
    private Long razaId;

    @Column(name = "origenid")
    private Long origenId;

    @Column(name = "fechanacimiento")
    private Date fechanacimiento;

    @Column(name = "fechaultimoparto")
    private Date fechaultimoparto;
    
    @Column(name = "fechaparir")
    private Date fechaparir;
    
    @Column(name = "fechadestete")
    private Date fechadestete;
    
    @Column(name = "fechacastracion")
    private Date fechacastracion;
    

    @Column(name = "estadoreproductivoid")
    private Long estadoreproductivoId;

    @Column(name = "estadoproductivoid")
    private Long estadoproductivoId;

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
    private boolean muerto;

    @Column(name = "venta")
    private boolean venta;
    
    @Column(name = "marca_izquierda", length = 50)
    private String marcaizquierda;
    
    @Column(name = "marca_derecha",length = 50)
    private String marcaderecha;
    
    @Column(name = "color",length = 20)
    private String color;
   
    @Column(name = "marca_distintiva",length = 100)
    private String marcadistintiva;
    
    @Column(name = "anotaciones",length = 100)
    private String anotaciones;
    
    @Column(name = "proposito")
    private Long propositoId;
    
    @Column(name = "pureza")
    private Integer pureza;
    
    @Column(name = "idgrupoanimal")
    private Long idGrupoAnimal;
    
    @Column(name = "noservir")
    private boolean noservir;
    
    
    @Column(name = "otra_identificacion_madre")
    private String otraIdentificacionMadre;
    
    @Column(name = "otra_identificacion_padre")
    private String otraIdentificacionPadre;
    
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
    
    

    public Date getFechaparir() {
		return fechaparir;
	}

	public void setFechaparir(Date fechaparir) {
		this.fechaparir = fechaparir;
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
