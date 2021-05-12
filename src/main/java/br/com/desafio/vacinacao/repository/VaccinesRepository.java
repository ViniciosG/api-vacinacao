package br.com.desafio.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.vacinacao.model.Vaccines;



@Repository //atuara como um repositorio de anco de dados, 
//responsaveis pelo processos do banco chamada cama de persistencia //metodos de transaçao com o BD
public interface VaccinesRepository extends JpaRepository<Vaccines, Long>{
	
}
