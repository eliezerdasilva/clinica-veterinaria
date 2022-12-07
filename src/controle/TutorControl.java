package controle;

import java.util.ArrayList;
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

	// INSERT
	public boolean inserir(Tutor tutor) {
		if (tutor != null) {
			tabelaTutores.add(tutor);
			return true;
		}
		return false;
	}

	// UPDATE
	public boolean alterar(Tutor tutorSelecionado, Long cpf) {		
		for (Tutor tutor : listaPessoas()) {
			if (tutor.getCpf() == cpf) {
				tutor.setNome(tutorSelecionado.getNome());
				tutor.setAnimais(tutorSelecionado.getAnimais());				
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
		if(tabelaTutores != null) {
			return tabelaTutores;
		}
		return null;
	}

}
