package com.vetapp.dto;



public class DetalleTipoEventoDTO extends BaseModelDTO {


	    private Long id;

	    
	    private String nombre;

	  
	    private String abreviacion;

	    
	    private   String tdesde;

	   
	    private String thasta;
	    
	   
	    private   String ndesde;

	   
	    private String nhasta;
	    
	    
	    private  String ddesde;

	   
	    private String dhasta;


	    
	    private String combosseleccionables;
	    
	    
	    private String padremadre;
	    
	    
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


		public String getNdesde() {
			return ndesde;
		}


		public void setNdesde(String ndesde) {
			this.ndesde = ndesde;
		}


		public String getNhasta() {
			return nhasta;
		}


		public void setNhasta(String nhasta) {
			this.nhasta = nhasta;
		}


		public String getDdesde() {
			return ddesde;
		}


		public void setDdesde(String ddesde) {
			this.ddesde = ddesde;
		}


		public String getDhasta() {
			return dhasta;
		}


		public void setDhasta(String dhasta) {
			this.dhasta = dhasta;
		}


		public String getCombosseleccionables() {
			return combosseleccionables;
		}


		public void setCombosseleccionables(String combosseleccionables) {
			this.combosseleccionables = combosseleccionables;
		}


		public String getPadremadre() {
			return padremadre;
		}


		public void setPadremadre(String padremadre) {
			this.padremadre = padremadre;
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
