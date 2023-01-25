package com.vetapp.dto;



public class ProtocoloDTO extends BaseModelDTO{
      
	private Long id;

    private String nombre;
    
    private Long grupoProtocoloId;
    
    private String nombreGrupo;

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

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}
    
	
    
    
    
}
