package com.vetapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.vetapp.dto.GrupoDTO;
import com.vetapp.model.Grupo;


@Repository
public class GrupoDAOImpl extends GenericDAOImpl<Grupo, Long> implements GrupoDAO  {

	@Override
	public List<Grupo> obtenerGrupoAnimales(boolean estado) {
		    
		// TODO Auto-generated method stub
		StringBuilder jpql = new StringBuilder();
		List<Grupo> listaGrupo = new ArrayList<>();
		jpql.append("  SELECT id,nombre,nombredetallado, padre ,level  FROM vet.grupo where is_active = :estado  ");
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("estado", estado);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			Grupo  grupo = new Grupo();
			grupo.setId(Long.parseLong(o[0].toString()));
			grupo.setNombre(o[1] == null? " ": o[1].toString());
			grupo.setNombredetallado(o[2] == null? " ": o[2].toString());
			grupo.setPadre(o[3] == null? 0: Long.parseLong(o[3].toString()));
			grupo.setLevel(o[4] == null? 0: Long.parseLong(o[4].toString()));
			
			listaGrupo.add(grupo);
		}
		
		return listaGrupo;
	}

	@Override
	public List<GrupoDTO> obtenerGrupoAnimalesSinHijos(boolean estado) {
		// TODO Auto-generated method stub
				StringBuilder jpql = new StringBuilder();
				List<GrupoDTO> listaGrupo = new ArrayList<>();
				jpql.append("  SELECT id,nombre,nombredetallado, padre ,level  FROM vet.grupo where is_active = :estado  ");
				Query query = em.createNativeQuery(jpql.toString());		
				query.setParameter("estado", estado);
				List<Object[]> lista = query.getResultList();
				
				for(Object[] o : lista){
					GrupoDTO  grupo = new GrupoDTO();
					grupo.setId(Long.parseLong(o[0].toString()));
					grupo.setNombre(o[1] == null? " ": o[1].toString());
					grupo.setNombredetallado(o[2] == null? " ": o[2].toString());
					grupo.setPadre(o[3] == null? 0: Long.parseLong(o[3].toString()));
					grupo.setLevel(o[4] == null? 0: Long.parseLong(o[4].toString()));
					
					listaGrupo.add(grupo);
				}
				
				return listaGrupo;
	}

	@Override
	public boolean existenciaAnimales(Long idgrupo) {
		String jpql = "select count(*) from vet.grupo g inner join vet.animal a on g.id = a.idgrupoanimal where (a.idgrupoanimal = :idgrupo or g.padre = :idgrupo) and a.venta = false and a.muerto= false and a.is_active= true  ";
		Query query = em.createNativeQuery(jpql);
		query.setParameter("idgrupo", idgrupo);
		int cantidad = Integer.parseInt("" + query.getSingleResult());
		if (cantidad > 0) {
			return true;
		} else return false;
	}

	
	
}
