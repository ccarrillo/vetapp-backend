package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.CategoriaFormulaAlimentosDAO;
import com.vetapp.dao.CategoriaFormulaDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.CategoriaFormulaAlimentosDTO;
import com.vetapp.exception.ResourceNotFoundException;
import com.vetapp.model.CategoriaFormula;
import com.vetapp.model.CategoriaFormulaAlimentos;
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
public class CategoriaFormulaAlimentosServiceImpl implements CategoriaFormulaAlimentosService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    CategoriaFormulaDAO categoriaFormulaDAO;

    @Autowired
    CategoriaFormulaAlimentosDAO categoriaFormulaAlimentosDAO;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public CategoriaFormulaAlimentosDTO guardarCategoriaFormulaAlimentos(CategoriaFormulaAlimentosDTO categoriaFormulaAlimentosDTO) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        categoriaFormulaAlimentosDTO.setUserCreation(user.getId());
        categoriaFormulaAlimentosDTO.setCreatedAt(Calendar.getInstance().getTime());
        CategoriaFormulaAlimentos obj = categoriaFormulaAlimentosDAO.insertar(convertDtoToEntity(categoriaFormulaAlimentosDTO));
        return convertEntityToDto(obj);
    }

    public ArrayList<CategoriaFormulaAlimentosDTO> obtenerCategoriaFormulaAlimentos() {
        return (ArrayList<CategoriaFormulaAlimentosDTO>) categoriaFormulaAlimentosDAO.buscarActivos(new CategoriaFormulaAlimentos())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public CategoriaFormulaAlimentosDTO obtenerCategoriaFormulaAlimentosPorId(Long id) {
        CategoriaFormulaAlimentos obj = categoriaFormulaAlimentosDAO.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public CategoriaFormulaAlimentosDTO actualizarCategoriaFormulaAlimentos(CategoriaFormulaAlimentosDTO categoriaFormulaAlimentosDTO, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        CategoriaFormulaAlimentos objTemp = categoriaFormulaAlimentosDAO.buscarPorId(id);
        if (objTemp != null) {
            categoriaFormulaAlimentosDTO.setId(objTemp.getId());
            categoriaFormulaAlimentosDTO.setUserCreation(objTemp.getUserCreation());
            categoriaFormulaAlimentosDTO.setCreatedAt(objTemp.getCreatedAt());
            categoriaFormulaAlimentosDTO.setUserUpdated(user.getId());
            categoriaFormulaAlimentosDTO.setModifiedAt(Calendar.getInstance().getTime());
            CategoriaFormulaAlimentos obj = categoriaFormulaAlimentosDAO.actualizar(convertDtoToEntity(categoriaFormulaAlimentosDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarCategoriaFormulaAlimentos(Long id) {
        try {
            categoriaFormulaAlimentosDAO.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public ArrayList<CategoriaFormulaAlimentosDTO> obtenerCategoriaFormulaAlimentosPorCategoriaFormulaId(Long categoriaFormulaId) {
        return (ArrayList<CategoriaFormulaAlimentosDTO>) categoriaFormulaAlimentosDAO.obtenerCategoriaFormulaAlimentosPorCategoriaFormulaId(categoriaFormulaId)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public CategoriaFormulaAlimentosDTO guardarCategoriaFormulaAlimentos(Long categoriaFormulaId, CategoriaFormulaAlimentosDTO categoriaFormulaAlimentosDTO) {
        CategoriaFormula categoriaFormula = categoriaFormulaDAO.buscarPorId(categoriaFormulaId);
        if (categoriaFormula == null) {
            throw new ResourceNotFoundException("Formula con el ID: " + categoriaFormulaId + " no existe");
        }
        CategoriaFormulaAlimentos reparto = this.convertDtoToEntity(categoriaFormulaAlimentosDTO);
        //reparto.setCategoriaFormula(categoriaFormula);
        CategoriaFormulaAlimentos obj = categoriaFormulaAlimentosDAO.insertar(reparto);
        return convertEntityToDto(obj);
    }

    public CategoriaFormulaAlimentosDTO actualizarCategoriaFormulaAlimentos(Long categoriaFormulaId, Long categoriaFormulaAlimentosId, CategoriaFormulaAlimentosDTO categoriaFormulaAlimentosDTO) {
        CategoriaFormula categoriaFormula = categoriaFormulaDAO.buscarPorId(categoriaFormulaId);
        if (categoriaFormula == null) {
            throw new ResourceNotFoundException("Formula con el ID: " + categoriaFormulaId + " no existe");
        }

        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        CategoriaFormulaAlimentos objTemp = categoriaFormulaAlimentosDAO.buscarPorId(categoriaFormulaAlimentosId);
        if (objTemp != null) {
            categoriaFormulaAlimentosDTO.setId(objTemp.getId());
            categoriaFormulaAlimentosDTO.setUserCreation(objTemp.getUserCreation());
            categoriaFormulaAlimentosDTO.setCreatedAt(objTemp.getCreatedAt());
            categoriaFormulaAlimentosDTO.setUserUpdated(user.getId());
            categoriaFormulaAlimentosDTO.setModifiedAt(Calendar.getInstance().getTime());
            CategoriaFormulaAlimentos obj = categoriaFormulaAlimentosDAO.actualizar(convertDtoToEntity(categoriaFormulaAlimentosDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarCategoriaFormulaAlimentos(Long categoriaFormulaId, Long categoriaFormulaAlimentosId) {
        try {
            CategoriaFormulaAlimentos objTemp = categoriaFormulaAlimentosDAO.obtenerCategoriaFormulaAlimentosPorIdYCategoriaFormulaId(categoriaFormulaId, categoriaFormulaAlimentosId);
            if (objTemp == null) {
                throw new ResourceNotFoundException("Reparto con el ID: " + categoriaFormulaAlimentosId + " y formulaID: " + categoriaFormulaId + " no existe");
            }
            categoriaFormulaAlimentosDAO.eliminarPorId(categoriaFormulaAlimentosId);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private CategoriaFormulaAlimentosDTO convertEntityToDto(CategoriaFormulaAlimentos categoriaFormulaAlimentos) {
        if (categoriaFormulaAlimentos != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            CategoriaFormulaAlimentosDTO categoriaFormulaAlimentosDTO = new CategoriaFormulaAlimentosDTO();
            categoriaFormulaAlimentosDTO = modelMapper.map(categoriaFormulaAlimentos, CategoriaFormulaAlimentosDTO.class);
            return categoriaFormulaAlimentosDTO;
        } else {
            return null;
        }
    }

    private CategoriaFormulaAlimentos convertDtoToEntity(CategoriaFormulaAlimentosDTO categoriaFormulaAlimentosDTO) {
        if (categoriaFormulaAlimentosDTO != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            CategoriaFormulaAlimentos categoriaFormulaAlimentos = new CategoriaFormulaAlimentos();
            categoriaFormulaAlimentos = modelMapper.map(categoriaFormulaAlimentosDTO, CategoriaFormulaAlimentos.class);
            return categoriaFormulaAlimentos;
        } else {
            return null;
        }
    }
}
