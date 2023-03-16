package com.vetapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.vetapp.dto.GrupoEventoDTO;
import com.vetapp.model.Grupo;
import com.vetapp.model.GrupoEvento;

@Repository
public class GrupoEventoDAOImpl extends GenericDAOImpl<GrupoEvento, Long> implements GrupoEventoDAO  {

	@Override
	public List<GrupoEvento> obtenerGrupoEvento(boolean estado) {
		StringBuilder jpql = new StringBuilder();
		List<GrupoEvento> listaGrupoEvento = new ArrayList<>();
		jpql.append("  SELECT id,nombre,nombredetallado,padre ,level  FROM vet.grupoevento where is_active = :estado  ");
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("estado", estado);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			GrupoEvento  grupo = new GrupoEvento();
			grupo.setId(Long.parseLong(o[0].toString()));
			grupo.setNombre(o[1] == null? " ": o[1].toString());
			grupo.setNombredetallado(o[2] == null? " ": o[2].toString());
			grupo.setPadre(o[3] == null? 0: Long.parseLong(o[3].toString()));
			grupo.setLevel(o[4] == null? 0: Long.parseLong(o[4].toString()));
			
			listaGrupoEvento.add(grupo);
		}
		
		return listaGrupoEvento;
	}

	@Override
	public List<GrupoEventoDTO> obtenerGrupoEventoSinHijos(boolean estado) {
		// TODO Auto-generated method stub
		StringBuilder jpql = new StringBuilder();
		List<GrupoEventoDTO> listaGrupoEvento = new ArrayList<>();
		jpql.append("  SELECT id,nombre,nombredetallado,padre ,level  FROM vet.grupoevento where is_active = :estado  ");
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("estado", estado);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			GrupoEventoDTO  grupo = new GrupoEventoDTO();
			grupo.setId(Long.parseLong(o[0].toString()));
			grupo.setNombre(o[1] == null? " ": o[1].toString());
			grupo.setNombredetallado(o[2] == null? " ": o[2].toString());
			grupo.setPadre(o[3] == null? 0: Long.parseLong(o[3].toString()));
			grupo.setLevel(o[4] == null? 0: Long.parseLong(o[4].toString()));
			
			listaGrupoEvento.add(grupo);
		}
		
		return listaGrupoEvento;
	}

	@Override
	public boolean existenciaEvento(Long idgrupo) {
		String jpql = "select count(*) from vet.grupoevento g inner join vet.tipoevento t on g.id = t.grupoeventoid where (t.grupoeventoid = :idgrupo or g.padre = :idgrupo) and a.venta = false and a.muerto= false and a.is_active= true  ";
		Query query = em.createNativeQuery(jpql);
		query.setParameter("idgrupo", idgrupo);
		int cantidad = Integer.parseInt("" + query.getSingleResult());
		if (cantidad > 0) {
			return true;
		} else return false;
	}

	
}
