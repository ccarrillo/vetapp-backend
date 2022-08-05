package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.UserAuthDTO;
import com.vetapp.model.UserAuth;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Collectors;

@Service
public class UserAuthService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;
    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    ModelMapper modelMapper = new ModelMapper();

    public UserAuthDTO guardarUserAuth(UserAuthDTO userAuthDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        String passTmp = userAuthDto.getPassword();
        userAuthDto.setUserCreation(user.getId());
        userAuthDto.setCreatedAt(Calendar.getInstance().getTime());
        userAuthDto.setPassword(passwordEncoder.encode(passTmp));
        UserAuth obj = userAuthRepository.save(convertDtoToEntity(userAuthDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<UserAuthDTO> obtenerUserAuths() {
        return (ArrayList<UserAuthDTO>) userAuthRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public UserAuthDTO obtenerUserAuthPorId(Long id) {
        UserAuth obj = userAuthRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public UserAuthDTO actualizarUserAuth(UserAuthDTO userAuthDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        UserAuth objTemp = userAuthRepository.findById(id).orElse(null);
        if (objTemp != null) {
            userAuthDto.setId(objTemp.getId());
            userAuthDto.setUserCreation(objTemp.getUserCreation());
            userAuthDto.setCreatedAt(objTemp.getCreatedAt());
            userAuthDto.setUserUpdated(user.getId());
            userAuthDto.setModifiedAt(Calendar.getInstance().getTime());
            UserAuth obj = userAuthRepository.save(convertDtoToEntity(userAuthDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarUserAuth(Long id) {
        try {
            userAuthRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private UserAuthDTO convertEntityToDto(UserAuth userAuth) {
        if (userAuth != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            UserAuthDTO userAuthDto = new UserAuthDTO();
            userAuthDto = modelMapper.map(userAuth, UserAuthDTO.class);
            return userAuthDto;
        } else {
            return null;
        }
    }

    private UserAuth convertDtoToEntity(UserAuthDTO userAuthDto) {
        if (userAuthDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            UserAuth userAuth = new UserAuth();
            userAuth = modelMapper.map(userAuthDto, UserAuth.class);
            return userAuth;
        } else {
            return null;
        }
    }
}
