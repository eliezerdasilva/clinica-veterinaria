package controle;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Pessoa;

public class PessoaControl {

	private ArrayList<Pessoa> tabelaPessoa = new ArrayList<Pessoa>(); 
	
	
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
			System.out.println(" Nome: "+ pp.getNome()+ " "+" Cpf"+pp.getCpf());
		
	}
	}
		public Pessoa BuscarPessoa(String nome, String cpf) {
	
			for(Pessoa pp : tabelaPessoa) {
				if(pp.getNome().equals(nome) && pp.getCpf().equals(cpf)){
					return pp;
				}
				}
			System.out.println(" Usuario nao cadastrado");
			return null;
		}
	}

