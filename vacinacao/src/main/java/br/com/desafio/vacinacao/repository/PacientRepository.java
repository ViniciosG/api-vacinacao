package br.com.desafio.vacinacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.vacinacao.model.Pacient;


public interface PacientRepository extends JpaRepository<Pacient,Long>{

	List<Pacient> findByName(String name);

}
