package br.com.desafio.vacinacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.vacinacao.model.Vaccines;
import br.com.desafio.vacinacao.repository.VaccinesRepository;
import br.com.desafio.vacinacao.service.VaccinesService;



@RestController
@RequestMapping("/vacinas")
@CrossOrigin("*")
public class VacController {
	
	private VaccinesRepository repository;

	@Autowired
	private VaccinesService service;
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Vaccines> postVacinas(@RequestBody Vaccines aplicacao){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarAplicacao(aplicacao));
			
		} catch(Exception e) {
			return new ResponseEntity<Vaccines>(HttpStatus.BAD_REQUEST);
		}
	}
}
