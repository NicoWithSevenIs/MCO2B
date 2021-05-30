package com.MCO2B.java;

public class Enemy {
	
	//properties
	
	private String name;
	private int power;
	private int quantity;
	
	//Constructors
	
	public Enemy (String param_name, int param_power, int param_quantity) {
		this.setName(param_name);
		this.setPower(param_power);
		this.setQuantity(param_quantity);
	}
	
	//Methods

	public String getName() {
		return this.name;
	}
	public void setName(String param_name) {
		this.name = param_name;
	}
	
	public int getPower() {
		return this.power;
	}
	public void setPower(int param_power) {
		this.power = param_power;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int param_quantity) {
		this.quantity = param_quantity;
	}
	public void increaseQuantity(int param_quantity) {
		this.quantity += param_quantity;
	}
	
  
}
