package com.MCO2B.java;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ViewerGUI extends GUI{
	
	  private JButton reroll;
	  private JButton hone;
	  private JButton levelUp;
	  private JButton equip;
	  private JButton unequip;
	  
	  private JPanel viewerContainer;
	  private JTable viewer;
	  private DefaultTableModel model;
	  private JScrollPane scroll;
	  
	  private JLabel honelogo;
	  private JLabel rerolllogo;
	  private JLabel levelUplogo;
	  private JLabel equiplogo;
	  private JLabel unequiplogo;
	  private JLabel refinalogo;
	  
	  private ImageIcon levelUpIcon;
	  private ImageIcon equipIcon;
	  private ImageIcon unequipIcon;
	  private ImageIcon honeIcon;
	  private ImageIcon rerollIcon;
	  private ImageIcon refinaIcon;
	  
	  
	public ViewerGUI() {
		super(512,512, "View");

		 reroll = new JButton();
		 hone = new JButton();
		 levelUp = new JButton();
		 equip = new JButton();
		 unequip = new JButton();
		 
		 honelogo = new JLabel();
		 rerolllogo = new JLabel();
		 levelUplogo = new JLabel();
		 equiplogo = new JLabel();
		 unequiplogo = new JLabel();
		 refinalogo = new JLabel();
		
		 levelUpIcon = new ImageIcon("src/Image_Assets/levelUp_icon.png");
		 equipIcon = new ImageIcon("src/Image_Assets/equip_icon.png");
		 unequipIcon = new ImageIcon("src/Image_Assets/unequip_icon.png");
		 honeIcon = new ImageIcon("src/Image_Assets/Hone_icon.png");
		 rerollIcon = new ImageIcon("src/Image_Assets/reroll_icon.png");
		 refinaIcon = new ImageIcon("src/Image_Assets/refina_icon.png");
		 
		 super.LP.add(refinalogo);
		 refinalogo.setIcon(refinaIcon);
		 refinalogo.setBounds(25, 15, 200, 100);
		 refinalogo.setIconTextGap(25);
		 refinalogo.setHorizontalTextPosition(JLabel.RIGHT);
		 
		 viewerContainer = new JPanel();
		 viewer = new JTable();
		 model = new DefaultTableModel();
		 scroll = new JScrollPane();
		 
		 super.LP.add(viewerContainer);
		 viewerContainer.setBounds(25, 115, 215, 235);
		 viewerContainer.setLayout(new BorderLayout());
		 
		 viewer.setModel(model);
		 model.addColumn("Unit Info");
		 
		 scroll = new JScrollPane(viewer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 scroll.getVerticalScrollBar().setUnitIncrement(20);	
		 viewerContainer.add(scroll);
		 
		 initializeViewer();
		
	}

		public void updateRefina(int param_refina) {
			this.refinalogo.setText("" + param_refina);
		}
		
		
		public void initializeViewer() {
			
			super.LP.add(levelUplogo, Integer.valueOf(7));
			levelUplogo.setIcon(levelUpIcon);
			levelUplogo.setBounds(270,115,100,100);
			
			super.LP.add(levelUp, Integer.valueOf(6));
			levelUp.setText("Level Up");
			levelUp.setBounds(300, 155, 150, 35);
			levelUp.setBackground(new Color(0xA6A6A6));
			levelUp.setFocusable(false);
			
			super.LP.add(equiplogo, Integer.valueOf(5));
			equiplogo.setIcon(equipIcon);
			equiplogo.setBounds(265,180,100,100);
			
			super.LP.add(equip, Integer.valueOf(4));
			equip.setText("Equip");
			equip.setBounds(300, 230, 150, 35);
			equip.setBackground(new Color(0xA6A6A6));
			equip.setFocusable(false);
			
			super.LP.add(unequiplogo, Integer.valueOf(3));
			unequiplogo.setIcon(unequipIcon);
			unequiplogo.setBounds(275,265,100,100);
			
			super.LP.add(unequip, Integer.valueOf(2));
			unequip.setText("Unequip");
			unequip.setBounds(300, 305, 150, 35);
			unequip.setBackground(new Color(0xA6A6A6));
			unequip.setFocusable(false);
			
			super.addBackButton(25, 375, 0);
		}
		
		public DefaultTableModel getModel() {
			return this.model;
		}
		
		public JButton getHone() {
			return this.hone;
		}
		
		public JButton getReroll() {
			return this.reroll;
		}
		
		public JButton getLevelUp() {
			return this.levelUp;
		}
		
		public JButton getEquip() {
			return this.equip;
		}
		
		public JButton getUnequip() {
			return this.unequip;
		}
		
		public void addHone() {
			
			super.LP.add(honelogo, Integer.valueOf(7));
			honelogo.setIcon(honeIcon);
			honelogo.setBounds(270,50,100,100);
			
			super.LP.add(hone, Integer.valueOf(6));
			hone.setText("Hone");
			hone.setBounds(300, 85, 150, 35);
			hone.setBackground(new Color(0xA6A6A6));
			hone.setFocusable(false);
			
			
		}
		
		public void addReroll() {
			
			super.LP.add(rerolllogo, Integer.valueOf(7));
			rerolllogo.setIcon(rerollIcon);
			rerolllogo.setBounds(270,50,100,100);
			
			super.LP.add(reroll, Integer.valueOf(6));
			reroll.setText("Reroll");
			reroll.setBounds(300, 85, 150, 35);
			reroll.setBackground(new Color(0xA6A6A6));
			reroll.setFocusable(false);
			
		}
		
}