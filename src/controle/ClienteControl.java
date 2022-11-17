package controle;

import java.util.ArrayList;

import modelo.Cliente;

public class ClienteControl {

	private ArrayList<Cliente> tabelaPessoa = new ArrayList<Cliente>();

	private static ClienteControl ac = null;

	public static ClienteControl getIntancia() {
		if (ac == null) {
			ac = new ClienteControl();
		}
		return ac;
	}

	public ClienteControl() {
		
	}

	// INSERT
	public boolean inserir(Cliente p) {
		this.tabelaPessoa.add(p);
		return false;
	}

	// UPDATE
	public boolean alterar(Cliente p) {
		return false;
	}

	// DELETE
	public boolean deletar(Cliente p) {
		return false;
	}

	// SELECT
	public void listaPessoas() {
		for (Cliente pp : tabelaPessoa) {
			System.out.println(" Nome: " + pp.getNome() + " " + " Cpf" + pp.getCpf());

		}
	}

	public Cliente BuscarPessoa(String nome, String cpf) {

		for (Cliente pp : tabelaPessoa) {
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
