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
import javax.swing.UIManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class QuanLyPhong extends JFrame {

	private JPanel contentPane;
	private JTextField map;
	private JTextField tenp;
	private JTable table;
	private PhongDao pd = new PhongDao();
	private List<Phong> ps;
	DefaultTableModel tb;
	Object[] colum = { "Mã phòng", "Tên phòng", "Số người/Phòng", "Giá phòng/Tháng" };
	private JTextField giap;
	private JTextField ng;
	private Phong p;

	public void loadDl() {		
		tb = new DefaultTableModel();
		tb.setColumnIdentifiers(colum);
		ps = pd.allList();
		for (Phong p : ps) {
			tb.addRow(new Object[] { p.getId(), p.getTenPhong(), p.getSongP(), p.getGiaPhong() });
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 731, 518);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 715, 39);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Quản lý phòng trọ");
				lblNewLabel.setBounds(0, 0, 715, 39);
				panel_1.add(lblNewLabel);
				lblNewLabel.setBackground(Color.DARK_GRAY);
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

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
		map.setBounds(144, 91, 102, 20);
		contentPane.add(map);
		map.setColumns(10);

		tenp = new JTextField();
		tenp.setBounds(142, 128, 102, 20);
		contentPane.add(tenp);
		tenp.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 192, 715, 278);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 37, 715, 241);
		panel.add(scrollPane);
		scrollPane.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		scrollPane.setRequestFocusEnabled(false);
		scrollPane.setOpaque(false);
		scrollPane.setFocusable(false);
		scrollPane.setFocusTraversalKeysEnabled(false);
		scrollPane.setEnabled(false);
		scrollPane.setBackground(Color.WHITE);
		table = new JTable();
		table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setVerifyInputWhenFocusTarget(false);
		table.setUpdateSelectionOnSort(false);
		table.setSelectionForeground(Color.WHITE);
		table.setSelectionBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				map.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				tenp.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				giap.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				ng.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			}
		});
		table.setFocusable(false);
		table.setFocusTraversalKeysEnabled(false);
		scrollPane.setViewportView(table);
		table.setBackground(Color.GRAY);
		table.setBorder(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
				JButton btnHinTh_1 = new JButton("Hiển thị");
				btnHinTh_1.setBounds(122, 0, 126, 29);
				panel.add(btnHinTh_1);
				btnHinTh_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadDl();

					}
				});
				btnHinTh_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
				btnHinTh_1.setForeground(Color.WHITE);
				btnHinTh_1.setFocusable(false);
				btnHinTh_1.setFocusTraversalKeysEnabled(false);
				btnHinTh_1.setFocusPainted(false);
				btnHinTh_1.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
				btnHinTh_1.setBackground(Color.DARK_GRAY);
				
						JButton btnHinTh_1_1 = new JButton("Tìm kiếm");
						btnHinTh_1_1.setBounds(290, 0, 126, 29);
						panel.add(btnHinTh_1_1);
						btnHinTh_1_1.addActionListener(new ActionListener() {
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
						btnHinTh_1_1.setForeground(Color.WHITE);
						btnHinTh_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
						btnHinTh_1_1.setFocusable(false);
						btnHinTh_1_1.setFocusTraversalKeysEnabled(false);
						btnHinTh_1_1.setFocusPainted(false);
						btnHinTh_1_1.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
						btnHinTh_1_1.setBackground(Color.DARK_GRAY);
						
						JButton btnHinTh_1_1_1 = new JButton("Xem phòng");
						btnHinTh_1_1_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									p = pd.searchById(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString())).get(0);
									
									QuanLyNguoiThuePhong qlp =new  QuanLyNguoiThuePhong(p);
									qlp.setVisible(true);
								} catch (Exception e1) {
									
								}
								
							}
						});
						btnHinTh_1_1_1.setForeground(Color.WHITE);
						btnHinTh_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
						btnHinTh_1_1_1.setFocusable(false);
						btnHinTh_1_1_1.setFocusTraversalKeysEnabled(false);
						btnHinTh_1_1_1.setFocusPainted(false);
						btnHinTh_1_1_1.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
						btnHinTh_1_1_1.setBackground(Color.DARK_GRAY);
						btnHinTh_1_1_1.setBounds(451, 0, 126, 29);
						panel.add(btnHinTh_1_1_1);
		loadDl();

		JLabel lblNewLabel_1_2 = new JLabel("Giá Phòng/tháng :");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(273, 91, 115, 22);
		contentPane.add(lblNewLabel_1_2);

		giap = new JTextField();
		giap.setColumns(10);
		giap.setBounds(391, 93, 102, 20);
		contentPane.add(giap);
		
		JButton btnHinTh_1_2 = new JButton("Thêm");
		btnHinTh_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tenp != null && tenp.getText().length() > 0) {
					if (giap != null && giap.getText().length() > 0) {
						if(ng != null && ng.getText().length()>0) {
							Phong p = new Phong();
							p.setTenPhong(tenp.getText());
							
							try {
								p.setSongP(ng.getText());
								p.setGiaPhong(giap.getText());
								pd.add(p);
								loadDl();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "Thông báo",
										JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(contentPane, "Không được để trống số người/Phòng", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
						}
						

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
		btnHinTh_1_2.setForeground(Color.WHITE);
		btnHinTh_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnHinTh_1_2.setFocusable(false);
		btnHinTh_1_2.setFocusTraversalKeysEnabled(false);
		btnHinTh_1_2.setFocusPainted(false);
		btnHinTh_1_2.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnHinTh_1_2.setBackground(Color.DARK_GRAY);
		btnHinTh_1_2.setBounds(544, 84, 126, 29);
		contentPane.add(btnHinTh_1_2);
		
		JButton btnHinTh_1_3 = new JButton("Sửa");
		btnHinTh_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Phong p = new Phong(tenp.getText(), giap.getText(),ng.getText());
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
		btnHinTh_1_3.setForeground(Color.WHITE);
		btnHinTh_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnHinTh_1_3.setFocusable(false);
		btnHinTh_1_3.setFocusTraversalKeysEnabled(false);
		btnHinTh_1_3.setFocusPainted(false);
		btnHinTh_1_3.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnHinTh_1_3.setBackground(Color.DARK_GRAY);
		btnHinTh_1_3.setBounds(544, 118, 126, 29);
		contentPane.add(btnHinTh_1_3);
		
		JButton btnHinTh_1_4 = new JButton("Xóa");
		btnHinTh_1_4.addActionListener(new ActionListener() {
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
		btnHinTh_1_4.setForeground(Color.WHITE);
		btnHinTh_1_4.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnHinTh_1_4.setFocusable(false);
		btnHinTh_1_4.setFocusTraversalKeysEnabled(false);
		btnHinTh_1_4.setFocusPainted(false);
		btnHinTh_1_4.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnHinTh_1_4.setBackground(Color.DARK_GRAY);
		btnHinTh_1_4.setBounds(544, 152, 126, 29);
		contentPane.add(btnHinTh_1_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số người/phòng :");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(273, 126, 117, 24);
		contentPane.add(lblNewLabel_1_1_1);
		
		ng = new JTextField();
		ng.setColumns(10);
		ng.setBounds(391, 126, 102, 20);
		contentPane.add(ng);
		
		
	}
}
