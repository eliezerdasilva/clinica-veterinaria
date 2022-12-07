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

public class TelaCadastroFunc extends JFrame {

	private JPanel contentPane;
	private JTextField txtlogin;
	private JTextField txtSenha;

	/**
	 * Create the frame.
	 */
	public TelaCadastroFunc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastrar Funcionario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(96, 21, 289, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setBounds(32, 59, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtlogin = new JTextField();
		txtlogin.setBounds(75, 56, 86, 20);
		contentPane.add(txtlogin);
		txtlogin.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setBounds(201, 59, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtSenha = new JTextField();
		txtSenha.setBounds(245, 56, 86, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
		
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
		btnNewButton.setBounds(135, 108, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 155, 89, 23);
		contentPane.add(btnVoltar);
	}
}
