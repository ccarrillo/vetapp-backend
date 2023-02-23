package com.vetapp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.MedicionDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.EnterpriseDTO;
import com.vetapp.dto.MedicionDTO;
import com.vetapp.model.Enterprise;
import com.vetapp.model.Medicion;
import com.vetapp.model.UserAuth;
import com.vetapp.vo.AnimalVO;

@Service
@Transactional
public class MedicionServiceImpl implements MedicionService{
	
	
	    @Autowired
	    private IAuthenticationFacade authenticationFacade;

	    @Autowired
	    MedicionDAO medicionDao;

	    @Autowired
	    UserAuthRepository userAuthRepository;

	    ModelMapper modelMapper = new ModelMapper();
	

	@Override
	public MedicionDTO guardarMedicion(MedicionDTO medicionDto) {
		// TODO Auto-generated method stub
		Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        medicionDto.setUserCreation(user.getId());
        medicionDto.setCreatedAt(Calendar.getInstance().getTime());
        Medicion obj = medicionDao.insertar(convertDtoToEntity(medicionDto));
        return convertEntityToDto(obj);
	}

	@Override
	public ArrayList<MedicionDTO> obtenerMediciones() {
		return (ArrayList<MedicionDTO>) medicionDao.buscarTodos(new Medicion())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
	}

	@Override
	public MedicionDTO obtenerMedicionPorId(Long id) {
		Medicion obj = medicionDao.buscarPorId(id);
        return convertEntityToDto(obj);
	}

	@Override
	public MedicionDTO actualizarMedicion(MedicionDTO medicionDto, Long id) {
		 Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        Medicion objTemp = medicionDao.buscarPorId(id);
	        if (objTemp != null) {
	        	medicionDto.setId(objTemp.getId());
	        	medicionDto.setUserCreation(objTemp.getUserCreation());
	        	medicionDto.setCreatedAt(objTemp.getCreatedAt());
	        	medicionDto.setUserUpdated(user.getId());
	        	medicionDto.setModifiedAt(Calendar.getInstance().getTime());
	            Medicion obj = medicionDao.actualizar(convertDtoToEntity(medicionDto));
	            return convertEntityToDto(obj);
	        } else {
	            return null;
	        }
	}

	@Override
	public boolean eliminarMedicion(Long id) {
		 try {
	            medicionDao.eliminarPorId(id);
	            return true;
	        } catch (Exception err) {
	            return false;
	        }
	}
	
	 private MedicionDTO convertEntityToDto(Medicion medicion) {
	        if (medicion != null) {
	            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	            MedicionDTO medicionDto = new MedicionDTO();
	            medicionDto = modelMapper.map(medicion, MedicionDTO.class);
	            return medicionDto;
	        } else {
	            return null;
	        }
	    }

	    private Medicion convertDtoToEntity(MedicionDTO medicionDto) {
	        if (medicionDto != null) {
	            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	            Medicion medicion = new Medicion();
	            medicion = modelMapper.map(medicionDto, Medicion.class);
	            return medicion;
	        } else {
	            return null;
	        }
	    }

		@Override
		public List<MedicionDTO> buscarMedicionesPorAnimal(Long id) {
			
			return  medicionDao.buscarMedicionesPorAnimal(id);
            
		}

}
