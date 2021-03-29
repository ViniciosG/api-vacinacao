package br.com.desafio.vacinacao.service.form;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.NotNull;

import br.com.desafio.vacinacao.model.Pacient;

public class PacientForm {

	@NotEmpty
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	private LocalDate birth = LocalDate.now();
	
	@NotEmpty
	@CPF
	private String cpf;

	public PacientForm(String name, String email, LocalDate birth, String cpf) {
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public String getCpf() {
		return cpf;
	}

	public Pacient convert() {
		return new Pacient(name, email, birth, cpf);
	}

}
