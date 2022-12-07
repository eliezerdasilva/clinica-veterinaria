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

public class TelaCadastroTutor extends JFrame {

	private static final long serialVersionUID = 1L;

	protected static final TelaCadastroTutor TelaAnimal = null;

	private JPanel contentPane;

	private JTextField txtnome;

	private JTextField txtcpf;

	public TutorControl bancoTutor;

	private JLabel lblTituloTutor;
	private JButton btnNewButton_2;
	private JButton bnbInserir;

	Tutor tutor;
	TutorControl tutorControl;

	public TelaCadastroTutor(Tutor tutorEdit) {		

		bancoTutor = TutorControl.getIntancia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtnome = new JTextField();
		txtnome.setBounds(63, 74, 86, 20);
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

		txtcpf = new JTextField();
		txtcpf.setBounds(63, 105, 86, 20);
		contentPane.add(txtcpf);
		txtcpf.setColumns(10);

		JButton btnCadastrarTutor = new JButton("CADASTRAR");
		
		btnCadastrarTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					String nomeTutorStr = txtnome.getText();
					String cpfTutorStr = txtcpf.getText();

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
						boolean valida = bancoTutor.alterar(novoTutor);
						if (valida == true) {
							try {
								JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
								tutor = novoTutor;
							} catch (Exception e2) {
								System.out.println(e2);
								JOptionPane.showMessageDialog(null, "Erro ao Alterar!");
							}
						}						
					}else {
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
		btnCadastrarTutor.setBounds(50, 136, 120, 23);
		contentPane.add(btnCadastrarTutor);

		lblTituloTutor = new JLabel("Cadastro Cliente");
		lblTituloTutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloTutor.setForeground(new Color(0, 0, 0));
		lblTituloTutor.setBounds(50, 30, 180, 14);
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
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaClinica telaClinica = new TelaClinica();
				telaClinica.setLocationRelativeTo(null);
				telaClinica.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(50, 204, 120, 23);
		contentPane.add(btnNewButton_2);

		bnbInserir = new JButton("Inserir animal");
		bnbInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaAnimal telaanimal = new TelaAnimal(tutor);
				telaanimal.setLocationRelativeTo(null);
				telaanimal.setVisible(true);
				dispose();

			}
		});
		bnbInserir.setBounds(50, 170, 122, 23);
		contentPane.add(bnbInserir);

		if (tutorEdit != null) {
			txtnome.setText(tutorEdit.getNome());
			txtcpf.setText(String.valueOf(tutorEdit.getCpf()));

			lblTituloTutor.setText("Atualizar tutor");
			btnCadastrarTutor.setText("Atualizar");

			// SETAR OS DADOS

		}

	}
}
