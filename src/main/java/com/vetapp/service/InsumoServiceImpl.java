package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.CategoriaFormulaInsumoDAO;
import com.vetapp.dao.FormulaDAO;
import com.vetapp.dao.InsumoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.IngredientesDTO;
import com.vetapp.dto.InsumoDTO;
import com.vetapp.model.CategoriaFormulaInsumo;
import com.vetapp.model.Insumo;
import com.vetapp.model.UserAuth;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InsumoServiceImpl implements InsumoService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    FormulaDAO formulaDAO;

    @Autowired
    InsumoDAO insumoDAO;

    @Autowired
    CategoriaFormulaInsumoDAO categoriaFormulaInsumoDAO;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public InsumoDTO guardarInsumo(InsumoDTO insumoDTO) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        insumoDTO.setUserCreation(user.getId());
        insumoDTO.setCreatedAt(Calendar.getInstance().getTime());
        Insumo obj = insumoDAO.insertar(convertDtoToEntity(insumoDTO));
        return convertEntityToDto(obj);
    }

    public ArrayList<InsumoDTO> obtenerInsumos() {
        return (ArrayList<InsumoDTO>) insumoDAO.buscarTodos(new Insumo())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public InsumoDTO obtenerInsumoPorId(Long id) {
        Insumo obj = insumoDAO.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public InsumoDTO actualizarInsumo(InsumoDTO insumoDTO, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Insumo objTemp = insumoDAO.buscarPorId(id);
        if (objTemp != null) {
            insumoDTO.setId(objTemp.getId());
            insumoDTO.setUserCreation(objTemp.getUserCreation());
            insumoDTO.setCreatedAt(objTemp.getCreatedAt());
            insumoDTO.setUserUpdated(user.getId());
            insumoDTO.setModifiedAt(Calendar.getInstance().getTime());
            Insumo obj = insumoDAO.actualizar(convertDtoToEntity(insumoDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarInsumo(Long id) {
        try {
            insumoDAO.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public ArrayList<InsumoDTO> obtenerInsumoPorCategoriaFormulaId(Long categoriaFormulaId) {
        return (ArrayList<InsumoDTO>) insumoDAO.obtenerInsumoPorCategoriaFormulaId(categoriaFormulaId)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private InsumoDTO convertEntityToDto(Insumo insumo) {
        if (insumo != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            InsumoDTO insumoDTO = new InsumoDTO();
            insumoDTO = modelMapper.map(insumo, InsumoDTO.class);
            return insumoDTO;
        } else {
            return null;
        }
    }

    private Insumo convertDtoToEntity(InsumoDTO insumoDTO) {
        if (insumoDTO != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Insumo insumo = new Insumo();
            insumo = modelMapper.map(insumoDTO, Insumo.class);
            return insumo;
        } else {
            return null;
        }
    }
}
