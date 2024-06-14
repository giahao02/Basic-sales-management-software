package DTO;

import java.util.Objects;

public class sanpham {
	private int masp;
	private String tensp;
	private float gia;
	private String hinh;
	private int matheloai;
	private String hangsx;
	private int soluong;
	
	public sanpham() {
	}

	public sanpham(int masp, String tensp, float gia, String hinh, int matheloai, String hangsx, int soluong) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.gia = gia;
		this.hinh = hinh;
		this.matheloai = matheloai;
		this.hangsx = hangsx;
		this.soluong = soluong;
	}

	public int getMasp() {
		return masp;
	}
	public void setMasp(int masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public int getMatheloai() {
		return matheloai;
	}
	public void setMatheloai(int matheloai) {
		this.matheloai = matheloai;
	}
	public String getHangsx() {
		return hangsx;
	}
	public void setHangsx(String hangsx) {
		this.hangsx = hangsx;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	@Override
	public String toString() {
		return "sanpham [masp=" + masp + ", tensp=" + tensp + ", gia=" + gia + ", hinh=" + hinh + ", matheloai="
				+ matheloai + ", hangsx=" + hangsx + ", soluong=" + soluong + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gia, hangsx, hinh, masp, matheloai, soluong, tensp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		sanpham other = (sanpham) obj;
		return Float.floatToIntBits(gia) == Float.floatToIntBits(other.gia) && Objects.equals(hangsx, other.hangsx)
				&& Objects.equals(hinh, other.hinh) && masp == other.masp && matheloai == other.matheloai
				&& soluong == other.soluong && Objects.equals(tensp, other.tensp);
	}
	
	
}
