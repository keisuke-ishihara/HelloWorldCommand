package com.mycompany.imagej;

public class Car extends Vehicle implements WheelOwner {
	
	private String brand;
	private int numWheels;

	// Constructor
	public Car(double weight) {
		super(weight);
		numWheels = 4;
	}
	
	// method that returns Brand
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		return "I'm a " + getBrand() + " and I weigh " + getWeight() + " kilos.";
	}
	
	@Override
	public void setWeight(double weight) {
		super.setWeight(weight + 10);
	}
	
	@Override
	public int getNumberOfWheels() {
		return numWheels;
	} 
	
	public void setNumberOfWheelsFromAnotherGuy( WheelOwner otherGuy ) {
		this.numWheels = otherGuy.getNumberOfWheels();
	}

	
	// main
	public static void main(String args[]){ 
		Car x = new Car(900);
		x.setWeight(950);
		x.setBrand("BMW");
		
		System.out.println( x.getNumberOfWheels() );
		
		System.out.println(x);
	}
}
