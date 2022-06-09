package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.NguoiThueDao;
import Dao.PhongDao;
import dto.Phong;
import dto.nguoiThue;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLyNguoithue extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField ten;
	private NguoiThueDao ntD = new NguoiThueDao();
	private PhongDao pd = new PhongDao();
	private nguoiThue ng;
	private List<nguoiThue> lng;
	DefaultTableModel tb;
	Object[] colum = { "Id", "CCCD", "Họ tên", "SĐT", "Ngày sinh", "Phòng", "Địa chỉ", "Ngày vào" };
	private JTextField ngayv;

	/**
	 * Launch the application.
	 */
	private void load() {
		tb = new DefaultTableModel();
		tb = new DefaultTableModel();
		tb.setColumnIdentifiers(colum);
		try {
			for (nguoiThue n : lng) {
				tb.addRow(new Object[] { n.getId(), n.getCccd(), n.getHoTen(), n.getSdt(), n.getNs(),
						n.getPhong() != null ? n.getPhong().getTenPhong() : "", n.getDc(),n.getNgayVao() });
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		table.setModel(tb);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNguoithue frame = new QuanLyNguoithue();
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
	public QuanLyNguoithue() {
		lng = ntD.allList();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 864, 516);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 848, 38);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý người thuê");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblNewLabel.setBounds(0, 5, 848, 30);
		panel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 218, 828, 248);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					ng = ntD.searchById(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()))
							.get(0);
				} catch (Exception e1) {
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionForeground(Color.WHITE);
		table.setSelectionBackground(Color.DARK_GRAY);
		table.setBackground(Color.GRAY);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		table.setForeground(Color.WHITE);
		table.setFocusTraversalKeysEnabled(false);
		table.setFocusable(false);
		scrollPane.setViewportView(table);
		load();
		JButton btnHinTh = new JButton("Hiển thị");
		btnHinTh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lng = ntD.allList();
				load();
			}
		});
		btnHinTh.setForeground(Color.WHITE);
		btnHinTh.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnHinTh.setFocusable(false);
		btnHinTh.setFocusTraversalKeysEnabled(false);
		btnHinTh.setFocusPainted(false);
		btnHinTh.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnHinTh.setBackground(Color.DARK_GRAY);
		btnHinTh.setBounds(10, 177, 86, 30);
		contentPane.add(btnHinTh);

		JButton btnThmNgiThu = new JButton("Thêm người thuê");
		btnThmNgiThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nguoiThue n = new nguoiThue();
				ThongTinNguoiThue tt = new ThongTinNguoiThue(n);
				tt.setVisible(true);
			}
		});
		btnThmNgiThu.setForeground(Color.WHITE);
		btnThmNgiThu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnThmNgiThu.setFocusable(false);
		btnThmNgiThu.setFocusTraversalKeysEnabled(false);
		btnThmNgiThu.setFocusPainted(false);
		btnThmNgiThu.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnThmNgiThu.setBackground(Color.DARK_GRAY);
		btnThmNgiThu.setBounds(10, 59, 141, 30);
		contentPane.add(btnThmNgiThu);

		JButton btnThayiThng = new JButton("Thay đổi thông tin ");
		btnThayiThng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ng!=null) {
					ThongTinNguoiThue tt = new ThongTinNguoiThue(ng);
					tt.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(btnThayiThng, "Chọn người cần xem thông tin!");
				}
				
			}
		});
		btnThayiThng.setForeground(Color.WHITE);
		btnThayiThng.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnThayiThng.setFocusable(false);
		btnThayiThng.setFocusTraversalKeysEnabled(false);
		btnThayiThng.setFocusPainted(false);
		btnThayiThng.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnThayiThng.setBackground(Color.DARK_GRAY);
		btnThayiThng.setBounds(175, 59, 154, 30);
		contentPane.add(btnThayiThng);

		JButton btnXa = new JButton("Xóa ");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = JOptionPane.showConfirmDialog(btnXa, "Bạn có chắc muốn xóa!");
				if(x==JOptionPane.YES_OPTION) {
					try {

						ntD.deleteById(ng.getId());
						lng = ntD.allList();
						load();
					} catch (Exception e1) {
						

					}
				}
				
			}
		});
		btnXa.setForeground(Color.WHITE);
		btnXa.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnXa.setFocusable(false);
		btnXa.setFocusTraversalKeysEnabled(false);
		btnXa.setFocusPainted(false);
		btnXa.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnXa.setBackground(Color.DARK_GRAY);
		btnXa.setBounds(358, 59, 68, 30);
		contentPane.add(btnXa);

		JLabel lblNewLabel_1 = new JLabel("Tên :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(123, 193, 35, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Phòng :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(436, 193, 49, 14);
		contentPane.add(lblNewLabel_1_1);

		JComboBox phong = new JComboBox();
		List<Phong> lp = pd.allList();
		String[] sp = new String[lp.size() + 1];
		sp[0] = "";
		for (int i = 0; i < lp.size(); i++) {

			sp[i + 1] = lp.get(i).getTenPhong();
		}
		phong.setModel(new DefaultComboBoxModel(sp));
		phong.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		phong.setBorder(null);
		phong.setFocusable(false);
		phong.setFocusTraversalKeysEnabled(false);
		phong.setForeground(Color.WHITE);
		phong.setBackground(Color.GRAY);
		phong.setBounds(495, 185, 68, 22);
		contentPane.add(phong);

		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lng = ntD.search(ten.getText(), phong.getSelectedItem().toString(), ngayv.getText());
				load();

			}
		});
		btnTmKim.setForeground(Color.WHITE);
		btnTmKim.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnTmKim.setFocusable(false);
		btnTmKim.setFocusTraversalKeysEnabled(false);
		btnTmKim.setFocusPainted(false);
		btnTmKim.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnTmKim.setBackground(Color.DARK_GRAY);
		btnTmKim.setBounds(602, 177, 99, 30);
		contentPane.add(btnTmKim);

		ten = new JTextField();
		ten.setSelectedTextColor(Color.WHITE);
		ten.setSelectionColor(Color.LIGHT_GRAY);
		ten.setColumns(10);
		ten.setBounds(162, 187, 86, 20);
		contentPane.add(ten);

		JLabel lblNewLabel_1_2 = new JLabel("Ngày vào :");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setBounds(239, 193, 68, 14);
		contentPane.add(lblNewLabel_1_2);

		ngayv = new JTextField();
		ngayv.setSelectionColor(Color.LIGHT_GRAY);
		ngayv.setSelectedTextColor(Color.WHITE);
		ngayv.setColumns(10);
		ngayv.setBounds(317, 187, 109, 20);
		contentPane.add(ngayv);
	}
}
