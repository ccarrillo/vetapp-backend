package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.RecordatorioEventoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.RecordatorioEventoDTO;
import com.vetapp.model.RecordatorioEvento;
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
public class RecordatorioEventoServiceImpl implements RecordatorioEventoService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    RecordatorioEventoDAO recordatorioEventoDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public RecordatorioEventoDTO guardarRecordatorioEvento(RecordatorioEventoDTO recordatorioEventoDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        recordatorioEventoDto.setUserCreation(user.getId());
        recordatorioEventoDto.setCreatedAt(Calendar.getInstance().getTime());
        RecordatorioEvento obj = recordatorioEventoDao.insertar(convertDtoToEntity(recordatorioEventoDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<RecordatorioEventoDTO> obtenerRecordatorioEventos() {
        return (ArrayList<RecordatorioEventoDTO>) recordatorioEventoDao.buscarTodos(new RecordatorioEvento())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public RecordatorioEventoDTO obtenerRecordatorioEventoPorId(Long id) {
        RecordatorioEvento obj = recordatorioEventoDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public RecordatorioEventoDTO actualizarRecordatorioEvento(RecordatorioEventoDTO recordatorioEventoDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        RecordatorioEvento objTemp = recordatorioEventoDao.buscarPorId(id);
        if (objTemp != null) {
            recordatorioEventoDto.setId(objTemp.getId());
            recordatorioEventoDto.setUserCreation(objTemp.getUserCreation());
            recordatorioEventoDto.setCreatedAt(objTemp.getCreatedAt());
            recordatorioEventoDto.setUserUpdated(user.getId());
            recordatorioEventoDto.setModifiedAt(Calendar.getInstance().getTime());
            RecordatorioEvento obj = recordatorioEventoDao.actualizar(convertDtoToEntity(recordatorioEventoDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarRecordatorioEvento(Long id) {
        try {
            recordatorioEventoDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private RecordatorioEventoDTO convertEntityToDto(RecordatorioEvento recordatorioEvento) {
        if (recordatorioEvento != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            RecordatorioEventoDTO recordatorioEventoDto = new RecordatorioEventoDTO();
            recordatorioEventoDto = modelMapper.map(recordatorioEvento, RecordatorioEventoDTO.class);
            return recordatorioEventoDto;
        } else {
            return null;
        }
    }

    private RecordatorioEvento convertDtoToEntity(RecordatorioEventoDTO recordatorioEventoDto) {
        if (recordatorioEventoDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            RecordatorioEvento recordatorioEvento = new RecordatorioEvento();
            recordatorioEvento = modelMapper.map(recordatorioEventoDto, RecordatorioEvento.class);
            return recordatorioEvento;
        } else {
            return null;
        }
    }

	@Override
	public List<RecordatorioEventoDTO> obtenerRecordatorioEventoPorIdGrupo(Long id) {
		// TODO Auto-generated method stub
		return recordatorioEventoDao.obtenerRecordatorioEventoPorIdGrupo(id);
	}

	@Override
	public List<RecordatorioEventoDTO> obtenerRecordatorioEventoPorIdTipo(Long id) {
		// TODO Auto-generated method stub
		return recordatorioEventoDao.obtenerRecordatorioEventoPorIdTipo(id);
	}

	@Override
	public void eliminarDetalleRecordatorioPorIdTipoEvento(Long id) {
		// TODO Auto-generated method stub
		recordatorioEventoDao.eliminarDetalleRecordatorioPorIdTipoEvento(id);;
		
	}
}
