package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.ProduccionLecheDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.ProduccionLecheDTO;
import com.vetapp.model.ProduccionLeche;
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
public class ProduccionLecheServiceImpl implements ProduccionLecheService{

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    ProduccionLecheDAO produccionLecheDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ProduccionLecheDTO guardarProduccionLeche(ProduccionLecheDTO produccionLecheDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        produccionLecheDto.setUserCreation(user.getId());
        produccionLecheDto.setCreatedAt(Calendar.getInstance().getTime());
        ProduccionLeche obj = produccionLecheDao.insertar(convertDtoToEntity(produccionLecheDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<ProduccionLecheDTO> obtenerProduccionLeches() {
        return (ArrayList<ProduccionLecheDTO>) produccionLecheDao.buscarTodos(new ProduccionLeche())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public ProduccionLecheDTO obtenerProduccionLechePorId(Long id) {
        ProduccionLeche obj = produccionLecheDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public ProduccionLecheDTO actualizarProduccionLeche(ProduccionLecheDTO produccionLecheDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        ProduccionLeche objTemp = produccionLecheDao.buscarPorId(id);
        if (objTemp != null) {
            produccionLecheDto.setId(objTemp.getId());
            produccionLecheDto.setUserCreation(objTemp.getUserCreation());
            produccionLecheDto.setCreatedAt(objTemp.getCreatedAt());
            produccionLecheDto.setUserUpdated(user.getId());
            produccionLecheDto.setModifiedAt(Calendar.getInstance().getTime());
            ProduccionLeche obj = produccionLecheDao.actualizar(convertDtoToEntity(produccionLecheDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarProduccionLeche(Long id) {
        try {
            produccionLecheDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private ProduccionLecheDTO convertEntityToDto(ProduccionLeche produccionLeche) {
        if (produccionLeche != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ProduccionLecheDTO produccionLecheDto = new ProduccionLecheDTO();
            produccionLecheDto = modelMapper.map(produccionLeche, ProduccionLecheDTO.class);
            return produccionLecheDto;
        } else {
            return null;
        }
    }

    private ProduccionLeche convertDtoToEntity(ProduccionLecheDTO produccionLecheDto) {
        if (produccionLecheDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ProduccionLeche produccionLeche = new ProduccionLeche();
            produccionLeche = modelMapper.map(produccionLecheDto, ProduccionLeche.class);
            return produccionLeche;
        } else {
            return null;
        }
    }
}
