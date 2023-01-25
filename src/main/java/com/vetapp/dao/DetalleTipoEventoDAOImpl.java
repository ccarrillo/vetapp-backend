package com.vetapp.dao;

import com.vetapp.dto.DetalleTipoEventoDTO;
import com.vetapp.model.DetalleTipoEvento;
import com.vetapp.vo.AnimalVO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class DetalleTipoEventoDAOImpl extends GenericDAOImpl<DetalleTipoEvento, Long> implements DetalleTipoEventoDAO {

	@Override
	public List<DetalleTipoEventoDTO> obtenerListaDetalleTipoEventoPorIdTipo(Long id) {
		// TODO Auto-generated method stub
		StringBuilder jpql = new StringBuilder();
		List<DetalleTipoEventoDTO> listaDetalleTipoEventoDTO = new ArrayList<>();
		jpql.append(" select id,nombre,abreviacion,tdesde,thasta,ndesde,nhasta,ddesde,dhasta,combosseleccionables,padremadre, ");
		jpql.append(" radioinformacion,requerido,idtipoevento from vet.detalletipoevento where idtipoevento = :id ");
		
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("id", id);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			DetalleTipoEventoDTO  detalle = new DetalleTipoEventoDTO();
			detalle.setId(Long.parseLong(o[0].toString()));
			detalle.setNombre(o[1] == null? " ": o[1].toString());
			detalle.setAbreviacion(o[2] == null? " ": o[2].toString());
			detalle.setTdesde(o[3] == null? " ": o[3].toString());
			detalle.setThasta(o[4] == null? " ": o[4].toString());
			detalle.setNdesde(o[5] == null? " ": o[5].toString());
			detalle.setNhasta(o[6] == null? " ": o[6].toString());
			detalle.setDdesde(o[7] == null? " ": o[7].toString());
			detalle.setDhasta(o[8] == null? " ": o[8].toString());
			detalle.setCombosseleccionables(o[9] == null? " ": o[9].toString());
			detalle.setPadremadre(o[10] == null? " ": o[10].toString());
			detalle.setRadioInformacion(o[11] == null? " ": o[11].toString());
			detalle.setRequerido((boolean) o[12] );
			detalle.setIdTipoEvento(Long.parseLong(o[13].toString()));
			
			listaDetalleTipoEventoDTO.add(detalle);
		}
		
		return listaDetalleTipoEventoDTO;
	}

}
