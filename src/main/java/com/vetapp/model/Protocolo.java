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

@Table(name = "protocolo", schema = "vet")
@Entity
public class Protocolo extends BaseModel{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	    @Id
        @Column(name = "id", nullable = false)
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    
	    @Column(name = "nombre", length = 100)
	    private String nombre;
	    
	    @Column(name = "grupoprotocoloid")
	    private Long grupoProtocoloId;
         

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


		public Long getGrupoProtocoloId() {
			return grupoProtocoloId;
		}


		public void setGrupoProtocoloId(Long grupoProtocoloId) {
			this.grupoProtocoloId = grupoProtocoloId;
		}
	    
		
	    

}
