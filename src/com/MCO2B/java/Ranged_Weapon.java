package com.MCO2B.java;

public class Ranged_Weapon extends Weapon{
	
	private float CriticalDamage;

	public Ranged_Weapon(String param_name, int param_power, int param_level, int param_rarity) {
		super(param_name, param_power, param_level, param_rarity);
		this.CriticalDamage = 1;
	}


	
	public float getCriticalDamage() {
		return this.CriticalDamage;
	}
	
	public void setCriticalDamage(float param_crit) {
		this.CriticalDamage = param_crit;
	}
	
	public void Hone() {
		
		if(this.CriticalDamage < 2) {
			this.CriticalDamage += 0.2;
		}
		
	}

	public int getPowerGacha() {
		return super.power;
	}
	
	@Override
	public int getPower() {
		return this.power + (int)(this.power * this.CriticalDamage);
	}
}
