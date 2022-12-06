package controle;

import java.util.ArrayList;

import modelo.Funcionario;

public class FuncionarioControl {

	private static ArrayList<Funcionario> tabelaFuncionarios;
	private static FuncionarioControl instancia;

	/**
	 * PADRAO SINGLETON QUE POSSIBILITA COM QUE SEMPRE SE UTILIZE A MESMA INSTANCIA
	 * DA MEMORIA RAM E PORTANTO
	 * 
	 * @return
	 */
	public static FuncionarioControl getInstancia() {
		if (instancia == null) {
			instancia = new FuncionarioControl();
			tabelaFuncionarios = new ArrayList<Funcionario>();

			tabelaFuncionarios.add(new Funcionario("admin", "admin"));
		}
		return instancia;
	}


	public Funcionario buscar(String login, String senha) {
		for (Funcionario funcionario : tabelaFuncionarios) {
			if (funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha)) {
				return funcionario;
			}
		}
		return null;
	}

	public boolean inserir(Funcionario funcionario) {
		if (funcionario != null) {
			FuncionarioControl.tabelaFuncionarios.add(funcionario);
			return true;
		}
		return false;
	}

	// UPDATE
	/*
	 * public boolean alterar(Funcionario login, String Senha) { for (Funcionario
	 * funcionario : tabelaFuncioario) {
	 * 
	 * if (funcionario.getSenha() == cpfPessoa) { tutor.setNome(p.getNome());
	 * tutor.setCpf(p.getCpf()); tutor.setAnimais(p.getAnimais()); return true; } }
	 * return false; }
	 */

	// DELETE
	/*
	 * public boolean deletar(Pessoa p, Long cpfPessoa) {
	 * 
	 * for (Tutor tutor : tabelaTutores) { if (tutor.getCpf() == cpfPessoa) {
	 * tabelaTutores.remove(tutor); return true; } }
	 * 
	 * return false; }
	 */
	// SELECT
	public ArrayList<Funcionario> listaFuncionario() {
		return FuncionarioControl.tabelaFuncionarios;
	}

	public Funcionario efetuarLogin(String login, String senha) {
		for (Funcionario funcionario : tabelaFuncionarios) {
			if (funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha)) {
				return funcionario;
			}
		}		
		return null;
	}

}
