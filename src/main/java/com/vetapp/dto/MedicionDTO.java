package com.vetapp.dto;

import java.util.Date;



public class MedicionDTO  extends BaseModelDTO{
	
	    private Long id;

	    private Date fechamedicion;

	    private double peso;

	    private double estatura;

	    private int concorporal;
	    
	    private AnimalDTO idanimal;
	    

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}


		public Date getFechamedicion() {
			return fechamedicion;
		}

		public void setFechamedicion(Date fechamedicion) {
			this.fechamedicion = fechamedicion;
		}

		public double getPeso() {
			return peso;
		}

		public void setPeso(double peso) {
			this.peso = peso;
		}

		public double getEstatura() {
			return estatura;
		}

		public void setEstatura(double estatura) {
			this.estatura = estatura;
		}

		public int getConcorporal() {
			return concorporal;
		}

		public void setConcorporal(int concorporal) {
			this.concorporal = concorporal;
		}

		public AnimalDTO getIdanimal() {
			return idanimal;
		}

		public void setIdanimal(AnimalDTO idanimal) {
			this.idanimal = idanimal;
		}
       
		
	    
	    
	    


}
