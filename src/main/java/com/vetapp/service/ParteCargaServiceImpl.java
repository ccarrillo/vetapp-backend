package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.FormulaDAO;
import com.vetapp.dao.ParteCargaDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.ParteCargaDTO;
import com.vetapp.exception.ResourceNotFoundException;
import com.vetapp.model.Formula;
import com.vetapp.model.ParteCarga;
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
public class ParteCargaServiceImpl implements ParteCargaService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    FormulaDAO formulaDAO;

    @Autowired
    ParteCargaDAO parteCargaDAO;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ParteCargaDTO guardarParteCarga(ParteCargaDTO parteCargaDTO) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        parteCargaDTO.setUserCreation(user.getId());
        parteCargaDTO.setCreatedAt(Calendar.getInstance().getTime());
        ParteCarga obj = parteCargaDAO.insertar(convertDtoToEntity(parteCargaDTO));
        return convertEntityToDto(obj);
    }

    public ArrayList<ParteCargaDTO> obtenerParteCargas() {
        return (ArrayList<ParteCargaDTO>) parteCargaDAO.buscarTodos(new ParteCarga())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public ParteCargaDTO obtenerParteCargaPorId(Long id) {
        ParteCarga obj = parteCargaDAO.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public ParteCargaDTO actualizarParteCarga(ParteCargaDTO parteCargaDTO, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        ParteCarga objTemp = parteCargaDAO.buscarPorId(id);
        if (objTemp != null) {
            parteCargaDTO.setId(objTemp.getId());
            parteCargaDTO.setUserCreation(objTemp.getUserCreation());
            parteCargaDTO.setCreatedAt(objTemp.getCreatedAt());
            parteCargaDTO.setUserUpdated(user.getId());
            parteCargaDTO.setModifiedAt(Calendar.getInstance().getTime());
            ParteCarga obj = parteCargaDAO.actualizar(convertDtoToEntity(parteCargaDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarParteCarga(Long id) {
        try {
            parteCargaDAO.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public ArrayList<ParteCargaDTO> obtenerParteCargaPorFormulaId(Long formulaId) {
        return (ArrayList<ParteCargaDTO>) parteCargaDAO.obtenerParteCargaPorFormulaId(formulaId)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public ParteCargaDTO guardarParteCarga(Long formulaId, ParteCargaDTO parteCargaDTO) {
        Formula formula = formulaDAO.buscarPorId(formulaId);
        if (formula == null) {
            throw new ResourceNotFoundException("Formula con el ID: " + formulaId + " no existe");
        }
        ParteCarga parteCarga = this.convertDtoToEntity(parteCargaDTO);
        parteCarga.setFormula(formula);
        ParteCarga obj = parteCargaDAO.insertar(parteCarga);
        return convertEntityToDto(obj);
    }

    public ParteCargaDTO actualizarParteCarga(Long formulaId, Long parteCargaId, ParteCargaDTO parteCargaDTO) {
        Formula formula = formulaDAO.buscarPorId(formulaId);
        if (formula == null) {
            throw new ResourceNotFoundException("Formula con el ID: " + formulaId + " no existe");
        }

        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        ParteCarga objTemp = parteCargaDAO.buscarPorId(parteCargaId);
        if (objTemp != null) {
            parteCargaDTO.setId(objTemp.getId());
            parteCargaDTO.setUserCreation(objTemp.getUserCreation());
            parteCargaDTO.setCreatedAt(objTemp.getCreatedAt());
            parteCargaDTO.setUserUpdated(user.getId());
            parteCargaDTO.setModifiedAt(Calendar.getInstance().getTime());
            ParteCarga obj = parteCargaDAO.actualizar(convertDtoToEntity(parteCargaDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarParteCarga(Long formulaId, Long parteCargaId) {
        try {
            ParteCarga objTemp = parteCargaDAO.obtenerParteCargaPorIdYFormulaId(formulaId, parteCargaId);
            if (objTemp == null) {
                throw new ResourceNotFoundException("ParteCarga con el ID: " + parteCargaId + " y formulaID: " + formulaId + " no existe");
            }
            parteCargaDAO.eliminarPorId(parteCargaId);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private ParteCargaDTO convertEntityToDto(ParteCarga parteCarga) {
        if (parteCarga != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ParteCargaDTO parteCargaDTO = new ParteCargaDTO();
            parteCargaDTO = modelMapper.map(parteCarga, ParteCargaDTO.class);
            return parteCargaDTO;
        } else {
            return null;
        }
    }

    private ParteCarga convertDtoToEntity(ParteCargaDTO parteCargaDTO) {
        if (parteCargaDTO != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ParteCarga parteCarga = new ParteCarga();
            parteCarga = modelMapper.map(parteCargaDTO, ParteCarga.class);
            return parteCarga;
        } else {
            return null;
        }
    }
}
