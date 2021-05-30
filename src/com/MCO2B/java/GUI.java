package com.MCO2B.java;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class GUI {

		//Properties
		
		protected JFrame frame;
		protected ImageIcon windowIcon; 
		protected JLayeredPane LP;
		protected JButton back;
		
		//Constructors
		
		public GUI(int x_size, int y_size, String window_name){
			
			this.frame = new JFrame();
			this.windowIcon = new ImageIcon("src/Image_Assets/window_icon.png");
			this.LP = new JLayeredPane();
			this.back = new JButton();
			
			this.frame.setSize(x_size,y_size);
			this.frame.setIconImage(windowIcon.getImage());
			this.frame.setTitle(window_name);
			this.frame.setResizable(false);
			this.frame.setLocationRelativeTo(null);
			this.frame.setLayout(new BorderLayout());
			//this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
			this.frame.add(LP);
			
			this.LP.setBounds(0,0, x_size, y_size);
		}
		
		public JButton getBackButton() {
			return this.back;
		}
		
		public void addBackButton(int x_coord, int y_coord, int order) {
			
			  JLabel backlogo = new JLabel();
			  ImageIcon backicon = new ImageIcon("src/Image_Assets/back_icon.png");
			  
	  		  this.LP.add(backlogo, Integer.valueOf(order+1));
	  		  backlogo.setIcon(backicon);
	  		  backlogo.setBounds(x_coord,y_coord,100,100);
					
	  		  this.LP.add(back, Integer.valueOf(order));
	  		  back.setText("Back");
	  		  back.setBounds(x_coord+25, y_coord+25, 150, 50);
	  		  back.setBackground(new Color(0xA6A6A6));
	  		  back.setFocusable(false);

		}
		
		public void frameToggler() {
			
				if(this.frame.isVisible() == true) {
					this.frame.setVisible(false);
				}else if (this.frame.isVisible() == false){
					this.frame.setVisible(true);
				}
				
		}
	
		
		
		
}
