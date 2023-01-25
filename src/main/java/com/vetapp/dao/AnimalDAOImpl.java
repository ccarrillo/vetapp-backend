package com.vetapp.dao;

import com.vetapp.dto.AnimalBusquedaDTO;
import com.vetapp.dto.AnimalDTO;
import com.vetapp.model.Animal;
import com.vetapp.vo.AnimalVO;

import org.springframework.stereotype.Repository;

import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalDAOImpl extends GenericDAOImpl<Animal, Long> implements AnimalDAO {

    @Override
    public List<Animal> obtenerAnimalBySexes(String sexo) {
        Query query = this.em.createQuery("SELECT o FROM Animal o WHERE o.sexo = :sexo");
        query.setParameter("sexo", sexo);
        List<Animal> animals = query.getResultList();
        return animals;
    }

	@Override
	public List<AnimalVO> obtenerAnimalesVO(Boolean estado) {
		StringBuilder jpql = new StringBuilder();
		List<AnimalVO> listaAnimalVO = new ArrayList<>();
		jpql.append(" select a.id, a.arete, pvr.name as estadoreproductivo, pvp.name as estadoproductivo, a.fechaultimoparto, a.fechaparir  from vet.animal a inner join vet.parvetvalue pvr on a.categoriareproduccionid = pvr.id inner join vet.parvetvalue pvp on a.categoriaproduccionid = pvp.id where a.is_active = :estado ");
		
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("estado", estado);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			AnimalVO  animal = new AnimalVO();
			animal.setId(Long.parseLong(o[0].toString()));
			animal.setArete(o[1] == null? " ": o[1].toString());
			animal.setEstadoreproductivo(o[2] == null? " ": o[2].toString());
			animal.setEstadoproductivo(o[3] == null? " ": o[3].toString());
			animal.setFechaultimoparto(o[4] == null? " ": o[4].toString());
			animal.setFechaparir(o[5] == null? " ": o[5].toString());
			listaAnimalVO.add(animal);
		}
		
		return listaAnimalVO;
	}

	@Override
	public boolean existenciaAnimal(String areteNombre) {
		// TODO Auto-generated method stub
		String jpql = "select count(*) from vet.animal where venta = false and muerto= false and is_active= true and arete= :areteNombre ";
		Query query = em.createNativeQuery(jpql);
		query.setParameter("areteNombre", areteNombre);
		int cantidad = Integer.parseInt("" + query.getSingleResult());
		if (cantidad > 0) {
			return true;
		} else return false;
	}

	@Override
	public boolean existenciaAnimalDistintoId(Long id, String arete) {
		// TODO Auto-generated method stub
		String jpql = "select count(*) from  vet.animal where id not in(:id) and arete= :arete ";
		Query query = em.createNativeQuery(jpql);
		query.setParameter("id", id);
		query.setParameter("arete", arete);
		int cantidad = Integer.parseInt("" + query.getSingleResult());
		if (cantidad > 0) {
			return true;
		} else return false;
	}

	

}
