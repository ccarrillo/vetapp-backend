package com.vetapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200","http://192.168.32.100"})
@RestController
@RequestMapping(path = "/api/vet/test")
public class TestController {

	@GetMapping("/")
	public ResponseEntity<?> test() {
		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "Api rest OK");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
