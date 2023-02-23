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
import com.vetapp.dao.RecordatorioEventoAnimalDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.EventoAnimalDTO;
import com.vetapp.dto.RecordatorioEventoAnimalDTO;
import com.vetapp.model.RecordatorioEventoAnimal;
import com.vetapp.model.UserAuth;

@Service
@Transactional
public class RecordatorioEventoAnimalServiceImpl implements RecordatorioEventoAnimalService {
	

	@Autowired
	private IAuthenticationFacade authenticationFacade;

    @Autowired
    RecordatorioEventoAnimalDAO recordatorioEventoAnimalDao;

    @Autowired
    UserAuthRepository userAuthRepository;

	ModelMapper modelMapper = new ModelMapper();
	
	
	 private RecordatorioEventoAnimalDTO convertEntityToDto(RecordatorioEventoAnimal recordatorioEventoAnimal) {
	        if (recordatorioEventoAnimal != null) {
	            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	            RecordatorioEventoAnimalDTO recordatorioEventoAnimalDto = new RecordatorioEventoAnimalDTO();
	            recordatorioEventoAnimalDto = modelMapper.map(recordatorioEventoAnimal, RecordatorioEventoAnimalDTO.class);
	            return recordatorioEventoAnimalDto;
	        } else {
	            return null;
	        }
	    }

	    private RecordatorioEventoAnimal convertDtoToEntity(RecordatorioEventoAnimalDTO recordatorioEventoAnimalDto) {
	        if (recordatorioEventoAnimalDto != null) {
	            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	            RecordatorioEventoAnimal recordatorioEventoAnimal = new RecordatorioEventoAnimal();
	            recordatorioEventoAnimal = modelMapper.map(recordatorioEventoAnimalDto, RecordatorioEventoAnimal.class);
	            return recordatorioEventoAnimal;
	        } else {
	            return null;
	        }
	    }

		@Override
		public ArrayList<RecordatorioEventoAnimalDTO> obtenerRecordatorioEventos(
				RecordatorioEventoAnimalDTO recordatorioEventoAnimalDto) {
			// TODO Auto-generated method stub
			return (ArrayList<RecordatorioEventoAnimalDTO>) recordatorioEventoAnimalDao.buscarTodos(new RecordatorioEventoAnimal())
	                .stream()
	                .map(this::convertEntityToDto)
	                .collect(Collectors.toList());
		}

		@Override
		public RecordatorioEventoAnimalDTO obtenerRecordatorioEventoPorId(Long id) {
			// TODO Auto-generated method stub
			RecordatorioEventoAnimal obj = recordatorioEventoAnimalDao.buscarPorId(id);
	        return convertEntityToDto(obj);
		}

		@Override
		public RecordatorioEventoAnimalDTO actualizarRecordatorioEvento(
				RecordatorioEventoAnimalDTO recordatorioEventoAnimalDto, Long id) {
			    Authentication auth = authenticationFacade.getAuthentication();
		        UserAuth user = userAuthRepository.findByEmail(auth.getName());
		        RecordatorioEventoAnimal objTemp = recordatorioEventoAnimalDao.buscarPorId(id);
		        if (objTemp != null) {
		        	recordatorioEventoAnimalDto.setId(objTemp.getId());
		        	recordatorioEventoAnimalDto.setUserCreation(objTemp.getUserCreation());
		        	recordatorioEventoAnimalDto.setCreatedAt(objTemp.getCreatedAt());
		        	recordatorioEventoAnimalDto.setUserUpdated(user.getId());
		        	recordatorioEventoAnimalDto.setModifiedAt(Calendar.getInstance().getTime());
		            RecordatorioEventoAnimal obj = recordatorioEventoAnimalDao.actualizar(convertDtoToEntity(recordatorioEventoAnimalDto));
		            return convertEntityToDto(obj);
		        } else {
		            return null;
		        }
		}

		@Override
		public boolean eliminarRecordatorioEventoAnimal(Long id) {
			 try {
		            recordatorioEventoAnimalDao.eliminarPorId(id);
		            return true;
		        } catch (Exception err) {
		            return false;
		        }
		}

		@Override
		public List<RecordatorioEventoAnimalDTO> obtenerRecordatorioEventoAnimalPorIdEvento(Long id) {
			return recordatorioEventoAnimalDao.obtenerRecordatorioEventoAnimalPorIdEvento(id);
		}

		@Override
		public List<RecordatorioEventoAnimalDTO> obtenerRecordatorioEventoPorIdTipo(Long id) {
			// TODO Auto-generated method stub
			return recordatorioEventoAnimalDao.obtenerRecordatorioEventoAnimalPorIdTipo(id);
		}

		@Override
		public void eliminarDetalleRecordatorioPorIdTipoEvento(Long id) {
			recordatorioEventoAnimalDao.eliminarDetalleRecordatorioAnimalPorIdTipoEvento(id);
			
		}

		@Override
		public RecordatorioEventoAnimalDTO guardarRecordatorioEvento(EventoAnimalDTO eventoAnimalDTO,
			RecordatorioEventoAnimalDTO recordatorioEventoDto) {
			
			Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        System.out.println("-----------------");
	        System.out.println(auth.getName());
	        System.out.println(user.getId());
	        System.out.println("-----------------");
	        recordatorioEventoDto.setUserCreation(user.getId());
	        recordatorioEventoDto.setCreatedAt(Calendar.getInstance().getTime());
	        recordatorioEventoDto.setIdeventoanimal(eventoAnimalDTO);
	        RecordatorioEventoAnimal obj = recordatorioEventoAnimalDao.insertar(convertDtoToEntity(recordatorioEventoDto));
	        return convertEntityToDto(obj);
		}

		@Override
		public RecordatorioEventoAnimalDTO actualizarRecordatorioEvento(EventoAnimalDTO eventoAnimalDTO,
		    RecordatorioEventoAnimalDTO recordatorioEventoDto, Long id) {
			Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        RecordatorioEventoAnimal objTemp = recordatorioEventoAnimalDao.buscarPorId(id);
	        if (objTemp != null) {
	            recordatorioEventoDto.setId(objTemp.getId());
	            recordatorioEventoDto.setUserCreation(objTemp.getUserCreation());
	            recordatorioEventoDto.setCreatedAt(objTemp.getCreatedAt());
	            recordatorioEventoDto.setUserUpdated(user.getId());
	            recordatorioEventoDto.setModifiedAt(Calendar.getInstance().getTime());
	            recordatorioEventoDto.setIdeventoanimal(eventoAnimalDTO);
	            RecordatorioEventoAnimal obj = recordatorioEventoAnimalDao.actualizar(convertDtoToEntity(recordatorioEventoDto));
	            return convertEntityToDto(obj);
	        } else {
	            return null;
	        }
		}

		@Override
		public RecordatorioEventoAnimalDTO guardarRecordatorioEvento(
				RecordatorioEventoAnimalDTO recordatorioEventoAnimalDto) {
			    Authentication auth = authenticationFacade.getAuthentication();
		        UserAuth user = userAuthRepository.findByEmail(auth.getName());
		        System.out.println("-----------------");
		        System.out.println(auth.getName());
		        System.out.println(user.getId());
		        System.out.println("-----------------");
		        recordatorioEventoAnimalDto.setUserCreation(user.getId());
		        recordatorioEventoAnimalDto.setCreatedAt(Calendar.getInstance().getTime());
		        RecordatorioEventoAnimal obj = recordatorioEventoAnimalDao.insertar(convertDtoToEntity(recordatorioEventoAnimalDto));
		        return convertEntityToDto(obj);
		}
	

	
	
	
}
