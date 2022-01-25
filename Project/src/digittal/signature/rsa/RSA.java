package digittal.signature.rsa;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.swing.JButton;
import javax.swing.JMenuItem;

public class RSA extends javax.swing.JFrame {
    /**
     * Creates new form RSA
     */
    static int bitleg;
    static BigInteger ciphertext;
    static AlgorithmRSA rsa;
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel contentPane;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private JComboBox jComboBox1;
    private JTextArea jTextArea2;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_12;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_2;
    private JTextField textField_3;
    
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	try {
				    RSA frame = new RSA();
				    frame.setVisible(true);
				} catch (Exception e) {
				    e.printStackTrace();
				}
            }
        });
    }
    
    private static int BUFFER_SIZE = 32 * 1024;
    private JLabel lblNewLabel_13;
    private JLabel lblNewLabel_15;
    public class SHA1 {
    	  public BigInteger md(String f) throws Exception {
    		    BufferedInputStream file = new BufferedInputStream(new FileInputStream(f));
    		    MessageDigest md = MessageDigest.getInstance("SHA-1");
    		    DigestInputStream in = new DigestInputStream(file, md);
    		    int i;
    		    byte[] buffer = new byte[BUFFER_SIZE];
    		    do {
    		    	i = in.read(buffer, 0, BUFFER_SIZE);
    		    } while (i == BUFFER_SIZE);
	    		    md = in.getMessageDigest();
	    		    in.close();
    		    return new BigInteger(md.digest());
    	  }
    	}
    
    public class AlgorithmRSA {

        private BigInteger n, d, e;
        public BigInteger getN() {
            return n;
        }
        public void setN(BigInteger n) {
            this.n = n;
        }
        public BigInteger getD() {
            return d;
        }
        public void setD(BigInteger d) {
            this.d = d;
        }
        public BigInteger getE() {
            return e;
        }
        public void setE(BigInteger e) {
            this.e = e;
        }

        /**
         * Create an instance that can encrypt using someone elses public key.
         */
        public AlgorithmRSA(BigInteger newn, BigInteger newe) {
            n = newn;
            e = newe;
        }
        /**
         * Create an instance that can both encrypt and decrypt.
         */
        public AlgorithmRSA() {}
        public void KeyRSA(int bits){
            SecureRandom r = new SecureRandom();
            BigInteger p = new BigInteger(bits / 2, 100, r);
            BigInteger q = new BigInteger(bits / 2, 100, r);
            n = p.multiply(q);
            BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q
                    .subtract(BigInteger.ONE));
            boolean found = false;
            do {
                e = new BigInteger(bits / 2, 50, r);
                if (m.gcd(e).equals(BigInteger.ONE) && e.compareTo(m) < 0) {
                    found = true;
                }
            } while (!found);
            d = e.modInverse(m);  
        }
        /**
         * Encrypt the given plaintext message.
         */
        public synchronized String encrypt(String message) {
            return (new BigInteger(message.getBytes())).modPow(d, n).toString();
        }
        /**
         * Encrypt the given plaintext message.
         */
        public synchronized BigInteger encrypt(BigInteger message) {
            return message.modPow(d, n);
        }
        /**
         * Decrypt the given ciphertext message.
         */
        public synchronized String decrypt(String message) {
            return new String((new BigInteger(message)).modPow(e, n).toByteArray());
        }
        /**
         * Decrypt the given ciphertext message.
         */
        public synchronized BigInteger decrypt(BigInteger message) {
            return message.modPow(e, n);
        }

        void setN(int bitleg) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    public RSA() {
    	// Giao dien
        initComponents();
        contentPane.setLayout(null);
        contentPane.add(jPanel2);
        contentPane.add(jPanel3);
        contentPane.add(jPanel4);
        jPanel2.add(jButton1);
        jPanel2.add(jComboBox1);
        jPanel3.add(jButton2);
        jPanel3.add(jButton4);
        jPanel4.add(jButton5);
        jPanel4.add(jButton3);
  
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Digital Signatures");
        
        lblNewLabel_12 = new JLabel("Khóa");
        lblNewLabel_12.setForeground(Color.BLACK);
        lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_12.setBounds(10, 10, 107, 20);
        jPanel2.add(lblNewLabel_12);
        
        JLabel lblNewLabel_5 = new JLabel("Kích thước");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_5.setForeground(Color.BLACK);
        lblNewLabel_5.setBounds(10, 40, 82, 13);
        jPanel2.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Khóa bí mật(Private Key)");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_6.setForeground(Color.BLACK);
        lblNewLabel_6.setBounds(179, 27, 208, 26);
        jPanel2.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Khóa công khai(Public Key)");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_7.setForeground(Color.BLACK);
        lblNewLabel_7.setBounds(436, 27, 216, 26);
        jPanel2.add(lblNewLabel_7);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_2.setForeground(Color.BLACK);
        textField_2.setBounds(179, 66, 208, 74);
        jPanel2.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setForeground(Color.BLACK);
        textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_3.setBounds(436, 66, 216, 74);
        jPanel2.add(textField_3);
        textField_3.setColumns(10);
        
        lblNewLabel_3 = new JLabel("Người Gửi");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_3.setForeground(Color.BLACK);
        lblNewLabel_3.setBounds(10, 10, 98, 20);
        jPanel3.add(lblNewLabel_3);
        
        JLabel lblNewLabel_8 = new JLabel("Băm SHA đầu vào");
        lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_8.setForeground(Color.BLACK);
        lblNewLabel_8.setBounds(235, 50, 123, 19);
        jPanel3.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Chữ ký đã được tạo");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setForeground(Color.BLACK);
        lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_9.setBounds(474, 50, 144, 16);
        jPanel3.add(lblNewLabel_9);
        
        textField = new JTextField();
        textField.setBounds(10, 77, 129, 25);
        jPanel3.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_10 = new JLabel("Đầu vào");
        lblNewLabel_10.setForeground(Color.BLACK);
        lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_10.setBounds(10, 51, 148, 16);
        jPanel3.add(lblNewLabel_10);
        
        lblNewLabel = new JLabel("Đã có khóa bí mật");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(235, 161, 129, 13);
        jPanel3.add(lblNewLabel);
        
        textField_5 = new JTextField();
        textField_5.setBackground(Color.WHITE);
        textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_5.setForeground(Color.BLACK);
        textField_5.setBounds(186, 75, 207, 76);
        jPanel3.add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBackground(Color.WHITE);
        textField_6.setForeground(Color.BLACK);
        textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_6.setBounds(446, 75, 207, 76);
        jPanel3.add(textField_6);
        textField_6.setColumns(10);
        
        lblNewLabel_4 = new JLabel("Người Nhận");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_4.setForeground(Color.BLACK);
        lblNewLabel_4.setBounds(10, 10, 105, 22);
        jPanel4.add(lblNewLabel_4);
        
        JLabel lblNewLabel_8_1 = new JLabel("Băm SHA đầu vào");
        lblNewLabel_8_1.setForeground(Color.BLACK);
        lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_8_1.setBounds(233, 43, 123, 21);
        jPanel4.add(lblNewLabel_8_1);
        
        JLabel lblNewLabel_9_1 = new JLabel("Xác nhận chữ ký");
        lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9_1.setForeground(Color.BLACK);
        lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_9_1.setBounds(457, 45, 201, 16);
        jPanel4.add(lblNewLabel_9_1);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_1.setBounds(10, 71, 129, 25);
        jPanel4.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_10_1 = new JLabel("Đầu vào");
        lblNewLabel_10_1.setForeground(Color.BLACK);
        lblNewLabel_10_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_10_1.setBounds(10, 45, 156, 16);
        jPanel4.add(lblNewLabel_10_1);
        
        lblNewLabel_1 = new JLabel("Đã có khóa công khai");
        lblNewLabel_1.setForeground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(220, 156, 136, 13);
        jPanel4.add(lblNewLabel_1);
        
        textField_7 = new JTextField();
        textField_7.setBackground(Color.WHITE);
        textField_7.setForeground(Color.BLACK);
        textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_7.setBounds(183, 71, 215, 75);
        jPanel4.add(textField_7);
        textField_7.setColumns(10);
        
        textField_8 = new JTextField();
        textField_8.setForeground(Color.BLACK);
        textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_8.setBackground(Color.WHITE);
        textField_8.setBounds(457, 71, 201, 75);
        jPanel4.add(textField_8);
        textField_8.setColumns(10);
        
        lblNewLabel_2 = new JLabel("Digital signature RSA");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(161, 22, 553, 77);
        lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        lblNewLabel_2.setForeground(Color.WHITE);
        contentPane.add(lblNewLabel_2);
        
        JButton btnNewButton = new JButton("Back to Menu");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainFrame frame = new MainFrame();
				frame.setVisible(true);
				dispose();
        	}
        });
        btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnNewButton.setBounds(614, 695, 238, 92);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.setIcon(new ImageIcon(RSA.class.getResource("/digittal/signature/rsa/haha-icon.png")));
        lblNewLabel_11.setBounds(23, 10, 128, 115);
        contentPane.add(lblNewLabel_11);
        
        lblNewLabel_13 = new JLabel("");
        lblNewLabel_13.setIcon(new ImageIcon(RSA.class.getResource("/digittal/signature/rsa/unnamed.png")));
        lblNewLabel_13.setBounds(724, 10, 128, 115);
        contentPane.add(lblNewLabel_13);
        
        lblNewLabel_15 = new JLabel("Guides");
        lblNewLabel_15.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblNewLabel_15.setBounds(172, 705, 177, 57);
        contentPane.add(lblNewLabel_15);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Guide frame = new Guide();
				frame.setVisible(true);
				dispose();
        	}
        });
        btnNewButton_1.setIcon(new ImageIcon(RSA.class.getResource("/digittal/signature/rsa/Categories-system-help-icon.png")));
        btnNewButton_1.setBounds(23, 681, 127, 118);
        contentPane.add(btnNewButton_1);
       
        bitleg = Integer.parseInt((String) jComboBox1.getSelectedItem());
        rsa = new AlgorithmRSA();
        rsa.KeyRSA(bitleg);
    }
    
    private void initComponents() {
    	contentPane = new javax.swing.JPanel();
    	contentPane.setBackground(Color.RED);
    	
    	jPanel2 = new javax.swing.JPanel();
    	jPanel2.setBounds(23, 125, 829, 162);
    	jPanel2.setLayout(null);
    	jPanel2.setBackground(Color.GREEN);
    	
        jPanel3 = new javax.swing.JPanel();
        jPanel3.setBounds(23, 297, 829, 189);
        jPanel3.setLayout(null);
        jPanel3.setBackground(Color.GREEN);
        
        jPanel4 = new javax.swing.JPanel();
        jPanel4.setBounds(23, 496, 829, 175);
        jPanel4.setLayout(null);
        jPanel4.setBackground(Color.GREEN);
        
        // Ham tao chu ky
        jButton1 = new javax.swing.JButton();
        jButton1.setText("Tạo khóa");
        jButton1.setBounds(694, 85, 107, 36);
        jButton1.setForeground(Color.BLACK);
        jButton1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsa.KeyRSA(bitleg);
                textField_2.setText(rsa.getE().toString());
                textField_3.setText(rsa.getD().toString());
                rsa.setD(new BigInteger(textField_2.getText()));
                rsa.setE(new BigInteger(textField_3.getText()));
            }
        });
        
        // Ham chon kich thuoc khoa
        jComboBox1 = new JComboBox();
        jComboBox1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jComboBox1.setBounds(10, 71, 71, 36);
        jComboBox1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		bitleg = Integer.parseInt((String) jComboBox1.getSelectedItem());
        	}
        });
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "256", "512", "1024"}));
        
        // Ham load du lieu dau vao
        jButton2 = new javax.swing.JButton();
        jButton2.setFont(new Font("Tahoma", Font.BOLD, 10));
        jButton2.setText("Selected");
        jButton2.setIcon(null);
        jButton2.setBounds(34, 112, 79, 38);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "exe", "doc", "docx", "jpg", "png", "txt");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    String attach = file.toString();
                    textField.setText(attach);
                }
            }
        });
        
        // Ham tao chu ky voi du lieu dau vao
        jButton4 = new javax.swing.JButton();
        jButton4.setText("Ký chữ ký");
        jButton4.setForeground(Color.BLACK);
        jButton4.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jButton4.setBounds(696, 94, 108, 38);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String filename = textField.getText();
                filename = filename.replace('\\', '/');
                if ("".equals(filename)) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập dữ liệu đầu vào", "Thông báo", JOptionPane.ERROR_MESSAGE);                  
                } else {
                    SHA1 sha1 = new SHA1();
                    try { 
                        BigInteger sh1 = new BigInteger(sha1.md(filename).abs().toString());
                        textField_5.setText(sh1.toString());
                        BigInteger sha1t = new BigInteger(textField_5.getText());
                        textField_6.setText(rsa.encrypt(sha1t).toString());
                        JOptionPane.showMessageDialog(null, "Bạn đã tạo chữ ký thành công");
                    } catch (Exception ex) {
                        Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        // Ham load du lieu dau vao
        jButton3 = new javax.swing.JButton();
        jButton3.setFont(new Font("Tahoma", Font.BOLD, 10));
        jButton3.setText("Selected");
        jButton3.setBounds(29, 106, 86, 40);
        jButton3.setIcon(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "exe", "doc", "docx", "jpg", "png", "txt");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    String attach = file.toString();
                    textField_1.setText(attach);

                }
            }
        });
        
        //Ham kiem chung chu ki
        jButton5 = new javax.swing.JButton();
        jButton5.setForeground(Color.BLACK);
        jButton5.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jButton5.setBounds(696, 90, 105, 37);
        jButton5.setText("Kiểm tra");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String filename = textField_1.getText();
                filename = filename.replace('\\', '/');
                if ("".equals(filename)) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập dữ liệu đầu vào", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else {
                    SHA1 sha1 = new SHA1();
                    try {
                    	textField_7.setText(sha1.md(filename).abs() + "");
                        BigInteger dsrsa = new BigInteger(textField_6.getText());
                        textField_8.setText(rsa.decrypt(dsrsa).toString());
                        if (textField_7.getText().equals(textField_8.getText())) {
                            JOptionPane.showMessageDialog(null, "Chữ ký vẹn toàn không thay đổi!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Chữ ký đã bị thay đổi!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(contentPane, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(contentPane, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);
        pack();
    }
}