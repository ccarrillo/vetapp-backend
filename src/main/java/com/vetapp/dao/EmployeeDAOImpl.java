package com.vetapp.dao;
import com.vetapp.model.Employee;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl extends GenericDAOImpl<Employee, Long> implements EmployeeDAO {

	@Override
	public List<Employee> obtenerTipoEmpleados(Integer id) {
		Query query = this.em.createQuery("SELECT o FROM Employee o WHERE o.tipoEmpleado = :id and o.isActive = true ");
        query.setParameter("id", id);
        List<Employee> employes = query.getResultList();
        return employes;
	}

}
