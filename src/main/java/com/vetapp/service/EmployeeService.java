package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.EmployeeRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.EmployeeDto;
import com.vetapp.model.Employee;
import com.vetapp.model.UserAuth;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public EmployeeDto guardarEmpleado(EmployeeDto employeeDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        employeeDto.setUserCreation(user.getId());
        employeeDto.setCreatedAt(Calendar.getInstance().getTime());
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
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Employee objTemp = employeeRepository.findById(id).orElse(null);
        if (objTemp != null) {
            employeeDto.setId(objTemp.getId());
            employeeDto.setUserCreation(objTemp.getUserCreation());
            employeeDto.setCreatedAt(objTemp.getCreatedAt());
            employeeDto.setUserUpdated(user.getId());
            employeeDto.setModifiedAt(Calendar.getInstance().getTime());
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
