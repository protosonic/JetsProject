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
				// Getting jet information menu
				System.out.println("Enter Model: ");
				System.out.println();
				String model = scanner.nextLine();

				System.out.println("Enter Max Speed: ");
				System.out.println();
				double speedMph = scanner.nextDouble();

				System.out.println("Enter Max Range: ");
				System.out.println();
				int range = scanner.nextInt();

				System.out.println("Enter Price: ");
				System.out.println();
				int price = scanner.nextInt();

				// Getting jet type sub-menu 
				System.out.println("Enter the type of Jet from the list below:"
				+ "\n1). Passenger Jet"
				+ "\n2). Fighter Jet" 
				+ "\n3). Cargo Jet");
				System.out.println();
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
					break;
				default:
					System.out.println("Invalid Model selection. No jet has been added");
				} // There's a bug here that prints the user jet info even if no jet is added
				System.out.println("Jet with type: " + jetType + "\nModel: " + model + "\nMax SPeed: " + speedMph
						+ "\nRange: " + range + "\nPrice: " + price + "\nHas been added");
				break;
			case "8":
				airField.displayFleet();
				System.out.println("Select the index [] of the jet you would like to remove:");
				int removeIndex = scanner.nextInt();
				airField.removeJet(removeIndex);
				break;
			case "9":
				keepGoing = false;
				break;
//			default: System.out.println("Invalid selection!");
			}

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
		System.out.println("8). Remove jet from fleet");
		System.out.println("9). Quit");
		System.out.println("----------------------------");
	}
}
