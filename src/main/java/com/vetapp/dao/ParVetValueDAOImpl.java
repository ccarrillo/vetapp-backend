package com.vetapp.dao;

import com.vetapp.dto.ParVetValueDTO;
import com.vetapp.model.ParVet;
import com.vetapp.model.ParVetValue;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParVetValueDAOImpl extends GenericDAOImpl<ParVetValue, Long> implements ParVetValueDAO {

    @Override
    public List<ParVetValue> findParVetValueByParvetId(Long idParVet) {
        Query query = this.em.createQuery("SELECT o FROM ParVetValue o WHERE o.parvetId = :idParVet");
        query.setParameter("idParVet", idParVet);
        List<ParVetValue> parVetValues = query.getResultList();
        return parVetValues;
    }

	@Override
	public List<ParVetValueDTO> buscarTodos(Boolean estado) {
		// TODO Auto-generated method stub
		  /*Query query = this.em.createQuery("select o FROM ParVetValue o where o.isActive = :estado", NativeQuery);
	        query.setParameter("estado", estado);
	        List<ParVetValueDTO> parVets = query.getResultList();
	        return parVets;*/
			
			StringBuilder jpql = new StringBuilder();
			List<ParVetValueDTO> listaParVetValueDTO = new ArrayList<>();
			jpql.append("  select pv.id,pv.name,pv.parvet_id,pa.name as nombre from vet.parvet pa inner join vet.parvetvalue pv on pa.id = pv.parvet_id  where pa.is_active = :estado ");
			
			Query query = em.createNativeQuery(jpql.toString());		
			query.setParameter("estado", estado);
			List<Object[]> lista = query.getResultList();
			
			for(Object[] o : lista){
				ParVetValueDTO  parVetValue = new ParVetValueDTO();
				parVetValue.setId(Long.parseLong(o[0].toString()));
				parVetValue.setName(o[1] == null? " ": o[1].toString());
				parVetValue.setParvetId(Long.parseLong(o[2].toString()));
				parVetValue.setNombreparvet(o[3] == null? " ": o[3].toString());
				listaParVetValueDTO.add(parVetValue);
			}
			
			return listaParVetValueDTO;
	}

}
