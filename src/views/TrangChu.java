package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dto.Phong;

import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrangChu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
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
	public TrangChu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 805, 504);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Quản lý phòng trọ");
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyPhong.main(null);
			}
		});
		btnNewButton.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(323, 75, 182, 60);
		contentPane.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 789, 39);
		contentPane.add(panel_1);
		
		JLabel lblPhnMmQun = new JLabel("Phần mềm quản lý phòng trọ");
		lblPhnMmQun.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnMmQun.setForeground(Color.WHITE);
		lblPhnMmQun.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblPhnMmQun.setBackground(Color.DARK_GRAY);
		lblPhnMmQun.setBounds(0, 0, 789, 39);
		panel_1.add(lblPhnMmQun);
		
		JButton btnQunLNgi = new JButton("Quản lý người thuê");
		btnQunLNgi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyNguoithue qlt = new QuanLyNguoithue();
				qlt.setVisible(true);
			}
			
			
			
		});
		btnQunLNgi.setForeground(Color.WHITE);
		btnQunLNgi.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnQunLNgi.setFocusable(false);
		btnQunLNgi.setFocusTraversalKeysEnabled(false);
		btnQunLNgi.setFocusPainted(false);
		btnQunLNgi.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnQunLNgi.setBackground(Color.DARK_GRAY);
		btnQunLNgi.setBounds(323, 160, 182, 60);
		contentPane.add(btnQunLNgi);
		
		JButton btnQunLHa = new JButton("Quản lý hóa đơn");
		btnQunLHa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyHoaDon hd = new QuanLyHoaDon();
				hd.setVisible(true);
				
			}
		});
		btnQunLHa.setForeground(Color.WHITE);
		btnQunLHa.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnQunLHa.setFocusable(false);
		btnQunLHa.setFocusTraversalKeysEnabled(false);
		btnQunLHa.setFocusPainted(false);
		btnQunLHa.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnQunLHa.setBackground(Color.DARK_GRAY);
		btnQunLHa.setBounds(323, 244, 182, 60);
		contentPane.add(btnQunLHa);
		
		JButton btnNewButton_1_1 = new JButton("Thông tin liên hệ");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setFocusTraversalKeysEnabled(false);
		btnNewButton_1_1.setFocusPainted(false);
		btnNewButton_1_1.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnNewButton_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_1.setBounds(662, 429, 117, 25);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnQunLPh = new JButton("Quản lý Phí");
		btnQunLPh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qlPhi qlp = new qlPhi();
				qlp.setVisible(true);
			}
		});
		btnQunLPh.setForeground(Color.WHITE);
		btnQunLPh.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnQunLPh.setFocusable(false);
		btnQunLPh.setFocusTraversalKeysEnabled(false);
		btnQunLPh.setFocusPainted(false);
		btnQunLPh.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnQunLPh.setBackground(Color.DARK_GRAY);
		btnQunLPh.setBounds(323, 341, 182, 60);
		contentPane.add(btnQunLPh);
		
	}
}
