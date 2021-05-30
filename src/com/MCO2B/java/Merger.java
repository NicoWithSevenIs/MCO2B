package com.MCO2B.java;

import javax.swing.*;

public class Merger{
	  //properties

	  //constructors

	  //methods
	
	  public boolean SameKindValidity(String name1, String name2, String name3){

		ImageIcon errorIcon = new ImageIcon("src/Image_Assets/error_icon.png");
	    if(name1 == name2 && name2 == name3){
	      return true;
	    }else{
	      JOptionPane.showMessageDialog(null, "Components are different!", "Unsuccessful!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );
	    }

	    return false;    
	  }

	  public boolean RarityValidity(int rarity1, int rarity2, int rarity3){
		ImageIcon errorIcon = new ImageIcon("src/Image_Assets/error_icon.png");
	    if(rarity1 == rarity2 && rarity2 == rarity3){
	      if(rarity1 < 5){
	        return true;
	      }else{
	    	  
	    	  JOptionPane.showMessageDialog(null, "Components are already at maximum rarity", "Unsuccessful!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );
	      }
	      
	    }else{
	      JOptionPane.showMessageDialog(null, " Components do not have same rarity!", "Unsuccessful!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );
	    }
	

	    return false;
	  }
	  
	 
	  public void unequipForMerging(Character param_char){
		  
		ImageIcon alertIcon = new ImageIcon("src/Image_Assets/warning_icon.png");
		
	    if(param_char.checkEquip() == true){
	    	JOptionPane.showMessageDialog(null, param_char.getName() + " has an equipped weapon!", "Unsuccessful!",  JOptionPane.INFORMATION_MESSAGE, alertIcon );

	        param_char.unequipWeapon();
	    }

	  }

	  public void unequipForMerging(Weapon param_weapon){
		ImageIcon alertIcon = new ImageIcon("src/Image_Assets/warning_icon.png");
		  
	    if(param_weapon.getHolder() != null){

	      if(param_weapon.getHolder().checkEquip() == true){

	    	JOptionPane.showMessageDialog(null,param_weapon.getName() + " is equipped by " + param_weapon.getHolder().getName(), "Unsuccessful!",  JOptionPane.INFORMATION_MESSAGE, alertIcon );
	        param_weapon.getHolder().unequipWeapon();

	      }

	    }
	    
	  }

	 
	  public void CharacterMerge(Character param_ascendant, Character param_fodder1, Character param_fodder2){
		  ImageIcon alertIcon = new ImageIcon("src/Image_Assets/warning_icon.png");
	    boolean NameValid = SameKindValidity(
	    	param_ascendant.getName(),
	    	param_fodder1.getName(),
	    	param_fodder2.getName()
	    ), 
	    RarityValid = RarityValidity(
	    	param_ascendant.getRarity(),
	    	param_fodder1.getRarity(),
	    	param_fodder2.getRarity()
	    ) ;

	    if(NameValid == true && RarityValid == true){

	      //index 1 is for ascending, index 2 and 3 is fodder

	      unequipForMerging(param_ascendant);
	      unequipForMerging(param_fodder1);
	      unequipForMerging(param_fodder2);

	      param_ascendant.increaseRarity();

	      param_fodder1.setName("-==!ForRemoval!==-");
	      param_fodder2.setName("-==!ForRemoval!==-");
	      
	      JOptionPane.showMessageDialog(null,"Merge Successful", "Attention!",  JOptionPane.INFORMATION_MESSAGE, alertIcon );

	  
	    }

	  }

	  public void WeaponMerge(WeaponContainer param_ascendant, WeaponContainer param_fodder1, WeaponContainer param_fodder2){
		 ImageIcon alertIcon = new ImageIcon("src/Image_Assets/warning_icon.png");
	     
		 boolean NameValid = SameKindValidity(
	      param_ascendant.getAsWeapon().getName(),
	      param_fodder1.getAsWeapon().getName(),
	      param_fodder2.getAsWeapon().getName()
	      );
		 

		 int AscendantRarity, Fodder1Rarity, Fodder2Rarity;
		 
		 AscendantRarity = param_ascendant.getAsWeapon().getRarity();
		 Fodder1Rarity = param_fodder1.getAsWeapon().getRarity();
		 Fodder2Rarity = param_fodder2.getAsWeapon().getRarity();
		 
		 if(param_ascendant.checkNonNull() == 2) {
			 AscendantRarity -= 1;
		 }
		 
		 if(param_fodder1.checkNonNull() == 2) {
			 Fodder1Rarity -= 1;
		 }
		 
		 if(param_fodder2.checkNonNull() == 2) {
			 Fodder2Rarity -= 1;
		 }
		 
		 boolean RarityValid = RarityValidity(AscendantRarity, Fodder1Rarity, Fodder2Rarity);

	    if(NameValid == true && RarityValid == true){

	      unequipForMerging(param_ascendant.getAsWeapon());
	      unequipForMerging(param_fodder1.getAsWeapon());
	      unequipForMerging(param_fodder2.getAsWeapon());

	      param_ascendant.getAsWeapon().increaseRarity();

	      param_fodder1.getAsWeapon().setName("-==!ForRemoval!==-");
	      param_fodder2.getAsWeapon().setName("-==!ForRemoval!==-");

	     

	      JOptionPane.showMessageDialog(null,"Merge Successful", "Attention!",  JOptionPane.INFORMATION_MESSAGE, alertIcon );

	  
	    }
	  }
	 
	}