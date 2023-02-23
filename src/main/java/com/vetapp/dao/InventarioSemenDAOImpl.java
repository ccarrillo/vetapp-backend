package com.vetapp.dao;

import com.vetapp.dto.InventarioSemenDTO;
import com.vetapp.model.InventarioSemen;
import com.vetapp.vo.AnimalVO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class InventarioSemenDAOImpl extends GenericDAOImpl<InventarioSemen, Long> implements InventarioSemenDAO {

	@Override
	public List<InventarioSemenDTO> obtenerInventarioSemenGrupos(boolean estado) {
		// TODO Auto-generated method stub
		StringBuilder jpql = new StringBuilder();
		List<InventarioSemenDTO> listaInventarioDTO = new ArrayList<>();
		jpql.append(" SELECT ins.id,ins.nombre, ins.nombrenum, pv.name, ins.numpajuelasdisponibles, gi.nombre as nombregrupo ");
		jpql.append(" FROM vet.inventariosemen ins inner join vet.grupoinventario gi on ins.id_grupo_inventario = gi.id ");
		jpql.append(" inner join vet.parvetvalue pv on ins.idraza = pv.id where ins.is_active = :estado ");
		Query query = em.createNativeQuery(jpql.toString());		
		query.setParameter("estado", estado);
		List<Object[]> lista = query.getResultList();
		
		for(Object[] o : lista){
			InventarioSemenDTO  animal = new InventarioSemenDTO();
			animal.setId(Long.parseLong(o[0].toString()));
			animal.setNombre(o[1] == null? " ": o[1].toString());
			animal.setNombreNum(o[2] == null? " ": o[2].toString());
			animal.setNombreRaza(o[3] == null? " ": o[3].toString());
			animal.setNumPajuelasDisponibles(Integer.parseInt(o[4].toString()));
			animal.setNombreGrupo(o[5] == null? " ": o[5].toString());
			listaInventarioDTO.add(animal);
		}
		
		return listaInventarioDTO;
	}

	@Override
	public boolean existenciainventarioDistintoId(String nombrenumero) {
		// TODO Auto-generated method stub
				String jpql = "select count(*) from vet.inventariosemen where  is_active= true and nombreNum= :nombrenumero ";
				Query query = em.createNativeQuery(jpql);
				query.setParameter("nombrenumero", nombrenumero);
				int cantidad = Integer.parseInt("" + query.getSingleResult());
				if (cantidad > 0) {
					return true;
				} else return false;
	}

	@Override
	public boolean existenciainventarioDistintoId(Long id, String nombrenumero) {
		// TODO Auto-generated method stub
		String jpql = "select count(*) from  vet.inventariosemen where id not in(:id) and nombreNum= :nombrenumero ";
		Query query = em.createNativeQuery(jpql);
		query.setParameter("id", id);
		query.setParameter("nombrenumero", nombrenumero);
		int cantidad = Integer.parseInt("" + query.getSingleResult());
		if (cantidad > 0) {
			return true;
		} else return false;
	}

}
