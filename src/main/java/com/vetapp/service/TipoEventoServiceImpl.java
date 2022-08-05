package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.TipoEventoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.TipoEventoDto;
import com.vetapp.model.TipoEvento;
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
public class TipoEventoServiceImpl implements TipoEventoService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    TipoEventoDAO tipoEventoDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public TipoEventoDto guardarTipoEvento(TipoEventoDto tipoEventoDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        tipoEventoDto.setUserCreation(user.getId());
        tipoEventoDto.setCreatedAt(Calendar.getInstance().getTime());
        TipoEvento obj = tipoEventoDao.insertar(convertDtoToEntity(tipoEventoDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<TipoEventoDto> obtenerTipoEventos() {
        return (ArrayList<TipoEventoDto>) tipoEventoDao.buscarTodos(new TipoEvento())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public TipoEventoDto obtenerTipoEventoPorId(Long id) {
        TipoEvento obj = tipoEventoDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public TipoEventoDto actualizarTipoEvento(TipoEventoDto tipoEventoDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        TipoEvento objTemp = tipoEventoDao.buscarPorId(id);
        if (objTemp != null) {
            tipoEventoDto.setId(objTemp.getId());
            tipoEventoDto.setUserCreation(objTemp.getUserCreation());
            tipoEventoDto.setCreatedAt(objTemp.getCreatedAt());
            tipoEventoDto.setUserUpdated(user.getId());
            tipoEventoDto.setModifiedAt(Calendar.getInstance().getTime());
            TipoEvento obj = tipoEventoDao.actualizar(convertDtoToEntity(tipoEventoDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarTipoEvento(Long id) {
        try {
            tipoEventoDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private TipoEventoDto convertEntityToDto(TipoEvento tipoEvento) {
        if (tipoEvento != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            TipoEventoDto tipoEventoDto = new TipoEventoDto();
            tipoEventoDto = modelMapper.map(tipoEvento, TipoEventoDto.class);
            return tipoEventoDto;
        } else {
            return null;
        }
    }

    private TipoEvento convertDtoToEntity(TipoEventoDto tipoEventoDto) {
        if (tipoEventoDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            TipoEvento tipoEvento = new TipoEvento();
            tipoEvento = modelMapper.map(tipoEventoDto, TipoEvento.class);
            return tipoEvento;
        } else {
            return null;
        }
    }
}
