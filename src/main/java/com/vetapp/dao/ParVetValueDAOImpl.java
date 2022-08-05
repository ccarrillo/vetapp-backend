package com.vetapp.dao;

import com.vetapp.model.ParVetValue;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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

}
