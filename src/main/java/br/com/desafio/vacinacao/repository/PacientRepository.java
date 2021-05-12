package br.com.desafio.vacinacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.vacinacao.model.Pacient;

//permite executar as principais operações de acesso ao banco de modo automático 
public interface PacientRepository extends JpaRepository<Pacient,Long>{

	List<Pacient> findByName(String name);
	//O metodo FindByName realiza uma busca por Nome diretamente na tabela, utilizando a convenção FindBy do Spring

}
