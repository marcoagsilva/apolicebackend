package br.com.wecode4u.insurancecliente.dtos;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

public class CustomerDTO {
	
	@NotBlank
	private String fullName;
	
	@NotBlank
	@CPF
	private String cpf;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String uf;

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
}
