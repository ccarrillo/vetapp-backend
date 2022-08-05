package com.vetapp.dao;

import com.vetapp.model.ParVet;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ParVetDAOImpl extends GenericDAOImpl<ParVet, Long> implements ParVetDAO {

    @Override
    public List<ParVet> buscarInactivos(Boolean estado) {
        Query query = this.em.createQuery("select o FROM ParVet o where o.isActive = :estado");
        query.setParameter("estado", estado);
        List<ParVet> parVets = query.getResultList();
        return parVets;
    }
}
