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
import java.awt.Color;
import javax.swing.ImageIcon;

public class TelaClinica extends JFrame {

	private JPanel contentPane;
	private JList<Tutor> listaTutoresJList;
	private Tutor TutorEscolhido;

	TutorControl tutorControl;

	/**
	 * Create the frame.
	 */
	public TelaClinica() {
		setTitle("Gerenciamento de Tutores\r\n");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("GERENCIAMENTO DE TUTORES");
		lblNewLabel.setForeground(new Color(32, 178, 170));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\icons8-network-48.png"));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel.setBounds(40, 29, 414, 65);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(79, 105, 258, 122);
		contentPane.add(scrollPane_1);

		TutorControl tutorControl = TutorControl.getIntancia();
		listaTutoresJList = new JList<>();
		listaTutoresJList.setBackground(new Color(32, 178, 170));
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
		btnCadastrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnCadastrar.setBackground(new Color(192, 192, 192));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroTutor telaCadastroTutor = new TelaCadastroTutor(null);
				telaCadastroTutor.setLocationRelativeTo(null);
				telaCadastroTutor.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(149, 277, 118, 23);
		contentPane.add(btnCadastrar);

		JButton btnExcluir = new JButton("DELETAR");
		btnExcluir.setBackground(new Color(192, 192, 192));
		btnExcluir.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (TutorEscolhido != null) {
					int confirmacao = JOptionPane.showConfirmDialog(null,
							"Deseja remover o tutor " + TutorEscolhido.getNome(), "Confirmação de exclusão",
							JOptionPane.YES_NO_OPTION);
					if (confirmacao == 0) {
						try {
							boolean valida = tutorControl.deletar(TutorEscolhido.getCpf());
							if (valida) {
								JOptionPane.showMessageDialog(null, "Removido com sucesso!");

								// atualizar o jlist
								listaTutoresJList.setListData(new Vector<Tutor>(tutorControl.listaPessoas()));
								listaTutoresJList.updateUI();
							} else {
								JOptionPane.showMessageDialog(null, "ERRO AO REMOVER!");
							}
						} catch (Exception error) {
							System.out.println(error);
							JOptionPane.showMessageDialog(null, "Erro ao remover!");
						}
					}

				}
			}

		});
		btnExcluir.setBounds(149, 345, 118, 23);
		contentPane.add(btnExcluir);

		JButton btnSair = new JButton("EXIT");
		btnSair.setBackground(new Color(192, 192, 192));
		btnSair.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnSair.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\icons8-sair-24.png"));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);
				dispose();

			}
		});
		btnSair.setBounds(149, 378, 118, 23);
		contentPane.add(btnSair);

		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setBackground(new Color(192, 192, 192));
		btnAlterar.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TutorEscolhido != null) {
					int val = JOptionPane.showConfirmDialog(null, "Deseja alterar o animal " + TutorEscolhido.getNome(),
							"Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
					if (val == 0) {

						// pegar os dados dos campos de texto

						dispose();
						TelaCadastroTutor telaCadTutor = new TelaCadastroTutor(TutorEscolhido);
						telaCadTutor.setLocationRelativeTo(null);
						telaCadTutor.setVisible(true);

					}

				} else {
					JOptionPane.showMessageDialog(null, "Nenhum tutor selecionado!");
				}
			}
		});
		btnAlterar.setBounds(149, 311, 118, 23);
		contentPane.add(btnAlterar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\clinica-veterinaria\\img\\images.jpg"));
		lblNewLabel_1.setBounds(373, 76, 236, 225);
		contentPane.add(lblNewLabel_1);

	}
}
