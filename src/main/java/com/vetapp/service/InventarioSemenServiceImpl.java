package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.InventarioSemenDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.InventarioSemenDTO;
import com.vetapp.model.InventarioSemen;
import com.vetapp.model.UserAuth;
import com.vetapp.vo.AnimalVO;

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
public class InventarioSemenServiceImpl implements InventarioSemenService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    InventarioSemenDAO inventarioSemenDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public InventarioSemenDTO guardarInventarioSemen(InventarioSemenDTO inventarioSemenDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        inventarioSemenDto.setUserCreation(user.getId());
        inventarioSemenDto.setCreatedAt(Calendar.getInstance().getTime());
        InventarioSemen obj = inventarioSemenDao.insertar(convertDtoToEntity(inventarioSemenDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<InventarioSemenDTO> obtenerInventarioSemens() {
        return (ArrayList<InventarioSemenDTO>) inventarioSemenDao.buscarActivos(new InventarioSemen())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public InventarioSemenDTO obtenerInventarioSemenPorId(Long id) {
        InventarioSemen obj = inventarioSemenDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public InventarioSemenDTO actualizarInventarioSemen(InventarioSemenDTO inventarioSemenDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        InventarioSemen objTemp = inventarioSemenDao.buscarPorId(id);
        if (objTemp != null) {
            inventarioSemenDto.setId(objTemp.getId());
            inventarioSemenDto.setUserCreation(objTemp.getUserCreation());
            inventarioSemenDto.setCreatedAt(objTemp.getCreatedAt());
            inventarioSemenDto.setUserUpdated(user.getId());
            inventarioSemenDto.setModifiedAt(Calendar.getInstance().getTime());
            InventarioSemen obj = inventarioSemenDao.actualizar(convertDtoToEntity(inventarioSemenDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarInventarioSemen(Long id) {
        try {
            inventarioSemenDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private InventarioSemenDTO convertEntityToDto(InventarioSemen inventarioSemen) {
        if (inventarioSemen != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            InventarioSemenDTO inventarioSemenDto = new InventarioSemenDTO();
            inventarioSemenDto = modelMapper.map(inventarioSemen, InventarioSemenDTO.class);
            return inventarioSemenDto;
        } else {
            return null;
        }
    }

    private InventarioSemen convertDtoToEntity(InventarioSemenDTO inventarioSemenDto) {
        if (inventarioSemenDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            InventarioSemen inventarioSemen = new InventarioSemen();
            inventarioSemen = modelMapper.map(inventarioSemenDto, InventarioSemen.class);
            return inventarioSemen;
        } else {
            return null;
        }
    }

	@Override
	public List<InventarioSemenDTO> obtenerInventarioSemenGrupos() {
		// TODO Auto-generated method stub
		return (List<InventarioSemenDTO>) inventarioSemenDao.obtenerInventarioSemenGrupos(true);
	}

	@Override
	public boolean existenciainventarioDistintoId(String nombrenumero) {
		// TODO Auto-generated method stub
		return inventarioSemenDao.existenciainventarioDistintoId(nombrenumero);
	}

	@Override
	public boolean existenciainventarioDistintoId(Long id, String nombrenumero) {
		// TODO Auto-generated method stub
		return inventarioSemenDao.existenciainventarioDistintoId(id,nombrenumero);
	}
}
