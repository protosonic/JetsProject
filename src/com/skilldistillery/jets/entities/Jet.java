package com.skilldistillery.jets.entities;

public abstract class Jet {
	String model;
	double speedMph;
	int range;
	long price;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeedMph() {
		return speedMph;
	}

	public void setSpeedMph(int speedMph) {
		this.speedMph = speedMph;
	}

	public double getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nModel: ");
		builder.append(model + "\n");
		builder.append("SpeedMph: ");
		builder.append(speedMph+ "\n");
		builder.append("Range: ");
		builder.append(range + "\n");
		builder.append("Price: ");
		builder.append(price + "\n");
		builder.append("-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
		return builder.toString();
	}

	public Jet(String model, double speedMph2, int range, long price) {
		super();
		this.model = model;
		this.speedMph = speedMph2;
		this.range = range;
		this.price = price;
	}

	public void fly() {
		double flightTime = range / speedMph;
		System.out.println("Initiating take off...." + 
		"\nModel: " + model + "\nSpeed: " + speedMph + 
		"\nRange: " + range + "\nPrice" + price
				+ "\nMax Flight time: " + flightTime);
	}
	public double getSpeedInMAch() {
		return speedMph /767.269;
	}
}
