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

import controle.ClienteControl;
import modelo.Cliente;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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

		nome = new JTextField();
		nome.setBounds(100, 67, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setBounds(27, 70, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_1.setBounds(170, 24, 189, 32);
		contentPane.add(lblNewLabel_1);

		cpf = new JTextField();
		cpf.setBounds(100, 98, 86, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("cpf");
		lblNewLabel_2.setBounds(27, 101, 46, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Entra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String n = nome.getText();
				String cp = cpf.getText();

				ClienteControl controle = ClienteControl.getIntancia();
				Cliente p = controle.BuscarPessoa(n, cp);
				if (p != null) {
					dispose();
					TelaAnimal telaAnimal = new TelaAnimal(p);
					telaAnimal.setLocationRelativeTo(null);
					telaAnimal.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usuário não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(97, 147, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("Não tem cadastro?Cadastre-se");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(62, 204, 199, 14);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("Cadastra-se");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCliente tc = new TelaCliente();
				dispose();
				tc.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(62, 227, 144, 23);
		contentPane.add(btnNewButton_1);
	}
}
