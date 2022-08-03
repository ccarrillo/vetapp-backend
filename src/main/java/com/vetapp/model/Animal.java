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

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "razaid")
    private Long razaId;

    @Column(name = "origenid")
    private Long origenId;

    @Column(name = "fechanacimiento")
    private Date fechanacimiento;

    @Column(name = "fechaultimoparto")
    private Date fechaultimoparto;

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
