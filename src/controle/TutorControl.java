package controle;

import java.util.ArrayList;

import modelo.Pessoa;
import modelo.Tutor;

public class TutorControl {

	private static ArrayList<Tutor> tabelaTutores;

	private static TutorControl ac = null;

	public static TutorControl getIntancia() {
		if (ac == null) {
			ac = new TutorControl();
			tabelaTutores = new ArrayList<Tutor>();

		}
		return ac;
	}

	private TutorControl() {

	}

	public void listaTutor() {
		for (Pessoa pp : tabelaTutores) {
			System.out.println(" Nome: " + pp.getNome() + " " + " Cpf" + pp.getCpf());

		}
	}

	// INSERT
	public boolean inserir(Tutor p) {
		if (p != null) {
			this.tabelaTutores.add(p);
			return true;
		}
		return false;
	}

	// UPDATE
	public boolean alterar(Tutor p, Long cpfPessoa) {
		for (Tutor tutor : tabelaTutores) {

			if (tutor.getCpf() == cpfPessoa) {
				tutor.setNome(p.getNome());
				tutor.setCpf(p.getCpf());
				tutor.setAnimais(p.getAnimais());
				return true;
			}
		}
		return false;
	}

	// DELETE
	public boolean deletar(Tutor p, Long cpfPessoa ) {

		for (Tutor tutor : tabelaTutores) {
			if (tutor.getCpf() == cpfPessoa) {
				tabelaTutores.remove(tutor);
				return true;
			}
		}

		return false;
	}

	// SELECT
	public ArrayList<Tutor> listaPessoas() {
		return this.tabelaTutores;

	}

}
