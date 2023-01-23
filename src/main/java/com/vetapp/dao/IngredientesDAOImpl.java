package com.vetapp.dao;

import com.vetapp.model.Ingredientes;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class IngredientesDAOImpl extends GenericDAOImpl<Ingredientes, Long> implements IngredientesDAO {

    @Override
    public List<Ingredientes> obtenerIngredientesPorFormulaId(Long formulaId) {
        Query query = this.em.createQuery("SELECT o FROM Ingredientes o WHERE o.formula.id = :formulaId");
        query.setParameter("formulaId", formulaId);
        List<Ingredientes> ingredientes = query.getResultList();
        return ingredientes;
    }

    @Override
    public Ingredientes obtenerIngredientesPorIdYFormulaId(Long formulaId, Long ingredientesId) {
        Query query = this.em.createQuery("SELECT o FROM Ingredientes o WHERE o.id = :ingredientesId AND o.formula.id = :formulaId");
        query.setParameter("ingredientesId", ingredientesId);
        query.setParameter("formulaId", formulaId);
        Ingredientes ingredientes = (Ingredientes) query.getSingleResult();
        return ingredientes;
    }

    @Override
    public List<Ingredientes> obtenerIngredientesPorInsumoId(Long insumoId) {
        Query query = this.em.createQuery("SELECT o FROM Ingredientes o WHERE o.insumo.id = :insumoId");
        query.setParameter("insumoId", insumoId);
        List<Ingredientes> ingredientes = query.getResultList();
        return ingredientes;
    }

    @Override
    public Ingredientes obtenerIngredientesPorIdYInsumoId(Long insumoId, Long ingredientesId) {
        Query query = this.em.createQuery("SELECT o FROM Ingredientes o WHERE o.id = :ingredientesId AND o.insumo.id = :insumoId");
        query.setParameter("ingredientesId", ingredientesId);
        query.setParameter("insumoId", insumoId);
        Ingredientes ingredientes = (Ingredientes) query.getSingleResult();
        return ingredientes;
    }

    @Override
    public Integer guardarIngredientesMasivo(Long formulaId, Long categoriaFormulaId) {
        Integer estado = null;
        StringBuilder sqlString = new StringBuilder();
        try {
            sqlString.append("SELECT * FROM VET.insertar_ingredientes(?1,?2) ");

            Query query = this.em.createNativeQuery(sqlString.toString());
            query.setParameter(1, formulaId);
            query.setParameter(2, categoriaFormulaId);
            estado = (Integer) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return estado;
    }

}
