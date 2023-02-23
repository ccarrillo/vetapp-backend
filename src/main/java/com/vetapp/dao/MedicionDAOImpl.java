package com.vetapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.vetapp.dto.MedicionDTO;
import com.vetapp.model.Medicion;


@Repository
public class MedicionDAOImpl extends GenericDAOImpl<Medicion, Long> implements MedicionDAO {
	
	
	 /* @Override
	  public List<Medicion> buscarMedicionesPorAnimal(Long id) {
	        Query query = this.em.createQuery("SELECT o FROM Medicion o WHERE o.idanimal = :id and o.isActive = true ORDER BY id desc");
	        query.setParameter("id", id);
	        List<Medicion> medicion = query.getResultList();
	        return medicion;
	  }*/


	public List<MedicionDTO> buscarMedicionesPorAnimal(Long id) {
		StringBuilder jpql = new StringBuilder();
		List<MedicionDTO> listaMedicionDTO = new ArrayList<>();
		jpql.append(" select id, created_at, is_active, modified_at,user_creation, ");
		jpql.append("concorporal, estatura, fecha, peso ");
		jpql.append("from vet.medicion where idanimal = :id and  is_active = true   ");
		
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("id", id);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			MedicionDTO  medicion = new MedicionDTO();
			medicion.setId(Long.parseLong(o[0].toString()));
			medicion.setCreatedAt((Date)o[1]);
			medicion.setActive((boolean)o[2]);
			medicion.setModifiedAt((Date)o[3]);
			medicion.setUserCreation(Long.parseLong(o[4].toString()));
			medicion.setConcorporal(Integer.parseInt(o[5].toString()));
			medicion.setEstatura(Double.parseDouble(o[6].toString()));
			medicion.setFechamedicion((Date)o[7]);
			medicion.setPeso(Double.parseDouble(o[8].toString()));
			listaMedicionDTO.add(medicion);
		}
		
		return listaMedicionDTO;
	}

}
