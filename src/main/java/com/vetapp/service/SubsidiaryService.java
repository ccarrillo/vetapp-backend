package com.vetapp.service;

import com.vetapp.dto.SubsidiaryDTO;

import java.util.ArrayList;

public interface SubsidiaryService {

    SubsidiaryDTO guardarSubsidiary(SubsidiaryDTO subsidiaryDto);

    ArrayList<SubsidiaryDTO> obtenerSubsidiarys();

    SubsidiaryDTO obtenerSubsidiaryPorId(Long id);

    SubsidiaryDTO actualizarSubsidiary(SubsidiaryDTO subsidiaryDto, Long id);

    boolean eliminarSubsidiary(Long id);
}
