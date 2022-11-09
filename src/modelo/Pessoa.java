package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pessoa {

	private String nome;
	private String cpf;
	//public LocalDate dataNascimento;
	public ArrayList<Animal> animais;
	public Endereco endereco;

	public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	//	this.dataNascimento = dataNascimento;
	}

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	//public LocalDate getDataNascimento() {
	//	return dataNascimento;
	//}

	//public void setDataNascimento(LocalDate dataNascimento) {
	//	this.dataNascimento = dataNascimento;
	//}

}
