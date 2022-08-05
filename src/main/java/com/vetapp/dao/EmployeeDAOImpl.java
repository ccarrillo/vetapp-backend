package com.vetapp.dao;

import com.vetapp.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl extends GenericDAOImpl<Employee, Long> implements EmployeeDAO {

}
