package com.vetapp.service;

import com.vetapp.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {

    EmployeeDTO guardarEmpleado(EmployeeDTO employeeDto);

    ArrayList<EmployeeDTO> obtenerEmpleados();

    EmployeeDTO obtenerEmpleadoPorId(Long id);

    EmployeeDTO actualizarEmpleado(EmployeeDTO employeeDto, Long id);

    boolean eliminarEmpleado(Long id);

	List<EmployeeDTO> obtenerTipoEmpleados(Integer id);

}
