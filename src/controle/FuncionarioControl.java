package controle;

import java.util.ArrayList;

import modelo.Funcionario;

public class FuncionarioControl {

	private ArrayList<Funcionario> tabelaFuncionarios = new ArrayList<>();

	public Funcionario buscar(String login, String senha) {

		for (Funcionario func : tabelaFuncionarios) {
			if (func.getLogin().equals(login) && func.getSenha().equals(senha)) {
				return func;
			}
		}
		return null;
	}

}
