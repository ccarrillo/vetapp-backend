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
import com.vetapp.dao.DetalleProtocoloDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.DetalleProtocoloDTO;
import com.vetapp.dto.ProtocoloDTO;
import com.vetapp.model.DetalleProtocolo;
import com.vetapp.model.UserAuth;

@Service
@Transactional
public class DetalleProtocoloServiceImpl implements DetalleProtocoloService{
	
	
	    @Autowired
	    private IAuthenticationFacade authenticationFacade;

	    @Autowired
	    DetalleProtocoloDAO detalleDao;

	    @Autowired
	    UserAuthRepository userAuthRepository;

	    ModelMapper modelMapper = new ModelMapper();
	    
	    private  DetalleProtocoloDTO convertEntityToDto( DetalleProtocolo detalle) {
	        if (detalle != null) {
	            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	            DetalleProtocoloDTO detalleDto = new  DetalleProtocoloDTO();
	            detalleDto = modelMapper.map(detalle,  DetalleProtocoloDTO.class);
	            return detalleDto;
	        } else {
	            return null;
	        }
	    }

	    private  DetalleProtocolo convertDtoToEntity( DetalleProtocoloDTO detalleDto) {
	        if (detalleDto != null) {
	            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	            DetalleProtocolo detalle = new  DetalleProtocolo();
	            detalle = modelMapper.map(detalleDto,  DetalleProtocolo.class);
	            return detalle;
	        } else {
	            return null;
	        }
	    }

	

	@Override
	public DetalleProtocoloDTO guardarDetalleProtocolo(DetalleProtocoloDTO detalleDto) {
		Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        detalleDto.setUserCreation(user.getId());
        detalleDto.setCreatedAt(Calendar.getInstance().getTime());
        DetalleProtocolo obj = detalleDao.insertar(convertDtoToEntity(detalleDto));
        return convertEntityToDto(obj);
	}

	@Override
	public ArrayList<DetalleProtocoloDTO> obtenerDetalleProtocolo() {
		// TODO Auto-generated method stub
		return (ArrayList<DetalleProtocoloDTO>) detalleDao.buscarTodos(new DetalleProtocolo())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
	}

	@Override
	public DetalleProtocoloDTO obtenerDetalleProtocoloPorId(Long id) {
		// TODO Auto-generated method stub
		DetalleProtocolo obj = detalleDao.buscarPorId(id);
        return convertEntityToDto(obj);
	}

	@Override
	public DetalleProtocoloDTO actualizarDetalleProtocolo(DetalleProtocoloDTO detalleDto, Long id) {
		 Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        DetalleProtocolo objTemp = detalleDao.buscarPorId(id);
	        if (objTemp != null) {
	        	detalleDto.setId(objTemp.getId());
	        	detalleDto.setUserCreation(objTemp.getUserCreation());
	        	detalleDto.setCreatedAt(objTemp.getCreatedAt());
	        	detalleDto.setUserUpdated(user.getId());
	        	detalleDto.setModifiedAt(Calendar.getInstance().getTime());
	        	DetalleProtocolo obj = detalleDao.actualizar(convertDtoToEntity(detalleDto));
	            return convertEntityToDto(obj);
	        } else {
	            return null;
	        }
	}

	@Override
	public boolean eliminarDetalleProtocolo(Long id) {
		try {
            detalleDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
	}

	@Override
	public List<DetalleProtocoloDTO> buscarDetalleProtocoloPorAnimal(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleProtocoloDTO> obtenerListaDetalleProtocolo(Long id) {
		// TODO Auto-generated method stub
		return detalleDao.obtenerListaDetalleProtocoloPorIdTipo( id);
	}

	@Override
	public void eliminarDetalleProtocoloPorIdProtocolo(Long id) {
		// TODO Auto-generated method stub
	
            detalleDao.eliminarDetalleProtocoloPorIdProtocolo(id);
       
	}

	@Override
	public DetalleProtocoloDTO actualizarDetalleProtocolo(ProtocoloDTO protocolo, DetalleProtocoloDTO detalleDto,
			Long id) {
		 Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        DetalleProtocolo objTemp = detalleDao.buscarPorId(id);
	        if (objTemp != null) {
	        	detalleDto.setId(objTemp.getId());
	        	detalleDto.setUserCreation(objTemp.getUserCreation());
	        	detalleDto.setCreatedAt(objTemp.getCreatedAt());
	        	detalleDto.setUserUpdated(user.getId());
	        	detalleDto.setModifiedAt(Calendar.getInstance().getTime());
	        	detalleDto.setProtocolo(protocolo);
	        	DetalleProtocolo obj = detalleDao.actualizar(convertDtoToEntity(detalleDto));
	            return convertEntityToDto(obj);
	        } else {
	            return null;
	        }
	}

	@Override
	public DetalleProtocoloDTO guardarDetalleProtocolo(ProtocoloDTO protocolo, DetalleProtocoloDTO detalleDto) {
		Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        detalleDto.setUserCreation(user.getId());
        detalleDto.setCreatedAt(Calendar.getInstance().getTime());
        detalleDto.setProtocolo(protocolo);
        DetalleProtocolo obj = detalleDao.insertar(convertDtoToEntity(detalleDto));
        return convertEntityToDto(obj);
	}

}
