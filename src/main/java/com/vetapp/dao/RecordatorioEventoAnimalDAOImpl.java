package com.vetapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.vetapp.dto.RecordatorioEventoAnimalDTO;
import com.vetapp.dto.RecordatorioEventoDTO;
import com.vetapp.model.RecordatorioEvento;
import com.vetapp.model.RecordatorioEventoAnimal;

@Repository
public class RecordatorioEventoAnimalDAOImpl extends GenericDAOImpl<RecordatorioEventoAnimal, Long> implements RecordatorioEventoAnimalDAO {

	@Override
	public List<RecordatorioEventoAnimalDTO> obtenerRecordatorioEventoAnimalPorIdEvento(Long id) {
		// TODO Auto-generated method stub
		StringBuilder jpql = new StringBuilder();
		List<RecordatorioEventoAnimalDTO> listaRecordatorioEventoAnimalDTO = new ArrayList<>();
		jpql.append(" select id, created_at, is_active, modified_at, user_creation, user_updated,fecha,idanimal, idtipoevento,ideventoanimal ");
		jpql.append(" from vet.recordatorioeventoanimal where ideventoanimal = :id ");
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("id", id);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			RecordatorioEventoAnimalDTO  recordatorio = new RecordatorioEventoAnimalDTO();
			recordatorio.setId(Long.parseLong(o[0].toString()));
			recordatorio.setCreatedAt((Date)o[1]);
			recordatorio.setActive((boolean)o[2]);
			recordatorio.setModifiedAt((Date)o[3]);
			recordatorio.setUserCreation(Long.parseLong(o[4].toString()));
			recordatorio.setUserUpdated(o[5] == null? 0 :Long.parseLong(o[5].toString()));
			recordatorio.setFecha((Date)o[6]);
			recordatorio.setIdanimal(Long.parseLong(o[7].toString()));
			recordatorio.setIdtipoevento(Long.parseLong(o[8].toString()));
	
			listaRecordatorioEventoAnimalDTO.add(recordatorio);
		}
		
		return listaRecordatorioEventoAnimalDTO;
	}

	@Override
	public List<RecordatorioEventoAnimalDTO> obtenerRecordatorioEventoAnimalPorIdTipo(Long id) {
		StringBuilder jpql = new StringBuilder();
		List<RecordatorioEventoAnimalDTO> listaRecordatorioEventoAnimalDTO = new ArrayList<>();
		jpql.append(" select id, created_at, is_active, modified_at, user_creation, user_updated,fecha, idtipoevento,ideventoanimal ");
		jpql.append(" from vet.recordatorioeventoanimal where ideventoanimal = :id ");
		
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("id", id);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			RecordatorioEventoAnimalDTO  recordatorio = new RecordatorioEventoAnimalDTO();
			recordatorio.setId(Long.parseLong(o[0].toString()));
			recordatorio.setCreatedAt((Date)o[1]);
			recordatorio.setActive((boolean)o[2]);
			recordatorio.setModifiedAt((Date)o[3]);
			recordatorio.setUserCreation(Long.parseLong(o[4].toString()));
			recordatorio.setUserUpdated(o[5] == null? 0 :Long.parseLong(o[5].toString()));
			recordatorio.setFecha((Date)o[6]);
			recordatorio.setIdtipoevento(Long.parseLong(o[7].toString()));
			//recordatorio.setIdeventoanimal(o[8] == null? 0 :Long.parseLong(o[8].toString()));
			//recordatorio.setIdtipoeventopadre(Long.parseLong(o[8].toString()));
			listaRecordatorioEventoAnimalDTO.add(recordatorio);
		}
		
		return listaRecordatorioEventoAnimalDTO;
	}

	@Override
	public void eliminarDetalleRecordatorioAnimalPorIdTipoEvento(Long id) {
		Query query = this.em.createQuery("DELETE FROM recordatorioeventoanimal o WHERE o.ideventoanimal = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

}
