package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoevento", schema = "vet")
public class TipoEvento extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombreEvento;

    @Column(name = "precio")
    private double precio;

    @Column(name = "abreviacion", length = 7)
    private String abreviacion;

    @Column(name = "grupoeventoid")
    private Long grupoEventoId;
    
    @Column(name = "idgrupomover")
    private Long idGrupoMover;
    
    @Column(name = "ideventorecordatorio")
    private Long idEventoRecordatorio;
    
    @Column(name = "checkgrupoanimal")
    private boolean checkgrupoanimal;
    
    @Column(name = "checktipoevento")
    private boolean checktipoevento;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
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

	public Long getGrupoEventoId() {
		return grupoEventoId;
	}

	public void setGrupoEventoId(Long grupoEventoId) {
		this.grupoEventoId = grupoEventoId;
	}

	public Long getIdGrupoMover() {
		return idGrupoMover;
	}

	public void setIdGrupoMover(Long idGrupoMover) {
		this.idGrupoMover = idGrupoMover;
	}

	public Long getIdEventoRecordatorio() {
		return idEventoRecordatorio;
	}

	public void setIdEventoRecordatorio(Long idEventoRecordatorio) {
		this.idEventoRecordatorio = idEventoRecordatorio;
	}

	public boolean isCheckgrupoanimal() {
		return checkgrupoanimal;
	}

	public void setCheckgrupoanimal(boolean checkgrupoanimal) {
		this.checkgrupoanimal = checkgrupoanimal;
	}

	public boolean isChecktipoevento() {
		return checktipoevento;
	}

	public void setChecktipoevento(boolean checktipoevento) {
		this.checktipoevento = checktipoevento;
	}

   


}
