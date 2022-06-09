package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.PhiD;
import Dao.PhongDao;
import Dao.hoaDonD;
import dto.HoaDon;
import dto.Phi;
import dto.Phong;
import dto.nguoiThue;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

import javax.swing.JTextPane;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

public class QuanLyHoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField ma;
	private JTable table;
	private hoaDonD hD = new hoaDonD();
	private HoaDon hd = new HoaDon();
	private List<HoaDon> lhd;
	private Phi phi = (new PhiD()).allList().get(0);
	private JTextPane ct;
	DefaultTableModel tb;
	Object[] colum = { "ID", "Mã hóa đơn", "Phòng", "Ngày tạo", "Tổng tiền" };
	private JComboBox phong;
	/**
	 * Launch the application.
	 */
	public void loaddl() {
		tb = new DefaultTableModel();
		tb = new DefaultTableModel();
		tb.setColumnIdentifiers(colum);
		try {
			for (HoaDon h : lhd) {
				tb.addRow(new Object[] { h.getId(), h.getMahoadon(), h.getP() != null ? h.getP().getTenPhong() : "",
						h.getNgaytao(),
						h.getTt().add(h.getP() != null ? h.getP().getGiaPhong() : new BigDecimal(0)) + "đ" });
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
					QuanLyHoaDon frame = new QuanLyHoaDon();
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
	public QuanLyHoaDon() {
		lhd = hD.allList();
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 918, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 903, 38);
		contentPane.add(panel);

		JLabel lblQunLHa = new JLabel("Quản lý hóa đơn");
		lblQunLHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLHa.setForeground(Color.WHITE);
		lblQunLHa.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblQunLHa.setBounds(0, 5, 903, 30);
		panel.add(lblQunLHa);

		JButton btnToHan = new JButton("Tạo hóa đơn");
		btnToHan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaoHoaDon thd = new TaoHoaDon();
				thd.setVisible(true);
				
			}
		});
		btnToHan.setForeground(Color.WHITE);
		btnToHan.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnToHan.setFocusable(false);
		btnToHan.setFocusTraversalKeysEnabled(false);
		btnToHan.setFocusPainted(false);
		btnToHan.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnToHan.setBackground(Color.DARK_GRAY);
		btnToHan.setBounds(0, 49, 112, 30);
		contentPane.add(btnToHan);

		JLabel lblNewLabel_1 = new JLabel("Mã :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(83, 103, 35, 14);
		contentPane.add(lblNewLabel_1);

		ma = new JTextField();
		ma.setSelectionColor(Color.LIGHT_GRAY);
		ma.setSelectedTextColor(Color.WHITE);
		ma.setColumns(10);
		ma.setBounds(122, 97, 86, 20);
		contentPane.add(ma);

		JLabel lblNewLabel_1_1 = new JLabel("Tháng :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(205, 103, 49, 14);
		contentPane.add(lblNewLabel_1_1);

		JComboBox thang = new JComboBox();
		thang.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		thang.setForeground(Color.WHITE);
		thang.setFocusable(false);
		thang.setFocusTraversalKeysEnabled(false);
		thang.setBorder(null);
		thang.setBackground(Color.GRAY);
		thang.setBounds(264, 95, 49, 22);
		contentPane.add(thang);

		JButton btnHinTh = new JButton("Hiển thị");
		btnHinTh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lhd = hD.allList();
				loaddl();
			}
		});
		btnHinTh.setForeground(Color.WHITE);
		btnHinTh.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnHinTh.setFocusable(false);
		btnHinTh.setFocusTraversalKeysEnabled(false);
		btnHinTh.setFocusPainted(false);
		btnHinTh.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnHinTh.setBackground(Color.DARK_GRAY);
		btnHinTh.setBounds(0, 87, 86, 30);
		contentPane.add(btnHinTh);

		JButton btnTm = new JButton("Tìm");
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lhd = hD.search(ma.getText(),phong.getSelectedItem().toString(), thang.getSelectedItem().toString());
				loaddl();
			}
		});
		btnTm.setForeground(Color.WHITE);
		btnTm.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnTm.setFocusable(false);
		btnTm.setFocusTraversalKeysEnabled(false);
		btnTm.setFocusPainted(false);
		btnTm.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnTm.setBackground(Color.DARK_GRAY);
		btnTm.setBounds(450, 90, 85, 30);
		contentPane.add(btnTm);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 128, 535, 337);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				try {
					hd = hD.searchById(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString())).get(0);

					ct.setText("=========================\n\nMã hóa đơn: " + hd.getMahoadon() + "\nPhòng: "
							+ hd.getP().getTenPhong() + "\nSố ngày ở:  "+hd.getSongayo()+"\nTiền điện:  " + hd.getSdien() + "X(" + phi.getPdien()
							+ "đ) = " + hd.getTdien()+" đ" + "\nTiền nước:  " + hd.getSnuoc() + "X(" + phi.getPnuoc()
							+ "đ) = " + hd.getTnuoc()+" đ" + "\nTiền dich vu:  " + hd.getTdichvu() + "\nTiền phòng:  "
							+ hd.getP().getGiaPhong()+" đ" + "\nTổng thanh toán:  " + hd.getTt().add(hd.getP().getGiaPhong())+" đ"
							+ "\n\n=========================");

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		loaddl();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1_1_1 = new JLabel("Phong :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(309, 103, 49, 14);
		contentPane.add(lblNewLabel_1_1_1);

		phong = new JComboBox();
		List<Phong> lp = new PhongDao().allList();
		String[] sp = new String[lp.size() + 1];
		sp[0] = "";
		for (int i = 0; i < lp.size(); i++) {

			sp[i + 1] = lp.get(i).getTenPhong();
		}
		phong.setModel(new DefaultComboBoxModel(sp));
		phong.setForeground(Color.WHITE);
		phong.setFocusable(false);
		phong.setFocusTraversalKeysEnabled(false);
		phong.setBorder(null);
		phong.setBackground(Color.GRAY);
		phong.setBounds(368, 95, 72, 22);
		contentPane.add(phong);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(537, 38, 366, 427);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chi tiết hóa đơn");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 366, 31);
		panel_1.add(lblNewLabel);

		ct = new JTextPane();
		ct.setSelectionColor(Color.LIGHT_GRAY);
		ct.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		ct.setDisabledTextColor(Color.BLACK);
		ct.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		ct.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		ct.setBackground(Color.WHITE);
		ct.setEnabled(false);
		ct.setBounds(65, 53, 301, 374);
		panel_1.add(ct);
	}
}
