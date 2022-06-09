package dto;

import java.io.Serializable;

public class TaiKhoan extends Base implements Serializable {
	private String username,password;

	/**
	 * 
	 */
	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param password
	 */
	public TaiKhoan(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
