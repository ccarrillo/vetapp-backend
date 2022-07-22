package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.InventarioSemenRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.InventarioSemenDto;
import com.vetapp.model.InventarioSemen;
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
public class InventarioSemenService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    InventarioSemenRepository inventarioSemenRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public InventarioSemenDto guardarInventarioSemen(InventarioSemenDto inventarioSemenDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        inventarioSemenDto.setUserCreation(user.getId());
        inventarioSemenDto.setCreatedAt(Calendar.getInstance().getTime());
        InventarioSemen obj = inventarioSemenRepository.save(convertDtoToEntity(inventarioSemenDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<InventarioSemenDto> obtenerInventarioSemens() {
        return (ArrayList<InventarioSemenDto>) inventarioSemenRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public InventarioSemenDto obtenerInventarioSemenPorId(Long id) {
        InventarioSemen obj = inventarioSemenRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public InventarioSemenDto actualizarInventarioSemen(InventarioSemenDto inventarioSemenDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        InventarioSemen objTemp = inventarioSemenRepository.findById(id).orElse(null);
        if (objTemp != null) {
            inventarioSemenDto.setId(objTemp.getId());
            inventarioSemenDto.setUserCreation(objTemp.getUserCreation());
            inventarioSemenDto.setCreatedAt(objTemp.getCreatedAt());
            inventarioSemenDto.setUserUpdated(user.getId());
            inventarioSemenDto.setModifiedAt(Calendar.getInstance().getTime());
            InventarioSemen obj = inventarioSemenRepository.save(convertDtoToEntity(inventarioSemenDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarInventarioSemen(Long id) {
        try {
            inventarioSemenRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private InventarioSemenDto convertEntityToDto(InventarioSemen inventarioSemen) {
        if (inventarioSemen != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            InventarioSemenDto inventarioSemenDto = new InventarioSemenDto();
            inventarioSemenDto = modelMapper.map(inventarioSemen, InventarioSemenDto.class);
            return inventarioSemenDto;
        } else {
            return null;
        }
    }

    private InventarioSemen convertDtoToEntity(InventarioSemenDto inventarioSemenDto) {
        if (inventarioSemenDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            InventarioSemen inventarioSemen = new InventarioSemen();
            inventarioSemen = modelMapper.map(inventarioSemenDto, InventarioSemen.class);
            return inventarioSemen;
        } else {
            return null;
        }
    }
}
