package modelo;

import java.util.ArrayList;

public class Cliente {

	private String nome;
	private Long cpf;
	public ArrayList<Animal> animais;

	public Cliente(String nome, long cpf, ArrayList<Animal> animais) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public Cliente() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}

}
