package com.vetapp.dto;



public class DetalleTipoEventoDTO extends BaseModelDTO {


	    private Long id;

	    
	    private String nombre;

	  
	    private String abreviacion;

	    
	    private   String tdesde;

	   
	    private String thasta;
	    
  
	    private String combosseleccionables;
	    
	    
	    private String radioInformacion;
	    
	    private boolean requerido;
	    
	    
	    private Long idTipoEvento;
	    
	    private boolean editado;
	    
	    private boolean eliminado;
      


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


		public String getAbreviacion() {
			return abreviacion;
		}


		public void setAbreviacion(String abreviacion) {
			this.abreviacion = abreviacion;
		}


	   

		public String getTdesde() {
			return tdesde;
		}


		public void setTdesde(String tdesde) {
			this.tdesde = tdesde;
		}


		public String getThasta() {
			return thasta;
		}


		public void setThasta(String thasta) {
			this.thasta = thasta;
		}


		public String getCombosseleccionables() {
			return combosseleccionables;
		}


		public void setCombosseleccionables(String combosseleccionables) {
			this.combosseleccionables = combosseleccionables;
		}


		public String getRadioInformacion() {
			return radioInformacion;
		}


		public void setRadioInformacion(String radioInformacion) {
			this.radioInformacion = radioInformacion;
		}


		public boolean isRequerido() {
			return requerido;
		}


		public void setRequerido(boolean requerido) {
			this.requerido = requerido;
		}


		public Long getIdTipoEvento() {
			return idTipoEvento;
		}


		public void setIdTipoEvento(Long idTipoEvento) {
			this.idTipoEvento = idTipoEvento;
		}


	


		public boolean isEditado() {
			return editado;
		}


		public void setEditado(boolean editado) {
			this.editado = editado;
		}


		public boolean isEliminado() {
			return eliminado;
		}


		public void setEliminado(boolean eliminado) {
			this.eliminado = eliminado;
		}



    

}
