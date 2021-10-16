package com.skilldistillery.foodtruck;

public class FoodTruck {
	private int truckId;
	private String truckName;
	private String foodType;
	private int rating;
	private static int counter = 1;

	public FoodTruck(String truckName, String foodType, int rating) {
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
		truckId = counter;
		counter++;
	}

	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Food Truck Id: ").append(truckId).append(", Food Truck Name: ").append(truckName)
				.append(", Food Type: ").append(foodType).append(", Rating: ").append(rating).append(". \n");
		return builder.toString();
	}
}
