package com.MCO2B.java;

import java.awt.*;
import javax.swing.*;

public class InventoryGUI extends GUI{

	private JButton viewCharInv;
	private JButton viewWeapInv;
	
	private ImageIcon charInvIcon;
	private ImageIcon weaponInvIcon;
	
	private JLabel charlogo;
	private JLabel weaplogo;
	
	public InventoryGUI() {
		super(512, 325, "Inventory");

		viewCharInv = new JButton();
		viewWeapInv = new JButton();
		
		charlogo = new JLabel();
		weaplogo = new JLabel();
		
		charInvIcon = new ImageIcon("src/Image_Assets/CharacterInv_icon.png");
		weaponInvIcon = new ImageIcon("src/Image_Assets/WeaponInv_icon.png");
		
		InitializeInventoryGUI();
	}

	public JButton getCharInv() {
		return viewCharInv;
	}
	
	public JButton getWeapInv() {
		return viewWeapInv;
	}
	
	public void InitializeInventoryGUI() {
		
		super.LP.add(charlogo, Integer.valueOf(5));
		charlogo.setIcon(charInvIcon);
		charlogo.setBounds(40,5,100,200);
		
		super.LP.add(viewCharInv, Integer.valueOf(4));
		viewCharInv.setText("Characters");
		viewCharInv.setBackground(new Color(0xA6A6A6));
		viewCharInv.setFocusable(false);
		viewCharInv.setBounds(80,100,150,50);
		
		super.LP.add(weaplogo, Integer.valueOf(3));
		weaplogo.setIcon(weaponInvIcon);
		weaplogo.setBounds(275,8,100,200);
		
		super.LP.add(viewWeapInv, Integer.valueOf(2));
		viewWeapInv.setText("Weapons");
		viewWeapInv.setBackground(new Color(0xA6A6A6));
		viewWeapInv.setFocusable(false);
		viewWeapInv.setBounds(300,100,150,50);

		super.addBackButton(25,190,0);
	}
	
}
