package dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class Phong extends Base implements Serializable {

	private String tenPhong;
	private int songP,song;
	private BigDecimal giaPhong;

	public int getSongP() {
		return songP;
	}

	public void setSongP(String ngP) throws Exception {
		try {
			this.songP = Integer.parseInt(ngP);
		} catch (Exception e) {
			throw new Exception("Nhập số người là số nguyên!");
		}
	}

	public int getSong() {
		return song;
	}

	public void setSong(int song) {
		this.song = song;
	}

	public BigDecimal getGiaPhong() {
		return giaPhong;
	}
	
	public void setGiaPhong(String giaPhong) throws Exception {
		try {
			this.giaPhong = new BigDecimal(giaPhong);
		} catch (Exception e) {
			throw new Exception("Nhập số!");
		}
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	
	/**
	 * 
	 */
	public Phong() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param tenPhong
	 */
	/**
	 * @param tenPhong
	 * @param giaPhong
	 * @throws Exception 
	 */
	public Phong(String tenPhong, String giaPhong,String ngP) throws Exception {
		
		try {
			this.tenPhong = tenPhong;
			this.giaPhong = new BigDecimal(giaPhong);
		} catch (Exception e) {
			throw new Exception("Nhập số cho tiền!");
		}
		try {
			this.songP = Integer.parseInt(ngP);
		} catch (Exception e) {
			throw new Exception("Nhập số người là số nguyên!");
		}
	}
	
//	public String giaToString() {
//		try {
//			NumberFormat.getInstance(new Locale("vi", "VN"));
//			return NumberFormat.getCurrencyInstance().format(getGiaPhong());
//		} catch (Exception e) {
//			return "null";
//		}
//	}

}
