package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import BLL.sanphamBLL;
import DTO.sanpham;
import net.miginfocom.swing.MigLayout;

public class dsspview extends JFrame {
	
	private JPanel contentPane;
	sanpham sp;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JLabel labelimg;
	TheModel model;
	String temp=null;
	String add=null;
	ArrayList<sanpham> arr = new ArrayList<sanpham>();
	private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public dsspview() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 599);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				ArrayList<sanpham> a = new ArrayList<sanpham>();
				sanphamBLL spbll = new sanphamBLL();
				a = spbll.search(t);
		        String[] columnName = {"Mã","Tên","Hình","Giá","Hãng sản xuất","Số lượng"};
		        Object[][] rows = new Object[a.size()][6];
		        for(int i = 0; i < a.size(); i++){
		            rows[i][0] = a.get(i).getMasp();
		            rows[i][1] = a.get(i).getTensp();
		            rows[i][2] = a.get(i).getHinh();
		            rows[i][3] = a.get(i).getGia();
		            rows[i][4] = a.get(i).getHangsx();
		            rows[i][5] = a.get(i).getSoluong();
		            
		            if(a.get(i).getHinh() != null){
		                
		             ImageIcon image = new ImageIcon(new ImageIcon(a.get(i).getHinh()).getImage()
		             .getScaledInstance(120, 120, Image.SCALE_SMOOTH) );   
		                
		            rows[i][2] = image;
		            }
		            else{
		                rows[i][2] = null;
		            }
		        }
		        textField.setText(null);
		        model = new TheModel(rows, columnName);
		        table.setModel(model);
		        table.setRowHeight(100);
		        table.getColumnModel().getColumn(2).setPreferredWidth(110);
		        table.getColumnModel().getColumn(0).setPreferredWidth(10);
		        for(int i=0;i<6;i++) {
		        	if(i==2) {
		        		continue;
		        	}
		        	TableColumn col = table.getColumnModel().getColumn(i);
		        	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  
		        	dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		        	col.setCellRenderer(dtcr);
		        }
			}
		});
		
				btnNewButton.setFocusable(false);
				btnNewButton.setHorizontalTextPosition(SwingConstants.LEFT);
				btnNewButton.setMnemonic(KeyEvent.VK_JAPANESE_KATAKANA);
				btnNewButton.setIcon(new ImageIcon(dsspview.class.getResource("/img/search1.png")));
				
				JButton btnLmMi = new JButton("Làm mới");
				btnLmMi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
						textField_3.setText(null);
						textField_4.setText(null);
						textField_5.setText(null);
						labelimg.setIcon(null);
						add=null;
						temp=null;
						loadsp1();
					}
				});
				btnLmMi.setIconTextGap(2);
				btnLmMi.setMnemonic(KeyEvent.VK_JAPANESE_KATAKANA);
				btnLmMi.setHorizontalTextPosition(SwingConstants.LEFT);
				btnLmMi.setFocusable(false);
				panel_1.setLayout(new MigLayout("", "[144px][12px][323px][25px][79px][32px][84px]", "[31px][33px]"));
				panel_1.add(lblNewLabel, "cell 0 0 7 1,growx,aligny top");
				panel_1.add(lblNewLabel_1, "cell 0 1,alignx right,aligny center");
				panel_1.add(textField, "cell 2 1,growx,aligny center");
				panel_1.add(btnNewButton, "cell 4 1,alignx left,aligny top");
				panel_1.add(btnLmMi, "cell 6 1,alignx left,growy");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách sản phẩm:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableMouseClicked(evt);}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin sản phẩm:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_4 = new JLabel("Tên sản phẩm:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_5 = new JLabel("Giá:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_6 = new JLabel("Hãng sản xuất:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_7 = new JLabel("Số lượng:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Hình ảnh:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		labelimg = new JLabel();
		labelimg.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				sanphamBLL spBLL = new sanphamBLL();
				sp = new sanpham();
				if(textField_1.getText().isEmpty() || textField_3.getText().isEmpty() || textField_2.getText().isEmpty() || textField_4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin");
					return;
				}
				sp.setTensp(textField_1.getText());
				sp.setGia(Float.parseFloat(textField_2.getText().trim()));
				sp.setHangsx(textField_3.getText());
				sp.setSoluong(Integer.parseInt(textField_4.getText().trim()));
				sp.setHinh(add);
				if(sp.getGia() < 0 || sp.getSoluong() < 0) {
					JOptionPane.showMessageDialog(null,"Giá và Số lượng phải lớn hơn hoặc bằng 0");
					return;
				}
				JOptionPane.showMessageDialog(null,spBLL.them(sp));
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				labelimg.setIcon(null);
				add=null;
				temp=null;
				loadsp1();
				} catch(Exception q) {
					JOptionPane.showMessageDialog(null,"Giá và Số lượng phải là kiểu số");
					return;
				}
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setIcon(new ImageIcon(dsspview.class.getResource("/img/add.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JButton btnNewButton_1_1 = new JButton("Cập nhật");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(textField_5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Vui lòng chọn sản phẩm cần cập nhật");
					return;
				}
				if(textField_1.getText().isEmpty() || textField_3.getText().isEmpty() || textField_2.getText().isEmpty() || textField_4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin");
					return;
				}
				sanphamBLL spBLL = new sanphamBLL();
				sp = new sanpham();
				sp.setTensp(textField_1.getText());
				sp.setGia(Float.parseFloat(textField_2.getText()));
				sp.setHangsx(textField_3.getText());
				sp.setSoluong(Integer.parseInt(textField_4.getText().trim()));
				sp.setMasp(Integer.parseInt(textField_5.getText().trim()));
				sp.setHinh(temp);
				if(sp.getGia() < 0 || sp.getSoluong() < 0) {
					JOptionPane.showMessageDialog(null,"Giá và Số lượng phải lớn hơn hoặc bằng 0");
					return;
				}
				JOptionPane.showMessageDialog(null,spBLL.capnhat(sp));
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				labelimg.setIcon(null);
				add=null;
				temp=null;
				loadsp1();
				} catch(Exception q) {
					JOptionPane.showMessageDialog(null,"Giá và Số lượng phải là kiểu số");
					return;
				}
			}
		});
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setIcon(new ImageIcon(dsspview.class.getResource("/img/update.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JButton btnNewButton_1_2 = new JButton("Xóa");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Vui lòng chọn sản phẩm cần xóa");
					return;
				}
				sanphamBLL spBLL = new sanphamBLL();
				sp = new sanpham();
				sp.setMasp(Integer.parseInt(textField_5.getText().trim()));
				JOptionPane.showMessageDialog(null,spBLL.xoa(sp));
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				labelimg.setIcon(null);
				add=null;
				temp=null;
				loadsp1();
			}
		});
		btnNewButton_1_2.setFocusable(false);
		btnNewButton_1_2.setIcon(new ImageIcon(dsspview.class.getResource("/img/delete.png")));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JButton btnNewButton_2 = new JButton("Chọn ảnh");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setIcon(new ImageIcon(dsspview.class.getResource("/img/openfile.png")));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
		          file.setCurrentDirectory(new File(System.getProperty("user.home")));
		          //filter the files
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		           //if the user click on save in Jfilechooser
		          if(result == JFileChooser.APPROVE_OPTION){
		              File selectedFile = file.getSelectedFile();
		              temp = add = selectedFile.getAbsolutePath();
		              ImageIcon MyImage = new ImageIcon(temp);
		              Image img = MyImage.getImage();
		              Image newImg = img.getScaledInstance(labelimg.getWidth(), labelimg.getHeight(), Image.SCALE_SMOOTH);
		              ImageIcon image = new ImageIcon(newImg);
		              labelimg.setIcon(image);
		          }
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new CardLayout(0, 0));

		panel_3.add(labelimg, "name_23141769676358900");
		
		JLabel lblNewLabel_9 = new JLabel("Mã sản phẩm:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		panel_2.setLayout(new MigLayout("", "[104px][30px][107px][50px][127px][20px][261px]", "[22px][196px][22px][19px][8px][19px][19px][12px][19px][12px][19px][50px][33px]"));
		panel_2.add(lblNewLabel_2, "cell 0 0 3 1,alignx left,aligny top");
		panel_2.add(scrollPane, "cell 0 1 7 1,grow");
		panel_2.add(lblNewLabel_3, "cell 0 2 3 1,alignx left,aligny top");
		panel_2.add(lblNewLabel_5, "cell 0 6,alignx center,aligny top");
		panel_2.add(lblNewLabel_6, "cell 0 8,alignx right,aligny top");
		panel_2.add(lblNewLabel_7, "cell 0 10,alignx center,aligny top");
		panel_2.add(btnNewButton_1, "cell 0 12,alignx left,aligny top");
		panel_2.add(btnNewButton_1_1, "cell 2 12,alignx left,aligny top");
		panel_2.add(textField_2, "cell 2 6,growx,aligny top");
		panel_2.add(textField_3, "cell 2 8,growx,aligny top");
		panel_2.add(textField_4, "cell 2 10,growx,aligny top");
		panel_2.add(lblNewLabel_9, "cell 0 3,alignx right,aligny top");
		panel_2.add(lblNewLabel_4, "cell 0 5,alignx left,aligny top");
		panel_2.add(textField_1, "cell 2 5,growx,aligny top");
		panel_2.add(textField_5, "cell 2 3,growx,aligny top");
		panel_2.add(lblNewLabel_8, "cell 4 3 1 3,alignx right,aligny center");
		panel_2.add(btnNewButton_2, "cell 6 3 1 3,alignx left,aligny top");
		panel_2.add(btnNewButton_1_2, "cell 4 12,alignx left,aligny top");
		panel_2.add(panel_3, "cell 6 6 1 7,grow");
		
		//this.setVisible(true);
	}
	
