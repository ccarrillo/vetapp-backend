package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "evento", schema = "vet")
@Entity
public class Evento extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="vet.evento_id_seq",sequenceName="vet.evento_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.evento_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombre;
    
    
    @Column(name = "precio")
    private double precio;

    @Column(name = "abreviacion", length = 7)
    private String abreviacion;

    @Column(name = "eventoid")

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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getAbreviacion() {
		return abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}


}
