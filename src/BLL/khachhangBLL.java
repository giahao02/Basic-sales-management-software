package BLL;

import java.util.ArrayList;

import DAL.khachhangDAL;
import DTO.khachhang;

public class khachhangBLL {
	khachhangDAL spDAL=new khachhangDAL();
	
	public ArrayList<khachhang> getAllkhachhang(){
		return spDAL.getAllkhachhang();
	}
	
	public String them(khachhang sp) {
//		if (spDAL.trungten(sp.getTensp()))
//			return "Mã NV đã tồn tại";
		if (spDAL.addkhachhang(sp)) {
			return "Thêm thành công";
		}
		return "Thêm thất bại";
	}
	
	public String capnhat(khachhang sp) {
		if (spDAL.capnhat(sp))
			return "Cập nhật thành công";
		return "Cập nhật thất bại";
	}
	
	public String xoa(khachhang sp) {
		if (spDAL.xoa(sp))
			return "Xóa thành công";
		return "Xóa thất bại";
	}
	
	public ArrayList<khachhang> search(String t) {
		if(spDAL.search(t)==null) {
			return null;
		}
		return  spDAL.search(t);
	}
}
