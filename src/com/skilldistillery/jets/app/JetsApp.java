package com.skilldistillery.jets.app;

import java.util.Scanner;

public class JetsApp {

	private AirField airField = new AirField();
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		JetsApp app = new JetsApp();
		app.launch();
		scanner.close();
	}

	private void launch() {
		// TODO Create an airfield
		boolean keepGoing = true;
		do {
			displayUserMenu();
			String userChoice = scanner.nextLine();

			switch (userChoice) {
			case "1":
				airField.displayFleet();
				break;
			case "2":
				airField.flyFleet();
				break;
			case "3":
				airField.findFastest();
				break;
			case "4":
				airField.findFurthest();
				break;
			case "5":
				airField.loadCargo();
				break;
			case "6":
				airField.dogFight();
				break;
			case "7":
									// Print get jets stats submenu
				String model = scanner.nextLine();
				double speedMph = scanner.nextDouble();
				int range = scanner.nextInt();
				int price = scanner.nextInt();

									// Print get jet type submenu
				int jetType = scanner.nextInt();
				switch (jetType) {
				case 1:
					airField.addVanilla(model, speedMph, range, price);
					break;
				case 2:
					airField.addFighter(model, speedMph, range, price);
					break;
				case 3:
					airField.addCargo(model, speedMph, range, price);
				}
				break;
			case "8":
				int removeIndex = 0;
				removeIndex = scanner.nextInt();
				airField.removeJet(removeIndex);
				break;
			case "9":
				keepGoing = false;
				break;
			}
			break;

		} while (keepGoing);

	}

	private void displayUserMenu() {
		System.out.println("----------AirField----------");
		System.out.println("1). List fleet");
		System.out.println("2). Fly all jets");
		System.out.println("3). View fastest jet");
		System.out.println("4). View jet with longest range");
		System.out.println("5). Load all Cargo Jets");
		System.out.println("6). Dogfight!");
		System.out.println("7). Add jet to fleet");
		System.out.println("8). Remove jet from fleet ");
		System.out.println("----------------------------");
	}
}
