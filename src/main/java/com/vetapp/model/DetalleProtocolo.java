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
@Table(name = "detalleprotocolo", schema = "vet")
public class DetalleProtocolo extends BaseModel{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	    @Id
        @Column(name = "id", nullable = false)
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		 /*@Column(name = "idprotocolo")
		 private Long idprotocolo;*/

	    @Column(name = "idtipoevento")
	    private Long idtipoevento;

	    @Column(name = "numerodias")
	    private Integer numerodias;
	    
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "idprotocolo", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
	    Protocolo protocolo;

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

		public Protocolo getProtocolo() {
			return protocolo;
		}

		public void setProtocolo(Protocolo protocolo) {
			this.protocolo = protocolo;
		}
	    
	    
	    

}
