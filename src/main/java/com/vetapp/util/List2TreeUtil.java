package com.vetapp.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.vetapp.dto.GrupoDTO;
import com.vetapp.dto.GrupoEventoDTO;
import com.vetapp.dto.GrupoInventarioDTO;
import com.vetapp.dto.GrupoProtocoloDTO;
import com.vetapp.model.Grupo;
import com.vetapp.model.GrupoEvento;
import com.vetapp.model.GrupoInventario;
import com.vetapp.model.GrupoProtocolo;

public class List2TreeUtil {
   
	/**
     * ID de padre de nivel raíz
*/
private static final Long ROOT_PARENT_ID = (long) 0;
 
//
/**
     * Convertir la colección de entidades ordinarias en una colección con una estructura de árbol
* @param list
* @return
*/       //grupo de animales
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
		
		//fin de grupo de animales
		
		
		
	
		// inicio de grupo inventario
		public static List<GrupoInventarioDTO> getDtoTreeListInventario(List<GrupoInventario> list){
			  List<GrupoInventarioDTO> dtos = new ArrayList<>();
			  if (list == null || list.isEmpty()) {
			      return dtos;
			  }
			  for (GrupoInventario grupo : list) {
			      if (ROOT_PARENT_ID.equals(grupo.getPadre())){
			          // Encuentra el directorio de nivel superior
			    	  GrupoInventarioDTO grupoDto = new GrupoInventarioDTO();
			          // Convertir datos de clase de entidad a dto
			          BeanUtils.copyProperties(grupo,grupoDto);
			          // Obtener todos los hijos en esta clase de entidad
			          dtos.add(findChildrenInventario(grupoDto,list));
			      }
			  }
			  return dtos;
			}
		
		
		private static GrupoInventarioDTO findChildrenInventario(GrupoInventarioDTO grupoDto, List<GrupoInventario> list) {
			  for (GrupoInventario grupo : list) {
			      if (grupoDto.getId().equals(grupo.getPadre())){
			          // En este punto, el menú es un elemento secundario en menuDto
			          if (grupoDto.getChildren() == null){
			              grupoDto.setChildren(new ArrayList<GrupoInventarioDTO>());
			          }
			          GrupoInventarioDTO dto = new GrupoInventarioDTO();
			          BeanUtils.copyProperties(grupo,dto);
			          // recursivo
			          grupoDto.getChildren().add(findChildrenInventario(dto,list));
			      }
			  }
			  return grupoDto;
			}
		
		// fines de grupo inventario
		
		//inicio grupo evento
		 
		public static List<GrupoEventoDTO> getDtoTreeListEvento(List<GrupoEvento> list){
			  List<GrupoEventoDTO> dtos = new ArrayList<>();
			  if (list == null || list.isEmpty()) {
			      return dtos;
			  }
			  for (GrupoEvento grupo : list) {
			      if (ROOT_PARENT_ID.equals(grupo.getPadre())){
			          // Encuentra el directorio de nivel superior
			    	  GrupoEventoDTO grupoDto = new GrupoEventoDTO();
			          // Convertir datos de clase de entidad a dto
			          BeanUtils.copyProperties(grupo,grupoDto);
			          // Obtener todos los hijos en esta clase de entidad
			          dtos.add(findChildrenEvento(grupoDto,list));
			      }
			  }
			  return dtos;
			}
		
		
		private static GrupoEventoDTO findChildrenEvento(GrupoEventoDTO grupoDto, List<GrupoEvento> list) {
			  for (GrupoEvento grupo : list) {
			      if (grupoDto.getId().equals(grupo.getPadre())){
			          // En este punto, el menú es un elemento secundario en menuDto
			          if (grupoDto.getChildren() == null){
			              grupoDto.setChildren(new ArrayList<GrupoEventoDTO>());
			          }
			          GrupoEventoDTO dto = new GrupoEventoDTO();
			          BeanUtils.copyProperties(grupo,dto);
			          // recursivo
			          grupoDto.getChildren().add(findChildrenEvento(dto,list));
			      }
			  }
			  return grupoDto;
			}
		
		
		//fin de grupo evento
		
		//inicio de grupo protocolo
		  
		public static List<GrupoProtocoloDTO> getDtoTreeListProtocolo(List<GrupoProtocolo> list){
			  List<GrupoProtocoloDTO> dtos = new ArrayList<>();
			  if (list == null || list.isEmpty()) {
			      return dtos;
			  }
			  for (GrupoProtocolo grupo : list) {
			      if (ROOT_PARENT_ID.equals(grupo.getPadre())){
			          // Encuentra el directorio de nivel superior
			    	  GrupoProtocoloDTO grupoDto = new GrupoProtocoloDTO();
			          // Convertir datos de clase de entidad a dto
			          BeanUtils.copyProperties(grupo,grupoDto);
			          // Obtener todos los hijos en esta clase de entidad
			          dtos.add(findChildrenProtocolo(grupoDto,list));
			      }
			  }
			  return dtos;
			}
		
		
		private static GrupoProtocoloDTO findChildrenProtocolo(GrupoProtocoloDTO grupoDto, List<GrupoProtocolo> list) {
			  for (GrupoProtocolo grupo : list) {
			      if (grupoDto.getId().equals(grupo.getPadre())){
			          // En este punto, el menú es un elemento secundario en menuDto
			          if (grupoDto.getChildren() == null){
			              grupoDto.setChildren(new ArrayList<GrupoProtocoloDTO>());
			          }
			          GrupoProtocoloDTO dto = new GrupoProtocoloDTO();
			          BeanUtils.copyProperties(grupo,dto);
			          // recursivo
			          grupoDto.getChildren().add(findChildrenProtocolo(dto,list));
			      }
			  }
			  return grupoDto;
			}
		 
		//  fin de grupo protocolo
		
		
	
}
