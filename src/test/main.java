package test;

import GUI.dskhview;
import GUI.dsspview;

public class main {
	public static void main(String[] args) {
		// test san pham
		dsspview frm = new dsspview();
		frm.loadsp1();
		frm.setVisible(true);
		
		// test khach hang
		dskhview frm1 = new dskhview();
		frm1.loadsp1();
		frm1.setVisible(true);
	}
}
