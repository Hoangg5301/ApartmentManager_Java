package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.NguoiThueDao;
import Dao.PhongDao;
import dto.Phong;
import dto.nguoiThue;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ThongTinNguoiThue extends JFrame {

	private JPanel contentPane;
	private JTextField cccd;
	private JTextField hoten;
	private JTextField sdt;
	private JTextField ngs;
	private JTextField ngv;
	private JTextArea dc;
	private NguoiThueDao nd = new NguoiThueDao();
	private PhongDao pd = new PhongDao();
	private nguoiThue n;
	private JComboBox phong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinNguoiThue frame = new ThongTinNguoiThue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ThongTinNguoiThue() {

	}

	/**
	 * Create the frame.
	 */
	public ThongTinNguoiThue(nguoiThue n) {
		this.n=n;
		setResizable(false);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 516);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 434, 38);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Thông tin người thuê");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblNewLabel.setBounds(0, 0, 434, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CCCD :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(60, 87, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Họ tên :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(60, 118, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(60, 150, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		cccd = new JTextField();
		cccd.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cccd.setColumns(10);
		cccd.setBounds(194, 81, 153, 20);
		contentPane.add(cccd);
		
		hoten = new JTextField();
		hoten.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		hoten.setColumns(10);
		hoten.setBounds(194, 112, 153, 20);
		contentPane.add(hoten);
		
		sdt = new JTextField();
		sdt.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		sdt.setColumns(10);
		sdt.setBounds(194, 144, 153, 20);
		contentPane.add(sdt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày sinh :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(60, 175, 102, 17);
		contentPane.add(lblNewLabel_1_1);
		
		ngs = new JTextField();
		ngs.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		ngs.setColumns(10);
		ngs.setBounds(194, 175, 153, 20);
		contentPane.add(ngs);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày vào :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(60, 209, 102, 17);
		contentPane.add(lblNewLabel_1_1_1);
		
		ngv = new JTextField();
		ngv.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		ngv.setEnabled(false);
		ngv.setColumns(10);
		ngv.setBounds(194, 206, 153, 20);
		contentPane.add(ngv);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(197, 271, 150, 85);
		contentPane.add(scrollPane);
		dc = new JTextArea();
		scrollPane.setViewportView(dc);
		cccd.setText(n.getCccd());
		hoten.setText(n.getHoTen());
		sdt.setText(n.getSdt());
		ngs.setText(n.getNs());
		dc.setText(n.getDc());
		ngv.setText(n.getNgayVao());
		
		JLabel lblNewLabel_3_1 = new JLabel("Địa chỉ :");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(60, 274, 102, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JButton btnNewButton;
		if(n.getId()>0) {
			btnNewButton = new JButton("Sửa");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						if((new Date().getTime()- new SimpleDateFormat("dd/MM/yyyy").parse(ngs.getText()).getTime())<0){
							JOptionPane.showMessageDialog(btnNewButton, "Ngày nhâpj nhỏ hơn hiện tại!");
						}else {
							nguoiThue ng = new nguoiThue(cccd.getText(), hoten.getText(),ngs.getText(), sdt.getText(), dc.getText(),pd.searchByName(phong.getSelectedItem().toString()),ngv.getText());
							ng.setId(n.getId());
							nd.edit(ng);
							JOptionPane.showMessageDialog(btnNewButton, "bạn đã thay đổi thông tin người thuê thành công!");
							setVisible(false);
						}
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(btnNewButton, e2.getMessage());
					}
				}
			});
		}else {
			btnNewButton = new JButton("Thêm");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						nguoiThue ng = new nguoiThue(cccd.getText(), hoten.getText(),ngs.getText(), sdt.getText(), dc.getText(),pd.searchByName(phong.getSelectedItem().toString()),ngv.getText());
						
						try {
							nd.addng(ng);
							JOptionPane.showMessageDialog(btnNewButton, "bạn đã thêm người thuê thành công!");
							setVisible(false);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(btnNewButton, e2.getMessage());
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(btnNewButton, "Lỗi thêm người thuê thất bại!");
					}
				}
			});
		}
		
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(113, 398, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnXa = new JButton("Reset");
		btnXa.setForeground(Color.WHITE);
		btnXa.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnXa.setFocusable(false);
		btnXa.setFocusTraversalKeysEnabled(false);
		btnXa.setFocusPainted(false);
		btnXa.setBackground(Color.BLACK);
		btnXa.setBounds(223, 398, 89, 23);
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(n.getId()<=0) {
					cccd.setText("");
					hoten.setText("");
					ngs.setText("");
					sdt.setText("");
					dc.setText("");
					ngv.setText("");
				}else {
					cccd.setText(n.getCccd());
					hoten.setText(n.getHoTen());
					ngs.setText(n.getNs());
					sdt.setText(n.getSdt());
					dc.setText(n.getDc());
					ngv.setText(n.getNgayVao());
				}
			}
		});
		contentPane.add(btnXa);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Phòng :");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(60, 240, 102, 17);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		phong = new JComboBox();
		List<Phong> lp = pd.allList();
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
		phong.setBounds(194, 236, 153, 22);
		contentPane.add(phong);
		
		
		
		
		if(n!=null&&n.getPhong()!=null) {
			phong.setSelectedItem(n.getPhong().getTenPhong());
		}
	}
}
