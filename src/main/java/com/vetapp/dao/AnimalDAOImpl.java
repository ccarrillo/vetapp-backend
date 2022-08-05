package com.vetapp.dao;

import com.vetapp.model.Animal;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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

}
