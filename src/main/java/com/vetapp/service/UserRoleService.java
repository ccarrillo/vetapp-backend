package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dao.UserRoleRepository;
import com.vetapp.dto.UserRoleDto;
import com.vetapp.model.UserAuth;
import com.vetapp.model.UserRole;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Collectors;

@Service
public class UserRoleService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public UserRoleDto guardaUserRole(UserRoleDto userRoleDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        userRoleDto.setUserCreation(user.getId());
        userRoleDto.setCreatedAt(Calendar.getInstance().getTime());
        UserRole obj = userRoleRepository.save(convertDtoToEntity(userRoleDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<UserRoleDto> obtenerUserRoles() {
        return (ArrayList<UserRoleDto>) userRoleRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public UserRoleDto obtenerUserRolePorId(Long id) {
        UserRole obj = userRoleRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public UserRoleDto actualizarUserRole(UserRoleDto userRoleDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        UserRole objTemp = userRoleRepository.findById(id).orElse(null);
        if (objTemp != null) {
            userRoleDto.setId(objTemp.getId());
            userRoleDto.setUserCreation(objTemp.getUserCreation());
            userRoleDto.setCreatedAt(objTemp.getCreatedAt());
            userRoleDto.setUserUpdated(user.getId());
            userRoleDto.setModifiedAt(Calendar.getInstance().getTime());
            UserRole obj = userRoleRepository.save(convertDtoToEntity(userRoleDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarUserRole(Long id) {
        try {
            userRoleRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public ArrayList<UserRoleDto> obtenerUserRolePorUserId(Long id) {
        return (ArrayList<UserRoleDto>) userRoleRepository.findByUserId(id)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private UserRoleDto convertEntityToDto(UserRole userRole) {
        if (userRole != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            UserRoleDto userRoleDto = new UserRoleDto();
            userRoleDto = modelMapper.map(userRole, UserRoleDto.class);
            return userRoleDto;
        } else {
            return null;
        }
    }

    private UserRole convertDtoToEntity(UserRoleDto userRoleDto) {
        if (userRoleDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            UserRole userRole = new UserRole();
            userRole = modelMapper.map(userRoleDto, UserRole.class);
            return userRole;
        } else {
            return null;
        }
    }
}
