package visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.TutorControl;
import modelo.Animal;
import modelo.Tutor;

public class TelaClinica extends JFrame {

	private JPanel contentPane;
	private JList<Tutor> listaTutoresJList;
	private Tutor TutorEscolhido;

	TutorControl controlBD;

	/**
	 * Create the frame.
	 */
	public TelaClinica() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("GERENCIAMENTO DE CADASTROS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(38, 39, 386, 31);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 105, 258, 122);
		contentPane.add(scrollPane_1);

		TutorControl tutorControl = TutorControl.getIntancia();
		listaTutoresJList = new JList<>();
		listaTutoresJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				TutorEscolhido = listaTutoresJList.getSelectedValue();
				if (TutorEscolhido != null) {
					System.out.println(TutorEscolhido);
				}
			}
		});
		listaTutoresJList.setListData(new Vector<Tutor>(tutorControl.listaPessoas()));
		listaTutoresJList.updateUI();
		scrollPane_1.setViewportView(listaTutoresJList);

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroTutor telaCadastroTutor = new TelaCadastroTutor(null);
				telaCadastroTutor.setLocationRelativeTo(null);
				telaCadastroTutor.setVisible(true);
				dispose();

			}
		});
		btnCadastrar.setBounds(306, 103, 118, 23);
		contentPane.add(btnCadastrar);

		JButton btnExcluir = new JButton("DELETAR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Tutor tutorAtual = listaTutoresJList.getSelectedValue();
				if (tutorAtual != null) {
					int val = JOptionPane.showConfirmDialog(null, "Deseja remover o animal " + tutorAtual.getNome(),
							"Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
					if (val == 0) {

						boolean valida = controlBD.deletar(tutorAtual, tutorAtual.getCpf());

						if (valida == true) {
							JOptionPane.showMessageDialog(null, "Removido com sucesso!");

							// ATUALIZAR O JTABLE
							TutorControl controlBD = TutorControl.getIntancia();
							atualiza();
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao remover!");
						}

					}

				}
			}

		});
		btnExcluir.setBounds(306, 163, 118, 23);
		contentPane.add(btnExcluir);

		JButton btnSair = new JButton("EXIT");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);
				dispose();

			}
		});
		btnSair.setBounds(306, 204, 118, 23);
		contentPane.add(btnSair);

		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tutor tutorAtual = listaTutoresJList.getSelectedValue();
				if (tutorAtual != null) {
					int val = JOptionPane.showConfirmDialog(null, "Deseja alterar o animal " + tutorAtual.getNome(),
							"Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
					if (val == 0) {

						// pegar os dados dos campos de texto
						dispose();
						TelaCadastroTutor telaCadTutor = new TelaCadastroTutor(tutorAtual);
						telaCadTutor.setVisible(true);

					}

				}
			}
		});
		btnAlterar.setBounds(306, 137, 118, 23);
		contentPane.add(btnAlterar);

	}

	public void atualiza() {
		listaTutoresJList.setListData(new Vector<Tutor>(controlBD.listaPessoas()));
		listaTutoresJList.updateUI();
	}

}
