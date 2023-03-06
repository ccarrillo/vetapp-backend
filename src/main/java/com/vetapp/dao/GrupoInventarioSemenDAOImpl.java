package com.vetapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.vetapp.dto.GrupoInventarioDTO;

import com.vetapp.model.GrupoInventario;

@Repository
public class GrupoInventarioSemenDAOImpl extends GenericDAOImpl<GrupoInventario, Long> implements GrupoInventarioSemenDAO   {

	@Override
	public List<GrupoInventarioDTO> obtenerGrupoInventarioSemen(boolean estado) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		StringBuilder jpql = new StringBuilder();
		List<GrupoInventarioDTO> listaGrupo = new ArrayList<>();
		jpql.append("  SELECT id,nombre,nombredetallado ,padre ,level  FROM vet.grupoinventario where is_active = :estado  ");
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("estado", estado);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			GrupoInventarioDTO  grupo = new GrupoInventarioDTO();
			grupo.setId(Long.parseLong(o[0].toString()));
			grupo.setNombre(o[1] == null? " ": o[1].toString());
			grupo.setNombredetallado(o[2] == null? " ": o[2].toString());
			grupo.setPadre(o[3] == null? 0: Long.parseLong(o[3].toString()));
			grupo.setLevel(o[4] == null? 0: Long.parseLong(o[4].toString()));
			
			listaGrupo.add(grupo);
		}
		
		return listaGrupo;
	}
	

}
