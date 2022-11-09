package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Animal {

	private String nome;
	private String raca;

	public Animal(String nome, String raca) {
		super();
		this.nome = nome;
		this.raca = raca;
	//	this.dataNascimento = dataNascimento;
	}

	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getraca() {
		return raca;
	}

	public void setraca(String raca) {
		this.raca = raca;
}
}
