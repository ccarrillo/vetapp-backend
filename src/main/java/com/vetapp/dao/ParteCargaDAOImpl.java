package com.vetapp.dao;

import com.vetapp.model.ParteCarga;
import com.vetapp.model.ParteCarga;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ParteCargaDAOImpl extends GenericDAOImpl<ParteCarga, Long> implements ParteCargaDAO {

    @Override
    public List<ParteCarga> obtenerParteCargaPorFormulaId(Long formulaId) {
        Query query = this.em.createQuery("SELECT o FROM ParteCarga o WHERE o.formula.id = :formulaId");
        query.setParameter("formulaId", formulaId);
        List<ParteCarga> parteCargaes = query.getResultList();
        return parteCargaes;
    }

    @Override
    public ParteCarga obtenerParteCargaPorIdYFormulaId(Long formulaId, Long parteCargaId) {
        Query query = this.em.createQuery("SELECT o FROM ParteCarga o WHERE o.id = :parteCargaId AND o.formula.id = :formulaId");
        query.setParameter("parteCargaId", parteCargaId);
        query.setParameter("formulaId", formulaId);
        ParteCarga parteCarga = (ParteCarga) query.getSingleResult();
        return parteCarga;
    }
}
