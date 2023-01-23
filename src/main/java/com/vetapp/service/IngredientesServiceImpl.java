package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.FormulaDAO;
import com.vetapp.dao.IngredientesDAO;
import com.vetapp.dao.InsumoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.IngredientesDTO;
import com.vetapp.exception.ResourceNotFoundException;
import com.vetapp.model.Formula;
import com.vetapp.model.Ingredientes;
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
public class IngredientesServiceImpl implements IngredientesService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    FormulaDAO formulaDAO;

    @Autowired
    IngredientesDAO ingredientesDAO;

    @Autowired
    InsumoDAO insumoDAO;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public IngredientesDTO guardarIngredientes(IngredientesDTO ingredientesDTO) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        ingredientesDTO.setUserCreation(user.getId());
        ingredientesDTO.setCreatedAt(Calendar.getInstance().getTime());
        Ingredientes obj = ingredientesDAO.insertar(convertDtoToEntity(ingredientesDTO));
        return convertEntityToDto(obj);
    }

    public ArrayList<IngredientesDTO> obtenerIngredientess() {
        return (ArrayList<IngredientesDTO>) ingredientesDAO.buscarTodos(new Ingredientes())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public IngredientesDTO obtenerIngredientesPorId(Long id) {
        Ingredientes obj = ingredientesDAO.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public IngredientesDTO actualizarIngredientes(IngredientesDTO ingredientesDTO, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Ingredientes objTemp = ingredientesDAO.buscarPorId(id);
        if (objTemp != null) {
            ingredientesDTO.setId(objTemp.getId());
            ingredientesDTO.setUserCreation(objTemp.getUserCreation());
            ingredientesDTO.setCreatedAt(objTemp.getCreatedAt());
            ingredientesDTO.setUserUpdated(user.getId());
            ingredientesDTO.setModifiedAt(Calendar.getInstance().getTime());
            Ingredientes obj = ingredientesDAO.actualizar(convertDtoToEntity(ingredientesDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarIngredientes(Long id) {
        try {
            ingredientesDAO.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public ArrayList<IngredientesDTO> obtenerIngredientesPorFormulaId(Long formulaId) {
        return (ArrayList<IngredientesDTO>) ingredientesDAO.obtenerIngredientesPorFormulaId(formulaId)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public IngredientesDTO guardarIngredientes(Long formulaId, IngredientesDTO ingredientesDTO) {
        Formula formula = formulaDAO.buscarPorId(formulaId);
        if (formula == null) {
            throw new ResourceNotFoundException("Formula con el ID: " + formulaId + " no existe");
        }
        Ingredientes ingredientes = this.convertDtoToEntity(ingredientesDTO);
        ingredientes.setFormula(formula);
        Ingredientes obj = ingredientesDAO.insertar(ingredientes);
        return convertEntityToDto(obj);
    }

    public IngredientesDTO actualizarIngredientes(Long formulaId, Long ingredientesId, IngredientesDTO ingredientesDTO) {
        Formula formula = formulaDAO.buscarPorId(formulaId);
        if (formula == null) {
            throw new ResourceNotFoundException("Formula con el ID: " + formulaId + " no existe");
        }

        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Ingredientes objTemp = ingredientesDAO.buscarPorId(ingredientesId);
        if (objTemp != null) {
            ingredientesDTO.setId(objTemp.getId());
            ingredientesDTO.setUserCreation(objTemp.getUserCreation());
            ingredientesDTO.setCreatedAt(objTemp.getCreatedAt());
            ingredientesDTO.setUserUpdated(user.getId());
            ingredientesDTO.setModifiedAt(Calendar.getInstance().getTime());
            Ingredientes obj = ingredientesDAO.actualizar(convertDtoToEntity(ingredientesDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarIngredientes(Long formulaId, Long ingredientesId) {
        try {
            Ingredientes objTemp = ingredientesDAO.obtenerIngredientesPorIdYFormulaId(formulaId, ingredientesId);
            if (objTemp == null) {
                throw new ResourceNotFoundException("Ingredientes con el ID: " + ingredientesId + " y formulaID: " + formulaId + " no existe");
            }
            ingredientesDAO.eliminarPorId(ingredientesId);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Integer guardarIngredientesMasivo(Long formulaId, Long categoriaFormulaId) {
        return ingredientesDAO.guardarIngredientesMasivo(formulaId, categoriaFormulaId);
    }

    private IngredientesDTO convertEntityToDto(Ingredientes ingredientes) {
        if (ingredientes != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            IngredientesDTO ingredientesDTO = new IngredientesDTO();
            ingredientesDTO = modelMapper.map(ingredientes, IngredientesDTO.class);
            return ingredientesDTO;
        } else {
            return null;
        }
    }

    private Ingredientes convertDtoToEntity(IngredientesDTO ingredientesDTO) {
        if (ingredientesDTO != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Ingredientes ingredientes = new Ingredientes();
            ingredientes = modelMapper.map(ingredientesDTO, Ingredientes.class);
            return ingredientes;
        } else {
            return null;
        }
    }
}
