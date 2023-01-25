package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//ventana de informacion adicional
@Entity
@Table(name = "detalletipoevento", schema = "vet")
public class DetalleTipoEvento extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="vet.detalletipoevento_id_seq",sequenceName="vet.detalletipoevento_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.detalletipoevento_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "abreviacion", length = 7)
    private String abreviacion;

    @Column(name = "tdesde")
    private   String tdesde;

    @Column(name = "thasta")
    private String thasta;
    
    @Column(name = "ndesde")
    private   String ndesde;

    @Column(name = "nhasta")
    private String nhasta;
    
    @Column(name = "ddesde")
    private  String ddesde;

    @Column(name = "dhasta")
    private String dhasta;


    @Column(name = "combosseleccionables", length = 300)
    private String combosseleccionables;
    
    @Column(name = "padremadre", length = 1)
    private String padremadre;
    
    @Column(name = "radioinformacion")
    private String radioInformacion;
    
    @Column(name = "requerido")
    private boolean requerido;
   
    @Column(name = "idtipoevento")
    private Long idTipoEvento;
    
 

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

	public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }
    
	
	public String getTdesde() {
		return tdesde;
	}

	public void setTdesde(String tdesde) {
		this.tdesde = tdesde;
	}

	public String getThasta() {
		return thasta;
	}

	public void setThasta(String thasta) {
		this.thasta = thasta;
	}

	public String getNdesde() {
		return ndesde;
	}

	public void setNdesde(String ndesde) {
		this.ndesde = ndesde;
	}

	public String getNhasta() {
		return nhasta;
	}

	public void setNhasta(String nhasta) {
		this.nhasta = nhasta;
	}

	public String getDdesde() {
		return ddesde;
	}

	public void setDdesde(String ddesde) {
		this.ddesde = ddesde;
	}

	public String getDhasta() {
		return dhasta;
	}

	public void setDhasta(String dhasta) {
		this.dhasta = dhasta;
	}

	public String getCombosseleccionables() {
		return combosseleccionables;
	}

	public void setCombosseleccionables(String combosseleccionables) {
		this.combosseleccionables = combosseleccionables;
	}

	public String getPadremadre() {
		return padremadre;
	}

	public void setPadremadre(String padremadre) {
		this.padremadre = padremadre;
	}

	public String getRadioInformacion() {
		return radioInformacion;
	}

	public void setRadioInformacion(String radioInformacion) {
		this.radioInformacion = radioInformacion;
	}

	public boolean isRequerido() {
		return requerido;
	}

	public void setRequerido(boolean requerido) {
		this.requerido = requerido;
	}

	public Long getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(Long idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}
     
     
    
    

}
