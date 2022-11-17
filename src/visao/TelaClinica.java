package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;

public class TelaClinica extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClinica frame = new TelaClinica();
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
	public TelaClinica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GERENCIAMENTO DE CADASTROS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(38, 39, 386, 31);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 105, 258, 122);
		contentPane.add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setBounds(306, 126, 118, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETAR");
		btnNewButton_1.setBounds(306, 163, 118, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.setBounds(306, 204, 118, 23);
		contentPane.add(btnNewButton_2);
	}
}
