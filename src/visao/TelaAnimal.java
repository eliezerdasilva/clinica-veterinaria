package visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.TutorControl;
import modelo.Animal;
import modelo.Tutor;
import java.awt.Color;

public class TelaAnimal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<String> cmbAnimal;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField raca;
	public TutorControl listTutor = TutorControl.getIntancia();
	private JLabel lblNewLabel;
	private Tutor tutor;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JList<Animal> listAnimal;
	private JButton btnNewButton_1;
	private JButton btnExcluir;
	private Animal animalEscolhido = null;
	private JButton btnNovo;
	private JLabel lblNewLabel_3;

	public TelaAnimal(Tutor tutor) {
		this.tutor = tutor;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		nome = new JTextField();
		nome.setBounds(108, 100, 106, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		raca = new JTextField();
		raca.setBounds(108, 151, 106, 20);
		contentPane.add(raca);
		raca.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setIcon(new ImageIcon(
				"C:\\Users\\Aluno\\Downloads\\clinica-veterinaria\\clinica-veterinaria\\img\\floppy-disk.png"));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String nomeSt = nome.getText();
				String racaSt = raca.getText();
				String tipoSt = (String) cmbAnimal.getSelectedItem();

				if (animalEscolhido == null) {
					animalEscolhido = new Animal();
					animalEscolhido.setNome(nomeSt);
					animalEscolhido.setRaca(racaSt);
					animalEscolhido.setTipo(tipoSt);

				} else {
					animalEscolhido.setNome(nomeSt);
					animalEscolhido.setRaca(racaSt);
					animalEscolhido.setTipo(tipoSt);
				}

				// deu tudo certo
				TutorControl tutorControl = TutorControl.getIntancia();

				ArrayList<Animal> animaisTutor = tutor.getAnimais();
				if (animaisTutor == null) {
					animaisTutor = new ArrayList<>();
				}
				animaisTutor.add(animalEscolhido);
				tutor.setAnimais(animaisTutor);

				boolean valida = tutorControl.alterar(tutor, tutor.getCpf());

				if (valida == true) {
					JOptionPane.showMessageDialog(null, "Sucesso cadastro do animal");
				} else {
					JOptionPane.showMessageDialog(null, "Erro cadastro do animal");
				}

//				dispose();
//				TelaClinica telaClinica = new TelaClinica();
//				telaClinica.setLocationRelativeTo(null);
//				telaClinica.setVisible(true);

				atualiza();
				nome.setText("");
				raca.setText("");
				cmbAnimal.setSelectedIndex(0);
				nome.requestFocus();

			}
		});
		btnNewButton.setBounds(29, 193, 283, 35);
		contentPane.add(btnNewButton);

		cmbAnimal = new JComboBox<>();
		cmbAnimal.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		cmbAnimal.setBounds(108, 51, 106, 20);
		contentPane.add(cmbAnimal);

		lblNewLabel = new JLabel(" Tipos :");
		lblNewLabel.setForeground(new Color(32, 178, 170));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setBounds(29, 49, 70, 18);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Nome :");
		lblNewLabel_1.setForeground(new Color(32, 178, 170));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_1.setBounds(30, 98, 69, 18);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Raça :");
		lblNewLabel_2.setForeground(new Color(32, 178, 170));
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_2.setBounds(29, 154, 70, 17);
		contentPane.add(lblNewLabel_2);

		// mostra animais cadastrados na tabela

		listAnimal = new JList<Animal>();
		listAnimal.setBackground(new Color(32, 178, 170));
		listAnimal.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				animalEscolhido = listAnimal.getSelectedValue();
				if (animalEscolhido != null) {
					System.out.println(animalEscolhido);
					raca.setText(animalEscolhido.getraca());
					nome.setText(animalEscolhido.getNome());
					cmbAnimal.setSelectedItem(animalEscolhido.getTipo());
					btnNewButton.setText("Alterar");
				}
			}
		});

		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClinica exit = new TelaClinica();
				exit.setLocationRelativeTo(null);
				exit.setVisible(true);
				dispose();

			}

		});
		btnNewButton_1.setBounds(326, 465, 283, 35);
		contentPane.add(btnNewButton_1);

		btnExcluir = new JButton("Deletar");
		btnExcluir.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnExcluir.setBackground(new Color(192, 192, 192));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Animal animalAtual = listAnimal.getSelectedValue();
				if (animalAtual != null) {
					// int i = JOptionPane
					int val = JOptionPane.showConfirmDialog(null, "Deseja remover o animal " + animalAtual.getNome(),
							"Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
					if (val == 0) {
						tutor.getAnimais().remove(animalAtual);
						atualiza();
					}

				}
			}
		});
		btnExcluir.setBounds(29, 466, 283, 34);
		contentPane.add(btnExcluir);

		btnNovo = new JButton("Limpar\r\n");
		btnNovo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btnNovo.setBackground(new Color(192, 192, 192));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				animalEscolhido = null;
				nome.setText("");
				raca.setText("");
				cmbAnimal.setSelectedIndex(0);
				btnNewButton.setText("Cadastrar");
			}
		});
		btnNovo.setBounds(29, 430, 283, 35);
		contentPane.add(btnNovo);

		cmbAnimal.addItem("Cachorro");
		cmbAnimal.addItem("Gato");
		cmbAnimal.addItem("Ave");
		cmbAnimal.addItem("Sapo");
		cmbAnimal.addItem("Peixe");
		cmbAnimal.addItem("Roedor");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 231, 283, 194);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(listAnimal);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\clinica-veterinaria\\img\\images.jpg"));
		lblNewLabel_3.setBounds(365, 25, 231, 225);
		contentPane.add(lblNewLabel_3);

		atualiza();
	}

	public void atualiza() {

		ArrayList<Animal> animais = tutor.getAnimais();
		if (animais == null) {
			animais = new ArrayList<>();
		}

		Vector<Animal> listData = new Vector<Animal>(animais);
		listAnimal.setListData(listData);
		listAnimal.updateUI();

	}

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { TelaAnimal frame = new TelaAnimal();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */

	public void tabela(Tutor p) {
		tutor = p;
	}

}
