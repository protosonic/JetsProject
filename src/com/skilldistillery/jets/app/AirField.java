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
	
	public AirField() {
	loadJetsFromFile("jetData.txt");
	}

	public void loadJetsFromFile(String fileName) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
//				System.out.println(line);

				String[] fields = line.split("[|]");
				String model = fields[1];
				double speedMph = Double.parseDouble(fields[2]);
				int range = Integer.parseInt(fields[3]);
				int price = Integer.parseInt(fields[4]);
				
				switch (fields[0]) {
				case "P":
					VanillaJet vJet = new VanillaJet(model, speedMph, range, price);
					fleet.add(vJet);
					break;
				case "F":
					FighterJet fJet = new FighterJet(model, speedMph, range, price);
					fleet.add(fJet);
					break;
				case "C":
					CargoJet jJet = new CargoJet(model, speedMph, range, price);
					fleet.add(jJet);
					break;
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public void addVanilla(String model, double speedMph, int range, int price) {
		Jet newJet = new VanillaJet(model, speedMph, range, price);
		fleet.add(newJet);
	}

	public void addFighter(String model, double speedMph, int range, int price) {
		Jet newJet = new FighterJet(model, speedMph, range, price);
		fleet.add(newJet);
	}

	public void addCargo(String model, double speedMph, int range, int price) {
		Jet newJet = new CargoJet(model, speedMph, range, price);
		fleet.add(newJet);
	}

	public void removeJet(int jetIndex) {
		if (jetIndex >= fleet.size() || jetIndex < 0) {
			System.out.println("Invalid index selected");
		} else {
			System.out.println("Jet at " + jetIndex + " has successfully been removed");
			fleet.remove(jetIndex);
		}

	}

	public void displayFleet() {
		System.out.println("----------Fleet List----------");
		for (Jet jet : fleet) {
			System.out.println(jet);
		}
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
		Jet fastestJet = fleet.get(2);
		for (Jet jet : fleet) {
			if (jet.getSpeedMph() > fastestJet.getSpeedMph()) {
				fastestJet = jet;
			}
		}

		System.out.println("----------Fastest Speed----------");
		System.out.println(fastestJet);
		System.out.println("---------------------------------");
	}

	public void findFurthest() {
		Jet furthestJet = fleet.get(3);
		for (Jet jet : fleet) {
			if (jet.getRange() > furthestJet.getRange()) {
				furthestJet = jet;
			
		System.out.println("----------Furthest Range----------");
		System.out.println(furthestJet);
		System.out.println("----------------------------------");
		}
		}
	}

	public void dogFight() {
		for (Jet jet : fleet) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).fight();
			}
		}
	}

	public void loadCargo() {
		for (Jet jet : fleet) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

//	public void loadJetsFromFile(String fileName) {
//		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
//			String line;
//			while ((line = bufIn.readLine()) != null) {
////				System.out.println(line);
//
//				String[] fields = line.split("[|]");
//				String model = fields[1];
//				double speedMph = Double.parseDouble(fields[2]);
//				int range = Integer.parseInt(fields[3]);
//				int price = Integer.parseInt(fields[4]);
//				
//				switch (fields[0]) {
//				case "P":
//					VanillaJet vJet = new VanillaJet(model, speedMph, range, price);
//					fleet.add(vJet);
//					break;
//				case "F":
//					FighterJet fJet = new FighterJet(model, speedMph, range, price);
//					fleet.add(fJet);
//					break;
//				case "C":
//					CargoJet jJet = new CargoJet(model, speedMph, range, price);
//					fleet.add(jJet);
//					break;
//				}
//
//			}
//		} catch (IOException e) {
//			System.err.println(e);
//		}
//	}
}
