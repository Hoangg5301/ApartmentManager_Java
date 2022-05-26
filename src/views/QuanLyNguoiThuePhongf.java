package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
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

public class QuanLyNguoiThuePhongf extends JFrame {

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
	public static Phong p;
	DefaultTableModel tb;
	Object[] colum = { "Mã người Thuê", "số CCCD", "Họ tên","Ngày sinh", "SĐT","Địa chỉ","Ngày vào" };
	private JLabel lblNewLabel;
	private JTextField ma;
	
	public void loadDl() throws ParserConfigurationException {
//		nguoiThue n = new nguoiThue("ccccc","haui","12/02/2001","13223232","hauid",p,"13/02/2001");
//		ntD.add(n);
		tb = new DefaultTableModel();
		tb.setColumnIdentifiers(colum);
		for (nguoiThue ng : ntD.getNguoiThueByPhong(p)) {
			tb.addRow(new Object[] {
					ng.getId(),
					ng.getCccd(),
					ng.getHoTen(),
					ng.getNs(),
					ng.getSdt(),
					ng.getDc(),
					ng.getNgayVao()
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
					QuanLyNguoiThuePhongf frame = new QuanLyNguoiThuePhongf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 * @throws ParserConfigurationException 
	 */
	public QuanLyNguoiThuePhongf() throws ParserConfigurationException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 518);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(26, 219, 653, 214);
		contentPane.add(scrollPane);
		table = new JTable();
		
		table.setFocusable(false);
		table.setFocusTraversalKeysEnabled(false);
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		table.setBorder(null);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		loadDl();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(table.getSelectedRow());
				ma.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				cccd.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				hoten.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				ngs.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				sdt.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				diachi.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				ngv.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
				
			}
		});
		JLabel tenp = new JLabel();
		tenp.setHorizontalAlignment(SwingConstants.CENTER);
		tenp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tenp.setForeground(Color.BLUE);
		tenp.setBounds(277, 11, 125, 42);
		contentPane.add(tenp);
		tenp.setText(p.getTenPhong());
		
		lblNewLabel_1 = new JLabel("CCCD :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(26, 96, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Họ tên :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(26, 121, 65, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Số điện thoại :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(26, 146, 94, 14);
		contentPane.add(lblNewLabel_3);
		
		cccd = new JTextField();
		cccd.setBounds(157, 90, 153, 20);
		contentPane.add(cccd);
		cccd.setColumns(10);
		
		hoten = new JTextField();
		hoten.setColumns(10);
		hoten.setBounds(157, 115, 153, 20);
		contentPane.add(hoten);
		
		sdt = new JTextField();
		sdt.setColumns(10);
		sdt.setBounds(157, 140, 153, 20);
		contentPane.add(sdt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày sinh :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(353, 60, 69, 17);
		contentPane.add(lblNewLabel_1_1);
		
		ngs = new JTextField();
		ngs.setColumns(10);
		ngs.setBounds(446, 61, 153, 20);
		contentPane.add(ngs);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày vào :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(353, 87, 68, 17);
		contentPane.add(lblNewLabel_1_1_1);
		
		ngv = new JTextField();
		ngv.setColumns(10);
		ngv.setBounds(446, 85, 153, 20);
		contentPane.add(ngv);
		
		JLabel lblNewLabel_3_1 = new JLabel("Địa chỉ :");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(353, 112, 49, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(446, 111, 153, 54);
		contentPane.add(scrollPane_1);
		
		diachi = new JTextArea();
		scrollPane_1.setViewportView(diachi);
		diachi.setBorder(null);
		
		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(189, 178, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ntD.deleteByPhong(ntD.searchById(Integer.valueOf(ma.getText())).get(0));
					loadDl();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnXa.setBounds(301, 178, 89, 23);
		contentPane.add(btnXa);
		
		lblNewLabel = new JLabel("Mã người thuê :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(26, 66, 110, 14);
		contentPane.add(lblNewLabel);
		
		ma = new JTextField();
		ma.setColumns(10);
		ma.setBounds(157, 60, 153, 20);
		contentPane.add(ma);
	}
}
