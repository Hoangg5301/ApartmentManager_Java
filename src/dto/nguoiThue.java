package dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

public class nguoiThue extends Base implements Serializable {
	private String cccd, hoTen;
	private String ns;
	private String sdt;
	private String dc;
	private Phong phong;
	private String ngayVao;
	private String ngayTra;
	
	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public String getNs() {
		return ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}

	public String getNgayVao() {
		return ngayVao;
	}

	public void setNgayVao(String ngayVao) {
		this.ngayVao = ngayVao;
	}

	public String getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(String ngayTra) {
		this.ngayTra = ngayTra;
	}

	/**
	 * 
	 */
	public nguoiThue() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cccd
	 * @param hoTen
	 * @param ns
	 * @param sdt
	 * @param dc
	 * @param phong
	 * @param ngayVao
	 */
	public nguoiThue(String cccd, String hoTen, String ns, String sdt, String dc, Phong phong, String ngayVao) {
		super();
		this.cccd = cccd;
		this.hoTen = hoTen;
		this.ns = ns;
		this.sdt = sdt;
		this.dc = dc;
		this.phong = phong;
		this.ngayVao = ngayVao;
	}
	
	
	
}
