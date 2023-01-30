package com.vetapp.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.vetapp.dto.DetalleProtocoloDTO;
import com.vetapp.model.DetalleProtocolo;


@Repository
public class DetalleProtocoloDAOImpl extends GenericDAOImpl<DetalleProtocolo, Long> implements DetalleProtocoloDAO {

	@Override
	public List<DetalleProtocoloDTO> obtenerListaDetalleProtocoloPorIdTipo(Long id) {
		StringBuilder jpql = new StringBuilder();
		List<DetalleProtocoloDTO> listaDetalleProtocoloDTO = new ArrayList<>();
		jpql.append(" select id,idprotocolo,idtipoevento,numerodias");
		jpql.append(" from vet.detalleprotocolo where idprotocolo = :id ");
		
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("id", id);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			DetalleProtocoloDTO  detalle = new DetalleProtocoloDTO();
			detalle.setId(Long.parseLong(o[0].toString()));
			detalle.setIdprotocolo(Long.parseLong(o[1].toString()));
			detalle.setIdtipoevento(Long.parseLong(o[2].toString()));
			detalle.setNumerodias(Integer.parseInt(o[3].toString()));
			
			
			listaDetalleProtocoloDTO.add(detalle);
		}
		
		return listaDetalleProtocoloDTO;
	}

	@Override
	public void eliminarDetalleProtocoloPorIdProtocolo(Long id) {
		
		Query query = this.em.createQuery("DELETE FROM DetalleProtocolo o WHERE o.idprotocolo = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		/*StringBuilder jpql = new StringBuilder();
		jpql.append(" delete from vet.detalleprotocolo where idprotocolo = :id ");
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("id", id);*/
		 
		
	}

}
