package controle;

import java.util.ArrayList;

import modelo.Animal;
import modelo.Pessoa;

public class PessoaAnimalControl {

	private ArrayList<Pessoa> tabelaPessoa = new ArrayList<Pessoa>();

	private static PessoaAnimalControl ac = null;

	public static PessoaAnimalControl getIntancia() {
		if (ac == null) {
			ac = new PessoaAnimalControl();
		}
		return ac;
	}
	private PessoaAnimalControl() {
		// TODO Auto-generated constructor stub
	}

	// INSERT
	public boolean inserir(Pessoa p) {
		this.tabelaPessoa.add(p);
		return false;
	}

	// UPDATE
	public boolean alterar(Pessoa p) {
		return false;
	}

	// DELETE
	public boolean deletar(Pessoa p) {
		return false;
	}

	// SELECT
	public void listaPessoas() {
		for (Pessoa pp : tabelaPessoa) {
			System.out.println(" Nome: " + pp.getNome() + " " + " Cpf" + pp.getCpf());

		}
	}

	public Pessoa BuscarPessoa(String nome, String cpf) {

		for (Pessoa pp : tabelaPessoa) {
			if (pp.getNome().equals(nome) && pp.getCpf().equals(cpf)) {
				return pp;
			}
		}
		System.out.println(" Usuario nao cadastrado");
		return null;
	}

	// SELECT
	public void listaAnimal() {
		/*
		 * for (Animal pp : tabela) { System.out.println(" Nome: "+ pp.getNome()+
		 * " "+" Cpf"+pp.getraca());
		 * 
		 * }
		 */
	}

}
