package com.vetapp.dao;

import com.vetapp.dto.DetalleTipoEventoDTO;
import com.vetapp.dto.RecordatorioEventoDTO;
import com.vetapp.model.RecordatorioEvento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class RecordatorioEventoDAOImpl extends GenericDAOImpl<RecordatorioEvento, Long> implements RecordatorioEventoDAO {

	@Override
	public List<RecordatorioEventoDTO> obtenerRecordatorioEventoPorIdGrupo(Long id) {
		// TODO Auto-generated method stub
				StringBuilder jpql = new StringBuilder();
				List<RecordatorioEventoDTO> listaRecordatorioEventoDTO = new ArrayList<>();
				jpql.append(" select id, created_at, is_active, modified_at, user_creation, user_updated, idtipoevento, numerodias, idtipoeventopadre ");
				jpql.append(" from vet.recordatorioevento where idtipoeventopadre = :id ");
				
				Query query = em.createNativeQuery(jpql.toString());		
				query.setParameter("id", id);
				List<Object[]> lista = query.getResultList();
				
				for(Object[] o : lista){
					RecordatorioEventoDTO  recordatorio = new RecordatorioEventoDTO();
					recordatorio.setId(Long.parseLong(o[0].toString()));
					recordatorio.setCreatedAt((Date)o[1]);
					recordatorio.setActive((boolean)o[2]);
					recordatorio.setModifiedAt((Date)o[3]);
					recordatorio.setUserCreation(Long.parseLong(o[4].toString()));
					recordatorio.setUserUpdated(o[5] == null? 0 :Long.parseLong(o[5].toString()));
					recordatorio.setIdtipoevento(Long.parseLong(o[6].toString()));
					recordatorio.setNumerodias(Integer.parseInt(o[7].toString()));
					recordatorio.setIdtipoeventopadre(Long.parseLong(o[8].toString()));
					listaRecordatorioEventoDTO.add(recordatorio);
				}
				
				return listaRecordatorioEventoDTO;
	}

	@Override
	public List<RecordatorioEventoDTO> obtenerRecordatorioEventoPorIdTipo(Long id) {
		StringBuilder jpql = new StringBuilder();
		List<RecordatorioEventoDTO> listaRecordatorioEventoDTO = new ArrayList<>();
		jpql.append(" select id, created_at, is_active, modified_at, user_creation, user_updated, idtipoevento, numerodias, idtipoeventopadre ");
		jpql.append(" from vet.recordatorioevento where idtipoeventopadre = :id ");
		
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("id", id);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			RecordatorioEventoDTO  recordatorio = new RecordatorioEventoDTO();
			recordatorio.setId(Long.parseLong(o[0].toString()));
			recordatorio.setCreatedAt((Date)o[1]);
			recordatorio.setActive((boolean)o[2]);
			recordatorio.setModifiedAt((Date)o[3]);
			recordatorio.setUserCreation(Long.parseLong(o[4].toString()));
			recordatorio.setUserUpdated(o[5] == null? 0 :Long.parseLong(o[5].toString()));
			recordatorio.setIdtipoevento(Long.parseLong(o[6].toString()));
			recordatorio.setNumerodias(Integer.parseInt(o[7].toString()));
			recordatorio.setIdtipoeventopadre(Long.parseLong(o[8].toString()));
			listaRecordatorioEventoDTO.add(recordatorio);
		}
		
		return listaRecordatorioEventoDTO;
	}

}
