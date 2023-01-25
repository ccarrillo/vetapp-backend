package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.ParVetValueDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.ParVetDTO;
import com.vetapp.dto.ParVetValueDTO;
import com.vetapp.model.ParVet;
import com.vetapp.model.ParVetValue;
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
public class ParVetValueServiceImpl implements ParVetValueService {
	
	 @Autowired
	 private IAuthenticationFacade authenticationFacade;

    @Autowired
    ParVetValueDAO parVetValueDao;
    
    @Autowired
    UserAuthRepository userAuthRepository;
    
    ModelMapper modelMapper = new ModelMapper();

    public ArrayList<ParVetValueDTO> obtenerParVetValues(Long idParVet) {
        return (ArrayList<ParVetValueDTO>) parVetValueDao.findParVetValueByParvetId(idParVet)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private ParVetValueDTO convertEntityToDto(ParVetValue parvetvalue) {
        if (parvetvalue != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ParVetValueDTO parvetvalueDto = new ParVetValueDTO();
            parvetvalueDto = modelMapper.map(parvetvalue, ParVetValueDTO.class);
            return parvetvalueDto;
        } else {
            return null;
        }
    }

    private ParVetValue convertDtoToEntity(ParVetValueDTO parVetValueDto) {
        if (parVetValueDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ParVetValue parVetValue = new ParVetValue();
            parVetValue = modelMapper.map(parVetValueDto, ParVetValue.class);
            return parVetValue;
        } else {
            return null;
        }
    }

	@Override
	public ParVetValueDTO guardarParVetValue(ParVetValueDTO parVetValueDTO) {
		Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        parVetValueDTO.setUserCreation(user.getId());
        parVetValueDTO.setCreatedAt(Calendar.getInstance().getTime());
        //ParVet obj = parVetDao.save(convertDtoToEntity(parVetDto));
		ParVetValue obj = parVetValueDao.insertar(convertDtoToEntity(parVetValueDTO));
        return convertEntityToDto(obj);
	}

	@Override
	public ParVetValueDTO obtenerParVetValuePorId(Long id) {
		// TODO Auto-generated method stub
		ParVetValue obj = parVetValueDao.buscarPorId(id);
        return convertEntityToDto(obj);
	}

	@Override
	public ParVetValueDTO actualizarParVetValue(ParVetValueDTO parVetValueDto, Long id) {
		 Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        //ParVet objTemp = parVetDao.findById(id).orElse(null);
			ParVetValue objTemp = parVetValueDao.buscarPorId(id);
	        if (objTemp != null) {
	        	parVetValueDto.setId(objTemp.getId());
	        	parVetValueDto.setUserCreation(objTemp.getUserCreation());
	        	parVetValueDto.setCreatedAt(objTemp.getCreatedAt());
	        	parVetValueDto.setUserUpdated(user.getId());
	        	parVetValueDto.setModifiedAt(Calendar.getInstance().getTime());
	            //ParVet obj = parVetDao.save(convertDtoToEntity(parVetDto));
				ParVetValue obj = parVetValueDao.actualizar(convertDtoToEntity(parVetValueDto));
	            return convertEntityToDto(obj);
	        } else {
	            return null;
	        }
	}
	
	 public boolean eliminarParVetValue(Long id) {
	        try {
	            //parVetDao.deleteById(id);
				parVetValueDao.eliminarPorId(id);
	            return true;
	        } catch (Exception err) {
	            return false;
	        }
	    }

	@Override
	public ArrayList<ParVetValueDTO> obtenerParVetValuesTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<ParVetValueDTO>) parVetValueDao.buscarTodos(true);
	}
}
