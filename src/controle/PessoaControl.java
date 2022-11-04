package controle;

import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaControl {

	private ArrayList<Pessoa> tabelaPessoa;

	public PessoaControl() { this.tabelaPessoa = new ArrayList<>(); }

	// INSERT
	public boolean inserir(Pessoa p) {

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
	public ArrayList<Pessoa> listaPessoas() {
		return null;
	}
}
