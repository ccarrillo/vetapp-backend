package com.vetapp.dao;

import com.vetapp.model.Reparto;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class RepartoDAOImpl extends GenericDAOImpl<Reparto, Long> implements RepartoDAO {

    @Override
    public List<Reparto> obtenerRepartoPorFormulaId(Long formulaId) {
        Query query = this.em.createQuery("SELECT o FROM Reparto o WHERE o.formula.id = :formulaId");
        query.setParameter("formulaId", formulaId);
        List<Reparto> repartoes = query.getResultList();
        return repartoes;
    }

    @Override
    public Reparto obtenerRepartoPorIdYFormulaId(Long formulaId, Long repartoId) {
        Query query = this.em.createQuery("SELECT o FROM Reparto o WHERE o.id = :repartoId AND o.formula.id = :formulaId");
        query.setParameter("repartoId", repartoId);
        query.setParameter("formulaId", formulaId);
        Reparto reparto = (Reparto) query.getSingleResult();
        return reparto;
    }
}
