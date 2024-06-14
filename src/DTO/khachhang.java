package DTO;

public class khachhang {
	private int makh;
	private String tenkh;
	private String diachi;
	private String sdt;
	private String email;
	
	public khachhang() {
	}
	
	public khachhang(int makh, String tenkh, String diachi, String sdt, String email) {
		super();
		this.makh = makh;
		this.tenkh = tenkh;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
	}
	
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "khachhang [makh=" + makh + ", tenkh=" + tenkh + ", diachi=" + diachi + ", sdt=" + sdt + ", email="
				+ email + "]";
	}
	
}
