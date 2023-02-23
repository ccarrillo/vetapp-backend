package com.vetapp.dto;




public class DetalleTipoEventoAnimalDTO extends BaseModelDTO {

	    private Long id;

	    private String nombre;
	    
	    private String nombrevalor;

	    private   String tdesde;

	    private String thasta;

	    private String combosseleccionables;

	    private String radioInformacion;

	    private boolean requerido;

	    private EventoAnimalDTO ideventoanimal;

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
		

		public String getNombrevalor() {
			return nombrevalor;
		}

		public void setNombrevalor(String nombrevalor) {
			this.nombrevalor = nombrevalor;
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

		public EventoAnimalDTO getIdeventoanimal() {
			return ideventoanimal;
		}

		public void setIdeventoanimal(EventoAnimalDTO ideventoanimal) {
			this.ideventoanimal = ideventoanimal;
		}

		

        


}
