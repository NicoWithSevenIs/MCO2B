package com.MCO2B.java;

public class Magical_Weapon extends Weapon {
	

	
	public Magical_Weapon(String param_name, int param_power, int param_level, int param_rarity) {
		super(param_name, param_power, param_level, param_rarity);
	}

	public int getRarityGacha() {
		return super.rarity;
	}
	
	@Override
	public int getRarity() {
		return (this.rarity + 1);
	}
	
}
