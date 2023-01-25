package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "recordatorioevento", schema = "vet")
public class RecordatorioEvento extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="vet.recordatorioevento_id_seq",sequenceName="vet.recordatorioevento_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.recordatorioevento_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "idtipoevento")
    private Long idtipoevento;

    @Column(name = "numerodias")
    private Integer numerodias;
    
    @Column(name = "idtipoeventopadre")
    private Long idtipoeventopadre;

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

	public Long getIdtipoeventopadre() {
		return idtipoeventopadre;
	}

	public void setIdtipoeventopadre(Long idtipoeventopadre) {
		this.idtipoeventopadre = idtipoeventopadre;
	}
     
    

}
