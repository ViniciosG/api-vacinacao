package br.com.desafio.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.vacinacao.model.Vaccines;



@Repository
public interface VaccinesRepository extends JpaRepository<Vaccines, Long>{
	
}
