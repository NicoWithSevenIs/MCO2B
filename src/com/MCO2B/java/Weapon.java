package com.MCO2B.java;

public class Weapon{
	
	  //properties
	  protected String name;
	  protected int power; 
	  protected int level;
	  protected int rarity;
	  protected Character holder;
	  protected boolean isEquipped;
	 

	  //constructors

	  public Weapon(String param_name, int param_power, int param_level, int param_rarity){
	    setName(param_name);
	    setPower(param_power);
	    setLevel(param_level);
	    setRarity(param_rarity);

	    
	    setEquipStatus(false);
	  }

	  //methods
	  public String getName(){
	    return this.name;
	  }

	  public void setName(String param_name){
	    this.name = param_name;
	  }

	  
	  public void setPower(int param_power){
	    this.power = param_power;
	  }

	  public int getPower(){
	    return this.power;
	  }
	  
	  public int getLevel(){
	    return this.level;
	  }

	  public void setLevel(int param_level){
	    this.level = param_level;
	  }

	  public void levelUp(int param_increment){

	    if(this.getLevel() < 50)
	      this.level += param_increment;
	  
	  }

	  public int getRarity() {
	    return this.rarity;
	  }

	  public void setRarity(int param_rarity) {
	    this.rarity = param_rarity;
	  }

	  public boolean checkIfEquipped(){
	    return this.isEquipped;
	  }

	  public void increaseRarity(){
	    this.rarity += 1;
	  }

	  public void setEquipStatus(boolean param_status){
	    this.isEquipped = param_status;
	  }

	  public Character getHolder(){
	    return this.holder;
	  }

	  public void equip(Character param_holder){
	    this.holder = param_holder;
	    this.setEquipStatus(true);
	  }

	  public void unequip(){
	    this.holder = null;
	    this.setEquipStatus(false);
	  }
	  
	  
	}