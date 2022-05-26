package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Dao.PhongDao;
import dto.Phong;
import dto.nguoiThue;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLyPhong extends JFrame {

	private JPanel contentPane;
	private JTextField map;
	private JTextField tenp;
	private JTable table;
	private PhongDao pd = new PhongDao();
	private List<Phong> ps;
	DefaultTableModel tb;
	Object[] colum = { "Mã phòng", "Tên phòng", "Số người ở", "Giá phòng/Tháng" };
	private JTextField giap;

	public void loadDl() {
		
		tb = new DefaultTableModel();
		tb.setColumnIdentifiers(colum);
		ps = pd.allList();
		for (Phong p : ps) {
			tb.addRow(new Object[] { p.getId(), p.getTenPhong(), p.getSong(), p.getGiaPhong() });
		}
		table.setModel(tb);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyPhong frame = new QuanLyPhong();
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
	public QuanLyPhong() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 509);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý phòng");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(237, 32, 164, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên Phòng :");
		lblNewLabel_1.setForeground(SystemColor.infoText);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(61, 126, 82, 22);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mã Phòng :");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(61, 91, 82, 24);
		contentPane.add(lblNewLabel_1_1);

		map = new JTextField();
		map.setBounds(144, 91, 130, 20);
		contentPane.add(map);
		map.setColumns(10);

		tenp = new JTextField();
		tenp.setBounds(142, 128, 131, 20);
		contentPane.add(tenp);
		tenp.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(328, 94, 291, 335);
		contentPane.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				map.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				tenp.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				giap.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
			}
		});
		table.setFocusable(false);
		table.setFocusTraversalKeysEnabled(false);
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		table.setBorder(null);
		loadDl();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tenp != null && tenp.getText().length() > 0) {
					if (giap != null && giap.getText().length() > 0) {
						Phong p = new Phong();
						p.setTenPhong(tenp.getText());
						p.setGiaPhong(giap.getText());
						pd.add(p);
						loadDl();
					} else {
						JOptionPane.showMessageDialog(contentPane, "Không được để trống giá phòng", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Không được để trống tên phòng", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBackground(new Color(119, 136, 153));
		btnNewButton
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"", TitledBorder.TRAILING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(54, 323, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Phong p = new Phong(tenp.getText(), giap.getText());
					p.setId(Integer.valueOf(map.getText()));
					pd.edit(p);
					loadDl();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSa.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSa.setFocusable(false);
		btnSa.setFocusTraversalKeysEnabled(false);
		btnSa.setFocusPainted(false);
		btnSa.setBorder(
				new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"", TitledBorder.TRAILING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		btnSa.setBackground(new Color(119, 136, 153));
		btnSa.setBounds(54, 369, 89, 23);
		contentPane.add(btnSa);

		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pd.deleteById(Integer.valueOf(map.getText()));

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane, e2.getMessage(), "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				} finally {
					loadDl();
				}

			}
		});
		btnXa.setFont(new Font("Arial", Font.PLAIN, 11));
		btnXa.setFocusable(false);
		btnXa.setFocusTraversalKeysEnabled(false);
		btnXa.setFocusPainted(false);
		btnXa.setBorder(
				new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"", TitledBorder.TRAILING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		btnXa.setBackground(new Color(119, 136, 153));
		btnXa.setBounds(185, 323, 89, 23);
		contentPane.add(btnXa);

		JButton btnTimf = new JButton("Tìm kiếm");
		btnTimf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tb = new DefaultTableModel();
					tb.setColumnIdentifiers(colum);
					ps = pd.searchById(Integer.valueOf(map.getText()));
					for (Phong p : ps) {
						tb.addRow(new Object[] { p.getId(), p.getTenPhong(), p.getSong(), p.getGiaPhong() });
					}
					table.setModel(tb);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, e2.getMessage(), "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnTimf.setFont(new Font("Arial", Font.PLAIN, 11));
		btnTimf.setFocusable(false);
		btnTimf.setFocusTraversalKeysEnabled(false);
		btnTimf.setFocusPainted(false);
		btnTimf.setBorder(
				new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"", TitledBorder.TRAILING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		btnTimf.setBackground(new Color(119, 136, 153));
		btnTimf.setBounds(185, 369, 89, 23);
		contentPane.add(btnTimf);

		JButton btnHinTh = new JButton("Hiển thị");
		btnHinTh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDl();
			}
		});
		btnHinTh.setFont(new Font("Arial", Font.PLAIN, 11));
		btnHinTh.setFocusable(false);
		btnHinTh.setFocusTraversalKeysEnabled(false);
		btnHinTh.setFocusPainted(false);
		btnHinTh.setBorder(
				new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"", TitledBorder.TRAILING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		btnHinTh.setBackground(new Color(119, 136, 153));
		btnHinTh.setBounds(107, 251, 89, 23);
		contentPane.add(btnHinTh);

		JButton btnHinThTheo = new JButton("Hiển thị theo số lượng người ở");
		btnHinThTheo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tb = new DefaultTableModel();
				tb.setColumnIdentifiers(colum);
				ps = new ArrayList<>();
				if (pd.allList().size() > 0) {
					for (int i = 0; i < pd.allList().size(); i++) {
						for (int j = pd.allList().size(); j > i + 1; j--) {
							if (pd.allList().get(i).getSong() <= pd.allList().get(j).getSong()) {
								ps.add(pd.allList().get(i));
							}
						}
					}
				}
				for (Phong p : ps) {
					tb.addRow(new Object[] { p.getId(), p.getTenPhong(), p.getSong(), p.getGiaPhong() });
				}
				table.setModel(tb);
			}
		});
		btnHinThTheo.setFont(new Font("Arial", Font.PLAIN, 11));
		btnHinThTheo.setFocusable(false);
		btnHinThTheo.setFocusTraversalKeysEnabled(false);
		btnHinThTheo.setFocusPainted(false);
		btnHinThTheo.setBorder(new TitledBorder(

				new TitledBorder(

						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),

								new Color(160, 160, 160)),

						"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),

				"", TitledBorder.TRAILING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		btnHinThTheo.setBackground(new Color(119, 136, 153));
		btnHinThTheo.setBounds(66, 285, 164, 23);
		contentPane.add(btnHinThTheo);

		JLabel lblNewLabel_1_2 = new JLabel("Giá Phòng/tháng :");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(25, 159, 115, 22);
		contentPane.add(lblNewLabel_1_2);

		giap = new JTextField();
		giap.setColumns(10);
		giap.setBounds(143, 161, 131, 20);
		contentPane.add(giap);

		JButton btnXemPhng = new JButton("Xem Phòng");
		btnXemPhng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					QuanLyNguoiThuePhongf.main(null);;
					QuanLyNguoiThuePhongf.p = pd.searchById(Integer.valueOf(map.getText())).get(0);
				} catch (NumberFormatException e1) {
					
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnXemPhng.setFont(new Font("Arial", Font.PLAIN, 11));
		btnXemPhng.setFocusable(false);
		btnXemPhng.setFocusTraversalKeysEnabled(false);
		btnXemPhng.setFocusPainted(false);
		btnXemPhng.setBorder(new TitledBorder(

				new TitledBorder(

						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),

								new Color(160, 160, 160)),

						"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),

				"", TitledBorder.TRAILING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		btnXemPhng.setBackground(new Color(119, 136, 153));
		btnXemPhng.setBounds(107, 406, 89, 23);
		contentPane.add(btnXemPhng);
	}
}
