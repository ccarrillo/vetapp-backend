package com.vetapp.service;

import com.vetapp.dto.EnterpriseDto;

import java.util.ArrayList;

public interface EnterpriseService {

    EnterpriseDto guardarEmpresa(EnterpriseDto enterpriseDto);

    ArrayList<EnterpriseDto> obtenerEmpresas();

    EnterpriseDto obtenerEmpresaPorId(Long id);

    EnterpriseDto actualizarEmpresa(EnterpriseDto employeeDto, Long id);

    boolean eliminarEmpresa(Long id);

}
