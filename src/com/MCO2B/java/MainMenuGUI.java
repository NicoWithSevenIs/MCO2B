package com.MCO2B.java;

import java.awt.Color;

import javax.swing.*;

public class MainMenuGUI extends GUI{
	
	//properties
	
	  private JButton adventureButton;
	  private JButton inventoryButton;
	  private JButton drawButton;
	  private JButton mergeButton;
	  private JButton exitButton;
	  
	  private ImageIcon logoImage;
	  private ImageIcon adventureImage;
	  private ImageIcon inventoryImage;
	  private ImageIcon drawImage;
	  private ImageIcon mergeImage;
	  private ImageIcon exitImage;
	  private ImageIcon refinaImage;
	  private ImageIcon animaImage;
	  private ImageIcon alertIcon;
	  
	  private JLabel gameLogo;
	  private JLabel adventureIcon;
	  private JLabel inventoryIcon;
	  private JLabel drawIcon;
	  private JLabel mergeIcon;
	  private JLabel exitIcon;
	
	  private JLabel refinaMainDisplay;
	  private JLabel animaMainDisplay;
	
	
	//constructors
		  
	  public MainMenuGUI() {
		super(512, 750, "Gacha Simulator");
			
		  adventureButton = new JButton();
		  inventoryButton = new JButton();
		  drawButton = new JButton();
		  mergeButton = new JButton();
		  exitButton = new JButton();
		  
		  logoImage = new ImageIcon("src/Image_Assets/logo.png");
		  adventureImage = new ImageIcon("src/Image_Assets/adventure_icon.png");
		  inventoryImage = new ImageIcon("src/Image_Assets/inventory_icon.png");
		  drawImage = new ImageIcon("src/Image_Assets/draw_icon.png");
		  mergeImage = new ImageIcon("src/Image_Assets/merge_icon.png");
		  exitImage = new ImageIcon("src/Image_Assets/exit_icon.png");
		  refinaImage = new ImageIcon("src/Image_Assets/refina_icon.png");
		  animaImage = new ImageIcon("src/Image_Assets/anima_icon.png");
		  alertIcon = new ImageIcon("src/Image_Assets/warning_icon.png");
		  
		  gameLogo = new JLabel();
		  adventureIcon = new JLabel();
		  inventoryIcon = new JLabel();
		  drawIcon = new JLabel();
		  mergeIcon = new JLabel();
		  exitIcon = new JLabel();
		
		  refinaMainDisplay = new JLabel();
		  animaMainDisplay = new JLabel();
		
		this.InitializeMenu();
		
	}
	
	//methods

	  public void initializeMainMenuButton(JLabel param_label, JButton param_button, 
			  int button_y_coord,  String Label, ImageIcon param_image, int x_coord, int y_coord,
			  int icon_order, int order) {
		  
		
		  param_label.setIcon(param_image);
		  param_label.setBounds(x_coord,y_coord,100,100);
		  super.LP.add(param_label, Integer.valueOf(order+1));
		  
		  param_button.setText(Label);
		  param_button.setFocusable(false);
		  param_button.setBounds(150,button_y_coord,250,50);
		  param_button.setBackground(new Color(0xA6A6A6));
		  super.LP.add(param_button, Integer.valueOf(order));
		  
	  }
	  
	  //getters and setters for JButtons
	  public JButton getAdvButton() {
			return this.adventureButton;
	  }
		
	  public JButton getInvButton() {
			return this.inventoryButton;
	  }
	
	  public JButton getGmButton() {
			return this.drawButton;
	  }
		
	  public JButton getMrgButton() {
			return this.mergeButton;
	  }
		
	  public void InitializeMenu() {
			  
			  super.LP.add(gameLogo);
			  gameLogo.setIcon(logoImage); 
			  gameLogo.setBounds(100,10,300,175);	
			  
			  super.LP.add(this.animaMainDisplay);
			  this.animaMainDisplay.setIcon(animaImage);
			  this.animaMainDisplay.setIconTextGap(25);
			  this.animaMainDisplay.setHorizontalTextPosition(JLabel.RIGHT);
			  this.animaMainDisplay.setBounds(75,193,124,64);
			  
			  super.LP.add(this.refinaMainDisplay);
			  this.refinaMainDisplay.setIcon(refinaImage);
			  this.refinaMainDisplay.setIconTextGap(25);
			  this.refinaMainDisplay.setHorizontalTextPosition(JLabel.RIGHT);
			  this.refinaMainDisplay.setBounds(315,175,175,100);
			  
			  initializeMainMenuButton(adventureIcon, adventureButton, 300, "ADVENTURE", adventureImage, 90, 275, 10, 9);
			  initializeMainMenuButton(inventoryIcon, inventoryButton, 375, "INVENTORY", inventoryImage, 100, 347, 8, 7);		 	  
			  initializeMainMenuButton(drawIcon, drawButton, 450, "ADVENTURER'S GUILD", drawImage, 90, 425, 6, 5);		  		 		  		  
			  initializeMainMenuButton(mergeIcon, mergeButton, 525, "ANCIENT TEMPLE", mergeImage, 100, 500, 4, 3);		  
			  initializeMainMenuButton(exitIcon, exitButton, 600, "EXIT", exitImage, 100, 575, 2, 1);			  		  
			  
			  exitButton.addActionListener(e-> {
			  		if(JOptionPane.showOptionDialog(null, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, alertIcon, null, 1) == 0) {
			  			System.exit(0);
			  		}
			  });
			 
			  
		}
		
	  public void menuToggler(int refina, int anima) {
			  
			 super.frameToggler();
			  
			 this.refinaMainDisplay.setText("" + refina);
			 this.animaMainDisplay.setText("" + anima);	
	  }
	  
	  
	}
