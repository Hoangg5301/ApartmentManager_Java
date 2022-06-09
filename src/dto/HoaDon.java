package dto;

import java.io.Serializable;
import java.math.BigDecimal;

import Dao.PhiD;

public class HoaDon extends Base implements Serializable {
	private String mahoadon,ngaytao;
	private int songayo;
	private float sdien,snuoc;
	private Phong p ;
	private BigDecimal tdien,tnuoc,tdichvu, tt;
	/**
	 * 
	 */
	public HoaDon() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param mahoadon
	 * @param ngaytao
	 * @param songayo
	 * @param sdien
	 * @param snuoc
	 * @param p
	 * @throws Exception 
	 */
	public HoaDon(String mahoadon, String ngaytao, int songayo, float sdien, float snuoc, Phong p) throws Exception {
		
		
		try {
			this.mahoadon = mahoadon;
			this.ngaytao = ngaytao;
			this.songayo = songayo;
			this.sdien = sdien;
			this.snuoc = snuoc;

			this.p = p;
		} catch (Exception e) {
			throw new Exception("Lỗi định dạng!");
		}
	}
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(String ngaytao) {
		this.ngaytao = ngaytao;
	}
	public int getSongayo() {
		return songayo;
	}
	public void setSongayo(int songayo) {
		this.songayo = songayo;
	}
	public float getSdien() {
		return sdien;
	}
	public void setSdien(float sdien) throws Exception {
		try {
			this.sdien = sdien;
		} catch (Exception e) {
			throw new Exception("Lỗi định dạng!");
		}
	}
	public float getSnuoc() {
		return snuoc;
	}
	public void setSnuoc(float snuoc) throws Exception {
		
		try {
			this.snuoc = snuoc;
		} catch (Exception e) {
			throw new Exception("Lỗi định dạng!");
		}
	}
	public Phong getP() {
		return p;
	}
	public void setP(Phong p) {
		this.p = p;
	}
	public BigDecimal getTdien() {
		PhiD pD= new PhiD(); 
		return pD.allList().get(0).getPdien().multiply(BigDecimal.valueOf(sdien));
	}
	public BigDecimal getTnuoc() {
		PhiD pD= new PhiD(); 
		return pD.allList().get(0).getPnuoc().multiply(BigDecimal.valueOf(snuoc));
	}
	public BigDecimal getTdichvu() {
		PhiD pD= new PhiD(); 
		return pD.allList().get(0).getPdichvu();
	}
	public BigDecimal getTt() {
		this.tt = getTdien().add(getTnuoc()).add(getTdichvu());
		return tt;
	}
	
	
}
