package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.RoleRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.RoleDTO;
import com.vetapp.model.Role;
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
public class RoleService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public RoleDTO guardarRole(RoleDTO roleDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        roleDto.setUserCreation(user.getId());
        roleDto.setCreatedAt(Calendar.getInstance().getTime());
        Role obj = roleRepository.save(convertDtoToEntity(roleDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<RoleDTO> obtenerRoles() {
        return (ArrayList<RoleDTO>) roleRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public RoleDTO obtenerRolePorId(Long id) {
        Role obj = roleRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public RoleDTO actualizarRole(RoleDTO roleDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Role objTemp = roleRepository.findById(id).orElse(null);
        if (objTemp != null) {
            roleDto.setId(objTemp.getId());
            roleDto.setUserCreation(objTemp.getUserCreation());
            roleDto.setCreatedAt(objTemp.getCreatedAt());
            roleDto.setUserUpdated(user.getId());
            roleDto.setModifiedAt(Calendar.getInstance().getTime());
            Role obj = roleRepository.save(convertDtoToEntity(roleDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarRole(Long id) {
        try {
            roleRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private RoleDTO convertEntityToDto(Role role) {
        if (role != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            RoleDTO roleDto = new RoleDTO();
            roleDto = modelMapper.map(role, RoleDTO.class);
            return roleDto;
        } else {
            return null;
        }
    }

    private Role convertDtoToEntity(RoleDTO roleDto) {
        if (roleDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Role role = new Role();
            role = modelMapper.map(roleDto, Role.class);
            return role;
        } else {
            return null;
        }
    }
}
