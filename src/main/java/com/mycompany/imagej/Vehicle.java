package com.mycompany.imagej;

public class Vehicle {
	
	private double weight;

	// Constructor
	public Vehicle(double weight) {
		this.weight = weight;
		System.out.println(weight);
	}
	
	// method that returns weight
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double newW) {
		this.weight = newW;
	}
	
	// main
	public static void main(String args[]){ 
		Vehicle v = new Vehicle(15);	// instantiation
		System.out.println(v.getWeight());
		Object o;
		
	}  

}
