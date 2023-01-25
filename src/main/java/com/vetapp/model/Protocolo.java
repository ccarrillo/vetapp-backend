package com.vetapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "protocolo", schema = "vet")
@Entity
public class Protocolo extends BaseModel{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		@Id
	    @SequenceGenerator(name="vet.protocolo_id_seq",sequenceName="vet.protocolo_id_seq",allocationSize=1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vet.protocolo_id_seq")
	    @Column(name = "id")
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
