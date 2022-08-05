package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.AlimentoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.AlimentoDto;
import com.vetapp.model.Alimento;
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
public class AlimentoServiceImpl implements AlimentoService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    AlimentoDAO alimentoDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public AlimentoDto guardarAlimento(AlimentoDto alimentoDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        alimentoDto.setUserCreation(user.getId());
        alimentoDto.setCreatedAt(Calendar.getInstance().getTime());
        Alimento obj = alimentoDao.insertar(convertDtoToEntity(alimentoDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<AlimentoDto> obtenerAlimentos() {
        return (ArrayList<AlimentoDto>) alimentoDao.buscarTodos(new Alimento())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public AlimentoDto obtenerAlimentoPorId(Long id) {
        Alimento obj = alimentoDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public AlimentoDto actualizarAlimento(AlimentoDto alimentoDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Alimento objTemp = alimentoDao.buscarPorId(id);
        if (objTemp != null) {
            alimentoDto.setId(objTemp.getId());
            alimentoDto.setUserCreation(objTemp.getUserCreation());
            alimentoDto.setCreatedAt(objTemp.getCreatedAt());
            alimentoDto.setUserUpdated(user.getId());
            alimentoDto.setModifiedAt(Calendar.getInstance().getTime());
            Alimento obj = alimentoDao.actualizar(convertDtoToEntity(alimentoDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarAlimento(Long id) {
        try {
            alimentoDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private AlimentoDto convertEntityToDto(Alimento alimento) {
        if (alimento != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            AlimentoDto alimentoDto = new AlimentoDto();
            alimentoDto = modelMapper.map(alimento, AlimentoDto.class);
            return alimentoDto;
        } else {
            return null;
        }
    }

    private Alimento convertDtoToEntity(AlimentoDto alimentoDto) {
        if (alimentoDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Alimento alimento = new Alimento();
            alimento = modelMapper.map(alimentoDto, Alimento.class);
            return alimento;
        } else {
            return null;
        }
    }
}
