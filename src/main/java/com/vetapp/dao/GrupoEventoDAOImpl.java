package com.vetapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.vetapp.dto.GrupoEventoDTO;
import com.vetapp.model.Grupo;
import com.vetapp.model.GrupoEvento;

@Repository
public class GrupoEventoDAOImpl extends GenericDAOImpl<Grupo, Long> implements GrupoEventoDAO  {

	@Override
	public List<GrupoEvento> obtenerGrupoEvento(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrupoEventoDTO> obtenerGrupoEventoSinHijos(boolean estado) {
		// TODO Auto-generated method stub
		StringBuilder jpql = new StringBuilder();
		List<GrupoEventoDTO> listaGrupoEvento = new ArrayList<>();
		jpql.append("  SELECT id,nombre ,padre ,level  FROM vet.grupoevento where is_active = :estado  ");
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("estado", estado);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			GrupoEventoDTO  grupo = new GrupoEventoDTO();
			grupo.setId(Long.parseLong(o[0].toString()));
			grupo.setNombre(o[1] == null? " ": o[1].toString());
			grupo.setPadre(o[2] == null? 0: Long.parseLong(o[2].toString()));
			grupo.setLevel(o[3] == null? 0: Long.parseLong(o[3].toString()));
			
			listaGrupoEvento.add(grupo);
		}
		
		return listaGrupoEvento;
	}

	
}
