package digittal.signature.rsa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Guide extends JFrame {

	private JPanel contentPane;
	private JTextField txtCchSDng;
	private JTextField txtBcNhp;
	private JTextField txtBcNhp_1;
	private JTextField txtBcNhp_2;
	private JTextField txtKtQu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guide frame = new Guide();
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
	public Guide() {
		setTitle("Guide");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1253, 791);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCchSDng = new JTextField();
		txtCchSDng.setBackground(Color.YELLOW);
		txtCchSDng.setForeground(Color.RED);
		txtCchSDng.setHorizontalAlignment(SwingConstants.CENTER);
		txtCchSDng.setText("C\u00E1ch s\u1EED d\u1EE5ng \u1EE9ng d\u1EE5ng Ch\u1EEF k\u00FD \u0111i\u1EC7n t\u1EED:");
		txtCchSDng.setFont(new Font("Times New Roman", Font.BOLD, 50));
		txtCchSDng.setBounds(29, 30, 1177, 72);
		contentPane.add(txtCchSDng);
		txtCchSDng.setColumns(10);
		
		txtBcNhp = new JTextField();
		txtBcNhp.setBackground(Color.GREEN);
		txtBcNhp.setText("B\u01B0\u1EDBc 1: Nh\u1EA5p v\u00E0o Buttom \"T\u1EA1o kh\u00F3a\" \u0111\u1EC3 t\u1EA1o kh\u00F3a b\u00ED m\u1EADt v\u00E0 kh\u00F3a c\u00F4ng khai cho ch\u1EEF k\u00FD \u0111i\u1EC7n t\u1EED");
		txtBcNhp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtBcNhp.setBounds(29, 148, 1177, 89);
		contentPane.add(txtBcNhp);
		txtBcNhp.setColumns(10);
		
		txtBcNhp_1 = new JTextField();
		txtBcNhp_1.setBackground(Color.GREEN);
		txtBcNhp_1.setText("B\u01B0\u1EDBc 2: Nh\u1EA5p v\u00E0o Selected \u0111\u1EC3 ch\u1ECDn m\u1ED9t file b\u1EA5t k\u1EF3 \u0111\u1EC3 k\u00FD ch\u1EEF k\u00FD \u0111i\u1EC7n t\u1EED cho n\u00F3. Sau \u0111\u00F3 Click v\u00E0o Buttom \"K\u00FD ch\u1EEF k\u00FD\" \u0111\u1EC3 t\u1EA1o \u0111\u01B0\u1EE3c ch\u1EEF k\u00FD ");
		txtBcNhp_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtBcNhp_1.setColumns(10);
		txtBcNhp_1.setBounds(29, 284, 1177, 89);
		contentPane.add(txtBcNhp_1);
		
		txtBcNhp_2 = new JTextField();
		txtBcNhp_2.setBackground(Color.GREEN);
		txtBcNhp_2.setText("B\u01B0\u1EDBc 3: Nh\u1EA5p v\u00E0o Selected \u0111\u1EC3 ch\u1ECDn m\u1ED9t file ki\u1EC3m tra ch\u1EEF k\u00FD \u0111i\u1EC7n t\u1EED. Sau \u0111\u00F3 Click v\u00E0o Buttom \"Ki\u1EC3m tra\" \u0111\u1EC3 ki\u1EC3m tra ch\u1EEF k\u00FD  ");
		txtBcNhp_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtBcNhp_2.setColumns(10);
		txtBcNhp_2.setBounds(29, 413, 1177, 89);
		contentPane.add(txtBcNhp_2);
		
		txtKtQu = new JTextField();
		txtKtQu.setBackground(Color.GREEN);
		txtKtQu.setText("K\u1EBFt qu\u1EA3: N\u1EBFu \u0111\u00FAng th\u00EC th\u00F4ng b\u00E1o ch\u1EEF k\u00FD kh\u00F4ng b\u1ECB thay \u0111\u1ED5i. N\u1EBFu sai th\u00EC th\u00F4ng b\u00E1o ch\u1EEF k\u00FD b\u1ECB thay \u0111\u1ED5i");
		txtKtQu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtKtQu.setColumns(10);
		txtKtQu.setBounds(29, 536, 1177, 81);
		contentPane.add(txtKtQu);
		
		JButton btnNewButton = new JButton("Back to application");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RSA frame = new RSA();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnNewButton.setBounds(413, 651, 331, 51);
		contentPane.add(btnNewButton);
	}
}
