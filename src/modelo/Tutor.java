package modelo;

import java.util.ArrayList;

public class Tutor extends Pessoa {

	public ArrayList<Animal> animais;

	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}

	@Override
	public String toString() {
		return " Tutor" + " Nome : " + getNome() + " CPF : " + getCpf() + "  Animais " + getAnimais();
	}
}
