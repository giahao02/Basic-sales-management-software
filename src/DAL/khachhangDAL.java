package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.khachhang;

public class khachhangDAL {
	private Connection con;

	public boolean openConnection() {
		try {
			String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=quanlybandienthoai";
			String username = "sa";
			String password = "sa";
			con = DriverManager.getConnection(dbUrl, username, password);
			if (con != null) {
				//JOptionPane.showMessageDialog(null, "Kết nối thành công");
				return true;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "" + ex);
		}
		return false;
	}

	public void closeConnection() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	public ArrayList<khachhang> getAllkhachhang(){
		ArrayList<khachhang> arr = new ArrayList<khachhang>();
		if (openConnection()) {
			try {
				String sql = "Select * from khachhang";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					khachhang em = new khachhang();
					em.setMakh(rs.getInt("makh"));
					em.setTenkh(rs.getString("tenkh"));
					em.setDiachi(rs.getString("diachi"));
					em.setSdt(rs.getString("sdt"));
					em.setEmail(rs.getString("email"));
					arr.add(em); }
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			} }
		return arr;
	}
	
	public ArrayList<khachhang> search(String t){
		ArrayList<khachhang> arr = new ArrayList<khachhang>();
		if (openConnection()) {
			try {
				String sql = "Select * from khachhang where tenkh like N'%"+t+"%'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					khachhang em = new khachhang();
					em.setMakh(rs.getInt("makh"));
					em.setTenkh(rs.getString("tenkh"));
					em.setDiachi(rs.getString("diachi"));
					em.setSdt(rs.getString("sdt"));
					em.setEmail(rs.getString("email"));
					arr.add(em); }
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			} }
		return arr;
	}

	public boolean addkhachhang(khachhang emp) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Insert into khachhang(tenkh,diachi,sdt,email) values('"+emp.getTenkh()+"','"+emp.getDiachi()+"','"+emp.getSdt()+"','"+emp.getEmail()+"')";
				PreparedStatement stmt = con.prepareStatement(sql);
//				stmt.setString(1, emp.getTensp());
//				stmt.setFloat(2, emp.getGia());
//				stmt.setString(3, emp.getHinh());
//				stmt.setString(4, emp.getHangsx());
//				stmt.setInt(5, emp.getSoluong());
				if (stmt.executeUpdate() >= 1) {
					result = true;
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			}
		}
		return result;
	}
	
	public boolean capnhat(khachhang emp) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "update khachhang set tenkh='"+emp.getTenkh()+"',diachi='"+emp.getDiachi()+"',sdt='"+emp.getSdt()+"',email='"+emp.getEmail()+"'where makh="+emp.getMakh()+";";
				PreparedStatement stmt = con.prepareStatement(sql);
//				stmt.setString(1, emp.getTensp());
//				stmt.setFloat(2, emp.getGia());
//				stmt.setString(3, emp.getHinh());
//				stmt.setString(4, emp.getHangsx());
//				stmt.setInt(5, emp.getSoluong());
//				stmt.setInt(6, emp.getMasp());
				if (stmt.executeUpdate() >= 1) {
					result = true;
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			}
		}
		return result;
	}
	
	public boolean xoa(khachhang emp) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "delete from khachhang where makh="+emp.getMakh()+";";
				PreparedStatement stmt = con.prepareStatement(sql);
//				stmt.setString(1, emp.getTensp());
//				stmt.setFloat(2, emp.getGia());
//				stmt.setString(3, emp.getHinh());
//				stmt.setString(4, emp.getHangsx());
//				stmt.setInt(5, emp.getSoluong());
				if (stmt.executeUpdate() >= 1) {
					result = true;
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			}
		}
		return result;
	}
}
