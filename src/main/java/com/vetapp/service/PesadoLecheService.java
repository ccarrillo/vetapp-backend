package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.PesadoLecheRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.PesadoLecheDto;
import com.vetapp.model.PesadoLeche;
import com.vetapp.model.UserAuth;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Collectors;

@Service
public class PesadoLecheService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    PesadoLecheRepository pesadoLecheRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public PesadoLecheDto guardarPesadoLeche(PesadoLecheDto pesadoLecheDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        pesadoLecheDto.setUserCreation(user.getId());
        pesadoLecheDto.setCreatedAt(Calendar.getInstance().getTime());
        PesadoLeche obj = pesadoLecheRepository.save(convertDtoToEntity(pesadoLecheDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<PesadoLecheDto> obtenerPesadoLeches() {
        return (ArrayList<PesadoLecheDto>) pesadoLecheRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public PesadoLecheDto obtenerPesadoLechePorId(Long id) {
        PesadoLeche obj = pesadoLecheRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public PesadoLecheDto actualizarPesadoLeche(PesadoLecheDto pesadoLecheDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        PesadoLeche objTemp = pesadoLecheRepository.findById(id).orElse(null);
        if (objTemp != null) {
            pesadoLecheDto.setId(objTemp.getId());
            pesadoLecheDto.setUserCreation(objTemp.getUserCreation());
            pesadoLecheDto.setCreatedAt(objTemp.getCreatedAt());
            pesadoLecheDto.setUserUpdated(user.getId());
            pesadoLecheDto.setModifiedAt(Calendar.getInstance().getTime());
            PesadoLeche obj = pesadoLecheRepository.save(convertDtoToEntity(pesadoLecheDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarPesadoLeche(Long id) {
        try {
            pesadoLecheRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private PesadoLecheDto convertEntityToDto(PesadoLeche pesadoLeche) {
        if (pesadoLeche != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            PesadoLecheDto pesadoLecheDto = new PesadoLecheDto();
            pesadoLecheDto = modelMapper.map(pesadoLeche, PesadoLecheDto.class);
            return pesadoLecheDto;
        } else {
            return null;
        }
    }

    private PesadoLeche convertDtoToEntity(PesadoLecheDto pesadoLecheDto) {
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
