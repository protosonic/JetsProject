package com.skilldistillery.jets.app;

import java.util.Scanner;

public class JetsApp {
	// NO jet collection in app class
	// ONLY in Airfield

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
				airField.loadJetsFromFile("jetData.txt");
				break;
			case "5":
				break;
			case "6":
				break;
			case "7":
				break;
			case "8":
				break;
			case "9":
				break;

			}
			break;

		} while (keepGoing);
		// do-while loop
		// *print menu (make new sysout method to call)
		// *get user choice
		// *switch on user choice
		// * call on Airfield method to act on user choice
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
