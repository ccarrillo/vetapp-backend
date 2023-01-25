package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "detalleprotocolo", schema = "vet")
public class DetalleProtocolo extends BaseModel{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @SequenceGenerator(name="vet.detalleprotocolo_id_seq",sequenceName="vet.detalleprotocolo_id_seq",allocationSize=1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.detalleprotocolo_id_seq")
	    @Column(name = "id")
	    private Long id;
		
		 @Column(name = "idprotocolo")
		 private Long idprotocolo;

	    @Column(name = "idtipoevento")
	    private Long idtipoevento;

	    @Column(name = "numerodias")
	    private Integer numerodias;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		

		public Long getIdprotocolo() {
			return idprotocolo;
		}

		public void setIdprotocolo(Long idprotocolo) {
			this.idprotocolo = idprotocolo;
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
	    
	    
	    

}
