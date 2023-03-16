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
	public List<GrupoProtocoloDTO> obtenerGrupoEventoSinHijos(boolean estado) {
		// TODO Auto-generated method stub
		StringBuilder jpql = new StringBuilder();
		List<GrupoProtocoloDTO> listaGrupoProtocolo = new ArrayList<>();
		jpql.append("  SELECT id,nombre ,nombredetallado, padre ,level  FROM vet.grupoprotocolo where is_active = :estado  ");
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("estado", estado);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			GrupoProtocoloDTO  grupo = new GrupoProtocoloDTO();
			grupo.setId(Long.parseLong(o[0].toString()));
			grupo.setNombre(o[1] == null? " ": o[1].toString());
			grupo.setNombredetallado(o[2] == null? " ": o[2].toString());
			grupo.setPadre(o[3] == null? 0: Long.parseLong(o[3].toString()));
			grupo.setLevel(o[4] == null? 0: Long.parseLong(o[4].toString()));
			
			listaGrupoProtocolo.add(grupo);
		}
		
		return listaGrupoProtocolo;
	}

	@Override
	public List<GrupoProtocolo> obtenerGrupoProtocolo(boolean estado) {
		// TODO Auto-generated method stub
				StringBuilder jpql = new StringBuilder();
				List<GrupoProtocolo> listaGrupoProtocolo = new ArrayList<>();
				jpql.append("  SELECT id,nombre ,nombredetallado, padre ,level  FROM vet.grupoprotocolo where is_active = :estado  ");
				Query query = em.createNativeQuery(jpql.toString());		
				query.setParameter("estado", estado);
				List<Object[]> lista = query.getResultList();
				
				for(Object[] o : lista){
					GrupoProtocolo  grupo = new GrupoProtocolo();
					grupo.setId(Long.parseLong(o[0].toString()));
					grupo.setNombre(o[1] == null? " ": o[1].toString());
					grupo.setNombredetallado(o[2] == null? " ": o[2].toString());
					grupo.setPadre(o[3] == null? 0: Long.parseLong(o[3].toString()));
					grupo.setLevel(o[4] == null? 0: Long.parseLong(o[4].toString()));
					
					listaGrupoProtocolo.add(grupo);
				}
				
				return listaGrupoProtocolo;
	}

	@Override
	public boolean existenciaProtocolo(Long idgrupo) {
		String jpql = "select count(*) from vet.grupoprotocolo g inner join vet.protocolo p on g.id = p.grupoprotocoloid where (p.grupoprotocoloid = :idgrupo or g.padre = :idgrupo) and a.venta = false and a.muerto= false and a.is_active= true  ";
		Query query = em.createNativeQuery(jpql);
		query.setParameter("idgrupo", idgrupo);
		int cantidad = Integer.parseInt("" + query.getSingleResult());
		if (cantidad > 0) {
			return true;
		} else return false;
	}

}
