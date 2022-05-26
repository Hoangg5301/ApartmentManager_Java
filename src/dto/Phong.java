package dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class Phong extends Base implements Serializable {

	private String tenPhong;
	private int song;
	private BigDecimal giaPhong;

	public int getSong() {
		return song;
	}

	public void setSong(int song) {
		this.song = song;
	}

	public BigDecimal getGiaPhong() {
		return giaPhong;
	}
	
	public void setGiaPhong(String giaPhong) {
		this.giaPhong = new BigDecimal(giaPhong);
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
	 */
	public Phong(String tenPhong, String giaPhong) {
		this.tenPhong = tenPhong;
		this.giaPhong = new BigDecimal(giaPhong);
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
