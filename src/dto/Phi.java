	package dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class Phi extends Base implements Serializable {
	private BigDecimal pdien,pnuoc,pdichvu;
	
	/**
	 * 
	 */
	public Phi() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pdien
	 * @param pnuoc
	 * @param pdichvu
	 */
	public Phi(String pdien,String pnuoc, String pdichvu) {
		this.pdien = new BigDecimal(pdien);
		this.pnuoc = new BigDecimal(pnuoc);
		this.pdichvu = new BigDecimal(pdichvu);
	}

	public BigDecimal getPdien() {
		return pdien;
	}

	public void setPdien(String pdien) {
		this.pdien = new BigDecimal(pdien);
	}

	public BigDecimal getPnuoc() {
		return pnuoc;
	}

	public void setPnuoc(String pnuoc) {
		this.pnuoc = new BigDecimal(pnuoc);
	}

	public BigDecimal getPdichvu() {
		return pdichvu;
	}

	public void setPdichvu(String pdichvu) {
		this.pdichvu = new BigDecimal(pdichvu);
	}
	
	
}
