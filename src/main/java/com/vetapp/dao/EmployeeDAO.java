package com.vetapp.dao;

import java.util.List;

import com.vetapp.model.Employee;

public interface EmployeeDAO extends GenericDAO<Employee, Long> {

	List<Employee> obtenerTipoEmpleados(Integer id);

}