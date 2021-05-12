package br.com.desafio.vacinacao.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

@Entity //informar a classe que ela é uma entidade, estabelecendo ligação com a tabela do banco 
public class Pacient {

	@Id  //informar ao JPA qual atributo de uma entidade estará relacionada á chave primária, obrigatório.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //valores a serem atribuídos ao identificador único serão gerados pela coluna de auto incremento do banco de dados
	private Long id;
	
	@Column(unique = true) //especificar a coluna mapeada, que este campo tem um valor único, e não pode repetir.
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String cpf;
	
	private LocalDate birth;
	


	public Pacient(String name, String email, LocalDate birth,String cpf) {	
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

	
	
}
