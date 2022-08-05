package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.RacionDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.RacionDTO;
import com.vetapp.model.Racion;
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
public class RacionServiceImpl implements RacionService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    RacionDAO racionDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public RacionDTO guardarRacion(RacionDTO racionDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        racionDto.setUserCreation(user.getId());
        racionDto.setCreatedAt(Calendar.getInstance().getTime());
        Racion obj = racionDao.insertar(convertDtoToEntity(racionDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<RacionDTO> obtenerRacions() {
        return (ArrayList<RacionDTO>) racionDao.buscarTodos(new Racion())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public RacionDTO obtenerRacionPorId(Long id) {
        Racion obj = racionDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public RacionDTO actualizarRacion(RacionDTO racionDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Racion objTemp = racionDao.buscarPorId(id);
        if (objTemp != null) {
            racionDto.setId(objTemp.getId());
            racionDto.setUserCreation(objTemp.getUserCreation());
            racionDto.setCreatedAt(objTemp.getCreatedAt());
            racionDto.setUserUpdated(user.getId());
            racionDto.setModifiedAt(Calendar.getInstance().getTime());
            Racion obj = racionDao.actualizar(convertDtoToEntity(racionDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarRacion(Long id) {
        try {
            racionDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private RacionDTO convertEntityToDto(Racion racion) {
        if (racion != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            RacionDTO racionDto = new RacionDTO();
            racionDto = modelMapper.map(racion, RacionDTO.class);
            return racionDto;
        } else {
            return null;
        }
    }

    private Racion convertDtoToEntity(RacionDTO racionDto) {
        if (racionDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Racion racion = new Racion();
            racion = modelMapper.map(racionDto, Racion.class);
            return racion;
        } else {
            return null;
        }
    }
}
