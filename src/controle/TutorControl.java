package controle;

import java.util.ArrayList;

import modelo.Pessoa;
import modelo.Tutor;

public class TutorControl {

	private static ArrayList<Tutor> tabelaTutores;

	private static TutorControl tutorControl;

	public static TutorControl getIntancia() {
		if (tutorControl == null) {
			tutorControl = new TutorControl();
			tabelaTutores = new ArrayList<Tutor>();
		}
		return tutorControl;
	}

	public void listaTutor() {
		for (Pessoa pessoa : tabelaTutores) {
			System.out.println(" Nome: " + pessoa.getNome() + " " + " Cpf" + pessoa.getCpf());
		}
	}

	// INSERT
	public boolean inserir(Tutor tutor) {
		if (tutor != null) {
			TutorControl.tabelaTutores.add(tutor);
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
	public boolean deletar(Long cpfPessoa ) {
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
		System.out.println(TutorControl.tabelaTutores);
		return TutorControl.tabelaTutores;
	}

}
