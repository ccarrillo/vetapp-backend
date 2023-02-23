package com.vetapp.dto;

import java.util.Date;

import com.vetapp.model.BaseModel;

public class RecordatorioEventoAnimalDTO extends BaseModel {
	
	 
	    private static final long serialVersionUID = 1L;

		private Long id;
		
	    private Long idtipoevento;
	    
	    private Long idanimal;

	    private Date fecha;
	    
	    private boolean eliminado;

	    private EventoAnimalDTO ideventoanimal;

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
		

		public Long getIdanimal() {
			return idanimal;
		}

		public void setIdanimal(Long idanimal) {
			this.idanimal = idanimal;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		
		

		public boolean isEliminado() {
			return eliminado;
		}

		public void setEliminado(boolean eliminado) {
			this.eliminado = eliminado;
		}

		public EventoAnimalDTO getIdeventoanimal() {
			return ideventoanimal;
		}

		public void setIdeventoanimal(EventoAnimalDTO ideventoanimal) {
			this.ideventoanimal = ideventoanimal;
		}

		
	    
	    

}
