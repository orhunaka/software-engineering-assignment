import java.util.Scanner;

public class Diesel {

	private String origin;
	private double pricePerLiter;
	private double totalLiters;

	public Diesel(String origin, double pricePerLiter, double totalLiters) {
		this.origin = origin;
		this.pricePerLiter = pricePerLiter;
		this.totalLiters = totalLiters;
	}

	public double getPricePerLiter() {
		return pricePerLiter;
	}

	public double getTotalLiters() {
		return totalLiters;
	}

	public void displayInfo() {
		System.out.println();
		System.out.println("Diesel...\nThe origin is: " + origin);
		System.out.println("Price per liter is: " + pricePerLiter);
		System.out.println("Total liters of this Diesel is: " + totalLiters);
	}

	public static Diesel createDiesel() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the origin of Diesel: ");
		String origin = sc.nextLine();
		System.out.print("Please enter the price per liter: ");
		double pricePerLiter = sc.nextDouble();
		System.out.print("Please enter the total shipment volume in liter: ");
		double totalLiters = sc.nextDouble();
		return new Diesel(origin, pricePerLiter, totalLiters);
	}

}
