package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import BLL.khachhangBLL;
import DTO.khachhang;
import net.miginfocom.swing.MigLayout;

public class dskhview extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	
	khachhang kh;
	TheModel model;
	ArrayList<khachhang> arr = new ArrayList<khachhang>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dskhview frame = new dskhview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dskhview() {
		//this.sp = new danhsachsp();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 505);
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
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				ArrayList<khachhang> a = new ArrayList<khachhang>();
				khachhangBLL spbll = new khachhangBLL();
				a = spbll.search(t);
		        String[] columnName = {"Mã","Tên","Địa chỉ","Số điện thoại","Email"};
		        Object[][] rows = new Object[a.size()][5];
		        for(int i = 0; i < a.size(); i++){
		            rows[i][0] = a.get(i).getMakh();
		            rows[i][1] = a.get(i).getTenkh();
		            rows[i][2] = a.get(i).getDiachi();
		            rows[i][3] = a.get(i).getSdt();
		            rows[i][4] = a.get(i).getEmail();
		        }
		        textField.setText(null);
		        model = new TheModel(rows, columnName);
		        table.setModel(model);
		        table.setRowHeight(50);
		        table.getColumnModel().getColumn(0).setPreferredWidth(10);
		        for(int i=0;i<5;i++) {
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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				loadsp1();
			}
		});
		btnLmMi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLmMi.setMnemonic(KeyEvent.VK_JAPANESE_KATAKANA);
		btnLmMi.setHorizontalTextPosition(SwingConstants.LEFT);
		btnLmMi.setFocusable(false);
		btnLmMi.setFocusTraversalPolicyProvider(true);
		btnLmMi.setFocusCycleRoot(true);
		panel_1.setLayout(new MigLayout("", "[154px][8px][326px][20px][79px][10px][79px]", "[31px][33px]"));
		panel_1.add(lblNewLabel, "cell 0 0 7 1,growx,aligny top");
		panel_1.add(lblNewLabel_1, "cell 0 1,alignx left,aligny center");
		panel_1.add(textField, "cell 2 1,growx,aligny center");
		panel_1.add(btnNewButton, "cell 4 1,alignx left,aligny top");
		panel_1.add(btnLmMi, "cell 6 1,grow");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách khách hàng:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableMouseClicked(evt);}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin khách hàng:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_4 = new JLabel("Tên khách hàng:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_5 = new JLabel("Địa chỉ:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_6 = new JLabel("Số điện thoại:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					khachhangBLL spBLL = new khachhangBLL();
					kh = new khachhang();
					if(textField_1.getText().isEmpty() || textField_3.getText().isEmpty() || textField_2.getText().isEmpty() || textField_4.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin");
						return;
					}
					float u = Float.parseFloat(textField_3.getText().trim());
					kh.setTenkh(textField_1.getText());
					kh.setDiachi(textField_2.getText());
					kh.setSdt(textField_3.getText());
					kh.setEmail(textField_4.getText());
					JOptionPane.showMessageDialog(null,spBLL.them(kh));
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					loadsp1();
					} catch(Exception q) {
						JOptionPane.showMessageDialog(null,"Số điện thoại phải là kiểu số");
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
						JOptionPane.showMessageDialog(null,"Vui lòng chọn khách hàng cần cập nhật");
						return;
					}
					if(textField_1.getText().isEmpty() || textField_3.getText().isEmpty() || textField_2.getText().isEmpty() || textField_4.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin");
						return;
					}
					float u = Float.parseFloat(textField_3.getText().trim());
					khachhangBLL spBLL = new khachhangBLL();
					kh = new khachhang();
					kh.setMakh(Integer.parseInt(textField_5.getText().trim()));
					kh.setTenkh(textField_1.getText());
					kh.setDiachi(textField_2.getText());
					kh.setSdt(textField_3.getText().trim());
					kh.setEmail(textField_4.getText().trim());
					JOptionPane.showMessageDialog(null,spBLL.capnhat(kh));
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					loadsp1();
					} catch(Exception q) {
						JOptionPane.showMessageDialog(null,"Số điện thoại phải là kiểu số");
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
					JOptionPane.showMessageDialog(null,"Vui lòng chọn khách hàng cần xóa");
					return;
				}
				khachhangBLL spBLL = new khachhangBLL();
				kh = new khachhang();
				kh.setMakh(Integer.parseInt(textField_5.getText().trim()));
				JOptionPane.showMessageDialog(null,spBLL.xoa(kh));
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				loadsp1();
			}
		});
		btnNewButton_1_2.setFocusable(false);
		btnNewButton_1_2.setIcon(new ImageIcon(dsspview.class.getResource("/img/delete.png")));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblNewLabel_8 = new JLabel("Mã khách hàng:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.setLayout(new MigLayout("", "[115px][16px][86px,grow][71px][107px][147px][134px]", "[22px][161px][22px][19px][20px][19px][20px][20px][33px]"));
		panel_2.add(lblNewLabel_2, "cell 0 0 3 1,alignx left,aligny top");
		panel_2.add(scrollPane, "cell 0 1 7 1,grow");
		panel_2.add(lblNewLabel_3, "cell 0 2 3 1,alignx left,aligny top");
		panel_2.add(lblNewLabel_8, "cell 0 3,alignx center,aligny center");
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		panel_2.add(textField_5, "cell 2 3,growx");
		textField_5.setColumns(10);
		panel_2.add(textField_1, "cell 2 4 3 1,growx,aligny bottom");
		panel_2.add(textField_2, "cell 2 5 3 1,growx,aligny top");
		panel_2.add(lblNewLabel_6, "cell 0 6,alignx center,aligny top");
		panel_2.add(lblNewLabel_4, "cell 0 4,alignx left,aligny top");
		panel_2.add(lblNewLabel_5, "cell 0 5,alignx center,aligny top");
		panel_2.add(textField_3, "cell 2 6 3 1,growx,aligny bottom");
		panel_2.add(lblNewLabel_7, "cell 0 7,alignx center,aligny top");
		panel_2.add(textField_4, "cell 2 7 3 1,growx,aligny bottom");
		panel_2.add(btnNewButton_1, "cell 0 8 3 1,alignx center,aligny top");
		panel_2.add(btnNewButton_1_1, "cell 4 8,alignx left,aligny top");
		panel_2.add(btnNewButton_1_2, "cell 6 8,alignx left,aligny top");
		
		//this.setVisible(true);
	}
	
	public void loadsp1() {
		khachhangBLL spbll = new khachhangBLL();
		arr = spbll.getAllkhachhang();
		String[] columnName = {"Mã","Tên","Địa chỉ","Số điện thoại","Email"};
        Object[][] rows = new Object[arr.size()][5];
        for(int i = 0; i < arr.size(); i++){
            rows[i][0] = arr.get(i).getMakh();
            rows[i][1] = arr.get(i).getTenkh();
            rows[i][2] = arr.get(i).getDiachi();
            rows[i][3] = arr.get(i).getSdt();
            rows[i][4] = arr.get(i).getEmail();
        }
        textField.setText(null);
        model = new TheModel(rows, columnName);
        table.setModel(model);
        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        for(int i=0;i<5;i++) {
        	TableColumn col = table.getColumnModel().getColumn(i);
        	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  
        	dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        	col.setCellRenderer(dtcr);
        }
    }
	
	 private void tableMouseClicked(java.awt.event.MouseEvent evt) {
		 try {
		 int i = table.getSelectedRow();
		 // Display Slected Row In JTexteFields
		 textField_5.setText(model.getValueAt(i,0).toString());
		 textField_1.setText(model.getValueAt(i,1).toString());
		 textField_2.setText(model.getValueAt(i,2).toString());
		 textField_3.setText(model.getValueAt(i,3).toString());
		 textField_4.setText(model.getValueAt(i,4).toString());
	    } catch (Exception e) {
	    }
	 }
}
