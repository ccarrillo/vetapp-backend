package com.vetapp.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.vetapp.dto.GrupoDTO;
import com.vetapp.model.Grupo;

public class List2TreeUtil {
   
	/**
     * ID de padre de nivel raíz
*/
private static final Long ROOT_PARENT_ID = (long) 0;

/**
     * Convertir la colección de entidades ordinarias en una colección con una estructura de árbol
* @param list
* @return
*/
		public static List<GrupoDTO> getDtoTreeList(List<Grupo> list){
		  List<GrupoDTO> dtos = new ArrayList<>();
		  if (list == null || list.isEmpty()) {
		      return dtos;
		  }
		  for (Grupo grupo : list) {
		      if (ROOT_PARENT_ID.equals(grupo.getPadre())){
		          // Encuentra el directorio de nivel superior
		    	  GrupoDTO grupoDto = new GrupoDTO();
		          // Convertir datos de clase de entidad a dto
		          BeanUtils.copyProperties(grupo,grupoDto);
		          // Obtener todos los hijos en esta clase de entidad
		          dtos.add(findChildren(grupoDto,list));
		      }
		  }
		  return dtos;
		}

/**
     * Obtenga a todos los niños en la clase dto y guárdelos para los niños en dto
* @param menuDto
* @param list
* @return
*/
		private static GrupoDTO findChildren(GrupoDTO grupoDto, List<Grupo> list) {
		  for (Grupo grupo : list) {
		      if (grupoDto.getId().equals(grupo.getPadre())){
		          // En este punto, el menú es un elemento secundario en menuDto
		          if (grupoDto.getChildren() == null){
		              grupoDto.setChildren(new ArrayList<GrupoDTO>());
		          }
		          GrupoDTO dto = new GrupoDTO();
		          BeanUtils.copyProperties(grupo,dto);
		          // recursivo
		          grupoDto.getChildren().add(findChildren(dto,list));
		      }
		  }
		  return grupoDto;
		}
	
}
