package com.vetapp.dao;

import com.vetapp.model.CategoriaFormulaAlimentos;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoriaFormulaAlimentosDAOImpl extends GenericDAOImpl<CategoriaFormulaAlimentos, Long> implements CategoriaFormulaAlimentosDAO {

    @Override
    public List<CategoriaFormulaAlimentos> obtenerCategoriaFormulaAlimentosPorCategoriaFormulaId(Long categoriaFormulaId) {
        Query query = this.em.createQuery("SELECT o FROM CategoriaFormulaAlimentos o WHERE o.categoriaFormula.id = :categoriaFormulaId");
        query.setParameter("categoriaFormulaId", categoriaFormulaId);
        List<CategoriaFormulaAlimentos> categoriaFormulaAlimentos = query.getResultList();
        return categoriaFormulaAlimentos;
    }

    @Override
    public CategoriaFormulaAlimentos obtenerCategoriaFormulaAlimentosPorIdYCategoriaFormulaId(Long categoriaFormulaId, Long categoriaFormulaAlimentosId) {
        Query query = this.em.createQuery("SELECT o FROM CategoriaFormulaAlimentos o WHERE o.id = :categoriaFormulaAlimentosId AND o.categoriaFormula.id = :categoriaFormulaId");
        query.setParameter("categoriaFormulaAlimentosId", categoriaFormulaAlimentosId);
        query.setParameter("categoriaFormulaId", categoriaFormulaId);
        CategoriaFormulaAlimentos categoriaFormulaAlimento = (CategoriaFormulaAlimentos) query.getSingleResult();
        return categoriaFormulaAlimento;
    }
}
