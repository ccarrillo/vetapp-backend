package com.vetapp.service;

import com.vetapp.dao.ParVetValueDAO;
import com.vetapp.dto.ParVetValueDto;
import com.vetapp.model.ParVetValue;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParVetValueServiceImpl implements ParVetValueService {

    @Autowired
    ParVetValueDAO parVetValueDao;
    
    ModelMapper modelMapper = new ModelMapper();

    public ArrayList<ParVetValueDto> obtenerParVetValues(Long idParVet) {
        return (ArrayList<ParVetValueDto>) parVetValueDao.findParVetValueByParvetId(idParVet)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

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
}
