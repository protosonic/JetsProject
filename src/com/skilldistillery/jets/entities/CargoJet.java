package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements CargoCarrier {

	public CargoJet(String model, double speedMph, int range, long price) {
		super(model, speedMph, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println("========================================");
		System.out.println("\t\t" + getModel() + "\n-Cargo door open;\n-Cargo ramp down;\n-Loading...\n-Cargo ramp up;\n-Cargo door open;\n\t\t" + getModel() + ": Loading complete.\n");
	}

}
