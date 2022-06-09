package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.PhiD;
import dto.Phi;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class qlPhi extends JFrame {

	private JPanel contentPane;
	private JTextField d;
	private JTextField n;
	private JTextField dv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					qlPhi frame = new qlPhi();
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
	public qlPhi() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 434, 39);
		contentPane.add(panel_1);
		
		JLabel lblQunLPh = new JLabel("Quản lý phí và dịch vụ");
		lblQunLPh.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLPh.setForeground(Color.WHITE);
		lblQunLPh.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblQunLPh.setBackground(Color.DARK_GRAY);
		lblQunLPh.setBounds(0, 0, 434, 39);
		panel_1.add(lblQunLPh);
		
		JLabel lblNewLabel_1 = new JLabel("Giá điện/Số(VND)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(80, 68, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Giá nước/khối(VND)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(80, 107, 127, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Phí dịch vụ(VND)");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(80, 138, 127, 14);
		contentPane.add(lblNewLabel_2_1);
		Phi p = new PhiD().allList().get(0);
		d = new JTextField();
		d.setColumns(10);
		d.setBounds(228, 66, 72, 20);
		contentPane.add(d);
		
		n = new JTextField();
		n.setColumns(10);
		n.setBounds(228, 105, 72, 20);
		contentPane.add(n);
		
		dv = new JTextField();
		dv.setColumns(10);
		dv.setBounds(228, 136, 72, 20);
		contentPane.add(dv);
		d.setText(p.getPdien()+"");
		n.setText(p.getPnuoc()+"");
		dv.setText(p.getPdichvu()+"");
		JButton btnThm_1 = new JButton("Thêm");
		btnThm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Phi p = new Phi(d.getText(),n.getText(),dv.getText());
					JOptionPane.showMessageDialog(btnThm_1, "Bạn đã thay đổi thông tin phí và dịch vụ!");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnThm_1.setForeground(Color.WHITE);
		btnThm_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnThm_1.setFocusable(false);
		btnThm_1.setFocusTraversalKeysEnabled(false);
		btnThm_1.setFocusPainted(false);
		btnThm_1.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnThm_1.setBackground(Color.DARK_GRAY);
		btnThm_1.setBounds(102, 190, 85, 30);
		contentPane.add(btnThm_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setText("");
				n.setText("");
				dv.setText("");
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnReset.setFocusable(false);
		btnReset.setFocusTraversalKeysEnabled(false);
		btnReset.setFocusPainted(false);
		btnReset.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnReset.setBackground(Color.DARK_GRAY);
		btnReset.setBounds(225, 190, 85, 30);
		contentPane.add(btnReset);
	}

}
