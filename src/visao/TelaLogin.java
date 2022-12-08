package visao;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.FuncionarioControl;
import controle.TutorControl;
import modelo.Funcionario;
import java.awt.SystemColor;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	TutorControl tutor;
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
	 * @throws IOException 
	 */
	public TelaLogin()  {
		setBackground(new Color(0, 255, 127));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 550);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 64));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtLogin = new JTextField();
		txtLogin.setBackground(new Color(32, 178, 170));
		txtLogin.setBounds(186, 191, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel.setBounds(72, 193, 69, 19);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(new Color(32, 178, 170));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\icons8-login-arredondado-50.png"));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel_1.setBounds(83, 62, 212, 81);
		contentPane.add(lblNewLabel_1);

		txtSenha = new JTextField();
		txtSenha.setBackground(new Color(32, 178, 170));
		txtSenha.setBounds(186, 222, 86, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(72, 224, 69, 18);
		contentPane.add(lblNewLabel_2);

		JButton btnLogar = new JButton("Entrar");
		btnLogar.setForeground(new Color(0, 0, 0));
		btnLogar.setBackground(new Color(192, 192, 192));
		btnLogar.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\icons8-importar-24.png"));
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
		btnLogar.setBounds(110, 295, 144, 38);
		contentPane.add(btnLogar);

		JLabel lblNewLabel_3 = new JLabel("Não tem cadastro? Cadastre-se");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setForeground(new Color(32, 178, 170));
		lblNewLabel_3.setBounds(28, 445, 267, 26);
		contentPane.add(lblNewLabel_3);

		JButton btnCadastrarTutor = new JButton("Cadastre-se");
		btnCadastrarTutor.setBackground(new Color(192, 192, 192));
		btnCadastrarTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroFunc telaFunc = new TelaCadastroFunc();
				telaFunc.setLocationRelativeTo(null);
				telaFunc.setVisible(true);
			}
		});
		btnCadastrarTutor.setBounds(89, 482, 144, 23);
		contentPane.add(btnCadastrarTutor);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\clinica-veterinaria\\img\\images.jpg"));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblNewLabel_4.setBounds(398, 62, 225, 226);
		contentPane.add(lblNewLabel_4);
	}
}
