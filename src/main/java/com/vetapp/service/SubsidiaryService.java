package com.vetapp.service;

import com.vetapp.dto.SubsidiaryDto;

import java.util.ArrayList;

public interface SubsidiaryService {

    SubsidiaryDto guardarSubsidiary(SubsidiaryDto subsidiaryDto);

    ArrayList<SubsidiaryDto> obtenerSubsidiarys();

    SubsidiaryDto obtenerSubsidiaryPorId(Long id);

    SubsidiaryDto actualizarSubsidiary(SubsidiaryDto subsidiaryDto, Long id);

    boolean eliminarSubsidiary(Long id);
}
