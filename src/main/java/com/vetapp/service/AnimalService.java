package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.AnimalRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.AnimalDto;
import com.vetapp.model.Animal;
import com.vetapp.model.UserAuth;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public AnimalDto guardarAnimal(AnimalDto animalDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        animalDto.setUserCreation(user.getId());
        animalDto.setCreatedAt(Calendar.getInstance().getTime());
        Animal obj = animalRepository.save(convertDtoToEntity(animalDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<AnimalDto> obtenerAnimals() {
        return (ArrayList<AnimalDto>) animalRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    public ArrayList<AnimalDto> obtenerAnimalBySexes(String sexo) {
        return (ArrayList<AnimalDto>) animalRepository.obtenerAnimalBySexes(sexo)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public AnimalDto obtenerAnimalPorId(Long id) {
        Animal obj = animalRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public AnimalDto actualizarAnimal(AnimalDto employeeDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Animal objTemp = animalRepository.findById(id).orElse(null);
        if (objTemp != null) {
            employeeDto.setId(objTemp.getId());
            employeeDto.setUserCreation(objTemp.getUserCreation());
            employeeDto.setCreatedAt(objTemp.getCreatedAt());
            employeeDto.setUserUpdated(user.getId());
            employeeDto.setModifiedAt(Calendar.getInstance().getTime());
            Animal obj = animalRepository.save(convertDtoToEntity(employeeDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarAnimal(Long id) {
        try {
            animalRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private AnimalDto convertEntityToDto(Animal animal) {
        if (animal != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            AnimalDto animalDto = new AnimalDto();
            animalDto = modelMapper.map(animal, AnimalDto.class);
            return animalDto;
        } else {
            return null;
        }
    }

    private Animal convertDtoToEntity(AnimalDto animalDto) {
        if (animalDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Animal animal = new Animal();
            animal = modelMapper.map(animalDto, Animal.class);
            return animal;
        } else {
            return null;
        }
    }
}
