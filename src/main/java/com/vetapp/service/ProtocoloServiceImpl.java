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
import com.vetapp.dao.ProtocoloDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.DetalleProtocoloDTO;
import com.vetapp.dto.ProtocoloDTO;
import com.vetapp.dto.TipoEventoDTO;
import com.vetapp.model.DetalleProtocolo;
import com.vetapp.model.Protocolo;
import com.vetapp.model.UserAuth;

@Service
@Transactional
public class ProtocoloServiceImpl implements ProtocoloService {
	
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    ProtocoloDAO protocoloDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();
    
    
    private  ProtocoloDTO convertEntityToDto( Protocolo protocolo) {
        if (protocolo != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ProtocoloDTO protocoloDto = new  ProtocoloDTO();
            protocoloDto = modelMapper.map(protocolo,  ProtocoloDTO.class);
            return protocoloDto;
        } else {
            return null;
        }
    }

    private  Protocolo convertDtoToEntity( ProtocoloDTO protocoloDto) {
        if (protocoloDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Protocolo protocolo = new  Protocolo();
            protocolo = modelMapper.map(protocoloDto,  Protocolo.class);
            return protocolo;
        } else {
            return null;
        }
    }

	@Override
	public ProtocoloDTO guardarProtocolo(ProtocoloDTO protocoloDto) {
		Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        protocoloDto.setUserCreation(user.getId());
        protocoloDto.setCreatedAt(Calendar.getInstance().getTime());
        Protocolo obj = protocoloDao.insertar(convertDtoToEntity(protocoloDto));
        return convertEntityToDto(obj);
	}

	@Override
	public ArrayList<ProtocoloDTO> obtenerProtocolo() {
		// TODO Auto-generated method stub
		return (ArrayList<ProtocoloDTO>) protocoloDao.buscarTodos(new Protocolo())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
	}

	@Override
	public ProtocoloDTO obtenerProtocoloPorId(Long id) {
		// TODO Auto-generated method stub
		Protocolo obj = protocoloDao.buscarPorId(id);
        return convertEntityToDto(obj);
	}

	@Override
	public ProtocoloDTO actualizarProtocolo(ProtocoloDTO protocoloDto, Long id) {
		 Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        Protocolo objTemp = protocoloDao.buscarPorId(id);
	        if (objTemp != null) {
	        	protocoloDto.setId(objTemp.getId());
	        	protocoloDto.setUserCreation(objTemp.getUserCreation());
	        	protocoloDto.setCreatedAt(objTemp.getCreatedAt());
	        	protocoloDto.setUserUpdated(user.getId());
	        	protocoloDto.setModifiedAt(Calendar.getInstance().getTime());
	        	Protocolo obj = protocoloDao.actualizar(convertDtoToEntity(protocoloDto));
	            return convertEntityToDto(obj);
	        } else {
	            return null;
	        }
	}

	@Override
	public boolean eliminarProtocolo(Long id) {
		try {
            protocoloDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
	}

	@Override
	public List<ProtocoloDTO> buscarProtocoloPorAnimal(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProtocoloDTO> obtenerProtocoloGrupos() {
		// TODO Auto-generated method stub
		return protocoloDao.obtenerProtocoloGrupos();
	}

}
