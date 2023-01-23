package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.FormulaDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.FormulaDTO;
import com.vetapp.model.Formula;
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
public class FormulaServiceImpl implements FormulaService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    FormulaDAO formulaDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public FormulaDTO guardarFormula(FormulaDTO formulaDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        formulaDto.setUserCreation(user.getId());
        formulaDto.setCreatedAt(Calendar.getInstance().getTime());
        Formula obj = formulaDao.insertar(convertDtoToEntity(formulaDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<FormulaDTO> obtenerFormulas() {
        return (ArrayList<FormulaDTO>) formulaDao.buscarActivos(new Formula())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public FormulaDTO obtenerFormulaPorId(Long id) {
        Formula obj = formulaDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public FormulaDTO actualizarFormula(FormulaDTO formulaDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Formula objTemp = formulaDao.buscarPorId(id);
        if (objTemp != null) {
            formulaDto.setId(objTemp.getId());
            formulaDto.setUserCreation(objTemp.getUserCreation());
            formulaDto.setCreatedAt(objTemp.getCreatedAt());
            formulaDto.setUserUpdated(user.getId());
            formulaDto.setModifiedAt(Calendar.getInstance().getTime());
            Formula obj = formulaDao.actualizar(convertDtoToEntity(formulaDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarFormula(Long id) {
        try {
            formulaDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private FormulaDTO convertEntityToDto(Formula formula) {
        if (formula != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            FormulaDTO formulaDto = new FormulaDTO();
            formulaDto = modelMapper.map(formula, FormulaDTO.class);
            return formulaDto;
        } else {
            return null;
        }
    }

    private Formula convertDtoToEntity(FormulaDTO formulaDto) {
        if (formulaDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Formula formula = new Formula();
            formula = modelMapper.map(formulaDto, Formula.class);
            return formula;
        } else {
            return null;
        }
    }
}
