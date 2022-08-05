package com.vetapp.service;

import com.vetapp.dto.EmployeeDTO;

import java.util.ArrayList;

public interface EmployeeService {

    EmployeeDTO guardarEmpleado(EmployeeDTO employeeDto);

    ArrayList<EmployeeDTO> obtenerEmpleados();

    EmployeeDTO obtenerEmpleadoPorId(Long id);

    EmployeeDTO actualizarEmpleado(EmployeeDTO employeeDto, Long id);

    boolean eliminarEmpleado(Long id);

}
