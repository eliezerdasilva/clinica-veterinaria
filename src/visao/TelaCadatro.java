package visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.PessoaControl;
import modelo.Pessoa;

public class TelaCadatro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final TelaCadatro TelaAnimal = null;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
	public  PessoaControl  listPessoa = new PessoaControl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadatro frame = new TelaCadatro();
					
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
	public TelaCadatro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(63, 47, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("nome");
		lblNewLabel.setBounds(64, 22, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("cpf");
		lblNewLabel_1.setBounds(64, 79, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		cpf = new JTextField();
		cpf.setBounds(63, 103, 86, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String n = nome.getText();
				String cp = cpf.getText();
				
				
				Pessoa p = new Pessoa();
				p.setNome(n);
				p.setCpf(cp);
				
				
				listPessoa.inserir(p);
				
				
				
				TelaAnimal tc = new TelaAnimal();
				tc.TabelaAnimal();
				
				listPessoa.listaPessoas();
	

			
			}
		});
		btnNewButton.setBounds(63, 163, 89, 23);
		contentPane.add(btnNewButton);
		

	}
}
