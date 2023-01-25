package com.vetapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.vetapp.dto.ProtocoloDTO;
import com.vetapp.dto.TipoEventoDTO;
import com.vetapp.model.Protocolo;

@Repository
public class ProtocoloDAOImpl extends GenericDAOImpl<Protocolo, Long> implements ProtocoloDAO  {

	@Override
	public List<ProtocoloDTO> obtenerProtocoloGrupos() {
		StringBuilder jpql = new StringBuilder();
		List<ProtocoloDTO> listaProtocolo = new ArrayList<>();
		jpql.append(" select p.id, p.grupoprotocoloid, p.nombre, g.nombre as nombreGrupo from vet.protocolo p ");
		jpql.append(" inner join vet.grupoprotocolo g on g.id = p.grupoprotocoloid ");
		jpql.append(" where p.is_active= true ");
		
		Query query = em.createNativeQuery(jpql.toString());		
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			ProtocoloDTO  protocolo = new ProtocoloDTO();
			protocolo.setId(Long.parseLong(o[0].toString()));
			protocolo.setGrupoProtocoloId(Long.parseLong(o[1].toString()));
			protocolo.setNombre(o[2] == null? " ": o[2].toString());
			protocolo.setNombreGrupo(o[3] == null? " ": o[3].toString());
			listaProtocolo.add(protocolo);
		}
		
		return listaProtocolo;
	}

}
