package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.PesadoLecheDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.PesadoLecheDTO;
import com.vetapp.model.PesadoLeche;
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
public class PesadoLecheServiceImpl implements PesadoLecheService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    PesadoLecheDAO pesadoLecheDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public PesadoLecheDTO guardarPesadoLeche(PesadoLecheDTO pesadoLecheDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        pesadoLecheDto.setUserCreation(user.getId());
        pesadoLecheDto.setCreatedAt(Calendar.getInstance().getTime());
        PesadoLeche obj = pesadoLecheDao.insertar(convertDtoToEntity(pesadoLecheDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<PesadoLecheDTO> obtenerPesadoLeches() {
        return (ArrayList<PesadoLecheDTO>) pesadoLecheDao.buscarTodos(new PesadoLeche())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public PesadoLecheDTO obtenerPesadoLechePorId(Long id) {
        PesadoLeche obj = pesadoLecheDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public PesadoLecheDTO actualizarPesadoLeche(PesadoLecheDTO pesadoLecheDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        PesadoLeche objTemp = pesadoLecheDao.buscarPorId(id);
        if (objTemp != null) {
            pesadoLecheDto.setId(objTemp.getId());
            pesadoLecheDto.setUserCreation(objTemp.getUserCreation());
            pesadoLecheDto.setCreatedAt(objTemp.getCreatedAt());
            pesadoLecheDto.setUserUpdated(user.getId());
            pesadoLecheDto.setModifiedAt(Calendar.getInstance().getTime());
            PesadoLeche obj = pesadoLecheDao.actualizar(convertDtoToEntity(pesadoLecheDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarPesadoLeche(Long id) {
        try {
            pesadoLecheDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private PesadoLecheDTO convertEntityToDto(PesadoLeche pesadoLeche) {
        if (pesadoLeche != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            PesadoLecheDTO pesadoLecheDto = new PesadoLecheDTO();
            pesadoLecheDto = modelMapper.map(pesadoLeche, PesadoLecheDTO.class);
            return pesadoLecheDto;
        } else {
            return null;
        }
    }

    private PesadoLeche convertDtoToEntity(PesadoLecheDTO pesadoLecheDto) {
        if (pesadoLecheDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            PesadoLeche pesadoLeche = new PesadoLeche();
            pesadoLeche = modelMapper.map(pesadoLecheDto, PesadoLeche.class);
            return pesadoLeche;
        } else {
            return null;
        }
    }
}
