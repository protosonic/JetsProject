package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.jets.entities.CargoCarrier;
import com.skilldistillery.jets.entities.CargoJet;
import com.skilldistillery.jets.entities.CombatReady;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.VanillaJet;

public class AirField {
	private List<Jet> fleet = new ArrayList<>();

//	public AirField() {
//		// load 5 jets here
//		loadJetsFromFile("jetData.txt");
//	}
	
	public void displayFleet() {
		for (Jet jet : fleet) {
			System.out.println(jet);
		}
		System.out.println("----------Fleet List----------");
		System.out.println(" ");
		System.out.println("------------------------------");
	}
	
	public void flyFleet() {
		for (Jet jet : fleet) {
			System.out.println("__________WOOOOSH!__________");
			jet.fly();
			System.out.println("____________________________");
		}
	}
	
	public void findFastest() {
		double fastestSpeed = 0.0;
		Jet fastestJet = null;
		for (Jet jet : fleet) {
			if (jet.getSpeedMph() > fastestSpeed) {
				fastestSpeed = jet.getSpeedMph();
				fastestJet = jet;
			}
		}

		System.out.println("----------Fastest Speed----------");
		System.out.println(" ");
		System.out.println("---------------------------------");
	}
	
	public void findFarthest() {
		double furthestRange = 0.0;
		Jet furthestJet = null;
		for (Jet jet : fleet) {
			if (jet.getRange() > furthestRange) {
				furthestRange = jet.getRange();
				furthestJet = jet;
			}
		}

		System.out.println("----------Furthest Range----------");
		System.out.println(" ");
		System.out.println("----------------------------------");
	}
	
	public void dogFight() {
		for (Jet jet : fleet) {
			if ( jet instanceof CombatReady) {
				((FighterJet) jet).flight();
			}
		}
	}
	
	public void loadCargo() {
		for (Jet jet : fleet) {
			if ( jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	public void loadJetsFromFile(String fileName) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				System.out.println(line);

				String[] fields = line.split("[|]");
				String model = fields[1];
				double speedMph = Double.parseDouble(fields[2]);
				int range = Integer.parseInt(fields[3]);
				int price = Integer.parseInt(fields[4]);
				switch (fields[0]) {
				case "P":
					VanillaJet vJet = new VanillaJet(model, speedMph, range, price);
					break;
				case "F":
					FighterJet fJet = new FighterJet(model, speedMph, range, price);
					break;
				case "C":
					CargoJet jJet = new CargoJet(model, speedMph, range, price);
					break;
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
