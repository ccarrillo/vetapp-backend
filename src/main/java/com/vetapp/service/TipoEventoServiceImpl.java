package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.TipoEventoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.DetalleTipoEventoDTO;
import com.vetapp.dto.RecordatorioEventoDTO;
import com.vetapp.dto.TipoEventoDTO;
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
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TipoEventoServiceImpl implements TipoEventoService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;
    
    @Autowired
    private DetalleTipoEventoService detalleTipoEventoService;
    
    @Autowired
    private RecordatorioEventoService recordatorioEventoService;

    @Autowired
    TipoEventoDAO tipoEventoDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public TipoEventoDTO guardarTipoEvento(TipoEventoDTO tipoEventoDto) {
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

    public ArrayList<TipoEventoDTO> obtenerTipoEventos() {
        return (ArrayList<TipoEventoDTO>) tipoEventoDao.buscarActivos(new TipoEvento())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public TipoEventoDTO obtenerTipoEventoPorId(Long id) {
        TipoEvento obj = tipoEventoDao.buscarPorId(id);
        
      TipoEventoDTO tipoEventoDTO=  convertEntityToDto(obj);
      
      List<DetalleTipoEventoDTO> listaDetallleTipoEventoDTO = detalleTipoEventoService.obtenerListaDetalleTipoEventoPorIdTipo(id);
      List<RecordatorioEventoDTO> listaRecordatorioEventoDTO = recordatorioEventoService.obtenerRecordatorioEventoPorIdGrupo(id);
        tipoEventoDTO.setListaDetallleTipoEventoDTO(listaDetallleTipoEventoDTO);
        tipoEventoDTO.setListaRecordatorioEventoDTO(listaRecordatorioEventoDTO);
        return tipoEventoDTO;
    }

    public TipoEventoDTO actualizarTipoEvento(TipoEventoDTO tipoEventoDto, Long id) {
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

    private TipoEventoDTO convertEntityToDto(TipoEvento tipoEvento) {
        if (tipoEvento != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            TipoEventoDTO tipoEventoDto = new TipoEventoDTO();
            tipoEventoDto = modelMapper.map(tipoEvento, TipoEventoDTO.class);
            return tipoEventoDto;
        } else {
            return null;
        }
    }

    private TipoEvento convertDtoToEntity(TipoEventoDTO tipoEventoDto) {
        if (tipoEventoDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            TipoEvento tipoEvento = new TipoEvento();
            tipoEvento = modelMapper.map(tipoEventoDto, TipoEvento.class);
            return tipoEvento;
        } else {
            return null;
        }
    }

	@Override
	public List<TipoEventoDTO> obtenerTipoEventosGrupos() {
		// TODO Auto-generated method stub
		return tipoEventoDao.obtenerTipoEventosGrupos();
	}
}
