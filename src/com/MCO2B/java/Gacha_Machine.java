package com.MCO2B.java;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Random;

public class Gacha_Machine{

//Properties

private ArrayList<Character> Rarity1Character, Rarity2Character, Rarity3Character;
private ArrayList<WeaponContainer> Rarity1Weapon, Rarity2Weapon, Rarity3Weapon;

//Constructors

public Gacha_Machine(){

  this.InitializeCharacterList();
  this.InitializeWeaponList();


}

//Methods

public void InitializeCharacterList(){

  //Rarity 1

  Rarity1Character = new ArrayList<Character>();
  
  Rarity1Character.add(new Character("Jekyll", "Joker", "Bladed", 20, 1));
  Rarity1Character.add(new Character("Earl Robert", "Trigger", "Ranged", 20, 1));
  Rarity1Character.add(new Character("Count d'Artagnan", "Metal", "Magical", 20, 1));
  Rarity1Character.add(new Character("Stede", "Cyclone","Bladed", 20, 1));
  Rarity1Character.add(new Character("Kaguya", "Luna","Ranged", 20, 1));
  Rarity1Character.add(new Character("Van Helmont", "Heat","Magical", 20, 1));

  //Rarity 2

  Rarity2Character = new ArrayList<Character>();

  Rarity2Character.add(new Character("Gray", "Joker", "Magical", 20, 2));
  Rarity2Character.add(new Character("Bonney", "Trigger", "Bladed", 20, 2));
  Rarity2Character.add(new Character("Sir William Marshal", "Metal", "Ranged", 20, 2));
  Rarity2Character.add(new Character("Teach", "Cyclone", "Magical", 20,  2));
  Rarity2Character.add(new Character("Jeanne", "Luna", "Bladed", 20, 2));
  Rarity2Character.add(new Character("Paracelsus", "Heat", "Ranged", 20, 2));  

  //Rarity 3

  Rarity3Character = new ArrayList<Character>();

  Rarity3Character.add(new Character("Faust", "Joker", "Ranged", 20, 3));
  Rarity3Character.add(new Character("Clyde", "Trigger", "Magical", 20, 3));
  Rarity3Character.add(new Character("Masamune", "Metal", "Bladed",  20, 3));
  Rarity3Character.add(new Character("Avery", "Cyclone", "Ranged", 20, 3));
  Rarity3Character.add(new Character("Arthur", "Luna", "Magical", 20, 3));
  Rarity3Character.add(new Character("Hermes ", "Heat", "Bladed",  20, 3));  
}


public void InitializeWeaponList(){

	//Rarity 1
	Rarity1Weapon = new ArrayList<WeaponContainer>();
	
	Rarity1Weapon.add(new WeaponContainer());
	Rarity1Weapon.get(0).setBladed(new Bladed_Weapon("Knife", 130, 20, 1));
	
	Rarity1Weapon.add(new WeaponContainer());
	Rarity1Weapon.get(1).setBladed(new Bladed_Weapon("Rapier", 140, 20, 1));
	
	Rarity1Weapon.add(new WeaponContainer());
	Rarity1Weapon.get(2).setRanged(new Ranged_Weapon("Revolver", 150, 20, 1));
	
	Rarity1Weapon.add(new WeaponContainer());
	Rarity1Weapon.get(3).setMagical(new Magical_Weapon("Mermaid Tears", 160,20, 1));
	
	Rarity1Weapon.add(new WeaponContainer());
	Rarity1Weapon.get(4).setBladed(new Bladed_Weapon("Clarent", 170 ,20 , 1));
	
	Rarity1Weapon.add(new WeaponContainer());
	Rarity1Weapon.get(5).setRanged(new Ranged_Weapon("English Longbow", 180, 20,1));
	
	
	//Rarity 2
	Rarity2Weapon = new ArrayList<WeaponContainer>();
	
	Rarity2Weapon.add(new WeaponContainer());
	Rarity2Weapon.get(0).setMagical(new Magical_Weapon("Circe Staff", 150,20, 2));
	
	Rarity2Weapon.add(new WeaponContainer());
	Rarity2Weapon.get(1).setMagical(new Magical_Weapon("Vorpal Sword", 160, 20,2));
	
	Rarity2Weapon.add(new WeaponContainer());
	Rarity2Weapon.get(2).setMagical(new Magical_Weapon("Merlin’s Staff", 170,20, 2));
	
	Rarity2Weapon.add(new WeaponContainer());
	Rarity2Weapon.get(3).setBladed(new Bladed_Weapon("Five-cross Sword", 180,20, 2));
	
	Rarity2Weapon.add(new WeaponContainer());
	Rarity2Weapon.get(4).setRanged(new Ranged_Weapon("Bashosen", 190,20, 2));
	
	Rarity2Weapon.add(new WeaponContainer());
	Rarity2Weapon.get(5).setGolden(new Golden_Weapon("Golden Cudgel", 200,20, 2));
	
	
	//Rarity 3
	Rarity3Weapon = new ArrayList<WeaponContainer>();

	Rarity3Weapon.add(new WeaponContainer());
	Rarity3Weapon.get(0).setMagical(new Magical_Weapon("Philosopher’s Stone", 180,20, 3));
	
	Rarity3Weapon.add(new WeaponContainer());
	Rarity3Weapon.get(1).setRanged(new Ranged_Weapon("Magic Bullets", 190,20, 3));

	Rarity3Weapon.add(new WeaponContainer());
	Rarity3Weapon.get(2).setBladed(new Bladed_Weapon("Fragarach", 200,20, 3));
	
	Rarity3Weapon.add(new WeaponContainer());
	Rarity3Weapon.get(3).setBladed(new Bladed_Weapon("Honjo Masamune", 210,20, 3));
	
	Rarity3Weapon.add(new WeaponContainer());
	Rarity3Weapon.get(4).setBladed(new Bladed_Weapon("Excalibur", 220,20, 3));
	
	Rarity3Weapon.add(new WeaponContainer());
	Rarity3Weapon.get(5).setGolden(new Golden_Weapon("Scythe of Father Time", 230,20, 3));
	
}


public int generateRarity(){

  //generates a number between 1 to 3 based on pull rate of each rarity

  int genNum;

  Random genrar = new Random();

  genNum = genrar.nextInt(100);

  if(genNum < 50){
    return 1;
  }else if (genNum >= 50 && genNum < 85){
    return 2;
  }else{
    return 3;
  }

}

public int randomizeDraw(int param_limit){

  //randomly generates a number up to a param_limit

  Random randomize = new Random();

  return randomize.nextInt(param_limit);

}


public Character drawCharacter(){
  
  int rarity = generateRarity();
  int randomize;
  ImageIcon CharCard = new ImageIcon("src/Image_Assets/drawSingleChar_icon.png");
  

    switch (rarity){
     
      
      case 1: 

        randomize = randomizeDraw(Rarity1Character.size());
        JOptionPane.showMessageDialog(null, "You have drawn " + Rarity1Character.get(randomize).getName() + "!", "Congratulations!",  JOptionPane.INFORMATION_MESSAGE, CharCard);
        return Rarity1Character.get(randomize);
      
     

      case 2:
      
        randomize = randomizeDraw(Rarity2Character.size());
        
        JOptionPane.showMessageDialog(null, "You have drawn " + Rarity2Character.get(randomize).getName() + "!", "Congratulations!",  JOptionPane.INFORMATION_MESSAGE, CharCard);
 
        return Rarity2Character.get(randomize);



      case 3:

        randomize = randomizeDraw(Rarity3Character.size());
        JOptionPane.showMessageDialog(null, "You have drawn " + Rarity3Character.get(randomize).getName() + "!", "Congratulations!",  JOptionPane.INFORMATION_MESSAGE, CharCard);
        return Rarity3Character.get(randomize);

  
    }
    
    return new Character ("?", "?", "?", 20, 1);
}


public WeaponContainer drawWeapon(){



  int rarity = generateRarity();
  int randomize;
  ImageIcon WeapCard = new ImageIcon("src/Image_Assets/drawSingleWeap_icon.png");


    
    switch (rarity){
    
      
      case 1: 
        randomize = randomizeDraw(Rarity1Weapon.size());     
        JOptionPane.showMessageDialog(null, "You have drawn " + Rarity1Weapon.get(randomize).getAsWeapon().getName() + "!", "Congratulations!",  JOptionPane.INFORMATION_MESSAGE, WeapCard);
        return Rarity1Weapon.get(randomize);


      case 2:
      
    	  randomize = randomizeDraw(Rarity2Weapon.size());	     
          JOptionPane.showMessageDialog(null, "You have drawn " + Rarity2Weapon.get(randomize).getAsWeapon().getName() + "!", "Congratulations!",  JOptionPane.INFORMATION_MESSAGE, WeapCard);     
          return Rarity2Weapon.get(randomize);

      case 3:
    	  randomize = randomizeDraw(Rarity3Weapon.size());
         JOptionPane.showMessageDialog(null, "You have drawn " + Rarity3Weapon.get(randomize).getAsWeapon().getName() + "!", "Congratulations!",  JOptionPane.INFORMATION_MESSAGE, WeapCard);       
          return Rarity3Weapon.get(randomize);

	  }

    return new WeaponContainer();
	}


}

