package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "recordatorioevento", schema = "vet")
public class RecordatorioEvento extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;;

    @Column(name = "idtipoevento")
    private Long idtipoevento;

    @Column(name = "numerodias")
    private Integer numerodias;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idtipoeventopadre", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TipoEvento idtipoeventopadre;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdtipoevento() {
        return idtipoevento;
    }

    public void setIdtipoevento(Long idtipoevento) {
        this.idtipoevento = idtipoevento;
    }

    public Integer getNumerodias() {
        return numerodias;
    }

    public void setNumerodias(Integer numerodias) {
        this.numerodias = numerodias;
    }

	public TipoEvento getIdtipoeventopadre() {
		return idtipoeventopadre;
	}

	public void setIdtipoeventopadre(TipoEvento idtipoeventopadre) {
		this.idtipoeventopadre = idtipoeventopadre;
	}

	
     
    

}
