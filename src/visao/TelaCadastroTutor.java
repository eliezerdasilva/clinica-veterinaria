package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
	private JTextField txtCpf;
	public TutorControl bancoTutor;
	private JLabel lblTituloTutor;
	private JButton btnNewButton_2;
	private JButton bnbInserir;
	private Tutor tutor;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	public TelaCadastroTutor(Tutor tutorEdit) {
		setTitle("Cadastrar Cliente\r\n");

		this.tutor = tutorEdit;

		bancoTutor = TutorControl.getIntancia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtnome = new JTextField();
		txtnome.setBackground(new Color(32, 178, 170));
		txtnome.setBounds(147, 169, 119, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setForeground(new Color(32, 178, 170));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setBackground(new Color(0, 0, 51));
		lblNewLabel.setBounds(70, 168, 60, 17);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(" Cpf :");
		lblNewLabel_1.setForeground(new Color(32, 178, 170));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_1.setBounds(70, 199, 70, 20);
		contentPane.add(lblNewLabel_1);

		txtCpf = new JTextField();
		txtCpf.setBackground(new Color(32, 178, 170));
		txtCpf.setBounds(147, 200, 119, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		JButton btnCadastrarTutor = new JButton("CADASTRAR");
		btnCadastrarTutor.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnCadastrarTutor.setBackground(new Color(192, 192, 192));

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
		btnCadastrarTutor.setBounds(137, 270, 132, 23);
		contentPane.add(btnCadastrarTutor);

		lblTituloTutor = new JLabel("Cadastro Cliente");
		lblTituloTutor.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\icons8-fita-de-bookmark-24.png"));
		lblTituloTutor.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblTituloTutor.setForeground(new Color(32, 178, 170));
		lblTituloTutor.setBounds(96, 88, 184, 33);
		contentPane.add(lblTituloTutor);

		btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\icons8-sair-24.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaClinica telaClinica = new TelaClinica();
				telaClinica.setLocationRelativeTo(null);
				telaClinica.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(30, 398, 132, 23);
		contentPane.add(btnNewButton_2);

		bnbInserir = new JButton("Inserir animal");
		bnbInserir.setBackground(new Color(192, 192, 192));
		bnbInserir.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\icons8-logout-arredondado-acima-30.png"));
		bnbInserir.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		bnbInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(bancoTutor.isEmpty()) {
//					
//				}
				TelaAnimal telaanimal = new TelaAnimal(tutor);
				telaanimal.setLocationRelativeTo(null);
				telaanimal.setVisible(true);
				dispose();

			}
		});
		bnbInserir.setBounds(231, 398, 132, 23);
		contentPane.add(bnbInserir);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\icons8-contatos-24.png"));
		lblNewLabel_2.setBounds(182, 22, 46, 24);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\clinica-veterinaria\\img\\images.jpg"));
		lblNewLabel_3.setBounds(383, 88, 212, 202);
		contentPane.add(lblNewLabel_3);

		if (tutorEdit != null) {
			txtnome.setText(tutorEdit.getNome());
			txtCpf.setText(String.valueOf(tutorEdit.getCpf()));

			lblTituloTutor.setText("Atualizar tutor");
			btnCadastrarTutor.setText("Atualizar");

			// SETAR OS DADOS

		}

	}
}