//	public void loadsp() {
//		DefaultTableModel dtm = new DefaultTableModel();
//		ImageIcon image = null;
//		dtm.addColumn("Mã");
//		dtm.addColumn("Tên");
//		dtm.addColumn("Gía");
//		dtm.addColumn("Hãng sản xuất");
//		dtm.addColumn("Số lượng");
//		table.setModel(dtm);
//		ArrayList<sanpham> arr = new ArrayList<sanpham>();
//		sanphamBLL spbll = new sanphamBLL();
//		arr = spbll.getAllsanpham();
//		for(int i = 0; i < arr.size(); i++){
//			sanpham em = arr.get(i);
//			int masp = em.getMasp();
//			String tensp = em.getTensp();
//			Float gia = em.getGia();
//			if(em.getHinh() != null){
//		        image = new ImageIcon(new ImageIcon(em.getHinh()).getImage().getScaledInstance(labelimg.getWidth(), labelimg.getHeight(), Image.SCALE_SMOOTH) );
//		    }
//			String hangsx = em.getHangsx();
//			int soluong = em.getSoluong();
//			Object[] row = {masp,tensp,gia,hangsx,soluong};
//			dtm.addRow(row);
//		}
//	}
//	
	public void loadsp1() {
		sanphamBLL spbll = new sanphamBLL();
		arr = spbll.getAllsanpham();
        String[] columnName = {"Mã","Tên","Hình","Giá","Hãng sản xuất","Số lượng"};
        Object[][] rows = new Object[arr.size()][6];
        for(int i = 0; i < arr.size(); i++){
            rows[i][0] = arr.get(i).getMasp();
            rows[i][1] = arr.get(i).getTensp();
            rows[i][2] = arr.get(i).getHinh();
            rows[i][3] = arr.get(i).getGia();
            rows[i][4] = arr.get(i).getHangsx();
            rows[i][5] = arr.get(i).getSoluong();
            
            if(arr.get(i).getHinh() != null){
            	ImageIcon image = new ImageIcon(new ImageIcon(arr.get(i).getHinh()).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH) );   
            	rows[i][2] = image;
            }
            else{
                rows[i][2] = null;
            }
        }
        
        model = new TheModel(rows, columnName);
        table.setModel(model);
        table.setRowHeight(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(110);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        for(int i=0;i<6;i++) {
        	if(i==2) {
        		continue;
        	}
        	TableColumn col = table.getColumnModel().getColumn(i);
        	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  
        	dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        	col.setCellRenderer(dtcr);
        }
    }
	
	 private void tableMouseClicked(java.awt.event.MouseEvent evt) {
		 try {
		 int i = table.getSelectedRow();
		 if(table.getValueAt(i, 2) != null)
	        {
			 ImageIcon image1 = (ImageIcon)table.getValueAt(i, 2);
			 Image image2 = image1.getImage().getScaledInstance(labelimg.getWidth(), labelimg.getHeight(), Image.SCALE_SMOOTH);
			 ImageIcon image3 = new ImageIcon(image2);
			 labelimg.setIcon(image3);
	        }   
		 // Display Slected Row In JTexteFields
		 textField_5.setText(model.getValueAt(i,0).toString());
		 textField_1.setText(model.getValueAt(i,1).toString());
		 textField_2.setText(model.getValueAt(i,3).toString());
		 textField_3.setText(model.getValueAt(i,4).toString());
		 textField_4.setText(model.getValueAt(i,5).toString());
		 temp=arr.get(i).getHinh();
	    } catch (Exception e) {
	    }
	 }

//	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dsspview frame = new dsspview();
					//loadsp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
