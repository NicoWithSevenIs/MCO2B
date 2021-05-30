package com.MCO2B.java;

import java.util.ArrayList;

public class Map{
	
  //properties
	private String name;
	private int baseAmount;
	private ArrayList<Enemy> mapPopulation;
	
	//Constructor
	public Map(String name, int baseAmount) {
		this.setName(name);
		this.setBaseAmount(baseAmount);		
		
		initializeEnemyList();
	}
	
	//Method
	
	public void initializeEnemyList() {
		
		mapPopulation = new ArrayList<Enemy>();
		
		mapPopulation.add(new Enemy("Slime", 73, 0));
		mapPopulation.add(new Enemy("Orc", 84, 0));
		mapPopulation.add(new Enemy("Familiar", 144, 0));
		mapPopulation.add(new Enemy("Faerie", 175, 0));
		mapPopulation.add(new Enemy("Elf", 224, 0));
		mapPopulation.add(new Enemy("Sorcerer", 313, 0));
		mapPopulation.add(new Enemy("Hydra", 360, 0));
		mapPopulation.add(new Enemy("Basilisk", 499, 0));
		mapPopulation.add(new Enemy("Harpy", 639, 0));
		mapPopulation.add(new Enemy("Loki", 740 , 0));
		
	}
	
	public void addEnemyQuantity (String enemy_name, int param_quantity) {
		
		for (int i =0 ; i < this.mapPopulation.size(); i++) {
			
			if(this.mapPopulation.get(i).getName() == enemy_name) {
				this.mapPopulation.get(i).increaseQuantity(param_quantity);
			}
			
		}
		
	}
	
	public ArrayList<Enemy> getEnemyList(){
		return this.mapPopulation;
	}
	
	public String getName() {
		return this.name ;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBaseAmount() {
		return this.baseAmount;
	}
	public void setBaseAmount(int baseAmount) {
		this.baseAmount = baseAmount;
	}
	
	
	public float computeEnemySuperiority() {
		
		float EnemySuperiority = 0;

		for(int i = 0; i < this.mapPopulation.size(); i++) {
			EnemySuperiority += this.mapPopulation.get(i).getPower() * this.mapPopulation.get(i).getQuantity();
		}
	
		return EnemySuperiority;
	}

}
