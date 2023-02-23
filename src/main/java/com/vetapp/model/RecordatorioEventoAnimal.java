package com.vetapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "recordatorioeventoanimal", schema = "vet")
public class RecordatorioEventoAnimal extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "idanimal")
    private Long idanimal;

    @Column(name = "idtipoevento")
    private Long idtipoevento;

    @Column(name = "fecha")
    private Date fecha;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ideventoanimal", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private EventoAnimal ideventoanimal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public Long getIdanimal() {
		return idanimal;
	}

	public void setIdanimal(Long idanimal) {
		this.idanimal = idanimal;
	}

	public Long getIdtipoevento() {
		return idtipoevento;
	}

	public void setIdtipoevento(Long idtipoevento) {
		this.idtipoevento = idtipoevento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EventoAnimal getIdeventoanimal() {
		return ideventoanimal;
	}

	public void setIdeventoanimal(EventoAnimal ideventoanimal) {
		this.ideventoanimal = ideventoanimal;
	}
    
    
    

}
