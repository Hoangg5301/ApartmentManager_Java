package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.PhongDao;
import Dao.hoaDonD;
import dto.HoaDon;
import dto.Phong;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class TaoHoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField d;
	private JTextField n;
	private JTextField n1;
	private JTextField n2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaoHoaDon frame = new TaoHoaDon();
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
	public TaoHoaDon() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 369, 395);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 353, 39);
		contentPane.add(panel_1);

		JLabel lblThngTinHa = new JLabel("Thông tin hóa đơn");
		lblThngTinHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinHa.setForeground(Color.WHITE);
		lblThngTinHa.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblThngTinHa.setBackground(Color.DARK_GRAY);
		lblThngTinHa.setBounds(0, 0, 349, 39);
		panel_1.add(lblThngTinHa);

		JComboBox phong = new JComboBox();
		List<Phong> lp = new PhongDao().allList();
		String[] sp = new String[lp.size()];
		for (int i = 0; i < lp.size(); i++) {

			sp[i] = lp.get(i).getTenPhong();
		}
		phong.setModel(new DefaultComboBoxModel(sp));
		phong.setForeground(Color.WHITE);
		phong.setFocusable(false);
		phong.setFocusTraversalKeysEnabled(false);
		phong.setBorder(null);
		phong.setBackground(Color.GRAY);
		phong.setBounds(194, 64, 72, 22);
		contentPane.add(phong);

		JLabel lblNewLabel = new JLabel("Chọn phòng :");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(46, 67, 127, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Điện tiêu thụ(số) :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(46, 108, 127, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nước tiêu thụ(khối) :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(46, 147, 127, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Thu từ :");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(46, 178, 127, 14);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Đến ngày :");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_2_1_1.setBounds(46, 206, 127, 14);
		contentPane.add(lblNewLabel_2_1_1);

		d = new JTextField();
		d.setBounds(194, 106, 72, 20);
		contentPane.add(d);
		d.setColumns(10);

		n = new JTextField();
		n.setColumns(10);
		n.setBounds(194, 145, 72, 20);
		contentPane.add(n);

		n1 = new JTextField();
		n1.setColumns(10);
		n1.setBounds(194, 176, 72, 20);
		contentPane.add(n1);

		n2 = new JTextField();
		n2.setColumns(10);
		n2.setBounds(194, 204, 72, 20);
		contentPane.add(n2);

		JButton btnThm = new JButton("Tạo");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HoaDon hd = new HoaDon(null, new SimpleDateFormat("dd/MM/yyy").format(new Date()),
							(int) ((-(new SimpleDateFormat("dd/MM/yyy").parse(n1.getText())).getTime()
									+ (new SimpleDateFormat("dd/MM/yyy").parse(n2.getText())).getTime()) / 1000 / 60
									/ 60 / 24),
							Integer.parseInt(d.getText()), Integer.parseInt(n.getText()),
							new PhongDao().searchByName(phong.getSelectedItem().toString()));
					(new hoaDonD()).add(hd);
					JOptionPane.showMessageDialog(btnThm, "Tạo hóa đơn thành công!");
					setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnThm, e1.getMessage());
				}

			}
		});
		btnThm.setForeground(Color.WHITE);
		btnThm.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnThm.setFocusable(false);
		btnThm.setFocusTraversalKeysEnabled(false);
		btnThm.setFocusPainted(false);
		btnThm.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnThm.setBackground(Color.DARK_GRAY);
		btnThm.setBounds(69, 278, 85, 30);
		contentPane.add(btnThm);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phong.setSelectedIndex(0);
				d.setText("");
				n.setText("");
				n1.setText("");
				n2.setText("");
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnReset.setFocusable(false);
		btnReset.setFocusTraversalKeysEnabled(false);
		btnReset.setFocusPainted(false);
		btnReset.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnReset.setBackground(Color.DARK_GRAY);
		btnReset.setBounds(192, 278, 85, 30);
		contentPane.add(btnReset);
	}

}
