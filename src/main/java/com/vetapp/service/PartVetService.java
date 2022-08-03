package com.vetapp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.ParVetRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.ParVetDto;
import com.vetapp.model.ParVet;
import com.vetapp.model.UserAuth;

@Service
public class PartVetService {
	
	    @Autowired
	    private IAuthenticationFacade authenticationFacade;

	    @Autowired
	    ParVetRepository parVetRepository;

	    @Autowired
	    UserAuthRepository userAuthRepository;

	    ModelMapper modelMapper = new ModelMapper();

	    public ParVetDto guardarParVet(ParVetDto parVetDto) {
	        Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        System.out.println("-----------------");
	        System.out.println(auth.getName());
	        System.out.println(user.getId());
	        System.out.println("-----------------");
	        parVetDto.setUserCreation(user.getId());
	        parVetDto.setCreatedAt(Calendar.getInstance().getTime());
	        ParVet obj = parVetRepository.save(convertDtoToEntity(parVetDto));
	        return convertEntityToDto(obj);
	    }

	    public ArrayList<ParVetDto> obtenerParVet() {
	        return (ArrayList<ParVetDto>) parVetRepository.findAll()
	                .stream()
	                .map(this::convertEntityToDto)
	                .collect(Collectors.toList());
	    }

	    public ParVetDto obtenerParVetPorId(Long id) {
	        ParVet obj = parVetRepository.findById(id).orElse(null);
	        return convertEntityToDto(obj);
	    }

	    public ParVetDto actualizarParVet(ParVetDto parVetDto, Long id) {
	        Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        ParVet objTemp = parVetRepository.findById(id).orElse(null);
	        if (objTemp != null) {
	            parVetDto.setId(objTemp.getId());
	            parVetDto.setUserCreation(objTemp.getUserCreation());
	            parVetDto.setCreatedAt(objTemp.getCreatedAt());
	            parVetDto.setUserUpdated(user.getId());
	            parVetDto.setModifiedAt(Calendar.getInstance().getTime());
	            ParVet obj = parVetRepository.save(convertDtoToEntity(parVetDto));
	            return convertEntityToDto(obj);
	        } else {
	            return null;
	        }
	    }
	    

	    public boolean eliminarParVet(Long id) {
	        try {
	            parVetRepository.deleteById(id);
	            return true;
	        } catch (Exception err) {
	            return false;
	        }
	    }

	    private ParVetDto convertEntityToDto(ParVet parVet) {
	        if (parVet != null) {
	            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	            ParVetDto parVetDto = new ParVetDto();
	            parVetDto = modelMapper.map(parVet, ParVetDto.class);
	            return parVetDto;
	        } else {
	            return null;
	        }
	    }

	    private ParVet convertDtoToEntity(ParVetDto parVetDto) {
	        if (parVetDto != null) {
	            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	            ParVet parVet = new ParVet();
	            parVet = modelMapper.map(parVetDto, ParVet.class);
	            return parVet;
	        } else {
	            return null;
	        }
	    }

}
