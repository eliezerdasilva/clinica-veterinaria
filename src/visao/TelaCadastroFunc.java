package visao;

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

import controle.FuncionarioControl;
import modelo.Funcionario;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TelaCadastroFunc extends JFrame {

	private JPanel contentPane;
	private JTextField txtlogin;
	private JTextField txtSenha;

	/**
	 * Create the frame.
	 */
	public TelaCadastroFunc() {
		setTitle("Cadastrar funcionario\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastrar Funcionario");
		lblNewLabel.setForeground(new Color(32, 178, 170));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblNewLabel.setBounds(60, 85, 314, 38);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(32, 178, 170));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(53, 182, 73, 20);
		contentPane.add(lblNewLabel_1);

		txtlogin = new JTextField();
		txtlogin.setBackground(new Color(192, 192, 192));
		txtlogin.setBounds(118, 185, 86, 20);
		contentPane.add(txtlogin);
		txtlogin.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setForeground(new Color(32, 178, 170));
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(53, 227, 73, 20);
		contentPane.add(lblNewLabel_2);

		txtSenha = new JTextField();
		txtSenha.setBackground(new Color(192, 192, 192));
		txtSenha.setBounds(118, 230, 86, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String login = txtlogin.getText();
				String senha = txtSenha.getText();

				Funcionario funcionario = new Funcionario();

				if (login.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum nome preenchido!");
				} else {
					funcionario.setLogin(login);
				}

				if (senha.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum CPF preenchido!");
				} else {
					funcionario.setSenha(senha);
				}

				FuncionarioControl tabelaFuncionario = FuncionarioControl.getInstancia();
				boolean inserir = tabelaFuncionario.inserir(funcionario);

				if (inserir == true) {
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					dispose();

					/*
					 * System.out.println(funcionario); TelaCadastroFunc telaLogin = new
					 * TelaCadastroFunc(); telaLogin.setLocationRelativeTo(null);
					 * telaLogin.setVisible(true);
					 */
					TelaLogin telaLogin = new TelaLogin();
					telaLogin.setLocationRelativeTo(null);
					telaLogin.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
				}

			}

		});
		btnNewButton.setBounds(103, 309, 112, 46);
		contentPane.add(btnNewButton);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 462, 116, 38);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\clinica-veterinaria\\img\\images.jpg"));
		lblNewLabel_3.setBounds(384, 85, 225, 210);
		contentPane.add(lblNewLabel_3);
	}
}
