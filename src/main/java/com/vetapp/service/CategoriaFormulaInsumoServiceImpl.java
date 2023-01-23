package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.CategoriaFormulaInsumoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.CategoriaFormulaInsumoDTO;
import com.vetapp.model.CategoriaFormulaInsumo;
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
public class CategoriaFormulaInsumoServiceImpl implements CategoriaFormulaInsumoService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    CategoriaFormulaInsumoDAO categoriaFormulaInsumoDAO;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public CategoriaFormulaInsumoDTO guardarCategoriaFormulaInsumo(CategoriaFormulaInsumoDTO categoriaFormulaInsumoDTO) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        categoriaFormulaInsumoDTO.setUserCreation(user.getId());
        categoriaFormulaInsumoDTO.setCreatedAt(Calendar.getInstance().getTime());
        CategoriaFormulaInsumo obj = categoriaFormulaInsumoDAO.insertar(convertDtoToEntity(categoriaFormulaInsumoDTO));
        return convertEntityToDto(obj);
    }

    public ArrayList<CategoriaFormulaInsumoDTO> obtenerCategoriaFormulaInsumos() {
        return (ArrayList<CategoriaFormulaInsumoDTO>) categoriaFormulaInsumoDAO.buscarActivos(new CategoriaFormulaInsumo())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public CategoriaFormulaInsumoDTO obtenerCategoriaFormulaInsumoPorId(Long id) {
        CategoriaFormulaInsumo obj = categoriaFormulaInsumoDAO.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public CategoriaFormulaInsumoDTO actualizarCategoriaFormulaInsumo(CategoriaFormulaInsumoDTO categoriaFormulaInsumoDTO, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        CategoriaFormulaInsumo objTemp = categoriaFormulaInsumoDAO.buscarPorId(id);
        if (objTemp != null) {
            categoriaFormulaInsumoDTO.setId(objTemp.getId());
            categoriaFormulaInsumoDTO.setUserCreation(objTemp.getUserCreation());
            categoriaFormulaInsumoDTO.setCreatedAt(objTemp.getCreatedAt());
            categoriaFormulaInsumoDTO.setUserUpdated(user.getId());
            categoriaFormulaInsumoDTO.setModifiedAt(Calendar.getInstance().getTime());
            CategoriaFormulaInsumo obj = categoriaFormulaInsumoDAO.actualizar(convertDtoToEntity(categoriaFormulaInsumoDTO));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarCategoriaFormulaInsumo(Long id) {
        try {
            categoriaFormulaInsumoDAO.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public ArrayList<CategoriaFormulaInsumoDTO> obtenerCategoriaFormulaInsumoPorCategoriaFormulaId(Long categoriaFormulaId) {
        return (ArrayList<CategoriaFormulaInsumoDTO>) categoriaFormulaInsumoDAO.obtenerCategoriaFormulaInsumoPorCategoriaFormulaId(categoriaFormulaId)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private CategoriaFormulaInsumoDTO convertEntityToDto(CategoriaFormulaInsumo categoriaFormulaInsumo) {
        if (categoriaFormulaInsumo != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            CategoriaFormulaInsumoDTO categoriaFormulaInsumoDTO = new CategoriaFormulaInsumoDTO();
            categoriaFormulaInsumoDTO = modelMapper.map(categoriaFormulaInsumo, CategoriaFormulaInsumoDTO.class);
            return categoriaFormulaInsumoDTO;
        } else {
            return null;
        }
    }

    private CategoriaFormulaInsumo convertDtoToEntity(CategoriaFormulaInsumoDTO categoriaFormulaInsumoDTO) {
        if (categoriaFormulaInsumoDTO != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            CategoriaFormulaInsumo categoriaFormulaInsumo = new CategoriaFormulaInsumo();
            categoriaFormulaInsumo = modelMapper.map(categoriaFormulaInsumoDTO, CategoriaFormulaInsumo.class);
            return categoriaFormulaInsumo;
        } else {
            return null;
        }
    }
}
