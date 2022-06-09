package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;

import Dao.NguoiThueDao;
import dto.Phong;
import dto.nguoiThue;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class QuanLyNguoiThuePhong extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField cccd;
	private JTextField hoten;
	private JTextField sdt;
	private JTextField ngs;
	private JTextField ngv;
	private JTextArea diachi;
	private NguoiThueDao ntD = new  NguoiThueDao();
	private nguoiThue ng;
	private Phong p;
	DefaultTableModel tb;
	Object[] colum = { "Mã người Thuê", "Họ tên" };
	private JLabel lblNewLabel;
	private JTextField ma;
	private JPanel panel;
	private JLabel tenp;
	private JPanel panel_1;
	private JLabel lblNewLabel_4;
	
	public void loadDl() throws ParserConfigurationException {
		 
//		try {
//			ntD.addng(new nguoiThue("ccccc","haui","12/02/2001","13223232","hauid",p,"13/02/2021"));
//			ntD.addng(new nguoiThue("ccccc","haui","12/02/2021","13223232","hauid",p,"13/02/2001"));
//			ntD.addng(new nguoiThue("ccccc","haci","12/02/2001","13223232","hauid",p,"13/02/2001"));
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(hoten, e.getMessage());
//		}
		tb = new DefaultTableModel();
		tb.setColumnIdentifiers(colum);
		for (nguoiThue ng : ntD.getNguoiThueByPhong(p)) {
			tb.addRow(new Object[] {
					ng.getId(),
					ng.getHoTen(),
			});
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
					QuanLyNguoiThuePhong frame = new QuanLyNguoiThuePhong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * @throws HeadlessException
	 */
	public QuanLyNguoiThuePhong() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Create the frame.
	 * @throws ParserConfigurationException 
	 */
	public QuanLyNguoiThuePhong(Phong p) throws ParserConfigurationException {
		this.p=p;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 518);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.DARK_GRAY);
		
		scrollPane.setBounds(26, 51, 323, 402);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setSelectionBackground(Color.DARK_GRAY);
		
		table.setFocusable(false);
		table.setFocusTraversalKeysEnabled(false);
		scrollPane.setViewportView(table);
		table.setBackground(Color.GRAY);
		table.setBorder(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		loadDl();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ng = ntD.searchById(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString())).get(0);
				} catch (Exception e1) {
					
				}
				
				ma.setText(ng.getId()+"");
				cccd.setText(ng.getCccd());
				hoten.setText(ng.getHoTen());
				ngs.setText(ng.getNs());
				sdt.setText(ng.getSdt());
				diachi.setText(ng.getDc());
				ngv.setText(ng.getNgayVao());
			}
		});
		
		lblNewLabel_1 = new JLabel("CCCD :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(377, 140, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Họ tên :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(377, 165, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Số điện thoại :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(377, 190, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		cccd = new JTextField();
		cccd.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cccd.setBounds(511, 134, 153, 20);
		contentPane.add(cccd);
		cccd.setColumns(10);
		
		hoten = new JTextField();
		hoten.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		hoten.setColumns(10);
		hoten.setBounds(511, 159, 153, 20);
		contentPane.add(hoten);
		
		sdt = new JTextField();
		sdt.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		sdt.setColumns(10);
		sdt.setBounds(511, 184, 153, 20);
		contentPane.add(sdt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày sinh :");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(377, 215, 102, 17);
		contentPane.add(lblNewLabel_1_1);
		
		ngs = new JTextField();
		ngs.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		ngs.setColumns(10);
		ngs.setBounds(511, 215, 153, 20);
		contentPane.add(ngs);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày vào :");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(377, 242, 102, 17);
		contentPane.add(lblNewLabel_1_1_1);
		
		ngv = new JTextField();
		ngv.setEnabled(false);
		ngv.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		ngv.setColumns(10);
		ngv.setBounds(511, 239, 153, 20);
		contentPane.add(ngv);
		
		JLabel lblNewLabel_3_1 = new JLabel("Địa chỉ :");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(377, 270, 102, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(511, 265, 153, 76);
		contentPane.add(scrollPane_1);
		
		diachi = new JTextArea();
		scrollPane_1.setViewportView(diachi);
		diachi.setBorder(null);
		
		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					nguoiThue n = new nguoiThue(cccd.getText(), hoten.getText(), ngs.getText(), sdt.getText(), diachi.getText(), p, ngv.getText());
					n.setId(ng.getId());
					try {
						ntD.edit(n);
						loadDl();
						JOptionPane.showMessageDialog(btnNewButton, "Bạn đã thay đổi thông tin thành công!");
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(btnNewButton, e2.getMessage());
					}
				
			}
		});
		btnNewButton.setBounds(443, 387, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnXa = new JButton("Reset");
		btnXa.setFocusPainted(false);
		btnXa.setFocusTraversalKeysEnabled(false);
		btnXa.setFocusable(false);
		btnXa.setBackground(Color.BLACK);
		btnXa.setForeground(Color.WHITE);
		btnXa.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ma.setText(ng.getId()+"");
				cccd.setText(ng.getCccd());
				hoten.setText(ng.getHoTen());
				ngs.setText(ng.getNs());
				sdt.setText(ng.getSdt());
				diachi.setText(ng.getDc());
				ngv.setText(ng.getNgayVao());
			}
		});
		btnXa.setBounds(553, 387, 89, 23);
		contentPane.add(btnXa);
		
		lblNewLabel = new JLabel("Mã người thuê :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(377, 110, 102, 14);
		contentPane.add(lblNewLabel);
		
		ma = new JTextField();
		ma.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		ma.setEditable(false);
		ma.setEnabled(false);
		ma.setColumns(10);
		ma.setBounds(511, 104, 153, 20);
		contentPane.add(ma);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 709, 39);
		contentPane.add(panel);
		
		tenp = new JLabel("Phòng "+p.getTenPhong());
		tenp.setHorizontalAlignment(SwingConstants.CENTER);
		tenp.setForeground(Color.WHITE);
		tenp.setFont(new Font("Segoe UI", Font.BOLD, 21));
		tenp.setBackground(Color.DARK_GRAY);
		tenp.setBounds(0, 0, 709, 39);
		panel.add(tenp);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(359, 51, 340, 402);
		contentPane.add(panel_1);
		
		lblNewLabel_4 = new JLabel("Thông tin người thuê");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBackground(Color.GRAY);
		panel_1.add(lblNewLabel_4);
	}
}
