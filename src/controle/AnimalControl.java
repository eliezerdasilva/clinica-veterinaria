package controle;

import java.util.ArrayList;

import modelo.Pessoa;
import modelo.Tutor;

public class AnimalControl {

	private ArrayList<Tutor> tabelaTutores = new ArrayList<Tutor>();

	private static TutorControl ac = null;

	public static TutorControl getIntancia() {
		if (ac == null) {
			ac = new TutorControl();
		}
		return ac;
	}

	private AnimalControl() {

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
	public boolean deletar(Pessoa p, Long cpfPessoa) {

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
