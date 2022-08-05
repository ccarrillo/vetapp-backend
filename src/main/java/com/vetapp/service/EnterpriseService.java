package com.vetapp.service;

import com.vetapp.dto.EnterpriseDTO;

import java.util.ArrayList;

public interface EnterpriseService {

    EnterpriseDTO guardarEmpresa(EnterpriseDTO enterpriseDto);

    ArrayList<EnterpriseDTO> obtenerEmpresas();

    EnterpriseDTO obtenerEmpresaPorId(Long id);

    EnterpriseDTO actualizarEmpresa(EnterpriseDTO employeeDto, Long id);

    boolean eliminarEmpresa(Long id);

}
