package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.ParVetDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.ParVetDTO;
import com.vetapp.model.ParVet;
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
public class PartVetServiceImpl implements PartVetService {
	
	    @Autowired
	    private IAuthenticationFacade authenticationFacade;

	    @Autowired
		ParVetDAO parVetDao;

	    @Autowired
	    UserAuthRepository userAuthRepository;

	    ModelMapper modelMapper = new ModelMapper();

	    public ParVetDTO guardarParVet(ParVetDTO parVetDto) {
	        Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        System.out.println("-----------------");
	        System.out.println(auth.getName());
	        System.out.println(user.getId());
	        System.out.println("-----------------");
	        parVetDto.setUserCreation(user.getId());
	        parVetDto.setCreatedAt(Calendar.getInstance().getTime());
	        //ParVet obj = parVetDao.save(convertDtoToEntity(parVetDto));
			ParVet obj = parVetDao.insertar(convertDtoToEntity(parVetDto));
	        return convertEntityToDto(obj);
	    }

	    public ArrayList<ParVetDTO> obtenerParVet() {
	        //return (ArrayList<ParVetDto>) parVetDao.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());

			//return (ArrayList<ParVetDto>) parVetDao.buscarTodos(new ParVet()).stream().map(this::convertEntityToDto).collect(Collectors.toList());
			//return (ArrayList<ParVetDto>) parVetDao.buscarActivos(new ParVet()).stream().map(this::convertEntityToDto).collect(Collectors.toList());
			return (ArrayList<ParVetDTO>) parVetDao.buscarInactivos(true).stream().map(this::convertEntityToDto).collect(Collectors.toList());
	    }

	    public ParVetDTO obtenerParVetPorId(Long id) {
	        //ParVet obj = parVetDao.findById(id).orElse(null);
			ParVet obj = parVetDao.buscarPorId(id);
	        return convertEntityToDto(obj);
	    }

	    public ParVetDTO actualizarParVet(ParVetDTO parVetDto, Long id) {
	        Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        //ParVet objTemp = parVetDao.findById(id).orElse(null);
			ParVet objTemp = parVetDao.buscarPorId(id);
	        if (objTemp != null) {
	            parVetDto.setId(objTemp.getId());
	            parVetDto.setUserCreation(objTemp.getUserCreation());
	            parVetDto.setCreatedAt(objTemp.getCreatedAt());
	            parVetDto.setUserUpdated(user.getId());
	            parVetDto.setModifiedAt(Calendar.getInstance().getTime());
	            //ParVet obj = parVetDao.save(convertDtoToEntity(parVetDto));
				ParVet obj = parVetDao.actualizar(convertDtoToEntity(parVetDto));
	            return convertEntityToDto(obj);
	        } else {
	            return null;
	        }
	    }
	    

	    public boolean eliminarParVet(Long id) {
	        try {
	            //parVetDao.deleteById(id);
				parVetDao.eliminarPorId(id);
	            return true;
	        } catch (Exception err) {
	            return false;
	        }
	    }

	    private ParVetDTO convertEntityToDto(ParVet parVet) {
	        if (parVet != null) {
	            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	            ParVetDTO parVetDto = new ParVetDTO();
	            parVetDto = modelMapper.map(parVet, ParVetDTO.class);
	            return parVetDto;
	        } else {
	            return null;
	        }
	    }

	    private ParVet convertDtoToEntity(ParVetDTO parVetDto) {
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
