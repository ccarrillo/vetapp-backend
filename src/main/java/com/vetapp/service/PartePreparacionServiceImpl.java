package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.FormulaDAO;
import com.vetapp.dao.PartePreparacionDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.PartePreparacionDTO;
import com.vetapp.exception.ResourceNotFoundException;
import com.vetapp.model.Formula;
import com.vetapp.model.PartePreparacion;
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
public class PartePreparacionServiceImpl implements PartePreparacionService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    FormulaDAO formulaDAO;

    @Autowired
    PartePreparacionDAO partePreparacionDAO;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public PartePreparacionDTO guardarPartePreparacion(PartePreparacionDTO partePreparacionDTO) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        partePreparacionDTO.setUserCreation(user.getId());
        partePreparacionDTO.setCreatedAt(Calendar.getInstance().getTime());
        PartePreparacion obj = partePreparacionDAO.insertar(convertDtoToEntity(partePreparacionDTO));
        return convertEntityToDto(obj);
    }

    public ArrayList<PartePreparacionDTO> obtenerPartePreparacions() {
        return (ArrayList<PartePreparacionDTO>) partePreparacionDAO.buscarTodos(new PartePreparacion())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public PartePreparacionDTO obtenerPartePreparacionPorId(Long id) {
        PartePreparacion obj = partePreparacionDAO.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public PartePreparacionDTO actualizarPartePreparacion(PartePreparacionDTO partePreparacionDTO, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        PartePreparacion objTemp = partePreparacionDAO.buscarPorId(id);
        if (objTemp != null) {
            partePreparacionDTO.setId(objTemp.getId());
            partePreparacionDTO.setUserCreation(objTemp.getUserCreation());
            partePreparacionDTO.setCreatedAt(objTemp.getCreatedAt());
            partePreparacionDTO.setUserUpdated(user.getId());
            partePreparacionDTO.setModifiedAt(Calendar.getInstance().getTime());
            PartePreparacion obj = partePreparacionDAO.actualizar(convertDtoToEntity(partePreparacionDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarPartePreparacion(Long id) {
        try {
            partePreparacionDAO.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public ArrayList<PartePreparacionDTO> obtenerPartePreparacionPorFormulaId(Long formulaId) {
        return (ArrayList<PartePreparacionDTO>) partePreparacionDAO.obtenerPartePreparacionPorFormulaId(formulaId)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public PartePreparacionDTO guardarPartePreparacion(Long formulaId, PartePreparacionDTO partePreparacionDTO) {
        Formula formula = formulaDAO.buscarPorId(formulaId);
        if (formula == null) {
            throw new ResourceNotFoundException("Formula con el ID: " + formulaId + " no existe");
        }
        PartePreparacion partePreparacion = this.convertDtoToEntity(partePreparacionDTO);
        partePreparacion.setFormula(formula);
        PartePreparacion obj = partePreparacionDAO.insertar(partePreparacion);
        return convertEntityToDto(obj);
    }

    public PartePreparacionDTO actualizarPartePreparacion(Long formulaId, Long partePreparacionId, PartePreparacionDTO partePreparacionDTO) {
        Formula formula = formulaDAO.buscarPorId(formulaId);
        if (formula == null) {
            throw new ResourceNotFoundException("Formula con el ID: " + formulaId + " no existe");
        }

        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        PartePreparacion objTemp = partePreparacionDAO.buscarPorId(partePreparacionId);
        if (objTemp != null) {
            partePreparacionDTO.setId(objTemp.getId());
            partePreparacionDTO.setUserCreation(objTemp.getUserCreation());
            partePreparacionDTO.setCreatedAt(objTemp.getCreatedAt());
            partePreparacionDTO.setUserUpdated(user.getId());
            partePreparacionDTO.setModifiedAt(Calendar.getInstance().getTime());
            PartePreparacion obj = partePreparacionDAO.actualizar(convertDtoToEntity(partePreparacionDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarPartePreparacion(Long formulaId, Long partePreparacionId) {
        try {
            PartePreparacion objTemp = partePreparacionDAO.obtenerPartePreparacionPorIdYFormulaId(formulaId, partePreparacionId);
            if (objTemp == null) {
                throw new ResourceNotFoundException("PartePreparacion con el ID: " + partePreparacionId + " y formulaID: " + formulaId + " no existe");
            }
            partePreparacionDAO.eliminarPorId(partePreparacionId);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private PartePreparacionDTO convertEntityToDto(PartePreparacion partePreparacion) {
        if (partePreparacion != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            PartePreparacionDTO partePreparacionDTO = new PartePreparacionDTO();
            partePreparacionDTO = modelMapper.map(partePreparacion, PartePreparacionDTO.class);
            return partePreparacionDTO;
        } else {
            return null;
        }
    }

    private PartePreparacion convertDtoToEntity(PartePreparacionDTO partePreparacionDTO) {
        if (partePreparacionDTO != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            PartePreparacion partePreparacion = new PartePreparacion();
            partePreparacion = modelMapper.map(partePreparacionDTO, PartePreparacion.class);
            return partePreparacion;
        } else {
            return null;
        }
    }
}
