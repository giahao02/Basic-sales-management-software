package BLL;

import java.util.ArrayList;

import DAL.sanphamDAL;
import DTO.sanpham;


public class sanphamBLL {
	
	sanphamDAL spDAL=new sanphamDAL();
	
	public ArrayList<sanpham> getAllsanpham(){
		return spDAL.getAllsanpham();
	}
	
	public String them(sanpham sp) {
//		if (spDAL.trungten(sp.getTensp()))
//			return "Mã NV đã tồn tại";
		if (spDAL.addsanpham(sp)) {
			return "Thêm thành công";
		}
		return "Thêm thất bại";
	}
	
	public String capnhat(sanpham sp) {
		if (spDAL.capnhat(sp))
			return "Cập nhật thành công";
		return "Cập nhật thất bại";
	}
	
	public String xoa(sanpham sp) {
		if (spDAL.xoa(sp))
			return "Xóa thành công";
		return "Xóa thất bại";
	}
	
	public ArrayList<sanpham> search(String t) {
		if(spDAL.search(t)==null) {
			return null;
		}
		return  spDAL.search(t);
	}
	
	
}
