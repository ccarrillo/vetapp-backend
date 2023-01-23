package com.vetapp.dao;

import com.vetapp.model.RepartoProgramacion;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class RepartoProgramacionDAOImpl extends GenericDAOImpl<RepartoProgramacion, Long> implements RepartoProgramacionDAO {

    @Override
    public List<RepartoProgramacion> obtenerRepartoProgramacionPorFormulaId(Long formulaId) {
        Query query = this.em.createQuery("SELECT o FROM RepartoProgramacion o WHERE o.formula.id = :formulaId order by o.fechaProgramada asc");
        query.setParameter("formulaId", formulaId);
        List<RepartoProgramacion> repartoProgramaciones = query.getResultList();
        return repartoProgramaciones;
    }

    @Override
    public RepartoProgramacion obtenerRepartoProgramacionPorIdYFormulaId(Long formulaId, Long repartoProgramacionId) {
        Query query = this.em.createQuery("SELECT o FROM RepartoProgramacion o WHERE o.id = :repartoProgramacionId AND o.formula.id = :formulaId");
        query.setParameter("repartoProgramacionId", repartoProgramacionId);
        query.setParameter("formulaId", formulaId);
        RepartoProgramacion repartoProgramacion = (RepartoProgramacion) query.getSingleResult();
        return repartoProgramacion;
    }
}
