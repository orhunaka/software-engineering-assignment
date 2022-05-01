
public class Service implements Profitable{

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

}
