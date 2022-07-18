package com.vetapp.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetapp.dao.ParVetValueRepository;
import com.vetapp.dto.ParVetValueDto;
import com.vetapp.model.ParVetValue;

@Service
public class ParVetValueService {
	
	//sdsds
    @Autowired
    ParVetValueRepository parVetValueRepository;
    
    ModelMapper modelMapper = new ModelMapper();
        
    private ParVetValueDto convertEntityToDto(ParVetValue parvetvalue) {
        if (parvetvalue != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ParVetValueDto parvetvalueDto = new ParVetValueDto();
            parvetvalueDto = modelMapper.map(parvetvalue, ParVetValueDto.class);
            return parvetvalueDto;
        } else {
            return null;
        }
    }
    
    private ParVetValue convertDtoToEntity(ParVetValueDto parVetValueDto) {
        if (parVetValueDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ParVetValue parVetValue = new ParVetValue();
            parVetValue = modelMapper.map(parVetValueDto, ParVetValue.class);
            return parVetValue;
        } else {
            return null;
        }
    }
    
    public ArrayList<ParVetValueDto> obtenerParVetValues(Long idParVet) {
        return (ArrayList<ParVetValueDto>) parVetValueRepository.findParVetValueByParvetId(idParVet)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    
}
