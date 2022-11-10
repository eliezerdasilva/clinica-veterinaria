package controle;

import java.util.ArrayList;

import modelo.Animal;
import modelo.Pessoa;

public class AnimalControl {

private ArrayList<Animal> tabela = new ArrayList<Animal>(); 
	
	
	// INSERT
	public boolean inserir(Animal animal) {
		this.tabela.add(animal);
		return false;
	}

	// UPDATE
	public boolean alterar(Animal animal) {
		return false;
	}

	// DELETE
	public boolean deletar(Animal animal) {
		return false;
	}

	// SELECT
	public void listaAnimal() {
		for (Animal pp : tabela) {
			System.out.println(" Nome: "+ pp.getNome()+ " "+" Cpf"+pp.getraca());
		
	}
	}
		
	}

