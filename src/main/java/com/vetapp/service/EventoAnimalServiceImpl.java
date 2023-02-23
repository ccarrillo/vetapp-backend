package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.EventoAnimalDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.AnimalDTO;
import com.vetapp.dto.DetalleTipoEventoAnimalDTO;
import com.vetapp.dto.DetalleTipoEventoDTO;
import com.vetapp.dto.EventoAnimalDTO;
import com.vetapp.dto.RecordatorioEventoAnimalDTO;
import com.vetapp.dto.RecordatorioEventoDTO;
import com.vetapp.dto.TipoEventoDTO;
import com.vetapp.model.EventoAnimal;
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
public class EventoAnimalServiceImpl implements EventoAnimalService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;
    
    @Autowired
    private DetalleTipoEventoAnimalService  detalleTipoEventoAnimalService;
    
    @Autowired
    private RecordatorioEventoAnimalService recordatorioEventoAnimalService;

    @Autowired
    EventoAnimalDAO eventoAnimalDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public EventoAnimalDTO guardarEvento(EventoAnimalDTO eventoDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        eventoDto.setUserCreation(user.getId());
        eventoDto.setCreatedAt(Calendar.getInstance().getTime());
        EventoAnimal obj = eventoAnimalDao.insertar(convertDtoToEntity(eventoDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<EventoAnimalDTO> obtenerEventos() {
        return (ArrayList<EventoAnimalDTO>) eventoAnimalDao.buscarTodos(new EventoAnimal())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public EventoAnimalDTO obtenerEventoPorId(Long id) {
        EventoAnimal obj = eventoAnimalDao.buscarPorId(id);
        
        EventoAnimalDTO eventoAnimalDTO=  convertEntityToDto(obj);
        List<DetalleTipoEventoAnimalDTO> listaDetallleTipoEventoAnimalDTO = detalleTipoEventoAnimalService.obtenerListaDetallePorIdEventoAnimal(id);
        List<RecordatorioEventoAnimalDTO> listaRecordatorioEventoAnimalDTO = recordatorioEventoAnimalService.obtenerRecordatorioEventoAnimalPorIdEvento(id);
        eventoAnimalDTO.setListaDetallleTipoEventoAnimalDTO(listaDetallleTipoEventoAnimalDTO);
        eventoAnimalDTO.setListaRecordatorioEventoAnimalDTO(listaRecordatorioEventoAnimalDTO);
        
        return eventoAnimalDTO;
    }

    public EventoAnimalDTO actualizarEvento(EventoAnimalDTO eventoDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        EventoAnimal objTemp = eventoAnimalDao.buscarPorId(id);
        if (objTemp != null) {
            eventoDto.setId(objTemp.getId());
            eventoDto.setUserCreation(objTemp.getUserCreation());
            eventoDto.setCreatedAt(objTemp.getCreatedAt());
            eventoDto.setUserUpdated(user.getId());
            eventoDto.setModifiedAt(Calendar.getInstance().getTime());
            EventoAnimal obj = eventoAnimalDao.actualizar(convertDtoToEntity(eventoDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarEvento(Long id) {
        try {
            eventoAnimalDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private EventoAnimalDTO convertEntityToDto(EventoAnimal evento) {
        if (evento != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            EventoAnimalDTO eventoDto = new EventoAnimalDTO();
            eventoDto = modelMapper.map(evento, EventoAnimalDTO.class);
            return eventoDto;
        } else {
            return null;
        }
    }

    private EventoAnimal convertDtoToEntity(EventoAnimalDTO eventoDto) {
        if (eventoDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            EventoAnimal evento = new EventoAnimal();
            evento = modelMapper.map(eventoDto, EventoAnimal.class);
            return evento;
        } else {
            return null;
        }
    }

	@Override
	public List<EventoAnimalDTO> obtenerEventosPorIdAnimal(Long id) {
		// return (ArrayList<EventoAnimalDTO>) eventoAnimalDao.obtenerEventosPorIdAnimal(id);
		return (List<EventoAnimalDTO>) eventoAnimalDao.obtenerEventosPorIdAnimal(id);
				 
				    
	}
}
