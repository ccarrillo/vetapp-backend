package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.FormulaDAO;
import com.vetapp.dao.RepartoProgramacionDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.RepartoProgramacionDTO;
import com.vetapp.exception.ResourceNotFoundException;
import com.vetapp.model.Formula;
import com.vetapp.model.RepartoProgramacion;
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
public class RepartoProgramacionServiceImpl implements RepartoProgramacionService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    FormulaDAO formulaDAO;

    @Autowired
    RepartoProgramacionDAO repartoProgramacionDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public RepartoProgramacionDTO guardarRepartoProgramacion(RepartoProgramacionDTO repartoProgramacionDTO) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        repartoProgramacionDTO.setUserCreation(user.getId());
        repartoProgramacionDTO.setCreatedAt(Calendar.getInstance().getTime());
        RepartoProgramacion obj = repartoProgramacionDao.insertar(convertDtoToEntity(repartoProgramacionDTO));
        return convertEntityToDto(obj);
    }

    public ArrayList<RepartoProgramacionDTO> obtenerRepartoProgramacions() {
        return (ArrayList<RepartoProgramacionDTO>) repartoProgramacionDao.buscarTodos(new RepartoProgramacion())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public RepartoProgramacionDTO obtenerRepartoProgramacionPorId(Long id) {
        RepartoProgramacion obj = repartoProgramacionDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public RepartoProgramacionDTO actualizarRepartoProgramacion(RepartoProgramacionDTO repartoProgramacionDTO, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        RepartoProgramacion objTemp = repartoProgramacionDao.buscarPorId(id);
        if (objTemp != null) {
            repartoProgramacionDTO.setId(objTemp.getId());
            repartoProgramacionDTO.setUserCreation(objTemp.getUserCreation());
            repartoProgramacionDTO.setCreatedAt(objTemp.getCreatedAt());
            repartoProgramacionDTO.setUserUpdated(user.getId());
            repartoProgramacionDTO.setModifiedAt(Calendar.getInstance().getTime());
            RepartoProgramacion obj = repartoProgramacionDao.actualizar(convertDtoToEntity(repartoProgramacionDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarRepartoProgramacion(Long id) {
        try {
            repartoProgramacionDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public ArrayList<RepartoProgramacionDTO> obtenerRepartoProgramacionPorFormulaId(Long formulaId) {
        return (ArrayList<RepartoProgramacionDTO>) repartoProgramacionDao.obtenerRepartoProgramacionPorFormulaId(formulaId)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public RepartoProgramacionDTO guardarRepartoProgramacion(Long formulaId, RepartoProgramacionDTO repartoProgramacionDTO) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Formula formula = formulaDAO.buscarPorId(formulaId);
        if (formula == null) {
            throw new ResourceNotFoundException("Formula con el ID: " + formulaId + " no existe");
        }
        RepartoProgramacion repartoProgramacion = this.convertDtoToEntity(repartoProgramacionDTO);
        repartoProgramacion.setFormula(formula);
        repartoProgramacion.setUserCreation(user.getId());
        repartoProgramacion.setCreatedAt(Calendar.getInstance().getTime());
        RepartoProgramacion obj = repartoProgramacionDao.insertar(repartoProgramacion);
        return convertEntityToDto(obj);
    }

    public RepartoProgramacionDTO actualizarRepartoProgramacion(Long formulaId, Long repartoProgramacionId, RepartoProgramacionDTO repartoProgramacionDTO) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Formula formula = formulaDAO.buscarPorId(formulaId);
        if (formula == null) {
            throw new ResourceNotFoundException("Formula con el ID: " + formulaId + " no existe");
        }

        RepartoProgramacion objTemp = repartoProgramacionDao.buscarPorId(repartoProgramacionId);
        if (objTemp != null) {
            repartoProgramacionDTO.setId(objTemp.getId());
            repartoProgramacionDTO.setUserCreation(objTemp.getUserCreation());
            repartoProgramacionDTO.setCreatedAt(objTemp.getCreatedAt());
            repartoProgramacionDTO.setUserUpdated(user.getId());
            repartoProgramacionDTO.setModifiedAt(Calendar.getInstance().getTime());

            RepartoProgramacion objUpdate= convertDtoToEntity(repartoProgramacionDTO);
            objUpdate.setFormula(objTemp.getFormula());
            RepartoProgramacion obj = repartoProgramacionDao.actualizar(objUpdate);
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarRepartoProgramacion(Long formulaId, Long repartoProgramacionId) {
        try {
            RepartoProgramacion objTemp = repartoProgramacionDao.obtenerRepartoProgramacionPorIdYFormulaId(formulaId, repartoProgramacionId);
            if (objTemp == null) {
                throw new ResourceNotFoundException("RepartoProgramacion con el ID: " + repartoProgramacionId + " y formulaID: " + formulaId + " no existe");
            }
            repartoProgramacionDao.eliminarPorId(repartoProgramacionId);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private RepartoProgramacionDTO convertEntityToDto(RepartoProgramacion repartoProgramacion) {
        if (repartoProgramacion != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            RepartoProgramacionDTO repartoProgramacionDTO = new RepartoProgramacionDTO();
            repartoProgramacionDTO = modelMapper.map(repartoProgramacion, RepartoProgramacionDTO.class);
            return repartoProgramacionDTO;
        } else {
            return null;
        }
    }

    private RepartoProgramacion convertDtoToEntity(RepartoProgramacionDTO repartoProgramacionDTO) {
        if (repartoProgramacionDTO != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            RepartoProgramacion repartoProgramacion = new RepartoProgramacion();
            repartoProgramacion = modelMapper.map(repartoProgramacionDTO, RepartoProgramacion.class);
            return repartoProgramacion;
        } else {
            return null;
        }
    }
}
