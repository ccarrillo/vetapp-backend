package com.vetapp.dao;

import com.vetapp.dto.EventoAnimalDTO;
import com.vetapp.model.EventoAnimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class EventoAnimalDAOImpl extends GenericDAOImpl<EventoAnimal, Long> implements EventoAnimalDAO {

	@Override
	public List<EventoAnimalDTO> obtenerEventosPorIdAnimal(Long id) {
		StringBuilder jpql = new StringBuilder();
		List<EventoAnimalDTO> listaEventoAnimalDTO = new ArrayList<>();
		jpql.append(" select e.id,e.fecha,t.nombre,e.anotacion from vet.eventoanimal e inner join vet.tipoevento t on e.idtipoevento = t.id  ");
		jpql.append(" where e.idanimal = :id ");
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("id", id);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			EventoAnimalDTO  evento = new EventoAnimalDTO();
			evento.setId(Long.parseLong(o[0].toString()));
			evento.setFecha( (Date) o[1]);
			evento.setNombreEvento(o[2] == null? " ": o[2].toString());
			evento.setAnotacion(o[3] == null? " ": o[3].toString());
			
			listaEventoAnimalDTO.add(evento);
		}
		
		return listaEventoAnimalDTO;
	}

}
