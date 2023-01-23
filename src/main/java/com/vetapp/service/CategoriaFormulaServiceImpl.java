package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.CategoriaFormulaDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.CategoriaFormulaDTO;
import com.vetapp.model.CategoriaFormula;
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
public class CategoriaFormulaServiceImpl implements CategoriaFormulaService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    CategoriaFormulaDAO categoriaFormulaDAO;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public CategoriaFormulaDTO guardarCategoriaFormula(CategoriaFormulaDTO categoriaFormulaDTO) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        categoriaFormulaDTO.setUserCreation(user.getId());
        categoriaFormulaDTO.setCreatedAt(Calendar.getInstance().getTime());
        CategoriaFormula obj = categoriaFormulaDAO.insertar(convertDtoToEntity(categoriaFormulaDTO));
        return convertEntityToDto(obj);
    }

    public ArrayList<CategoriaFormulaDTO> obtenerCategoriaFormulas() {
        return (ArrayList<CategoriaFormulaDTO>) categoriaFormulaDAO.buscarActivos(new CategoriaFormula())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public CategoriaFormulaDTO obtenerCategoriaFormulaPorId(Long id) {
        CategoriaFormula obj = categoriaFormulaDAO.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public CategoriaFormulaDTO actualizarCategoriaFormula(CategoriaFormulaDTO categoriaFormulaDTO, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        CategoriaFormula objTemp = categoriaFormulaDAO.buscarPorId(id);
        if (objTemp != null) {
            categoriaFormulaDTO.setId(objTemp.getId());
            categoriaFormulaDTO.setUserCreation(objTemp.getUserCreation());
            categoriaFormulaDTO.setCreatedAt(objTemp.getCreatedAt());
            categoriaFormulaDTO.setUserUpdated(user.getId());
            categoriaFormulaDTO.setModifiedAt(Calendar.getInstance().getTime());
            CategoriaFormula obj = categoriaFormulaDAO.actualizar(convertDtoToEntity(categoriaFormulaDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarCategoriaFormula(Long id) {
        try {
            categoriaFormulaDAO.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private CategoriaFormulaDTO convertEntityToDto(CategoriaFormula categoriaFormula) {
        if (categoriaFormula != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            CategoriaFormulaDTO formulaDto = new CategoriaFormulaDTO();
            formulaDto = modelMapper.map(categoriaFormula, CategoriaFormulaDTO.class);
            return formulaDto;
        } else {
            return null;
        }
    }

    private CategoriaFormula convertDtoToEntity(CategoriaFormulaDTO categoriaFormulaDTO) {
        if (categoriaFormulaDTO != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            CategoriaFormula formula = new CategoriaFormula();
            formula = modelMapper.map(categoriaFormulaDTO, CategoriaFormula.class);
            return formula;
        } else {
            return null;
        }
    }
}
