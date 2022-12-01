package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private JTextField txtcep;

	private JLabel lblNewLabel_2;

	private JTextField txtrua;

	private JLabel lblNewLabel_3;
	private JTextField txtn_casa;

	private JLabel numcasa;

	private JLabel lblTituloTutor;
	private JButton btnNewButton_2;
	private JButton bnbInserir;
	private Tutor tutorAEditar;

	Tutor tutor;
	TutorControl tutorControl;

	public TelaCadastroTutor(Tutor tutorEdit) {
		this.tutorAEditar = tutorEdit;

		bancoTutor = TutorControl.getIntancia();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtnome = new JTextField();
		txtnome.setBounds(63, 47, 86, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBackground(new Color(0, 0, 51));
		lblNewLabel.setBounds(10, 50, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(" Cpf :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(20, 78, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtcpf = new JTextField();
		txtcpf.setBounds(63, 78, 86, 20);
		contentPane.add(txtcpf);
		txtcpf.setColumns(10);
		txtcep = new JTextField();
		txtcep.setBounds(63, 132, 86, 20);
		contentPane.add(txtcep);
		txtcep.setColumns(10);

		lblNewLabel_2 = new JLabel("Cep :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(20, 134, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtrua = new JTextField();
		txtrua.setBounds(63, 103, 86, 20);
		contentPane.add(txtrua);
		txtrua.setColumns(10);

		lblNewLabel_3 = new JLabel("Rua :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(22, 109, 34, 14);
		contentPane.add(lblNewLabel_3);

		txtn_casa = new JTextField();
		txtn_casa.setBounds(63, 163, 86, 20);
		contentPane.add(txtn_casa);
		txtn_casa.setColumns(10);

		numcasa = new JLabel(" N° :");
		numcasa.setFont(new Font("Tahoma", Font.BOLD, 13));
		numcasa.setBounds(22, 165, 34, 14);
		contentPane.add(numcasa);

		JButton btnCadastrarTutor = new JButton("CADASTRAR");
		btnCadastrarTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tutorAEditar != null) {
					// EDITAR

					TutorControl control = TutorControl.getIntancia();
					control.alterar(tutorEdit, tutorEdit.getCpf());

				} else {
					// CADASTRAR
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

					boolean inserir = bancoTutor.inserir(novoTutor);

					if (inserir == true) {
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
						tutor = novoTutor;

					} else {
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
					}
				}
			}

		});
		btnCadastrarTutor.setBounds(50, 196, 120, 23);
		contentPane.add(btnCadastrarTutor);

		lblTituloTutor = new JLabel("Cadastro Cliente");
		lblTituloTutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloTutor.setForeground(new Color(0, 0, 0));
		lblTituloTutor.setBounds(63, 11, 180, 14);
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
		btnNewButton_2.setBounds(50, 277, 120, 23);
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
		bnbInserir.setBounds(48, 232, 122, 23);
		contentPane.add(bnbInserir);

		if (tutorAEditar != null) {

			txtnome.setText(tutorAEditar.getNome());
			txtcpf.setText(tutorAEditar.getCpf());
		
			
			
			
			
			lblTituloTutor.setText("Atualizar tutor");
			btnCadastrarTutor.setText("Atualizar");

			// SETAR OS DADOS

		}

	}
}
