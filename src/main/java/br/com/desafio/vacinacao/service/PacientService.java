package br.com.desafio.vacinacao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.desafio.vacinacao.model.Pacient;
import br.com.desafio.vacinacao.repository.PacientRepository;
import br.com.desafio.vacinacao.service.dto.PacientDTO;
import br.com.desafio.vacinacao.service.form.PacientForm;



@Service //Responsável pelas regras de négocio do projeto;

public class PacientService {

	@Autowired //Injeção de dependência do nosso repository. processo de prover instâncias de classas 
	//que um objeto precisa para funcionar. usado em setters e construtores.
	PacientRepository repository;

	
	
	@Transactional //
	public Pacient save(PacientForm pacienteForm) {
		Pacient pacient = pacienteForm.convert();
		repository.save(pacient);
		return pacient;
	}
	
 //um simples trecho para buscarmos usuarios atraves do seu Id e conseguir listar pela URL
	public Optional<Pacient> findById(Long id) {
		Optional<Pacient> pacient = repository.findById(id);
		if (pacient.isPresent()) {
			return pacient;
		} else {
			return Optional.empty();
		}
	}

	public List<PacientDTO> findAll(String name) {
		if (name == null) {
			return PacientDTO.convert(repository.findAll());
		} else {
			return PacientDTO.convert(repository.findByName(name));
		}
	}
		




}
