package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.EventoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.EventoDto;
import com.vetapp.model.Evento;
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
public class EventoServiceImpl implements EventoService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    EventoDAO eventoDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public EventoDto guardarEvento(EventoDto eventoDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        eventoDto.setUserCreation(user.getId());
        eventoDto.setCreatedAt(Calendar.getInstance().getTime());
        Evento obj = eventoDao.insertar(convertDtoToEntity(eventoDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<EventoDto> obtenerEventos() {
        return (ArrayList<EventoDto>) eventoDao.buscarTodos(new Evento())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public EventoDto obtenerEventoPorId(Long id) {
        Evento obj = eventoDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public EventoDto actualizarEvento(EventoDto eventoDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Evento objTemp = eventoDao.buscarPorId(id);
        if (objTemp != null) {
            eventoDto.setId(objTemp.getId());
            eventoDto.setUserCreation(objTemp.getUserCreation());
            eventoDto.setCreatedAt(objTemp.getCreatedAt());
            eventoDto.setUserUpdated(user.getId());
            eventoDto.setModifiedAt(Calendar.getInstance().getTime());
            Evento obj = eventoDao.actualizar(convertDtoToEntity(eventoDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarEvento(Long id) {
        try {
            eventoDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private EventoDto convertEntityToDto(Evento evento) {
        if (evento != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            EventoDto eventoDto = new EventoDto();
            eventoDto = modelMapper.map(evento, EventoDto.class);
            return eventoDto;
        } else {
            return null;
        }
    }

    private Evento convertDtoToEntity(EventoDto eventoDto) {
        if (eventoDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Evento evento = new Evento();
            evento = modelMapper.map(eventoDto, Evento.class);
            return evento;
        } else {
            return null;
        }
    }
}
