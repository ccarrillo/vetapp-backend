package com.vetapp.service;

import com.vetapp.dao.EmployeeRepository;
import com.vetapp.dto.EmployeeDto;
import com.vetapp.model.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    ModelMapper modelMapper = new ModelMapper();

    public EmployeeDto guardarEmpleado(EmployeeDto employeeDto) {
        Employee obj = employeeRepository.save(convertDtoToEntity(employeeDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<EmployeeDto> obtenerEmpleados() {
        return (ArrayList<EmployeeDto>) employeeRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public EmployeeDto obtenerEmpleadoPorId(Long id) {
        Employee obj = employeeRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public EmployeeDto actualizarEmpleado(EmployeeDto employeeDto, Long id) {
        Employee objTemp = employeeRepository.findById(id).orElse(null);
        if (objTemp != null) {
            employeeDto.setId(objTemp.getId());
            Employee obj = employeeRepository.save(convertDtoToEntity(employeeDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarEmpleado(Long id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private EmployeeDto convertEntityToDto(Employee employee) {
        if (employee != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto = modelMapper.map(employee, EmployeeDto.class);
            return employeeDto;
        } else {
            return null;
        }

    }

    private Employee convertDtoToEntity(EmployeeDto employeeDto) {
        if (employeeDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Employee employee = new Employee();
            employee = modelMapper.map(employeeDto, Employee.class);
            return employee;
        } else {
            return null;
        }

    }
}
