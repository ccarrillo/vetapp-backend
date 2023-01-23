package com.vetapp.dao;

import com.vetapp.model.CategoriaFormulaInsumo;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoriaFormulaInsumoDAOImpl extends GenericDAOImpl<CategoriaFormulaInsumo, Long> implements CategoriaFormulaInsumoDAO {

    @Override
    public List<CategoriaFormulaInsumo> obtenerCategoriaFormulaInsumoPorCategoriaFormulaId(Long categoriaFormulaId) {
        Query query = this.em.createQuery("SELECT o FROM CategoriaFormulaInsumo o WHERE o.categoriaFormulaId = :categoriaFormulaId");
        query.setParameter("categoriaFormulaId", categoriaFormulaId);
        List<CategoriaFormulaInsumo> categoriaFormulaInsumo = query.getResultList();
        return categoriaFormulaInsumo;
    }
}
