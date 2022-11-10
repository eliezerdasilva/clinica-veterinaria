package visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.PessoaControl;
import modelo.Animal;
import modelo.Pessoa;

public class TelaAnimal extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField raca;
	private Pessoa Pessoa;



	public TelaAnimal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(29, 44, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		raca = new JTextField();
		raca.setBounds(188, 44, 86, 20);
		contentPane.add(raca);
		raca.setColumns(10);
		
		JButton btnNewButton = new JButton("cadastra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String n = nome.getText();
				String rc = raca.getText();
				
				Animal animal = new Animal();
			}
		});
		btnNewButton.setBounds(71, 108, 89, 23);
		contentPane.add(btnNewButton);
	}
	

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAnimal frame = new TelaAnimal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	
public void tabela(Pessoa p) {
	 Pessoa = p;
 }

public void TabelaAnimal() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	nome = new JTextField();
	nome.setBounds(29, 44, 86, 20);
	contentPane.add(nome);
	nome.setColumns(10);
	
	raca = new JTextField();
	raca.setBounds(188, 44, 86, 20);
	contentPane.add(raca);
	raca.setColumns(10);
	
	JButton btnNewButton = new JButton("cadastra");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String n = nome.getText();
			String rc = raca.getText();
			
			 Animal animal = new Animal();
		}
	});
	btnNewButton.setBounds(71, 108, 89, 23);
	contentPane.add(btnNewButton);
}
	
}

	
