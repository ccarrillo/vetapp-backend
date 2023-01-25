package com.vetapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.vetapp.dto.MedicionDTO;
import com.vetapp.model.Animal;
import com.vetapp.model.Medicion;


@Repository
public class MedicionDAOImpl extends GenericDAOImpl<Medicion, Long> implements MedicionDAO {
	
	
	  @Override
	  public List<Medicion> buscarMedicionesPorAnimal(Long id) {
	        Query query = this.em.createQuery("SELECT o FROM Medicion o WHERE o.idanimal = :id and o.isActive = true ORDER BY id desc");
	        query.setParameter("id", id);
	        List<Medicion> medicion = query.getResultList();
	        return medicion;
	  }


	/*@Override
	public List<MedicionDTO> buscarMedicionesPorAnimal(Long id) {
		StringBuilder jpql = new StringBuilder();
		List<MedicionDTO> listaMedicionDTO = new ArrayList<>();
		jpql.append(" select id, concorporal, estatura, fecha, peso from vet.medicion where id_animal = :id and  is_active = true   ");
		
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("id", id);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			MedicionDTO  medicion = new MedicionDTO();
			medicion.setId(Long.parseLong(o[0].toString()));
			medicion.setConcorporal(Integer.parseInt(o[1].toString()));
			medicion.setEstatura(Double.parseDouble(o[2].toString()));
			medicion.setFecha(o[3] == null? " ": o[3].toString());
			medicion.setPeso(Double.parseDouble(o[4].toString()));
			
			listaMedicionDTO.add(medicion);
		}
		
		return listaMedicionDTO;
	}*/

}
