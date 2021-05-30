package com.MCO2B.java;


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Adventure {

	//properties
	private ArrayList<Map> Maplist;

	//constructors
	
	public Adventure() {
		initializeMaps();
	}
	
	//methods


	public void initializeMaps() {
		
		Maplist = new ArrayList<Map>();
		
		Maplist.add(new Map("Underground Caverns", 53));
		this.getMapInd(0).addEnemyQuantity("Elf", 1);
		this.getMapInd(0).addEnemyQuantity("Slime", 6);
		
		Maplist.add(new Map("Forest of Enchantments", 77));
		this.getMapInd(1).addEnemyQuantity("Elf", 2);
		this.getMapInd(1).addEnemyQuantity("Slime", 5);
		this.getMapInd(1).addEnemyQuantity("Orc", 5);
		this.getMapInd(1).addEnemyQuantity("Familiar", 3);
		this.getMapInd(1).addEnemyQuantity("Sorcerer", 1);
		
		Maplist.add(new Map("Sea of Hope", 85));
		this.getMapInd(2).addEnemyQuantity("Slime", 75);
		this.getMapInd(2).addEnemyQuantity("Sorcerer", 20);
		this.getMapInd(2).addEnemyQuantity("Hydra", 5);
		
		Maplist.add(new Map("Tower of Ether", 91));
		this.getMapInd(3).addEnemyQuantity("Basilisk", 20);
		this.getMapInd(3).addEnemyQuantity("Harpy", 7);
		this.getMapInd(3).addEnemyQuantity("Loki", 5);
		
		Maplist.add(new Map("Celestial Plane", 100));
		this.getMapInd(4).addEnemyQuantity("Faerie", 50);
		this.getMapInd(4).addEnemyQuantity("Hydra", 20);
		this.getMapInd(4).addEnemyQuantity("Loki", 10);
		

		
	}
	
	public int initiateAdventure(Map used_Map, Character Adventurer1, Character Adventurer2) {
		
		float totalRewards = 0;
		ImageIcon alertIcon = new ImageIcon("src/Image_Assets/warning_icon.png");
		
		float charSup = getCharacterSuperiority(Adventurer1, Adventurer2);
	
		if(charSup/2 >= used_Map.computeEnemySuperiority()) {
			Adventurer1.levelUp(2);
			Adventurer2.levelUp(2);
			JOptionPane.showMessageDialog(null, "Adventure Excellently Completed!", "Victory!",  JOptionPane.INFORMATION_MESSAGE, alertIcon);
			totalRewards = getRewards(used_Map, Adventurer1, Adventurer2);
		}else if (charSup > used_Map.computeEnemySuperiority()) {
			Adventurer1.levelUp(1);
			Adventurer2.levelUp(1);
			JOptionPane.showMessageDialog(null, "Adventure Completed!", "Victory!",  JOptionPane.INFORMATION_MESSAGE, alertIcon);
			totalRewards = getRewards(used_Map, Adventurer1, Adventurer2);
		}else {
			JOptionPane.showMessageDialog(null, "Adventure Failed", "Defeat!",  JOptionPane.INFORMATION_MESSAGE, alertIcon);
		}

		
		return (int)totalRewards;
	}
	
	public float getElementCombination(String param_elem1, String param_elem2){
		
		 float A = 1.1f, //Normal
		       B = 1.75f, //Perfect
		       C = 1.5f, //Nice
		       D = 1.25f, //Decent
		       E = 1f, //No Effect
		       F = 0.75f; //Bad 
		
		 switch(param_elem1){
		   case "Joker":{
		     switch(param_elem2){
		       case "Trigger": return D;
		       case "Metal":  return D;    	   		
		       case "Cyclone": return B;                       
		       case "Luna":  return C;                   
		       case "Heat":  return C;
		                   
		     }
		   }break;
		
		   case "Trigger":{
		     switch(param_elem2){
		       case "Joker": return D; 
		       case "Metal":  return E;
		       case "Cyclone": return E;                      
		       case "Luna":  return B;                      
		       case "Heat":  return E;                   
		     }
		   }
		
		  case "Metal":{
		     switch(param_elem2){
		       case "Joker":  return D;                      
		       case "Trigger":  return E;                     
		       case "Cyclone":  return D;                   
		       case "Luna":  return D;                     
		       case "Heat":  return B;
		     }
		   }
		
		  case "Cyclone":{
		     switch(param_elem2){
		       case "Joker":return B; 
		       case "Trigger":return E;
		       case "Metal": return D; 
		       case "Luna": return F;
		       case "Heat": return F;
		     }
		   }
		  
		
		  case "Luna":{
		     switch(param_elem2){
		       case "Joker": return C;
		       case "Trigger": return B;
		       case "Metal": return D;
		       case "Cyclone":return F;
		       case "Heat":return F; 
		     }
		   }
		
		  case "Heat":{
		     switch(param_elem2){
		       case "Joker": return C;
		       case "Trigger":return E; 
		       case "Metal": return B;
		       case "Cyclone": return F;
		       case "Luna": return F;
		     }
		   }
		  
		 }
		
		 return A; 
		}
		
	public Map getMapInd(int param_index) {
		return this.Maplist.get(param_index);
	}

	public float getFinalWeaponPower(Weapon param_weapon) {
		return param_weapon.getPower() * (float)(0.7 + (0.1 * param_weapon.getRarity())) + param_weapon.getLevel();
	}

	public float getCharacterInfluence (Character param_char) {
		return param_char.getLevel() * (1 + ((param_char.getRarity()-1)/5));
	}

	public float getCharacterSuperiority(Character Adventurer1, Character Adventurer2) {
		return (getFinalWeaponPower(Adventurer1.getWeapon()) + getFinalWeaponPower(Adventurer2.getWeapon())) * 
				((getCharacterInfluence(Adventurer1) + getCharacterInfluence(Adventurer2))/10);
	}

	public float getRewards(Map used_Map, Character Adventurer1, Character Adventurer2) {
		
		return (int)used_Map.getBaseAmount() + 
				   ((int)((getFinalWeaponPower(Adventurer1.getWeapon()) + getFinalWeaponPower(Adventurer2.getWeapon()))/24) *
				   (int)((getCharacterInfluence(Adventurer1) + getCharacterInfluence(Adventurer2))/36) *
				   getElementCombination(Adventurer1.getElement(), Adventurer2.getElement()));
		
	}
	

}
	

