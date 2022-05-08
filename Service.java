import java.util.Collections;
import java.util.Comparator;

public class Service implements Profitable, Comparable<Service>, Comparator<Service> {

	private String carPlate;
	private double revenue = 0;

	public Service(String carPlate) {
		this.carPlate = carPlate;
	}

	public void displayServiceInfo() {

		System.out.println("Car Plate is " + carPlate + ".");
		System.out.println("The revenue from this service is " + revenue + ".");
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public void makeTransaction(double value) {
		setRevenue(value);
	}

	public double getRevenue() {
		return revenue;
	}

	@Override
	public double calculate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Service o) {
		// TODO Auto-generated method stub
		return (int) (this.getRevenue() - o.getRevenue());
	}

	@Override
	public int compare(Service o1, Service o2) {
		// TODO Auto-generated method stub
		return o1.carPlate.compareTo(o2.carPlate);
	}
}
