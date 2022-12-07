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
	public boolean alterar(Tutor tutorSelecionado) {		
		for (Tutor tutor : listaPessoas()) {
			if (tutor.equals(tutorSelecionado)) {
				tutor.setNome(tutorSelecionado.getNome());
				tutor.setCpf(tutorSelecionado.getCpf());
				tutor.setAnimais(tutorSelecionado.getAnimais());				
				return true;
			}
			System.out.println("ate qui foi 2");
		}
		System.out.println("ate qui foi 3");
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
