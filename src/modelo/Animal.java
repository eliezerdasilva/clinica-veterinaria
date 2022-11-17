package modelo;

import java.util.ArrayList;

public class Animal {

	private String tipo;
	private String nome;
	private String raca;
	private ArrayList<Animal> tabelalista = new ArrayList<>();

	public Animal(String tipo, String nome, String raca) {
		super();
		this.tipo = tipo;
		this.nome = nome;
		this.raca = raca;
		// this.dataNascimento = dataNascimento;
	}

	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
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

	public void setRaca(String raca) {
		this.raca = raca;
	}

	@Override
	public String toString() {

		return tipo + " - " + nome + "(" + raca + ")";
	}
}
