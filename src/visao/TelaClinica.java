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
import modelo.Tutor;

public class TelaClinica extends JFrame {

	private JPanel contentPane;
	private JList<Tutor> listTutor;
	private Tutor TutorEscolhido = null;

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
		JList<Tutor> list = new JList<>();
		list.setListData(new Vector<Tutor>(tutorControl.listaPessoas()));
		list.updateUI();

		scrollPane_1.setViewportView(list);

		listTutor = new JList<Tutor>();
		listTutor.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				TutorEscolhido = listTutor.getSelectedValue();
				if (TutorEscolhido != null) {

					System.out.println(TutorEscolhido);
				}
			}
		});

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroTutor telaCadastroTutor = new TelaCadastroTutor();
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

				Tutor tutorAtual = listTutor.getSelectedValue();
				if (tutorAtual != null) {
					int val = JOptionPane.showConfirmDialog(null, "Deseja remover o animal " + tutorAtual.getNome(),
							"Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
					if (val == 0) {
						TutorControl controlBD = TutorControl.getIntancia();
						controlBD.deletar(tutorAtual, tutorAtual.getCpf());
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

			}
		});
		btnAlterar.setBounds(306, 137, 118, 23);
		contentPane.add(btnAlterar);

	}

}
