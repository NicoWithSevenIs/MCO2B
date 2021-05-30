package com.MCO2B.java;

import java.awt.Color;

import javax.swing.*;
public class CharSelectAdvGUI extends GUI {

	private ImageIcon mapIcon;
	private ImageIcon startADVIcon;
	private JLabel startADVlogo;
	private JLabel maplogo;
	private JComboBox<String> firstChar;
	private JComboBox<String> secondChar;
	private JButton startADV;
	
	public CharSelectAdvGUI(String param_mapName, String param_landscape) {
		super(495, 365, param_mapName);
		
		mapIcon = new ImageIcon(param_landscape);
		maplogo = new JLabel();
		firstChar = new JComboBox<String>();
		secondChar = new JComboBox<String>();
		startADV = new JButton();
		startADVIcon = new ImageIcon("src/Image_Assets/WeaponInv_icon.png");
		startADVlogo = new JLabel();
		
		super.LP.add(maplogo, Integer.valueOf(6));
		maplogo.setIcon(mapIcon);
		maplogo.setBounds(15,15, 500, 100);

		JLabel SelectTip = new JLabel();
		super.LP.add(SelectTip, Integer.valueOf(5));
		SelectTip.setBounds(175,95, 200,100);
		SelectTip.setText("Choose your Heroes!");
		
		super.LP.add(firstChar, Integer.valueOf(4));
		firstChar.setBounds(25,185, 200, 25);
		
		super.LP.add(secondChar, Integer.valueOf(3));
		secondChar.setBounds(250,185, 200, 25);
		
		super.addBackButton(25, 225, 2);
		
		super.LP.add(startADVlogo, Integer.valueOf(1));
		startADVlogo.setIcon(startADVIcon);
		startADVlogo.setBounds(415,200,100,150);
		
		super.LP.add(startADV, Integer.valueOf(0));
		startADV.setText("Start Adventure!");
		startADV.setBounds(260, 250 , 175, 50);
		startADV.setBackground(new Color(0xA6A6A6));
		startADV.setFocusable(false);
	
	}
	
	public JButton getStartADV() {
		return this.startADV;
	}
	
	public JComboBox<String> getFirstCharComboBox() {
		return this.firstChar;
	}
	
	public JComboBox<String> getSecondCharComboBox() {
		return this.secondChar;
	}
	
	

}
