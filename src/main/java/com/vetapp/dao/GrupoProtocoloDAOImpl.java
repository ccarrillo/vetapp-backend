package com.vetapp.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.vetapp.dto.GrupoProtocoloDTO;
import com.vetapp.model.GrupoProtocolo;

@Repository
public class GrupoProtocoloDAOImpl extends GenericDAOImpl<GrupoProtocolo, Long> implements GrupoProtocoloDAO {

	@Override
	public List<GrupoProtocolo> obtenerGrupoEvento(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrupoProtocoloDTO> obtenerGrupoEventoSinHijos(boolean estado) {
		// TODO Auto-generated method stub
		StringBuilder jpql = new StringBuilder();
		List<GrupoProtocoloDTO> listaGrupoProtocolo = new ArrayList<>();
		jpql.append("  SELECT id,nombre ,padre ,level  FROM vet.grupoprotocolo where is_active = :estado  ");
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("estado", estado);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			GrupoProtocoloDTO  grupo = new GrupoProtocoloDTO();
			grupo.setId(Long.parseLong(o[0].toString()));
			grupo.setNombre(o[1] == null? " ": o[1].toString());
			grupo.setPadre(o[2] == null? 0: Long.parseLong(o[2].toString()));
			grupo.setLevel(o[3] == null? 0: Long.parseLong(o[3].toString()));
			
			listaGrupoProtocolo.add(grupo);
		}
		
		return listaGrupoProtocolo;
	}

}
