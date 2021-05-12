package br.com.desafio.vacinacao.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.vacinacao.model.Pacient;
import br.com.desafio.vacinacao.service.PacientService;
import br.com.desafio.vacinacao.service.dto.PacientDTO;
import br.com.desafio.vacinacao.service.form.PacientForm;

@RestController //responsavel por criar a API Rest
@RequestMapping("paciente/v1/api") //indicará qual o path do serviço.
public class PacientController {
	
	@Autowired
	PacientService service;
	
	@GetMapping()
	public List<PacientDTO> findAll(String name){
		return service.findAll(name);
	}
	
	//Método get utilizado para recebermos dados;
	
	@GetMapping("/vacinas/v1/api/{id}")  //rota que nosso metodo  será chamado.
	
	//ResonseEntity classe unitária nos permite gerenciar as requisições HTTP e retornar o DTO para o cliente

	public ResponseEntity<PacientDTO> findById(@PathVariable Long id) { //pathvariable serve para obter o valor passado na URL
		//Utilizamos um objeto ResponseEntity para manipular o tipo de resposta HTTP que queremos
		Optional<Pacient> pacient = service.findById(id);
		
		if(pacient.isPresent()) { //percorre a lista buscando o paciente
			return ResponseEntity.ok(new PacientDTO(pacient.get())); // retorna 200 se obtivermos sucesso!
		}else {
			return ResponseEntity.notFound().build(); // caso contrário ele nos retorna 404!
		}
	}
	
	
	
	@PostMapping // Método post utilizado para inserirmos dados;
	@Transactional // para substituir TRY E CATCH e dar (legibilidade no código)
	public ResponseEntity<PacientDTO> save(@RequestBody @Valid PacientForm pacientForm,
			UriComponentsBuilder componentsBuilder) { 
				//@RequestoBody responsavel por converter 
				//os dados automaticamente de uma requisição em formato Java para o DTO
		
		Pacient pacient = service.save(pacientForm);
		URI uri = componentsBuilder.path("/pacient/{id}").buildAndExpand(pacient.getId()).toUri();
		return ResponseEntity.created(uri).body(new PacientDTO(pacient));
		
	}




}
