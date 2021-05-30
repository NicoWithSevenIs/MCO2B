package com.MCO2B.java;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Character {

	  // Properties

	  private String name; 
	  private String element;
	  private String WeaponType;
	  private int rarity;
	  private int level;
	  private boolean hasWeapon;
	  private Weapon equippedWeapon;

	  // Constructors

	  public Character(String param_name, String param_element, String param_weapType, int param_level, int param_rarity) {
	    setName(param_name);
	    setElement(param_element);
	    setRarity(param_rarity);
	    setLevel(param_level);
	    setWeaponType(param_weapType);

	    setEquipStatus(false);
	  }

	  // Methods

	  public String getName() {
	    return this.name;
	  }

	  public void setName(String param_name) {
	    this.name = param_name;
	  }

	  public String getElement() {
	    return this.element;
	  }

	  public void setElement(String param_element) {
	    this.element = param_element;
	  }

	  public String getWeaponType(){
	    return this.WeaponType;
	  }

	  public void setWeaponType(String param_weaponType){
	    this.WeaponType = param_weaponType;
	  }

	  public int getLevel() {
	    return this.level;
	  }

	  public void setLevel(int param_level) {
	    this.level = param_level;
	  }

	  public void levelUp(int param_increment) {
 
	    if(this.getLevel() < 100)
	      this.level += param_increment;

	  }

	  public int getRarity() {
	    return this.rarity;
	  }

	  public void setRarity(int param_rarity) {
	    this.rarity = param_rarity;
	  }

	  public void increaseRarity(){
	    this.rarity += 1;
	  }

	  public Weapon getWeapon() {
	    return this.equippedWeapon;
	  }

	  public boolean checkEquip() {
	    return hasWeapon;
	  }

	  public void setEquipStatus(boolean param_status){
	    this.hasWeapon = param_status;
	  }

	  public void equipWeapon(Weapon param_weapon) {
		  ImageIcon errorIcon = new ImageIcon("src/Image_Assets/error_icon.png");
		  ImageIcon alertIcon = new ImageIcon("src/Image_Assets/warning_icon.png");
	    //checks if param_weapon is already equipped

	    if(param_weapon.checkIfEquipped() == false){

	      //checks if character has already an equipped weapon

	      if (checkEquip() == false) {

	    	if((this.WeaponType == "Bladed" && param_weapon instanceof Bladed_Weapon) ||
    		   (this.WeaponType == "Magical" && param_weapon instanceof Magical_Weapon) ||
    		   (this.WeaponType == "Ranged" && param_weapon instanceof Ranged_Weapon)){
			        this.equippedWeapon = param_weapon;
			        param_weapon.equip(this);
			        this.setEquipStatus(true);
	        
			        JOptionPane.showMessageDialog(null, "Weapon Equipped!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, alertIcon );
	    	}else {
	    		JOptionPane.showMessageDialog(null, "Weapon Incompatible", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );
	    	}
	      } else {
	    	  
	    	JOptionPane.showMessageDialog(null, this.name + " is already using " + getWeapon().getName(), "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );

	      }

	    }else{
	    	
	    	JOptionPane.showMessageDialog(null, param_weapon.getName() + " is already held by " + param_weapon.getHolder().getName(), "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );

	    }

	  }

	  public void unequipWeapon() {

	    // checks if this character is currently equipping a weapon 
		 ImageIcon errorIcon = new ImageIcon("src/Image_Assets/error_icon.png");
		 ImageIcon alertIcon = new ImageIcon("src/Image_Assets/warning_icon.png");
		 
	    if (checkEquip() == true) {

	      setEquipStatus(false);
	      getWeapon().unequip();
	      this.equippedWeapon = null;

	      JOptionPane.showMessageDialog(null, "Weapon Unequipped!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, alertIcon );

	    } else {
	    	
	      JOptionPane.showMessageDialog(null, this.getName() + " has no weapon equipped!", "Attention!",  JOptionPane.INFORMATION_MESSAGE, errorIcon );	

	    }

	  }

	}