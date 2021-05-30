package com.MCO2B.java;

import java.awt.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InventoryListGUI extends GUI {
	
	private ImageIcon charInvIcon;
	private ImageIcon weapInvIcon;
	private JLabel viewlogo;
	private JButton view;
	private boolean CharOrWeap;
	
	private String[] columnNames = {"ID", "Rarity", "Name", "Level"};
	private JTable CharInv;
	private DefaultTableModel model;
	private JScrollPane scroll;
	
	private JPanel nested;
	private JComboBox<String> Invlist;
	
	public InventoryListGUI(boolean param_CharOrWeap) {
		super(752, 512, "Inventory");
		
		this.CharOrWeap = param_CharOrWeap;
		
		CharInv = new JTable();
		model = new DefaultTableModel(columnNames, 0);
		nested = new JPanel();
		Invlist = new JComboBox<String>();

		
		super.LP.add(Invlist);
		Invlist.setBounds(250, 315, 200, 25);
		
		super.LP.add(nested);
		nested.setBounds(20,15,700,290);
		
		nested.add(CharInv, Integer.valueOf(5));
		nested.setLayout(new BorderLayout());
		CharInv.setModel(model);
	
		scroll = new JScrollPane(CharInv, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getVerticalScrollBar().setUnitIncrement(20);	
		nested.add(scroll);
		
		charInvIcon = new ImageIcon("src/Image_Assets/CharacterInv_icon.png");
		weapInvIcon = new ImageIcon("src/Image_Assets/WeaponInv_icon.png");	
		viewlogo = new JLabel();
		view = new JButton();
		
		InitializeCharInv();
		
		super.addBackButton(150,375, 0);
	}
	public JComboBox<String> getComboBox() {
		return this.Invlist;
	}
	public DefaultTableModel getTableModel() {
		return this.model;
	}
	
	public JButton getView() {
		return this.view;
	}
	
	public void InitializeCharInv() {
		LP.add(viewlogo, Integer.valueOf(3));
		
		if(this.CharOrWeap == true) {
			viewlogo.setIcon(charInvIcon);
		}else {
			viewlogo.setIcon(weapInvIcon);
		}
		
		viewlogo.setBounds(375,355,100,100);
		
		LP.add(view, Integer.valueOf(2));
		view.setText("View");
		view.setBounds(400, 400, 150, 50);
		view.setBackground(new Color(0xA6A6A6));
		view.setFocusable(false);
		
	}
}
