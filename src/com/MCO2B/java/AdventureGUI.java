package com.MCO2B.java;

import java.awt.*;
import javax.swing.*;

public class AdventureGUI extends GUI {

	//properties
	
	  private JLabel UG;
	  private JLabel FOE;
	  private JLabel SOH;
	  private JLabel CPL;
	  private JLabel TOE;
	  
	  private ImageIcon UGIcon;
	  private ImageIcon FOEIcon;
	  private ImageIcon SOHIcon;
	  private ImageIcon TOEIcon;
	  private ImageIcon CPLIcon;
	  
	  private JButton pickCPL;
	  private JButton viewCPLEnemies;
	  private JButton pickTOE;
	  private JButton viewTOEEnemies;
	  private JButton pickSOH;
	  private JButton viewSOHEnemies;
	  private JButton pickFOE;
	  private JButton viewFOEEnemies;
	  private JButton pickUG;
	  private JButton viewUGEnemies;
	  
	  private JScrollPane scroll;
	

	
	 public AdventureGUI() {
		super(532, 720, "Adventure");
		super.LP.setPreferredSize(new Dimension(512,1000));
		
		
		//Underground caverns
		   UG = new JLabel();
		   UGIcon = new ImageIcon("src/Image_Assets/UG_icon.png");
		   pickUG = new JButton();
		   viewUGEnemies = new JButton();
		  
		  //Forest of Enchantments
		  
		   FOE = new JLabel();
		   FOEIcon = new ImageIcon("src/Image_Assets/FOE_icon.png");
		   pickFOE = new JButton();
		   viewFOEEnemies = new JButton();
		  
		  //Sea of Hope
		  
		   SOH = new JLabel();
		   SOHIcon = new ImageIcon("src/Image_Assets/SOH_icon.png");
		   pickSOH = new JButton();
		   viewSOHEnemies = new JButton();
		  
		  //Tower of Ether
		  
		   TOE = new JLabel();
		   TOEIcon = new ImageIcon("src/Image_Assets/TOE_icon.png");
		   pickTOE = new JButton();
		   viewTOEEnemies = new JButton();
		  
		  //Celestial Plane
		  
		   CPL = new JLabel();
		   CPLIcon = new ImageIcon("src/Image_Assets/CPL_icon.png");
		   pickCPL = new JButton();
		   viewCPLEnemies = new JButton();
		
		scroll = new JScrollPane(LP, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getVerticalScrollBar().setUnitIncrement(20);	
		super.frame.add(scroll);

		InitializeAdventureGUI();
		
	  }

	  public JButton pickUGAdv() {
		  return this.pickUG;
	  }
	  
	  public JButton pickFOEAdv() {
		  return this.pickFOE;
	  }
	  
	  public JButton pickSOHAdv() {
		  return this.pickSOH;
	  }
	  
	  public JButton pickTOEAdv() {
		  return this.pickTOE;
	  }
	  
	  public JButton pickCPLAdv() {
		  return this.pickCPL;
	  }
	  
	  public JButton getUGEnemies() {
		  return viewUGEnemies; 
	  }
	  
	  public JButton getFOEEnemies() {
		  return viewFOEEnemies; 
	  }
	  
	  public JButton getSOHEnemies() {
		  return viewSOHEnemies; 
	  }
	  
	  public JButton getTOEEnemies() {
		  return viewTOEEnemies; 
	  }
	  
	  public JButton getCPLEnemies() {
		  return viewCPLEnemies; 
	  }
	  
	 public void InitializeAdvButton(JLabel param_bg, JButton param_adv, JButton param_enemy, 
			  ImageIcon param_icon, int icon_y_coord, int order, String label, int map_index) {
		
			super.LP.add(param_bg, Integer.valueOf(order));
			param_bg.setIcon(param_icon);
			param_bg.setBounds(22,icon_y_coord,500,200);
			param_bg.setIconTextGap(10);
			
			super.LP.add(param_adv, Integer.valueOf(order-1));
			param_adv.setText(label);
			param_adv.setBounds(22, icon_y_coord+160, 300, 35);
			param_adv.setBackground(new Color(0xA6A6A6));
			param_adv.setFocusable(false);

			
			super.LP.add(param_enemy, Integer.valueOf(order-2));
			param_enemy.setText("View Enemies");
			param_enemy.setBounds(335, icon_y_coord+160, 138, 35);
			param_enemy.setBackground(new Color(0xA6A6A6));
			param_enemy.setFocusable(false);
		
	  	}
	  
	 public void InitializeAdventureGUI() {
		
		InitializeAdvButton(UG, pickUG, viewUGEnemies, UGIcon, 75, 10, "Underground Caverns", 0);
		
		InitializeAdvButton(FOE, pickFOE, viewFOEEnemies, FOEIcon, 245, 8, "Forest of Enchantments", 1);
		
		InitializeAdvButton(SOH, pickSOH, viewSOHEnemies, SOHIcon, 415, 6, "Sea of Hope", 2);
		
		InitializeAdvButton(TOE, pickTOE, viewTOEEnemies, TOEIcon, 585, 4, "Tower of Ether", 3);
		
		InitializeAdvButton(CPL, pickCPL, viewCPLEnemies, CPLIcon, 755, 2, "Celestial Plane", 4);
		
		this.addBackButton(20,15,0);
		
	}
	  
}
