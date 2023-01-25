package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.DetalleTipoEventoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.DetalleTipoEventoDTO;
import com.vetapp.model.DetalleTipoEvento;
import com.vetapp.model.UserAuth;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DetalleTipoEventoServiceImpl implements DetalleTipoEventoService{

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    DetalleTipoEventoDAO detalleTipoEventoDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public DetalleTipoEventoDTO guardarDetalleTipoEvento(DetalleTipoEventoDTO detalleTipoEventoDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        detalleTipoEventoDto.setUserCreation(user.getId());
        detalleTipoEventoDto.setCreatedAt(Calendar.getInstance().getTime());
        DetalleTipoEvento obj = detalleTipoEventoDao.insertar(convertDtoToEntity(detalleTipoEventoDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<DetalleTipoEventoDTO> obtenerDetalleTipoEventos() {
        return (ArrayList<DetalleTipoEventoDTO>) detalleTipoEventoDao.buscarTodos(new DetalleTipoEvento())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public DetalleTipoEventoDTO obtenerDetalleTipoEventoPorId(Long id) {
        DetalleTipoEvento obj = detalleTipoEventoDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public DetalleTipoEventoDTO actualizarDetalleTipoEvento(DetalleTipoEventoDTO detalleTipoEventoDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        DetalleTipoEvento objTemp = detalleTipoEventoDao.buscarPorId(id);
        if (objTemp != null) {
            detalleTipoEventoDto.setId(objTemp.getId());
            detalleTipoEventoDto.setUserCreation(objTemp.getUserCreation());
            detalleTipoEventoDto.setCreatedAt(objTemp.getCreatedAt());
            detalleTipoEventoDto.setUserUpdated(user.getId());
            detalleTipoEventoDto.setModifiedAt(Calendar.getInstance().getTime());
            DetalleTipoEvento obj = detalleTipoEventoDao.actualizar(convertDtoToEntity(detalleTipoEventoDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarDetalleTipoEvento(Long id) {
        try {
            detalleTipoEventoDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private DetalleTipoEventoDTO convertEntityToDto(DetalleTipoEvento detalleTipoEvento) {
        if (detalleTipoEvento != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            DetalleTipoEventoDTO detalleTipoEventoDto = new DetalleTipoEventoDTO();
            detalleTipoEventoDto = modelMapper.map(detalleTipoEvento, DetalleTipoEventoDTO.class);
            return detalleTipoEventoDto;
        } else {
            return null;
        }
    }

    private DetalleTipoEvento convertDtoToEntity(DetalleTipoEventoDTO detalleTipoEventoDto) {
        if (detalleTipoEventoDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            DetalleTipoEvento detalleTipoEvento = new DetalleTipoEvento();
            detalleTipoEvento = modelMapper.map(detalleTipoEventoDto, DetalleTipoEvento.class);
            return detalleTipoEvento;
        } else {
            return null;
        }
    }

	@Override
	public List<DetalleTipoEventoDTO> obtenerListaDetalleTipoEventoPorIdTipo(Long id) {
		// TODO Auto-generated method stub
		return detalleTipoEventoDao.obtenerListaDetalleTipoEventoPorIdTipo( id);
		
	}
}
