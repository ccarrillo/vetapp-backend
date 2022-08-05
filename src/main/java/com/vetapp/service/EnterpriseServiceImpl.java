package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.EnterpriseDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.EnterpriseDto;
import com.vetapp.model.Enterprise;
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
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    EnterpriseDAO enterpriseDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public EnterpriseDto guardarEmpresa(EnterpriseDto enterpriseDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        enterpriseDto.setUserCreation(user.getId());
        enterpriseDto.setCreatedAt(Calendar.getInstance().getTime());
        Enterprise obj = enterpriseDao.insertar(convertDtoToEntity(enterpriseDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<EnterpriseDto> obtenerEmpresas() {
        return (ArrayList<EnterpriseDto>) enterpriseDao.buscarTodos(new Enterprise())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public EnterpriseDto obtenerEmpresaPorId(Long id) {
        Enterprise obj = enterpriseDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public EnterpriseDto actualizarEmpresa(EnterpriseDto employeeDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Enterprise objTemp = enterpriseDao.buscarPorId(id);
        if (objTemp != null) {
            employeeDto.setId(objTemp.getId());
            employeeDto.setUserCreation(objTemp.getUserCreation());
            employeeDto.setCreatedAt(objTemp.getCreatedAt());
            employeeDto.setUserUpdated(user.getId());
            employeeDto.setModifiedAt(Calendar.getInstance().getTime());
            Enterprise obj = enterpriseDao.actualizar(convertDtoToEntity(employeeDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarEmpresa(Long id) {
        try {
            enterpriseDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private EnterpriseDto convertEntityToDto(Enterprise enterprise) {
        if (enterprise != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            EnterpriseDto enterpriseDto = new EnterpriseDto();
            enterpriseDto = modelMapper.map(enterprise, EnterpriseDto.class);
            return enterpriseDto;
        } else {
            return null;
        }
    }

    private Enterprise convertDtoToEntity(EnterpriseDto enterpriseDto) {
        if (enterpriseDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Enterprise enterprise = new Enterprise();
            enterprise = modelMapper.map(enterpriseDto, Enterprise.class);
            return enterprise;
        } else {
            return null;
        }
    }
}
