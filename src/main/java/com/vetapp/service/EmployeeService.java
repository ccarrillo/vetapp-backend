package com.vetapp.service;

import com.vetapp.dto.EmployeeDto;

import java.util.ArrayList;

public interface EmployeeService {

    EmployeeDto guardarEmpleado(EmployeeDto employeeDto);

    ArrayList<EmployeeDto> obtenerEmpleados();

    EmployeeDto obtenerEmpleadoPorId(Long id);

    EmployeeDto actualizarEmpleado(EmployeeDto employeeDto, Long id);

    boolean eliminarEmpleado(Long id);

}
