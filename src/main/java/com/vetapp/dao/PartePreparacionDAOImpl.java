package com.vetapp.dao;

import com.vetapp.model.PartePreparacion;
import com.vetapp.model.PartePreparacion;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PartePreparacionDAOImpl extends GenericDAOImpl<PartePreparacion, Long> implements PartePreparacionDAO {

    @Override
    public List<PartePreparacion> obtenerPartePreparacionPorFormulaId(Long formulaId) {
        Query query = this.em.createQuery("SELECT o FROM PartePreparacion o WHERE o.formula.id = :formulaId");
        query.setParameter("formulaId", formulaId);
        List<PartePreparacion> partePreparaciones = query.getResultList();
        return partePreparaciones;
    }

    @Override
    public PartePreparacion obtenerPartePreparacionPorIdYFormulaId(Long formulaId, Long partePreparacionId) {
        Query query = this.em.createQuery("SELECT o FROM PartePreparacion o WHERE o.id = :partePreparacionId AND o.formula.id = :formulaId");
        query.setParameter("partePreparacionId", partePreparacionId);
        query.setParameter("formulaId", formulaId);
        PartePreparacion partePreparacion = (PartePreparacion) query.getSingleResult();
        return partePreparacion;
    }
}
