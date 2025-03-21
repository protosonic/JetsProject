package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements CargoCarrier {

	public CargoJet(String model, double speedMph, int range, long price) {
		super(model, speedMph, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println(getModel() + " -Cargo door open;\nCargo ramp down;\nLoading...\nCargo ramp up;\nCargo door open;");
	}

}
