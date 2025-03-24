package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speedMph, int range, long price) {
		super(model, speedMph, range, price);
	}

	@Override
	public void fight() {
		System.out.println("========================================");
		System.out.println("\t\t" + getModel() + "\n-Weapons ready;\n-Scanning for target....;\n-Target aquired;\n-Engaging target;\n-Deploying ordinance;\n-Splash, splash, splash!;\n-Target nutralized;\n-Returning to base;");
	}

}
