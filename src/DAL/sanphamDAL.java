package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.sanpham;

public class sanphamDAL {
	
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

	public ArrayList<sanpham> getAllsanpham(){
		ArrayList<sanpham> arr = new ArrayList<sanpham>();
		if (openConnection()) {
			try {
				String sql = "Select * from sanpham";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					sanpham em = new sanpham();
					em.setMasp(rs.getInt("masp"));
					em.setTensp(rs.getString("tensp"));
					em.setGia(rs.getFloat("gia"));
					em.setHinh(rs.getString("hinh"));
					em.setHangsx(rs.getString("hangsx"));
					em.setSoluong(rs.getInt("soluong"));
					arr.add(em); }
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			} }
		return arr;
	}
	
	public ArrayList<sanpham> search(String t){
		ArrayList<sanpham> arr = new ArrayList<sanpham>();
		if (openConnection()) {
			try {
				String sql = "Select * from sanpham where tensp like N'%"+t+"%'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					sanpham em = new sanpham();
					em.setMasp(rs.getInt("masp"));
					em.setTensp(rs.getString("tensp"));
					em.setGia(rs.getFloat("gia"));
					em.setHinh(rs.getString("hinh"));
					em.setHangsx(rs.getString("hangsx"));
					em.setSoluong(rs.getInt("soluong"));
					arr.add(em); }
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			} }
		return arr;
	}

	public boolean addsanpham(sanpham emp) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Insert into sanpham(tensp,gia,hinh,hangsx,soluong) values('"+emp.getTensp()+"',"+emp.getGia()+",'"+emp.getHinh()+"','"+emp.getHangsx()+"',"+emp.getSoluong()+")";
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
	
	public boolean capnhat(sanpham emp) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "update sanpham set tensp='"+emp.getTensp()+"',gia="+emp.getGia()+",hinh='"+emp.getHinh()+"',hangsx='"+emp.getHangsx()+"',soluong="+emp.getSoluong()+"where masp="+emp.getMasp()+";";
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
	
	public boolean xoa(sanpham emp) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "delete from sanpham where masp="+emp.getMasp()+";";
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

//	public class MyQuery {
//	    
//		   public Connection getConnection(){
//		        Connection con = null;
//		        try {
//		            con = DriverManager.getConnection("jdbc:mysql://localhost/project", "root","");
//		        } catch (SQLException ex) {
//		            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
//		        }
//		        return con;
//		    }
//		    
//		    public ArrayList<Product2> BindTable(){
//		        
//		   ArrayList<Product2> list = new ArrayList<Product2>();
//		   Connection con = getConnection();
//		   Statement st;
//		   ResultSet rs;
//		   
//		   try {
//		   st = con.createStatement();
//		   rs = st.executeQuery("SELECT `ID_PRO`, `PRO_NAME`, `QTE_IN_STOCK`, `PRICE`, `PRO_IMAGE`, `ID_CAT` FROM `products`");
//		   
//		   Product2 p;
//		   while(rs.next()){
//		   p = new Product2(
//		   rs.getString("ID_PRO"),
//		   rs.getString("PRO_NAME"),
//		   rs.getInt("QTE_IN_STOCK"),
//		   rs.getString("PRICE"),
//		   rs.getBytes("PRO_IMAGE"),
//		   rs.getInt("ID_CAT")
//		   );
//		   list.add(p);
//		   }
//		   
//		   } catch (SQLException ex) {
//		   Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
//		   }
//		   return list;
//		   }
//		}
//
//
//}
