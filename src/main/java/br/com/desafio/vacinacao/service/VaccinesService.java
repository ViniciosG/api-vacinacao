package br.com.desafio.vacinacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.vacinacao.model.Vaccines;
import br.com.desafio.vacinacao.repository.VaccinesRepository;



@Service //Responsável pelas regras de négocio do projeto;
public class VaccinesService {

	@Autowired
	private VaccinesRepository repository;
	
	public Vaccines cadastrarAplicacao(Vaccines vacina) {
		return this.repository.save(vacina);
	}
}
