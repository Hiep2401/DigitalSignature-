package digittal.signature.rsa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtFacebook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("MainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/digittal/signature/rsa/image.png")));
		mntmNewMenuItem.setBounds(61, 45, 131, 115);
		contentPane.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("");
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/digittal/signature/rsa/100px-Facebook_Messenger_logo_2018.svg.png")));
		mntmNewMenuItem_1.setBounds(299, 45, 117, 115);
		contentPane.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("");
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/digittal/signature/rsa/images.png")));
		mntmNewMenuItem_2.setBounds(566, 45, 117, 115);
		contentPane.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RSA frame = new RSA();
				frame.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/digittal/signature/rsa/signature-icon.png")));
		mntmNewMenuItem_3.setBounds(61, 304, 131, 110);
		contentPane.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("");
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainFrame.class.getResource("/digittal/signature/rsa/icon-message-100x100.png")));
		mntmNewMenuItem_4.setBounds(299, 299, 117, 115);
		contentPane.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("");
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainFrame.class.getResource("/digittal/signature/rsa/Google-Chrome-icon.png")));
		mntmNewMenuItem_5.setBounds(566, 299, 117, 115);
		contentPane.add(mntmNewMenuItem_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/digittal/signature/rsa/35687hd.jpg")));
		lblNewLabel.setBounds(0, 10, 849, 516);
		contentPane.add(lblNewLabel);
	}
}
