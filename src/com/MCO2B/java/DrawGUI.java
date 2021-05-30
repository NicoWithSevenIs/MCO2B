package com.MCO2B.java;

import java.awt.*;

import javax.swing.*;

public class DrawGUI extends GUI{

	private JLabel animaGachaDisplay;
	private JLabel displayCost1C;
	private JLabel displayCost10C;
	private JLabel displayCost1W;
	private JLabel displayCost10W;
	
	private JButton drawSingleChar;
	private JButton drawTenChar;
	private JButton drawSingleWeap;
	private JButton drawTenWeap;
	
	private ImageIcon singleCharIcon;
	private ImageIcon tenCharIcon;
	private ImageIcon singleWeapIcon;
	private ImageIcon tenWeapIcon;
	private ImageIcon Cost;
	
	public DrawGUI() {
		super(800, 512, "Adventurer's Guild");
		
		animaGachaDisplay = new JLabel();
		 displayCost1C = new JLabel();
		 displayCost10C = new JLabel();
		 displayCost1W = new JLabel();
		 displayCost10W = new JLabel();
		
		 
		 drawSingleChar = new JButton();
		 drawTenChar = new JButton();
		 drawSingleWeap = new JButton();
		 drawTenWeap = new JButton();
		
		 singleCharIcon = new ImageIcon("src/Image_Assets/drawSingleChar_icon.png");
		 tenCharIcon = new ImageIcon("src/Image_Assets/drawTenChar_icon.png");
		 singleWeapIcon = new ImageIcon("src/Image_Assets/drawSingleWeap_icon.png");
		 tenWeapIcon = new ImageIcon("src/Image_Assets/drawTenWeap_icon.png");
		 Cost = new ImageIcon("src/Image_Assets/anima_icon.png");
		
		 InitializeGachaMachine();
	}
	
	public JButton getSingleCharacterDraw() {
		return this.drawSingleChar;
	}
	
	public JButton getSingleWeaponDraw() {
		return this.drawSingleWeap;
	}
	
	public JButton getTenCharacterDraw() {
		return this.drawTenChar;
	}
	
	public JButton getTenWeaponDraw() {
		return this.drawTenWeap;
	}


	public void InitializeDrawButton(JButton param_button, ImageIcon param_icon, 
				int x_coord, int order, int gap,  String label, JLabel param_price, ImageIcon param_currency, String param_cost) {	
			
		super.LP.add(param_price, Integer.valueOf(order+1));
			param_price.setIcon(param_currency);
			param_price.setText(param_cost);
			param_price.setIconTextGap(30);
			param_price.setBounds(x_coord+5,265,150,100);
			
			super.LP.add(param_button, Integer.valueOf(order));
			param_button.setBounds(x_coord,150,150,150);
			param_button.setBackground(new Color(0xA6A6A6));
			param_button.setFocusable(false);
			param_button.setIcon(param_icon);
			param_button.setText(label);
			param_button.setVerticalTextPosition(JButton.BOTTOM);
			param_button.setHorizontalTextPosition(JButton.CENTER);
			param_button.setIconTextGap(gap);
			
	}
	
	public void InitializeGachaMachine(){
		
		super.LP.add(animaGachaDisplay, Integer.valueOf(11));
		animaGachaDisplay.setIcon(Cost);
		animaGachaDisplay.setIconTextGap(30);
		animaGachaDisplay.setBounds(50,50, 150,100);
		
		InitializeDrawButton(drawSingleChar, singleCharIcon, 55, 8, 10, "Draw 1 Hero!", displayCost1C, Cost, "300");
		
		InitializeDrawButton(drawTenChar, tenCharIcon, 230, 6, 30, "Draw 10 Heroes!", displayCost10C, Cost, "2700");

		InitializeDrawButton(drawSingleWeap, singleWeapIcon, 405, 4, 10, "Draw 1 Weapon!", displayCost1W, Cost, "300");
		
		InitializeDrawButton(drawTenWeap, tenWeapIcon, 580, 2, 30, "Draw 10 Weapons!", displayCost10W, Cost, "2700");
		
		super.addBackButton(25, 370, 0);
	}

	 public void drawToggler(int anima) {
			 super.frameToggler();
			 refreshAnima(anima);
	  }
	 
	 public void refreshAnima(int anima) {
		 this.animaGachaDisplay.setText("" + anima);
	 }
	  
}
