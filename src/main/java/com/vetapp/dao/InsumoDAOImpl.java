package com.vetapp.dao;

import com.vetapp.model.Insumo;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class InsumoDAOImpl extends GenericDAOImpl<Insumo, Long> implements InsumoDAO {

    @Override
    public List<Insumo> obtenerInsumoPorCategoriaFormulaId(Long categoriaFormulaId) {
        List<Insumo> insumo = null;
        StringBuilder sqlString = new StringBuilder();

        sqlString.append("SELECT I.* FROM VET.insumo I ");
        sqlString.append("INNER JOIN VET.cat_form_insumo CFI on I.id = CFI.insumo_id ");
        sqlString.append("WHERE CFI.cat_form_id = :categoriaFormulaId ");
        sqlString.append("ORDER BY I.categoria_id ASC,I.id ASC ");

        Query query = this.em.createNativeQuery(sqlString.toString(), Insumo.class);
        query.setParameter("categoriaFormulaId", categoriaFormulaId);
        insumo = (List<Insumo>) query.getResultList();
        return insumo;
    }

}
