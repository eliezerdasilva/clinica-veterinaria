package visao;

import java.awt.Color;
import java.awt.EventQueue;
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

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtLogin = new JTextField();
		txtLogin.setBounds(100, 67, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(27, 70, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_1.setBounds(170, 24, 189, 32);
		contentPane.add(lblNewLabel_1);

		txtSenha = new JTextField();
		txtSenha.setBounds(100, 98, 86, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(27, 101, 46, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnLogar = new JButton("Entra");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String loginStr = txtLogin.getText();
				String senhaStr = txtSenha.getText();

				FuncionarioControl controle = FuncionarioControl.getInstancia();
				Funcionario funcionario = controle.efetuarLogin(loginStr, senhaStr);

				if (funcionario != null) {
					dispose();
					TelaClinica telaClinica = new TelaClinica();
					telaClinica.setLocationRelativeTo(null);
					telaClinica.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usuário não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnLogar.setBounds(100, 129, 86, 23);
		contentPane.add(btnLogar);

		JLabel lblNewLabel_3 = new JLabel("Não tem cadastro? Cadastre-se");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(62, 204, 199, 14);
		contentPane.add(lblNewLabel_3);

		JButton btnCadastrarTutor = new JButton("Cadastre-se");
		btnCadastrarTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroFunc telaFunc = new TelaCadastroFunc();
				telaFunc.setLocationRelativeTo(null);
				telaFunc.setVisible(true);
			}
		});
		btnCadastrarTutor.setBounds(62, 227, 144, 23);
		contentPane.add(btnCadastrarTutor);
	}
}
