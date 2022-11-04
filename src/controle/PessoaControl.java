package controle;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Pessoa;

public class PessoaControl {

	Scanner ler = new Scanner(System.in);
	Pessoa pessoa = new Pessoa();
	private ArrayList<Pessoa> tabelaPessoa;
	public PessoaControl() { this.tabelaPessoa = new ArrayList<>(); }
	
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
	public ArrayList<Pessoa> listaPessoas() {
		return null;
	}
}
