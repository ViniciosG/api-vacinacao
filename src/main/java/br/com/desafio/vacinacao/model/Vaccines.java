package br.com.desafio.vacinacao.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="vacinnes") 
public class Vaccines {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	private String nameVaccine;
	
	@NotEmpty
	@Email
	private String emailPacient;
	
	private Date dataAplicacao = new Date(); //Atribuindo valor de data atual como padrão;
	
	@ManyToOne //muitos para muitos // exemplo time tem varios jogadores, porém, um jogador só pode jogar em um time
			  // 
	@JsonIgnoreProperties("vacinas")
	private Pacient usuario;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeVacina() {
		return nameVaccine;
	}

	public void setNameVaccine(String nameVaccine) {
		this.nameVaccine = nameVaccine;
	}

	public String getEmailUsuario() {
		return emailPacient;
	}

	public void setEmailPacient(String emailPacient) {
		this.emailPacient = emailPacient;
	}

	public Date getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}
	
	
}
