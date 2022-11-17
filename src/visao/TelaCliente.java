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

import controle.AnimalControl;
import controle.ClienteControl;
import modelo.Cliente;
import javax.swing.JTable;

public class TelaCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final TelaCliente TelaAnimal = null;

	private JPanel contentPane;

	private JTextField nome;

	private JTextField cpf;

	public ClienteControl listPessoa = ClienteControl.getIntancia();

	public AnimalControl listAnimal = new AnimalControl();

	private JTextField cep;

	private JLabel lblNewLabel_2;

	private JTextField rua;

	private JLabel lblNewLabel_3;

	private JTextField textField_2;

	private JLabel numcasa;

	private JLabel lblNewLabel_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();

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
	public TelaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		nome = new JTextField();
		nome.setText("Eli");
		nome.setBounds(63, 47, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBackground(new Color(0, 0, 51));
		lblNewLabel.setBounds(10, 50, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(" Cpf :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(20, 78, 46, 14);
		contentPane.add(lblNewLabel_1);

		cpf = new JTextField();
		cpf.setText("312312");
		cpf.setBounds(63, 78, 86, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);
		cep = new JTextField();
		cep.setText("cep");
		cep.setBounds(63, 132, 86, 20);
		contentPane.add(cep);
		cep.setColumns(10);

		lblNewLabel_2 = new JLabel("Cep :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(20, 134, 46, 14);
		contentPane.add(lblNewLabel_2);

		rua = new JTextField();
		rua.setText("4341");
		rua.setBounds(63, 103, 86, 20);
		contentPane.add(rua);
		rua.setColumns(10);

		lblNewLabel_3 = new JLabel("Rua :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(22, 109, 34, 14);
		contentPane.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setText("123");
		textField_2.setBounds(63, 163, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		numcasa = new JLabel(" N° :");
		numcasa.setFont(new Font("Tahoma", Font.BOLD, 13));
		numcasa.setBounds(22, 165, 34, 14);
		contentPane.add(numcasa);

		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String n = nome.getText();
				String cp = cpf.getText();
				// String ce = cep.getText();
				// String ru= rua.getText();
				// String nucasa = numcasa.getText();

				Cliente novaPessoa = new Cliente();

				if (nome == null || n.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum 'nome' preenchido!");
				} else {
					novaPessoa.setNome(n);
				}
				if (cpf == null || cp.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum 'cpf' preenchido!");
				} else {
					novaPessoa.setCpf(Long.parseLong(cp));
				}

				ClienteControl tabelaPessoa = new ClienteControl();
				boolean inserir = tabelaPessoa.inserir(novaPessoa);

				// Endereco endereco = new Endereco();
				// endereco.setCep(ce);
				// endereco.setRua(ru);
				// endereco.setNumCasa(nucasa);
				// p.setEndereco(endereco);

				listPessoa.inserir(p);

			}

		});
		btnNewButton.setBounds(148, 194, 120, 23);
		contentPane.add(btnNewButton);

		lblNewLabel_4 = new JLabel("Cadastro Cliente");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(237, 11, 180, 14);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 249, 399, 153);
		contentPane.add(panel);
		
		table = new JTable();
		panel.add(table);

	}
}
