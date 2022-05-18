import java.util.InputMismatchException;
import java.util.Scanner;

public class Gasoline {

	private String origin;
	private double pricePerLiter;
	private double totalLiters;

	public Gasoline(String origin, double pricePerLiter, double totalLiters) {
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
		System.out.println("Gasoline...\nThe origin is: " + origin);
		System.out.println("Price per liter is: " + pricePerLiter);
		System.out.println("Total liters of this gasoline is: " + totalLiters);
	}

	public static Gasoline createGasoline() {

		String origin;
		double pricePerLiter;
		double totalLiters;

		Scanner sc = new Scanner(System.in);
		
		

		

		while (true) {
			try {
				System.out.print("Please enter the origin of gasoline: ");
				origin = sc.nextLine();

				System.out.print("Please enter the price per liter: ");
				pricePerLiter = sc.nextDouble();

				System.out.print("Please enter the total shipment volume in liter: ");
				totalLiters = sc.nextDouble();

				return new Gasoline(origin, pricePerLiter, totalLiters);

			} catch (InputMismatchException exception) {
				System.err.println("Price should be double...");
				continue;
			}
			
		}
		
	}

}
