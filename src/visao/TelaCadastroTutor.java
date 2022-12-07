package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.TutorControl;
import modelo.Tutor;
import javax.swing.ImageIcon;

public class TelaCadastroTutor extends JFrame {

	private static final long serialVersionUID = 1L;

	protected static final TelaCadastroTutor TelaAnimal = null;

	private JPanel contentPane;

	private JTextField txtnome;

	private JTextField txtCpf;

	public TutorControl bancoTutor;

	private JLabel lblTituloTutor;
	private JButton btnNewButton_2;
	private JButton bnbInserir;

	Tutor tutor;
	TutorControl tutorControl;
	private JLabel lblNewLabel_2;

	public TelaCadastroTutor(Tutor tutorEdit) {

		bancoTutor = TutorControl.getIntancia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 327);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtnome = new JTextField();
		txtnome.setBackground(new Color(192, 192, 192));
		txtnome.setBounds(63, 74, 119, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBackground(new Color(0, 0, 51));
		lblNewLabel.setBounds(10, 77, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(" Cpf :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(20, 105, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtCpf = new JTextField();
		txtCpf.setBackground(new Color(192, 192, 192));
		txtCpf.setBounds(63, 105, 119, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		JButton btnCadastrarTutor = new JButton("CADASTRAR");

		if (tutorEdit != null) {
			txtCpf.setEditable(false);
			txtCpf.setEnabled(false);
		}

		btnCadastrarTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nomeTutorStr = txtnome.getText();
				String cpfTutorStr = txtCpf.getText();

				Tutor novoTutor = new Tutor();

				if (nomeTutorStr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum nome preenchido!");
				} else {
					novoTutor.setNome(nomeTutorStr);
				}

				if (cpfTutorStr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum CPF preenchido!");
				} else {
					novoTutor.setCpf(Long.valueOf(cpfTutorStr));
				}

				if (tutorEdit != null) {

					boolean valida = bancoTutor.alterar(novoTutor, tutorEdit.getCpf());
					if (valida == true) {
						try {
							JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
							tutor = novoTutor;
							dispose();
							TelaClinica tC = new TelaClinica();
							tC.setLocationRelativeTo(null);
							tC.setVisible(true);
						} catch (Exception e2) {
							System.out.println(e2);
							JOptionPane.showMessageDialog(null, "Erro ao Alterar!");
						}
					}
				} else {
					boolean valida = bancoTutor.inserir(novoTutor);
					if (valida == true) {
						try {
							JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
							tutor = novoTutor;
						} catch (Exception e2) {
							System.out.println(e2);
							JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
						}
					}
				}

			}

		});
		btnCadastrarTutor.setBounds(50, 155, 132, 23);
		contentPane.add(btnCadastrarTutor);

		lblTituloTutor = new JLabel("Cadastro Cliente");
		lblTituloTutor.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\icons8-fita-de-bookmark-24.png"));
		lblTituloTutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloTutor.setForeground(new Color(0, 0, 0));
		lblTituloTutor.setBounds(32, 22, 198, 20);
		contentPane.add(lblTituloTutor);

		JButton btnNewButton_1 = new JButton("Voltar ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClinica telaClinica = new TelaClinica();
				telaClinica.setLocationRelativeTo(null);
				telaClinica.setVisible(true);
				dispose();
			}

		});
		btnNewButton_1.setBounds(463, 379, 89, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\icons8-sair-24.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaClinica telaClinica = new TelaClinica();
				telaClinica.setLocationRelativeTo(null);
				telaClinica.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(50, 223, 132, 23);
		contentPane.add(btnNewButton_2);

		bnbInserir = new JButton("Inserir animal");
		bnbInserir.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\icons8-logout-arredondado-acima-30.png"));
		bnbInserir.setFont(new Font("Tahoma", Font.PLAIN, 9));
		bnbInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaAnimal telaanimal = new TelaAnimal(tutor);
				telaanimal.setLocationRelativeTo(null);
				telaanimal.setVisible(true);
				dispose();

			}
		});
		bnbInserir.setBounds(50, 189, 132, 23);
		contentPane.add(bnbInserir);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\icons8-contatos-24.png"));
		lblNewLabel_2.setBounds(182, 22, 46, 24);
		contentPane.add(lblNewLabel_2);

		if (tutorEdit != null) {
			txtnome.setText(tutorEdit.getNome());
			txtCpf.setText(String.valueOf(tutorEdit.getCpf()));

			lblTituloTutor.setText("Atualizar tutor");
			btnCadastrarTutor.setText("Atualizar");

			// SETAR OS DADOS

		}

	}
}
