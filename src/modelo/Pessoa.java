package modelo;

import java.util.ArrayList;

public abstract class Pessoa {

	private String nome;
	private Long cpf;
	public ArrayList<Animal> animais = new ArrayList<>();

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

}
