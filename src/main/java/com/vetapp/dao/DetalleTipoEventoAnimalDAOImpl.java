package com.vetapp.dao;

import com.vetapp.dto.DetalleTipoEventoAnimalDTO;
import com.vetapp.dto.DetalleTipoEventoDTO;
import com.vetapp.model.DetalleTipoEventoAnimal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class DetalleTipoEventoAnimalDAOImpl extends GenericDAOImpl<DetalleTipoEventoAnimal, Long> implements DetalleTipoEventoAnimalDAO {

	@Override
	public List<DetalleTipoEventoAnimalDTO> obtenerListaDetallePorIdEventoAnimal(Long id) {
		StringBuilder jpql = new StringBuilder();
		List<DetalleTipoEventoAnimalDTO> listaDetalleTipoEventoAnimalDTO = new ArrayList<>();
		jpql.append(" select id,nombre, nombrevalor,tdesde,thasta,combosseleccionables, ");
		jpql.append(" radioinformacion,requerido from vet.detalletipoeventoanimal where ideventoanimal = :id ");
		
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("id", id);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			DetalleTipoEventoAnimalDTO  detalle = new DetalleTipoEventoAnimalDTO();
			detalle.setId(Long.parseLong(o[0].toString()));
			detalle.setNombre(o[1] == null? " ": o[1].toString());
			detalle.setNombrevalor(o[2] == null? " ": o[2].toString());
			detalle.setTdesde(o[3] == null? " ": o[3].toString());
			detalle.setThasta(o[4] == null? " ": o[4].toString());
			detalle.setCombosseleccionables(o[5] == null? " ": o[5].toString());
			detalle.setRadioInformacion(o[6] == null? " ": o[6].toString());
			detalle.setRequerido((boolean) o[7] );
			//detalle.setIdTipoEvento(Long.parseLong(o[8].toString()));
			
			listaDetalleTipoEventoAnimalDTO.add(detalle);
		}
		
		return listaDetalleTipoEventoAnimalDTO;
	}

}