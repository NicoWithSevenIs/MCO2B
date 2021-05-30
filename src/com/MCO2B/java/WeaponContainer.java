package com.MCO2B.java;

public class WeaponContainer {
	
	//properties
	private Bladed_Weapon Bladed;
	private Magical_Weapon Magical;
	private Ranged_Weapon Ranged;
	private Golden_Weapon Golden;
	
	//methods
	
	public Bladed_Weapon getBladed() {
		return this.Bladed;
	}
	
	public void setBladed(Bladed_Weapon param_weapon) {
		this.Bladed = new Bladed_Weapon(param_weapon.getName(), param_weapon.getPowerGacha(), param_weapon.getLevel(), param_weapon.getRarity());
				
			
	}
	
	public Magical_Weapon getMagical() {
		return this.Magical;
	}
	
	public void setMagical(Magical_Weapon param_weapon) {
		
		
		this.Magical =  new Magical_Weapon(param_weapon.getName(), param_weapon.getPower(), param_weapon.getLevel(),param_weapon.getRarityGacha());
	}
	
	public Ranged_Weapon getRanged() {
		return this.Ranged;
	}
	
	public void setRanged(Ranged_Weapon param_weapon) {
		this.Ranged = new Ranged_Weapon(param_weapon.getName(), param_weapon.getPowerGacha(), param_weapon.getLevel(), param_weapon.getRarity());
	}
	
	public Golden_Weapon getGolden() {
		return this.Golden;
	}
	
	public void setGolden(Golden_Weapon param_weapon) {
		this.Golden = new Golden_Weapon(param_weapon.getName(), param_weapon.getPowerGacha(), param_weapon.getLevel(), param_weapon.getRarity());
	}
	
	public int checkNonNull() {
		
		if(this.Bladed != null) {
			return 1;
		}else if(this.Magical != null) {
			return 2;
		}else if(this.Ranged != null) {
			return 3;
		}else { //Golden
			return 4;
		}

	}
	
	public Weapon getAsWeapon() {
		
		if(this.Bladed != null) {
			return this.Bladed;
		}else if(this.Magical != null) {
			return this.Magical;
		}else if(this.Ranged != null) {
			return this.Ranged;
		}else {
			return this.Golden;
		}
		
	}
	
}
