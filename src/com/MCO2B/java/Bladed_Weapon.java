package com.MCO2B.java;

public class Bladed_Weapon extends Weapon {



	public Bladed_Weapon(String param_name, int param_power, int param_level, int param_rarity) {
		super(param_name, param_power, param_level, param_rarity);
	}

	public int getPowerGacha() {
		return super.power;
	}
	@Override
	public int getPower() {
		return this.power + (10* this.rarity);
	}

}
