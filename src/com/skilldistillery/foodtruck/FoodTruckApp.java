package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {
	// list only the food trucks that have been inputted. dont show null
	// average rating done with .length

	// create 5 methods which get called in the loop each being created if the user
	// does not hit quit
	FoodTruck[] foodTrucks = new FoodTruck[5];
	StringBuilder sBuilder = new StringBuilder();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FoodTruckApp foodTruckApp = new FoodTruckApp();

		foodTruckApp.addFoodTruck(scanner);
		foodTruckApp.userMenu(scanner);
	}

	// this needs to loop through 5 times, if user types quit, loop ends, next menu
	// loops
	public void addFoodTruck(Scanner scanner) {
		for (int i = 0; i < 5; i++) {
			System.out.print("Please enter the name of the food truck. \n"
					+ "If you do not wish to enter a truck, please type \"quit\": ");
			String truckName = scanner.nextLine();
			System.out.println();
			if (truckName.equals("quit")) {
				break;
			}

			System.out.print("Please enter the type of food this truck serves: ");
			String foodType = scanner.nextLine();
			System.out.println();

			System.out.print("How would you rate this truck from 1-5? ");
			int rating = scanner.nextInt();
			scanner.nextLine();
			System.out.println();

			int numTrucks = 0;
			for (int j = 0; j < foodTrucks.length; j++) {
				if (foodTrucks[j] == null) {
					if (numTrucks == 0) {
						foodTrucks[j] = truckOne(truckName, foodType, rating);
					} else if (numTrucks == 1) {
						foodTrucks[j] = truckTwo(truckName, foodType, rating);
					} else if (numTrucks == 2) {
						foodTrucks[j] = truckThree(truckName, foodType, rating);
					} else if (numTrucks == 3) {
						foodTrucks[j] = truckFour(truckName, foodType, rating);
					} else {
						foodTrucks[j] = truckFive(truckName, foodType, rating);
					}
					numTrucks++;
					System.out.println("Thank you for adding this food truck!");
					System.out.println();
					break;
				}
			}
		}
	}

	public FoodTruck truckOne(String truckName, String foodType, int rating) {
		FoodTruck truckOne = new FoodTruck(truckName, foodType, rating);
		return truckOne;
	}

	public FoodTruck truckTwo(String truckName, String foodType, int rating) {
		FoodTruck truckTwo = new FoodTruck(truckName, foodType, rating);
		return truckTwo;
	}

	public FoodTruck truckThree(String truckName, String foodType, int rating) {
		FoodTruck truckThree = new FoodTruck(truckName, foodType, rating);
		return truckThree;
	}

	public FoodTruck truckFour(String truckName, String foodType, int rating) {
		FoodTruck truckFour = new FoodTruck(truckName, foodType, rating);
		return truckFour;
	}

	public FoodTruck truckFive(String truckName, String foodType, int rating) {
		FoodTruck truckFive = new FoodTruck(truckName, foodType, rating);
		return truckFive;
	}

	public void userMenu(Scanner scanner) {
		boolean userWantsInfo = true;
		while (userWantsInfo) {
			System.out.println("Would you like to: " + "\n 1) Display other food trucks in the area? "
					+ "\n 2) Display the average rating of the food trucks?"
					+ "\n 3) Display the highest-rated food truck?" + "\n 4) Quit? ");
			int menu = scanner.nextInt();
			scanner.nextLine();

			switch (menu) {
			case 1:
				System.out.println(listFoodTrucks(sBuilder));
				break;

			case 2:
				System.out.println("The average food truck rating is: " + averageFoodTruckRating());
				System.out.println();
				break;

			case 3:
				System.out.println(bestFoodTruck(sBuilder));
				System.out.println();
				break;

			case 4:
				userWantsInfo = false;
				break;
			}
		}

	}

	// iterate how many trucks were added and toString them out.
	// if null skip value
	public StringBuilder listFoodTrucks(StringBuilder sbuilder) {
		sbuilder.setLength(0);
		for (int i = 0; i < foodTrucks.length; i++) {
			if (foodTrucks[i] == null) {
				continue;
			} else {
				sbuilder.append(foodTrucks[i].toString());
			}
		}
		return sbuilder;
	}

	public double averageFoodTruckRating() {
		double sum = 0;
		double average = 0;
		double totalTrucks = 0;
		for (int i = 0; i < foodTrucks.length; i++) {
			if (foodTrucks[i] == null) {
				continue;
			} else {
				sum += (double) foodTrucks[i].getRating();
				totalTrucks++;
			}
			average = sum / totalTrucks;
		}
		return average;
	}

	public StringBuilder bestFoodTruck(StringBuilder sbuilder) {
		sbuilder.setLength(0);
		int highestRating = 0;
		String bestTruck = "";
		String foodType = "";

		for (int i = 0; i < foodTrucks.length; i++) {
			if (foodTrucks[i] == null) {
				continue;
			} else if (foodTrucks[i].getRating() >= highestRating) {
				highestRating = foodTrucks[i].getRating();
				bestTruck = foodTrucks[i].getTruckName();
				foodType = foodTrucks[i].getFoodType();
			}
		}
		sbuilder.append("The best food truck is ").append(bestTruck).append(" which serves ").append(foodType)
				.append(" and has a rating of ").append(highestRating).append(" out of 5.");

		return sbuilder;
	}

}
