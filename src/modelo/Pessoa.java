package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pessoa {

	private String nome;
	private String cpf;
	//public LocalDate dataNascimento;
	public ArrayList<Animal> animais = new ArrayList<>();
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

	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Endereco getEndereco() {
		return endereco;
	}

	//public LocalDate getDataNascimento() {
	//	return dataNascimento;
	//}

	//public void setDataNascimento(LocalDate dataNascimento) {
	//	this.dataNascimento = dataNascimento;
	//}
	

}
