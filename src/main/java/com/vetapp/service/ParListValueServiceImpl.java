package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.ParListValueDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.ParListValueDTO;
import com.vetapp.model.ParListValue;
import com.vetapp.model.UserAuth;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParListValueServiceImpl implements ParListValueService{

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    ParListValueDAO parListValueDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ParListValueDTO guardarParListValue(ParListValueDTO parListValueDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        parListValueDto.setUserCreation(user.getId());
        parListValueDto.setCreatedAt(Calendar.getInstance().getTime());
        ParListValue obj = parListValueDao.insertar(convertDtoToEntity(parListValueDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<ParListValueDTO> obtenerParListValues() {
        return (ArrayList<ParListValueDTO>) parListValueDao.buscarTodos(new ParListValue())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public ParListValueDTO obtenerParListValuePorId(Long id) {
        ParListValue obj = parListValueDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public ParListValueDTO actualizarParListValue(ParListValueDTO parListValueDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        ParListValue objTemp = parListValueDao.buscarPorId(id);
        if (objTemp != null) {
            parListValueDto.setId(objTemp.getId());
            parListValueDto.setUserCreation(objTemp.getUserCreation());
            parListValueDto.setCreatedAt(objTemp.getCreatedAt());
            parListValueDto.setUserUpdated(user.getId());
            parListValueDto.setModifiedAt(Calendar.getInstance().getTime());
            ParListValue obj = parListValueDao.actualizar(convertDtoToEntity(parListValueDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }
    

    public boolean eliminarParListValue(Long id) {
        try {
            parListValueDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private ParListValueDTO convertEntityToDto(ParListValue parListValue) {
        if (parListValue != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ParListValueDTO parListValueDto = new ParListValueDTO();
            parListValueDto = modelMapper.map(parListValue, ParListValueDTO.class);
            return parListValueDto;
        } else {
            return null;
        }
    }

    private ParListValue convertDtoToEntity(ParListValueDTO parListValueDto) {
        if (parListValueDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ParListValue parListValue = new ParListValue();
            parListValue = modelMapper.map(parListValueDto, ParListValue.class);
            return parListValue;
        } else {
            return null;
        }
    }
}
