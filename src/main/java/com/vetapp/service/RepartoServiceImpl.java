package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.FormulaDAO;
import com.vetapp.dao.RepartoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.RepartoDTO;
import com.vetapp.exception.ResourceNotFoundException;
import com.vetapp.model.Formula;
import com.vetapp.model.Reparto;
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
public class RepartoServiceImpl implements RepartoService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    FormulaDAO formulaDAO;

    @Autowired
    RepartoDAO repartoDAO;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public RepartoDTO guardarReparto(RepartoDTO repartoDTO) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        repartoDTO.setUserCreation(user.getId());
        repartoDTO.setCreatedAt(Calendar.getInstance().getTime());
        Reparto obj = repartoDAO.insertar(convertDtoToEntity(repartoDTO));
        return convertEntityToDto(obj);
    }

    public ArrayList<RepartoDTO> obtenerRepartos() {
        return (ArrayList<RepartoDTO>) repartoDAO.buscarTodos(new Reparto())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public RepartoDTO obtenerRepartoPorId(Long id) {
        Reparto obj = repartoDAO.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public RepartoDTO actualizarReparto(RepartoDTO repartoDTO, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Reparto objTemp = repartoDAO.buscarPorId(id);
        if (objTemp != null) {
            repartoDTO.setId(objTemp.getId());
            repartoDTO.setUserCreation(objTemp.getUserCreation());
            repartoDTO.setCreatedAt(objTemp.getCreatedAt());
            repartoDTO.setUserUpdated(user.getId());
            repartoDTO.setModifiedAt(Calendar.getInstance().getTime());
            Reparto obj = repartoDAO.actualizar(convertDtoToEntity(repartoDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarReparto(Long id) {
        try {
            repartoDAO.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public ArrayList<RepartoDTO> obtenerRepartoPorFormulaId(Long formulaId) {
        return (ArrayList<RepartoDTO>) repartoDAO.obtenerRepartoPorFormulaId(formulaId)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public RepartoDTO guardarReparto(Long formulaId, RepartoDTO repartoDTO) {
        Formula formula = formulaDAO.buscarPorId(formulaId);
        if (formula == null) {
            throw new ResourceNotFoundException("Formula con el ID: " + formulaId + " no existe");
        }
        Reparto reparto = this.convertDtoToEntity(repartoDTO);
        reparto.setFormula(formula);
        Reparto obj = repartoDAO.insertar(reparto);
        return convertEntityToDto(obj);
    }

    public RepartoDTO actualizarReparto(Long formulaId, Long repartoId, RepartoDTO repartoDTO) {
        Formula formula = formulaDAO.buscarPorId(formulaId);
        if (formula == null) {
            throw new ResourceNotFoundException("Formula con el ID: " + formulaId + " no existe");
        }

        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Reparto objTemp = repartoDAO.buscarPorId(repartoId);
        if (objTemp != null) {
            repartoDTO.setId(objTemp.getId());
            repartoDTO.setUserCreation(objTemp.getUserCreation());
            repartoDTO.setCreatedAt(objTemp.getCreatedAt());
            repartoDTO.setUserUpdated(user.getId());
            repartoDTO.setModifiedAt(Calendar.getInstance().getTime());
            Reparto obj = repartoDAO.actualizar(convertDtoToEntity(repartoDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarReparto(Long formulaId, Long repartoId) {
        try {
            Reparto objTemp = repartoDAO.obtenerRepartoPorIdYFormulaId(formulaId, repartoId);
            if (objTemp == null) {
                throw new ResourceNotFoundException("Reparto con el ID: " + repartoId + " y formulaID: " + formulaId + " no existe");
            }
            repartoDAO.eliminarPorId(repartoId);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private RepartoDTO convertEntityToDto(Reparto reparto) {
        if (reparto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            RepartoDTO repartoDTO = new RepartoDTO();
            repartoDTO = modelMapper.map(reparto, RepartoDTO.class);
            return repartoDTO;
        } else {
            return null;
        }
    }

    private Reparto convertDtoToEntity(RepartoDTO repartoDTO) {
        if (repartoDTO != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Reparto reparto = new Reparto();
            reparto = modelMapper.map(repartoDTO, Reparto.class);
            return reparto;
        } else {
            return null;
        }
    }
}
