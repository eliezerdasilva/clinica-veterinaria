package visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import controle.AnimalControl;
import controle.TutorControl;
import modelo.Animal;
import modelo.Funcionario;
import modelo.Tutor;

public class TelaAnimal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<String> cmbAnimal;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField raca;
	private Funcionario funcionario;
	public TutorControl listPessoa = TutorControl.getIntancia();
	public AnimalControl tabela = new AnimalControl();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JList<Animal> listAnimal;
	private JButton btnNewButton_1;
	private JButton btnExcluir;
	private Animal animalEscolhido = null;
	private JButton btnNovo;

	public TelaAnimal(Funcionario func) {
		this.funcionario = func;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		nome = new JTextField();
		nome.setBounds(108, 42, 204, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		raca = new JTextField();
		raca.setBounds(108, 71, 86, 20);
		contentPane.add(raca);
		raca.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
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

					pessoa.getAnimais().add(animalEscolhido);
				} else {
					animalEscolhido.setNome(nomeSt);
					animalEscolhido.setRaca(racaSt);
					animalEscolhido.setTipo(tipoSt);
				}

				animalEscolhido = null;
				btnNewButton.setText("Cadastrar");

				atualiza();
				nome.setText("");
				raca.setText("");
				cmbAnimal.setSelectedIndex(0);
				nome.requestFocus();

			}
		});
		btnNewButton.setBounds(29, 102, 231, 35);
		contentPane.add(btnNewButton);

		cmbAnimal = new JComboBox<>();
		cmbAnimal.setBounds(108, 11, 106, 20);
		contentPane.add(cmbAnimal);

		lblNewLabel = new JLabel(" Tipos :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(29, 14, 46, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Nome :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(29, 45, 46, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Raça :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(29, 74, 46, 14);
		contentPane.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 148, 283, 194);
		contentPane.add(scrollPane);

		listAnimal = new JList<Animal>();
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

		scrollPane.setViewportView(listAnimal);

		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin exit = new TelaLogin();
				dispose();
				exit.setVisible(true);
			}

		});
		btnNewButton_1.setBounds(29, 359, 89, 23);
		contentPane.add(btnNewButton_1);

		btnExcluir = new JButton("-");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Animal animalAtual = listAnimal.getSelectedValue();
				if (animalAtual != null) {
					// int i = JOptionPane
					int val = JOptionPane.showConfirmDialog(null, "Deseja remover o animal " + animalAtual.getNome(),
							"Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
					if (val == 0) {
						pessoa.getAnimais().remove(animalAtual);
						atualiza();
					}

				}
			}
		});
		btnExcluir.setBounds(317, 146, 46, 23);
		contentPane.add(btnExcluir);

		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				animalEscolhido = null;
				nome.setText("");
				raca.setText("");
				cmbAnimal.setSelectedIndex(0);
				btnNewButton.setText("Cadastrar");
			}
		});
		btnNovo.setBounds(274, 108, 89, 23);
		contentPane.add(btnNovo);

		cmbAnimal.addItem("Cachorro");
		cmbAnimal.addItem("Gato");
		cmbAnimal.addItem("Outros");

		atualiza();
	}

	public void atualiza() {

		listAnimal.setListData(new Vector<Animal>(pessoa.getAnimais()));
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
		pessoa = p;
	}
}
