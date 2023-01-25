package com.vetapp.dao;

import com.vetapp.dto.TipoEventoDTO;
import com.vetapp.model.TipoEvento;
import com.vetapp.vo.AnimalVO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class TipoEventoDAOImpl extends GenericDAOImpl<TipoEvento, Long> implements TipoEventoDAO {

	@Override
	public List<TipoEventoDTO> obtenerTipoEventosGrupos() {
		StringBuilder jpql = new StringBuilder();
		List<TipoEventoDTO> listaTipoEvento = new ArrayList<>();
		jpql.append(" select t.id, t.grupoeventoid, t.nombre, g.nombre as nombreGrupo from vet.tipoevento t ");
		jpql.append(" inner join vet.grupoevento g on g.id = t.grupoeventoid ");
		jpql.append(" where t.is_active= true ");
		
		Query query = em.createNativeQuery(jpql.toString());		
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			TipoEventoDTO  tipo = new TipoEventoDTO();
			tipo.setId(Long.parseLong(o[0].toString()));
			tipo.setGrupoEventoId(Long.parseLong(o[1].toString()));
			tipo.setNombreEvento(o[2] == null? " ": o[2].toString());
			tipo.setNombreGrupo(o[3] == null? " ": o[3].toString());
			listaTipoEvento.add(tipo);
		}
		
		return listaTipoEvento;
	}
	
	

}
