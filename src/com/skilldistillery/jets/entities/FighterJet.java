package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speedMph, int range, long price) {
		super(model, speedMph, range, price);
	}

	@Override
	public void flight() {
		//TODO fill out print statement
		System.out.println(getModel() + " -Loading ordinance;");
	}

}
