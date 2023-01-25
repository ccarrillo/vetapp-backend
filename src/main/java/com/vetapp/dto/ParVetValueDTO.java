package com.vetapp.dto;

public class ParVetValueDTO extends BaseModelDTO {

    private Long id;

    private String name;

    private Long parvetId;
    
    private String nombreparvet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParvetId() {
        return parvetId;
    }

    public void setParvetId(Long parvetId) {
        this.parvetId = parvetId;
    }

	public String getNombreparvet() {
		return nombreparvet;
	}

	public void setNombreparvet(String nombreparvet) {
		this.nombreparvet = nombreparvet;
	}
    
    
}
