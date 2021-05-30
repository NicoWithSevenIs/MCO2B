package com.MCO2B.java;

import javax.swing.*;
import java.awt.*;

public class MergerGUI extends GUI{

	private JButton mergeChar;
	private JButton mergeWeap;

	private ImageIcon mergeCharIcon;
	private ImageIcon mergeWeapIcon;
	
	private JLabel charMergelogo;
	private JLabel weapMergelogo;
	
	public MergerGUI() {
		super(512, 325, "Ancient Temple");
		
		 mergeChar = new JButton();
		 mergeWeap = new JButton();

		 mergeCharIcon = new ImageIcon("src/Image_Assets/charMerge_icon.png");
		 mergeWeapIcon = new ImageIcon("src/Image_Assets/weapMerge_icon.png");
		
		 charMergelogo = new JLabel();
		 weapMergelogo = new JLabel();
		
		InitializeMerger();
	}
	
	public JButton getCharMergeButton() {
		return this.mergeChar;
	}
	
	public JButton getWeapMergeButton() {
		return this.mergeWeap;
	}
	
	public void InitializeMerger() {
		
		super.LP.add(charMergelogo, Integer.valueOf(6));
		charMergelogo.setIcon(mergeCharIcon);
		charMergelogo.setBounds(40,2,100,200);
		
		super.LP.add(mergeChar, Integer.valueOf(5));
		mergeChar.setText("Merge Characters");
		mergeChar.setBackground(new Color(0xA6A6A6));
		mergeChar.setFocusable(false);
		mergeChar.setBounds(80,100,150,50);
		
		super.LP.add(weapMergelogo, Integer.valueOf(4));
		weapMergelogo.setIcon(mergeWeapIcon);
		weapMergelogo.setBounds(275,8,100,200);
		
		super.LP.add(mergeWeap, Integer.valueOf(3));
		mergeWeap.setText("Merge Weapons");
		mergeWeap.setBackground(new Color(0xA6A6A6));
		mergeWeap.setFocusable(false);
		mergeWeap.setBounds(300,100,150,50);
		
		super.addBackButton(25, 190, 0);
		
	}

}
