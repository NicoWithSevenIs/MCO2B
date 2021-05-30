package com.MCO2B.java;

import java.util.ArrayList;

public class Inventory {

	 //properties
	  private ArrayList<Character> CharacterInv;
	  private ArrayList<WeaponContainer> WeaponInv;
	  

		
	  //constructors

	  public Inventory(){
	    this.CharacterInv = new ArrayList<Character>();
	    this.WeaponInv = new ArrayList<WeaponContainer>();
	  }

		//methods

	 
	      public ArrayList<WeaponContainer> getWeapArrayList(){
		    return this.WeaponInv;
		  }
		  
		  public WeaponContainer getWeapInd(int param_index){
			  	return WeaponInv.get(param_index);
		  }
		  
		  public void addWeapon(WeaponContainer param_draw){
			  
			  	WeaponContainer Holder = new WeaponContainer();
			   
			    
			    switch(param_draw.checkNonNull()) {
			    
			    case 1: Holder.setBladed(param_draw.getBladed()); break;
			    case 2: Holder.setMagical(param_draw.getMagical()); break;
			    case 3: Holder.setRanged(param_draw.getRanged()); break;
			    case 4: Holder.setGolden(param_draw.getGolden()); break;
			    
			    }
			    
			    WeaponInv.add(Holder);
		  }
		
		 
	  
	  //Manage Character ArrayList
	  public ArrayList<Character> getCharArrayList(){
		  return this.CharacterInv;
	  }

	  public Character getCharInd(int param_index){
		  return CharacterInv.get(param_index);
	  }
	  
	  public void addCharacter(Character param_draw){
		  CharacterInv.add(new Character(param_draw.getName(), param_draw.getElement(), param_draw.getWeaponType(), param_draw.getLevel(), param_draw.getRarity()));
	  }
	  
	 

	  
	 
	  

	   
}
		
