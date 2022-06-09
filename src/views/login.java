package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.TaiKhoanDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.UIManager;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField tk;
	private JPasswordField mk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 434, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 437, 32);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản");
		lblNewLabel_1.setBounds(101, 89, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đăng nhập");
		lblNewLabel_1_1.setBounds(101, 118, 243, 14);
		contentPane.add(lblNewLabel_1_1);
		
		tk = new JTextField();
		tk.setBounds(188, 86, 156, 20);
		contentPane.add(tk);
		tk.setColumns(10);
		
		mk = new JPasswordField();
		mk.setBounds(188, 115, 156, 20);
		contentPane.add(mk);
		
		JButton btnHinTh_1_2 = new JButton("Xóa");
		btnHinTh_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tk.setText(null);
				mk.setText(null);
				
			}
		});
		btnHinTh_1_2.setForeground(Color.WHITE);
		btnHinTh_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnHinTh_1_2.setFocusable(false);
		btnHinTh_1_2.setFocusTraversalKeysEnabled(false);
		btnHinTh_1_2.setFocusPainted(false);
		btnHinTh_1_2.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnHinTh_1_2.setBackground(Color.DARK_GRAY);
		btnHinTh_1_2.setBounds(255, 167, 89, 29);
		contentPane.add(btnHinTh_1_2);
		
		JButton btnHinTh_1_2_1 = new JButton("Đăng nhập");
		btnHinTh_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaiKhoanDao t = new TaiKhoanDao();
				if(tk.getText().equals(t.allList().get(0).getUsername()) && mk.getText().equals(t.allList().get(0).getPassword())) {
					TrangChu.main(null);
				}else {
					JOptionPane.showMessageDialog(btnHinTh_1_2_1, "Tài Khoản hoặc mật khẩu không đúng!");
				}
			}
		});
		btnHinTh_1_2_1.setForeground(Color.WHITE);
		btnHinTh_1_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnHinTh_1_2_1.setFocusable(false);
		btnHinTh_1_2_1.setFocusTraversalKeysEnabled(false);
		btnHinTh_1_2_1.setFocusPainted(false);
		btnHinTh_1_2_1.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnHinTh_1_2_1.setBackground(Color.DARK_GRAY);
		btnHinTh_1_2_1.setBounds(132, 167, 103, 29);
		contentPane.add(btnHinTh_1_2_1);
	}
}
